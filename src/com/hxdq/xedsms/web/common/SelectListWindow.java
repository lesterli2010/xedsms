package com.hxdq.xedsms.web.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;

import com.hxdq.xedsms.*;

public abstract class SelectListWindow extends ContentWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListModel listModel;
	private int numberOfDeletedItem;
	private Label countLabel, pageLabel;
	private int numberOfItem;
	private Button nextBtn, prevBtn;
	private Grid listGrid;
	private PreNextPageData pageData;// 10 is max rows one page

	protected int maxRowsOneNum = 10;
	protected String cbType;
	protected List<RowData> listData = null;
	protected int queryType = Utility.QUERY_TYPE_NO;

	public abstract int getCount();

	public abstract List<RowData> getListData(int startIdx, int maxNum);

	public abstract void delete(String id);

	public abstract RowRenderer getListRowRenderer();

	public SelectListWindow() {
		pageData = new PreNextPageData(maxRowsOneNum);
	}

	public void onCreate() {
		super.onCreate();
		countLabel = (Label) getFellow("countLabel");
		listGrid = (Grid) getFellow("listGrid");
		pageLabel = (Label) getFellow("pageLabel");
		nextBtn = (Button) getFellow("nextBtn");
		prevBtn = (Button) getFellow("prevBtn");

		this.setTotalNumberOfItems();

		this.setPreNextButton();

		pageLabel.setValue(String.valueOf(pageData.getCurrentPageNum()));
	}

	public void setTotalNumberOfItems() {

		this.numberOfItem = getCount();

		countLabel.setValue(String.valueOf(numberOfItem));
		pageData.setTotalRecords(numberOfItem);
	}

	public void delete() {
		try {
			// TODO:Add Confirm button here.
			this.doDelete();
		} catch (Exception e) {
			Utility.logger.error("Exception when delete items.", e);
		}
	}

	@SuppressWarnings("unchecked")
	public void doDelete() {
		try {
			Collection col = this.getFellows();
			Iterator it = col.iterator();
			String cbtype, comID;
			Checkbox cb;
			int numberBeforeDelete = listData.size();
			while (it.hasNext()) {
				Object obj = it.next();
				if (obj instanceof Checkbox) {
					cb = (Checkbox) obj;
					if (!cb.isChecked()) {
						continue;
					}
					cbtype = (String) cb.getAttribute(Utility.CBTYPE_AttName);
					if (cbtype != null) {
						comID = cb.getId();
						if (cbtype.equals(this.cbType)) {
							delete(Utility.parseCheckboxId2Str(comID));
						}
					}
				}
			}

			// Refresh index number;
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).setIndex(i + 1);
			}

			this.numberOfDeletedItem = numberBeforeDelete
					- this.listData.size();
			pageData.setNumberOfDeletedItems(this.numberOfDeletedItem);
			// Update data
			this.refreshData();
			this.setTotalNumberOfItems();
		} catch (Exception e) {
			Utility.logger.error("Exception when delete items.", e);
		}
	}

	public void next() {
		try {
			pageData.nextPage();
			this.setPreNextButton();

			listData = this.getListData(pageData.getStartIndex(), pageData
					.getMaxRowsOnePage());
			this.refreshData();
			Utility.logger.info("next:" + pageData.getStartIndex());
			pageLabel.setValue(String.valueOf(pageData.getCurrentPageNum()));
		} catch (Exception e) {
			Utility.logger.error("Exception when click next page");
		}
	}

	private void refreshData() {
		this.listModel = new SimpleListModel(listData);
		this.listGrid.setModel(listModel);
		this.listGrid.setRowRenderer(getListRowRenderer());
	}

	private void setPreNextButton() {
		if (pageData.isFirstPage()) {
			this.prevBtn.setDisabled(true);
		} else {
			this.prevBtn.setDisabled(false);
		}

		if (pageData.isLastPage()) {
			this.nextBtn.setDisabled(true);
		} else {
			this.nextBtn.setDisabled(false);
		}
	}

	public void previous() {
		try {
			pageData.previousPage();
			this.setPreNextButton();

			listData = this.getListData(pageData.getStartIndex(), pageData
					.getMaxRowsOnePage());
			Utility.logger.info("previous:" + pageData.getStartIndex());
			this.refreshData();

			pageLabel.setValue(String.valueOf(pageData.getCurrentPageNum()));
		} catch (Exception e) {
			Utility.logger.error("Exception when click previous page");
		}
	}

	public ListModel getListModel() {
		try {
			listData = this.getListData(0, pageData.getMaxRowsOnePage());
			listModel = new SimpleListModel(listData);
			return listModel;
		} catch (Exception e) {
			Utility.logger.error(e);
			return null;
		}
	}

	public RowRenderer getListRenderer() {
		return getListRowRenderer();
	}

	protected void initData() {
		try {
			pageData.setStartIndex(0);
			pageData.setCurrentPageNum(1); // return to the first page
			pageLabel.setValue(String.valueOf(pageData.getCurrentPageNum()));
			listData = this.getListData(0, pageData.getMaxRowsOnePage());
			this.setTotalNumberOfItems();
			this.setPreNextButton();
			this.refreshData();
		} catch (Exception e) {
			Utility.logger.error("initData", e);
		}
	}
}
