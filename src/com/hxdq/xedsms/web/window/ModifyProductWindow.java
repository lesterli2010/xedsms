package com.hxdq.xedsms.web.window;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.web.common.ModifyWindow;
import com.hxdq.xedsms.db.accessor.*;
public class ModifyProductWindow extends ModifyWindow {

	private Productinfo product;
	private Combobox dkCombobox;
	private Combobox specCombobox;
	private void getCurrentProduct() {
		try {
			int id = (Integer)Utility.getParaID(this);
			rtnPage = (String)Utility.getRtnPage(this);
			if(rtnPage == null){
				this.rtnPage = "select_customer.zul";
			}
			product = ConstAccessor.getProductById(id);
		} catch (Exception e) {
			Utility.logger.error(e);
		}
	}
	
	public void onCreate() {
		getCurrentProduct();
		this.fileName = "modify_customer.zul";
		this.beanID = "product";
		this.beanObj = product;
		try{
			super.onCreate();
			this.dkCombobox = (Combobox)getFellow("dkCombox");
			for(int i=0;i<this.dkCombobox.getItemCount();i++)
			{
				if((Integer)this.dkCombobox.getItemAtIndex(i).getValue() == this.product.getDkspecId()){
					this.dkCombobox.setSelectedIndex(i);
					break;
				}
			}
			this.dkCombobox.setReadonly(true);
			
			this.specCombobox = (Combobox)getFellow("specCombox");
			for(int i=0;i<this.specCombobox.getItemCount();i++)
			{
				if((Integer)this.specCombobox.getItemAtIndex(i).getValue() == this.product.getSpecId()){
					this.specCombobox.setSelectedIndex(i);
					break;
				}
			}
			this.specCombobox.setReadonly(true);
		}catch(Exception e){
			Utility.logger.error(e);
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifyData() throws Exception {
		// TODO Auto-generated method stub
		this.product.setDkspecId((Integer)this.dkCombobox.getSelectedItem().getValue());
		this.product.setSpecId((Integer)this.specCombobox.getSelectedItem().getValue());
		ConstAccessor.update(product);
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
