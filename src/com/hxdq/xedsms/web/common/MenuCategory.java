package com.hxdq.xedsms.web.common;

import java.util.LinkedList;
import java.util.List;

public class MenuCategory {
	private String _id;
	private String _icon;
	private String _label;
	private String _href;
	private List<MenuItem> _items;
	
	@SuppressWarnings({ "unchecked", "serial" })
	public MenuCategory(String id, String icon, String label, String href) {
		_id = id;
		_icon = icon;
		_label = label; 
		_items = new LinkedList() {
			public Object remove(int index) {
				throw new UnsupportedOperationException();
			}
		};
		_href = href;
	}
	public void addItem(MenuItem item) {
		_items.add(item);
	}
	public String getHref() {
		return _href;
	}
	public List<MenuItem> getItems() {
		return _items;
	}
	
	public String getId() {
		return _id;
	}
	public String getIcon() {
		return _icon;
	}
	public String getLabel() {
		return _label;
	}
}
