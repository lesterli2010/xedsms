package com.hxdq.xedsms.web.common;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListitemRenderer;

public interface MainLayoutAPI {
	public MenuCategory[] getCategories();
	public ListModel getSelectedModel();
	public ListitemRenderer getItemRenderer();
}
