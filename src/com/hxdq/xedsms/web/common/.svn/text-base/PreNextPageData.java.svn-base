package com.hxdq.xedsms.web.common;

public class PreNextPageData {
	private int _currentPageNum = 1;
	private int _maxRowsOnePage = 10; // List at max 10 items in one page
	private int _numberOfDeletedItems = 0;
	private int _startIndex = 0;
	private int _totalRecords = 0;

	public PreNextPageData(int maxRowsOnePage) {
		this._maxRowsOnePage = maxRowsOnePage;
	}

	public void setNumberOfDeletedItems(int numberOfDeletedItems) {
		this._numberOfDeletedItems = numberOfDeletedItems;
	}

	public void clearNumberOfDeletedItems() {
		this._numberOfDeletedItems = 0;
	}

	public int getStartIndex() {
		return this._startIndex;
	}

	public void setStartIndex(int startIndex) {
		this._startIndex = startIndex;
	}

	public void setTotalRecords(int totalRecords) {
		this._totalRecords = totalRecords;
	}

	public int getMaxRowsOnePage() {
		return this._maxRowsOnePage;
	}

	public int getCurrentPageNum() {
		return this._currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this._currentPageNum = currentPageNum;
	}

	public void nextPage() {
		_currentPageNum++;
		this._startIndex = (_currentPageNum - 1) * this._maxRowsOnePage
				- this._numberOfDeletedItems;
		this._numberOfDeletedItems = 0;
	}

	public void previousPage() {
		_currentPageNum--;
		if (_currentPageNum == 0) {
			_currentPageNum = 1;
		}
		this._startIndex = (_currentPageNum - 1) * this._maxRowsOnePage;
		this._numberOfDeletedItems = 0;
	}

	public boolean isFirstPage() {
		return _currentPageNum == 1 ? true : false;
	}

	public boolean isLastPage() {
		return ((_startIndex + _maxRowsOnePage) >= _totalRecords) ? true
				: false;
	}
}
