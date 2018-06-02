package com.hxdq.xedsms.web.common;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.zkoss.lang.reflect.FusionInvoker;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.ComponentNotFoundException;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.BookmarkEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.ComposerExt;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.A;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Popup;

import com.hxdq.xedsms.*;

public class MainLayoutComposer extends GenericForwardComposer implements
		MainLayoutAPI, ComposerExt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String fileName = "main.zul";

	private Listbox itemList;

	private Borderlayout main;

	private Include xcontents;

	private Button _selected;
	
	private Div header;
	private Map<String, MenuCategory> _cateMap = null;// new LinkedHashMap<String, MenuCategory>();
	private String currentAuthority = Utility.getCurrentUserAuthority();
	
	public MainLayoutComposer() {
	}

	private void loadMenuConfig()throws Exception {
		if(_cateMap == null){
			_cateMap = new LinkedHashMap<String, MenuCategory>();
		}else{
			return;
		}
		
		if(this.currentAuthority == null){
			Utility.logger.error("currentAuthority is null");
			return;
		}
		
		SAXReader reader = new SAXReader();
		File meanFile = new File(Utility.menuFileRealPath);
		Document document = reader.read(meanFile);

		Element root = document.getRootElement();

		List<Element> cateList = (List<Element>) root.elements("category");
		Element cate, item;
		String mid, iid;
		

		for (int i = 0; i < cateList.size(); i++) {
			cate = cateList.get(i);
			
			String catPermission = cate.elementText("permission");
			if(catPermission != null && !catPermission.equals("ALL") && !catPermission.contains(currentAuthority)){
				continue;
			}
			
			mid = cate.attributeValue("id");
			MenuCategory mcate = new MenuCategory(mid, cate
				.elementText("icon-url"), cate.elementText("label"), cate
				.elementText("href"));
			
			List<Element> itemList = (List<Element>) cate.elements("item");
			for (int j = 0; j < itemList.size(); j++) {
			item = itemList.get(j);
			
			String permission = item.elementText("permission");
			if(permission != null && !permission.equals("ALL") && !permission.contains(currentAuthority)){
				continue;
			}
			
			iid = item.attributeValue("id");
			MenuItem mitem = new MenuItem(iid, mid, item
					.elementText("file-url"), item.elementText("icon-url"),
					item.elementText("label"));
			mcate.addItem(mitem);
		}
		this._cateMap.put(mid, mcate);
	}
	}
	
	public Map<String, MenuCategory> getCategoryMap() {
		try{
			if(currentAuthority.equals("ROLE_ADMIN")){
				// Admin, just return all menus.
				return Utility.getMenuMap();
			}
			
			loadMenuConfig();
			return this._cateMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public void onCategorySelect(ForwardEvent event) {
		Button btn = (Button) event.getOrigin().getTarget();
		Listitem item = null;
		if (_selected != btn) {
			_selected = btn;
		} else {
			item = itemList.getSelectedItem();
		}
		String href = getCategory(_selected.getId()).getHref();
		if (href != null) {
			Executions.getCurrent().sendRedirect(href);
		} else {
			itemList.setModel(getSelectedModel());
			if (Executions.getCurrent().isBrowser("ie6_"))
				Clients.evalJavaScript("fixImage4IE6();");
			if (item != null) {
				itemList.renderAll();
				((Listitem) itemList.getFellow(item.getId())).setSelected(true);
			}
		}
	}

	@Override
	public MenuCategory[] getCategories() {
		// TODO Auto-generated method stub
		return (MenuCategory[]) this.getCategoryMap().values().toArray(
				new MenuCategory[] {});
	}

	@Override
	public ListitemRenderer getItemRenderer() {
		// TODO Auto-generated method stub
		return _defRend;
	}

	@Override
	public ListModel getSelectedModel() {
		// TODO Auto-generated method stub
		MenuCategory cate = _selected == null ? getCategories()[0]
				: getCategory(_selected.getId());
		return new ListModelList(cate.getItems());
	}

	public void onBookmarkChange$main(BookmarkEvent event) {
		String id = event.getBookmark();
		if (id != null) {
			final MenuItem[] items = getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].getId().equals(id)) {
					_selected = (Button) main.getFellow(items[i].getCateId());
					itemList.setModel(getSelectedModel());
					itemList.renderAll();
					Listitem item = ((Listitem) itemList.getFellow(id));
					item.setSelected(true);
					itemList.invalidate();
					setSelectedCategory(item);
					xcontents.setSrc(((MenuItem) item.getValue()).getFile());
					item.focus();
					return;
				}
			}
		}
	}

	public void onClick$itemList() {
		Listitem item = itemList.getSelectedItem();

		if (item != null) {
			// sometimes the item is unloaded.
			if (!item.isLoaded()) {
				itemList.renderItem(item);
			}

			setSelectedCategory(item);
			xcontents.setSrc(null);
			xcontents.setSrc(((MenuItem) item.getValue()).getFile());
		}
	}

	@SuppressWarnings("unchecked")
	public void onMainCreate(Event event) {
		final Execution exec = Executions.getCurrent();
		final String id = exec.getParameter("id");
		Listitem item = null;
		if (id != null) {
			try {
				final LinkedList list = new LinkedList();
				final MenuItem[] items = getItems();
				for (int i = 0; i < items.length; i++) {
					if (items[i].getId().equals(id))
						list.add(items[i]);
				}
				if (!list.isEmpty()) {
					itemList.setModel(new ListModelList(list));
					itemList.renderAll();
					item = (Listitem) main.getFellow(id);
					setSelectedCategory(item);
				}
			} catch (ComponentNotFoundException ex) { // ignore
			}
		}

		if (item == null) {
			item = (Listitem) main.getFellow("b1");
			setSelectedCategory(item);
		}
		xcontents.setSrc(((MenuItem) item.getValue()).getFile());

		itemList.selectItem(item);
		
		// Set User ID
		try{
			String userID = Utility.getCurrentUserID();
			Label useridLabel = (Label)self.getFellow("useridLabel");
			String authority = Utility.getAuthorityName(Utility.getCurrentUserAuthority());
			useridLabel.setValue(authority + " " + userID);
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}

	public void setSelectedCategory(Listitem item) {
		MenuItem di = (MenuItem) item.getValue();
		_selected = (Button) main.getFellow(di.getCateId());
		String deselect = _selected != null ? "jq('#"
				+ _selected.getUuid()
				+ "').addClass('ngdirweb-seld').siblings().removeClass('ngdirweb-seld');"
				: "";
		if (Executions.getCurrent().isBrowser("ie6_")) {
			Clients.evalJavaScript(deselect + "fixImage4IE6();");
		} else {
			Clients.evalJavaScript(deselect);
		}
		item.getDesktop().setBookmark(item.getId());
	}

	@SuppressWarnings("unchecked")
	public void onCtrlKey$searchBox(KeyEvent event) {
		int keyCode = event.getKeyCode();
		List items = itemList.getItems();
		if (items.isEmpty())
			return;
		Listitem item = null;
		switch (keyCode) {
		case 38: // UP
			item = itemList.getItemAtIndex(items.size() - 1);
			itemList.setSelectedItem(item);
			break;
		case 40: // DOWN
			item = itemList.getItemAtIndex(0);
			itemList.setSelectedItem(item);
			break;
		}
		if (item != null) {
			setSelectedCategory(item);
			xcontents.setSrc(((MenuItem) item.getValue()).getFile());
			item.focus();
		}
	}

	@SuppressWarnings("unchecked")
	public void onChanging$searchBox(InputEvent event) {
		String key = event.getValue();
		LinkedList item = new LinkedList();
		MenuItem[] items = getItems();

		if (key.trim().length() != 0) {
			for (int i = 0; i < items.length; i++) {
				if (items[i].getLabel().toLowerCase()
						.indexOf(key.toLowerCase()) != -1)
					item.add(items[i]);
			}
			itemList.setModel(new ListModelList(item));
		} else
			itemList.setModel(new ListModelList(items));
		String deselect = _selected != null ? "onSelect('"
				+ _selected.getUuid() + "', true);" : "";
		if (Executions.getCurrent().isBrowser("ie_")) {
			itemList.renderAll();
			Clients.evalJavaScript(deselect + "fixImage4IE6();");
		} else {
			Clients.evalJavaScript(deselect);
		}
		_selected = null;
	}

	@SuppressWarnings("unchecked")
	public MenuItem[] getItems() {
		LinkedList items = new LinkedList();
		MenuCategory[] categories = getCategories();
		for (int i = 0; i < categories.length; i++) {
			items.addAll(categories[i].getItems());
		}
		return (MenuItem[]) items.toArray(new MenuItem[] {});
	}

	public static final ListitemRenderer _defRend = new ListitemRenderer() {
		public void render(Listitem item, Object data) {
			MenuItem di = (MenuItem) data;
			Listcell lc = new Listcell();
			item.setValue(di);
			lc.setHeight("30px");
			lc.setImage(di.getIcon());
			item.setId(di.getId());
			lc.setLabel(di.getLabel());
			lc.setParent(item);
		}
	};

	public MenuCategory getCategory(String cateId) {
		return (MenuCategory) this.getCategoryMap().get(cateId);
	}

	// Composer Implementation
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Events.postEvent("onMainCreate", comp, null);
		
		
	}

	public ComponentInfo doBeforeCompose(Page page, Component parent,
			ComponentInfo compInfo) {
		return compInfo;
	}

	public void doBeforeComposeChildren(Component comp) throws Exception {
		bindComponent(comp);
		Object obj = FusionInvoker.newInstance(new Object[] { comp, this });
		comp.setAttribute("main", obj);
		main = (Borderlayout) comp;

	}

	public boolean doCatch(Throwable ex) throws Exception {
		Utility.logger.error("Failed to compose "+this, ex);
		return false;
	}

	public void doFinally() throws Exception {
	}
}
