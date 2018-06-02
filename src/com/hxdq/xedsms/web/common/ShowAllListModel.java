package com.hxdq.xedsms.web.common;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelExt;
import org.zkoss.zul.ListSubModel;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.event.ListDataListener;

public class ShowAllListModel implements ListModel, ListModelExt, ListSubModel,
		Serializable {

	private List _data;
	
	public ShowAllListModel(List data){
		_data = data;
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort(Comparator arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public ListModel getSubModel(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		final LinkedList data = new LinkedList();
		for (int i = 0; i < _data.size(); i++) {
				data.add(_data.get(i));
		}
		return new SimpleListModel(data);
	}

}
