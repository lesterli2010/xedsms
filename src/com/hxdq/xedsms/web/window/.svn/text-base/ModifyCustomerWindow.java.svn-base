package com.hxdq.xedsms.web.window;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.api.Textbox;

import com.hxdq.xedsms.*;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.web.common.ModifyWindow;

public class ModifyCustomerWindow extends ModifyWindow {

	private Customer customer = null;
	private Combobox genderCombobox = null;
	private int provId;
	private Combobox city = null;
	private Combobox province = null;
	private Combobox saler = null;
	private void getCurrentCustomer() {
		try {
			if(customer != null)
				return;
			
			int id = (Integer)Utility.getParaID(this);
			rtnPage = (String)Utility.getRtnPage(this);
			if(rtnPage == null){
				this.rtnPage = "select_customer.zul";
			}
			customer = CustomerAccessor.getCustomerById(id);
			this.provId = customer.getProvinceid();
		} catch (Exception e) {
			Utility.logger.error(e);
		}
	}
	
	public void onCreate() {
		getCurrentCustomer();

		this.fileName = "modify_customer.zul";
		this.beanID = "customer";
		this.beanObj = customer;
		try{
			super.onCreate();
		
			this.genderCombobox = (Combobox)getFellow("genderCombox");
			this.genderCombobox.setSelectedIndex(customer.getGender());
			this.genderCombobox.setReadonly(true);
			city = (Combobox)getFellow("city");
			
			city.setModel(this.getCityModel());
			province = (Combobox)getFellow("province");
			for(int i=0;i<province.getItemCount();i++){
				if(customer.getProvinceid() == (Integer)province.getItemAtIndex(i).getValue()){
					province.setSelectedIndex(i);
					break;
				}
			}
			saler = (Combobox)getFellow("saler");
			
			for(int i=0;i<saler.getItemCount();i++){
				if(customer.getSalerid() == (Integer)saler.getItemAtIndex(i).getValue()){
					saler.setSelectedIndex(i);
					break;
				}
			}
			
			int cityId, itemCityId;
			for(int i=0;i<city.getItemCount();i++){
				cityId = customer.getCityid();
				itemCityId = (Integer)city.getItemAtIndex(i).getValue();
			
				if(cityId == itemCityId){
					city.setSelectedIndex(i);
					break;
				}
			}
			city.setReadonly(true);
			province.setReadonly(true);
			saler.setReadonly(true);
		}catch(Exception e){
			Utility.logger.error(e);
			e.printStackTrace();
		}
	}
	@Override
	public void modifyData() throws Exception {
		// TODO Auto-generated method stub
		Integer gender = genderCombobox.getSelectedIndex();
		customer.setGender(gender.byteValue());
		customer.setUpdatetime(new java.util.Date());
		customer.setCityid((Integer)city.getSelectedItem().getValue());
		customer.setProvinceid((Integer)province.getSelectedItem().getValue());
		customer.setSalerid((Integer)saler.getSelectedItem().getValue());
		CustomerAccessor.update(customer);
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
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
			return new SimpleListModel(Utility.GENDER_NAME);
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
		getCurrentCustomer();
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
