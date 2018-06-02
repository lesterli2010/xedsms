package com.hxdq.xedsms.web.common;

import org.zkoss.zul.Include;

public class RowData {
	private Object _data;
	private int _index;
	private Include _contentPage;
	
	public RowData(Object data, int index, Include contentPage){
		this._data = data;
		this._index = index;
		this._contentPage = contentPage;
	}
	
	public Object getData(){
		return this._data;
	}
	
	public int getIndex(){
		return this._index;
	}
	
	public Include getContentPage(){
		return this._contentPage;
	}
	
	public void setIndex(int index){
		this._index = index;
	}
}
