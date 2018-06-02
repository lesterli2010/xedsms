package com.hxdq.xedsms.web.window;

import com.hxdq.xedsms.web.common.InsertWindow;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.api.Textbox;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.Utility;

public class AddCustomerWindow extends InsertWindow {

	private Customer customer = null;
	private ListModel _genderModel;
	private Combobox genderCombobox = null;
	private Combobox city = null;
	private Combobox province = null;
	private Combobox saler = null;
	private int provId = 15; // default to shang dong province.
	
	public void onCreate(){
		try{
			this.fileName = "add_customer.zul";
			this.rtnPage = "add_customer.zul";
			customer = new Customer();
			
			this.beanID = "customer";
			this.beanObj = customer;
			super.onCreate();
			
			city = (Combobox)getFellow("city");
			province = (Combobox)getFellow("province");
			saler = (Combobox)getFellow("saler");
			
			genderCombobox = (Combobox)getFellow("genderCombox");
			genderCombobox.setSelectedIndex(0);
			genderCombobox.setReadonly(true);
			
			saler.setSelectedIndex(0);
			for(int i=0;i<province.getItemCount();i++){
				if((Integer)province.getItemAtIndex(i).getValue() == this.provId){
					province.setSelectedIndex(i);
					break;
				}
			}
			city.setSelectedIndex(0);
			
			city.setReadonly(true);
			province.setReadonly(true);
			saler.setReadonly(true);
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	@Override
	public void insertData() throws Exception {
		// TODO Auto-generated method stub
		Integer gender = genderCombobox.getSelectedIndex();
		customer.setGender(gender.byteValue());
		customer.setCreatetime(new java.util.Date());
		customer.setUpdatetime(new java.util.Date());
		customer.setCityid((Integer)city.getSelectedItem().getValue());
		customer.setProvinceid((Integer)province.getSelectedItem().getValue());
		customer.setSalerid((Integer)saler.getSelectedItem().getValue());
		CustomerAccessor.insert(customer);
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		Textbox nameTB = (Textbox)getFellow("name");
		if(!nameTB.isValid()){
			nameTB.setFocus(false);
			return false;
		}
		return true;
	}
	
	public ComboitemRenderer getGenderRenderer(){
		return Utility.getStringRenderer();
	}

	public ListModel getGenderModel() {
		try {
			this._genderModel = new SimpleListModel(Utility.GENDER_NAME);
			return this._genderModel;
		} catch (Exception e) {
			Utility.logger.error(e);
			return null;
		}
	}
	
	public ListModel getSalerModel(){
		return Utility.getSalerListModel();
	}
	
	public ComboitemRenderer getSalerRenderer(){
		return Utility.salerItemRenderer;
	}
	
	public ListModel getProvinceModel(){
		return Utility.getProvinceListModel();
	}
	
	public ComboitemRenderer getProvinceRenderer(){
		return Utility.provinceItemRenderer;
	}
	
	public ListModel getCityModel(){
		return Utility.getCityListModel(provId);
	}
	
	public ComboitemRenderer getCityRenderer(){
		return Utility.cityItemRenderer;
	}
	
	public void changeProvince(){
		try{
			this.provId = (Integer)province.getSelectedItem().getValue();
			ListModel cityListModel = Utility.getCityListModel(provId);
			city.setModel(cityListModel);
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
}
