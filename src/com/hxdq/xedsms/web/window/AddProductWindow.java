package com.hxdq.xedsms.web.window;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.StockStatusAccessor;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Stockstatus;
import com.hxdq.xedsms.web.common.InsertWindow;

public class AddProductWindow extends InsertWindow {

	private Productinfo product = null;
	private boolean success = false;

	private Combobox dkCombobox = null;
	private Combobox specCombobox = null;
	
	public void onCreate(){
		try{
			this.fileName = "add_product.zul";
			this.rtnPage = "add_product.zul";
			product = new Productinfo();
			
			this.beanID = "product";
			this.beanObj = product;
			super.onCreate();
			
			dkCombobox = (Combobox)getFellow("dkCombox");
			dkCombobox.setSelectedIndex(0);
			dkCombobox.setReadonly(true);
			
			specCombobox = (Combobox)getFellow("specCombox");
			specCombobox.setSelectedIndex(0);
			specCombobox.setReadonly(true);
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void insertData() throws Exception {
		// TODO Auto-generated method stub
		boolean success1 = false;
		boolean success2 = false;
		try{
		product.setDkspecId((Integer)dkCombobox.getSelectedItem().getValue());
		product.setSpecId((Integer)specCombobox.getSelectedItem().getValue());
		product.setTemp(Integer.parseInt(((Textbox)getFellow("temp")).getValue()));
		ConstAccessor.insert(product );
		success1 = true;
		
		Stockstatus status = new Stockstatus();
		status.setProductId(product.getProductId());
		status.setIncount(0);
		status.setOutcount(0);
		status.setRemaincount(0);
		status.setUpdatetime(new java.util.Date());
		StockStatusAccessor.insert(status);
		success2 = true;
		}catch(Exception e){
			if(!success2 && success1){
				ConstAccessor.deleteProductById(product.getProductId());
			}
			throw e;
		}
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		if(((Textbox)getFellow("name")).isValid() == false){
			((Textbox)getFellow("name")).setFocus(true);
			return false;
		}
		if(((Textbox)getFellow("temp")).isValid() == false){
			((Textbox)getFellow("temp")).setFocus(true);
			return false;
		}
		return true;
	}
	
	public ComboitemRenderer getDkRenderer(){
		return Utility.getDkRenderer();
	}
	
	public ComboitemRenderer getSpecRenderer(){
		return Utility.getSpecRenderer();
	}

	public ListModel getDkModel() {
		return Utility.getDkModel();
	}
	
	public ListModel getSpecModel(){
		return Utility.getSpecinfoModel();
	}

}
