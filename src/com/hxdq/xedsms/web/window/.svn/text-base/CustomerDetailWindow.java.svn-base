package com.hxdq.xedsms.web.window;

import org.zkoss.zul.Label;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.City;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.Province;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.web.common.ContentWindow;
import com.hxdq.xedsms.web.common.ModifyWindow;

public class CustomerDetailWindow extends ModifyWindow {

	private Customer customer = null;
	public void onCreate(){
		try{
			String id = this.getPage().getDesktop().getExecution().getParameter(Utility.PARA_NAME_ID);
			int cusId = Integer.parseInt(id);
			Utility.logger.info("Display customer infor" + cusId);
			customer = CustomerAccessor.getCustomerById(cusId);
			this.fileName = "modify_customer.zul";
			this.beanID = "customer";
			this.beanObj = customer;
			
			super.onCreate();
			
			Label gender = (Label)getFellow("gender");
			Label birthdate = (Label)getFellow("birthdate");
			Label city = (Label)getFellow("city");
			Label saler = (Label)getFellow("saler");
			
			gender.setValue(Utility.GENDER_NAME[customer.getGender()]);
			birthdate.setValue(Utility.listDateFormat.format(customer.getBirthdate()));
			Province pro = ConstAccessor.getProvinceById(customer.getProvinceid());
			City cit = ConstAccessor.getCityById(customer.getCityid());
			city.setValue(pro.getProvName()+ cit.getCityName());
			Saler sal = SalerAccessor.getSalerById(customer.getSalerid());
			saler.setValue(sal.getName());
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void modifyData() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
