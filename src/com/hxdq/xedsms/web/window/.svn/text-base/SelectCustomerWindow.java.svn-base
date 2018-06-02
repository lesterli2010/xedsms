package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.hxdq.xedsms.*;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.web.common.AClickEventListener;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;
import org.zkoss.zul.Include;
import org.zkoss.zul.api.Textbox;

public class SelectCustomerWindow extends SelectListWindow {

	private String searchName;
	public void onCreate(){
		try{
			this.fileName = "select_customer.zul";
			super.onCreate();	
			this.cbType = Utility.CB_TYPE_CUSTOMER;
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		int cusId = Integer.parseInt(id);
		for (int i = 0; i < this.listData.size(); i++) {
			if (cusId == ((Customer)this.listData.get(i).getData()).getCustomerId()) {
				// First delete it from DB
				try{
					CustomerAccessor.deleteById(cusId);
					// No error happen, delete it from list.
					this.listData.remove(i);
					Utility.logger.info("Customer " + cusId + " is deleted.");
				}catch(Exception e){
					Utility.logger.error("Exception happened when delete AD " + cusId, e);
				}
			}
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
			switch(this.queryType){
			case Utility.QUERY_TYPE_BYNAME:
				return CustomerAccessor.getTotalCountByName(this.searchName);
			default:
				return CustomerAccessor.getTotalCount();
			
			}
		}catch(Exception e){
			Utility.logger.error(e);
		}
		return 0;
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		try {
			List<Customer> customerList;
			switch(this.queryType){
				case Utility.QUERY_TYPE_BYNAME:
					customerList = CustomerAccessor.getAllCustomerLimitByName(this.searchName, startIdx, maxNum);
					break;
				default:
					customerList = CustomerAccessor.getAllCustomerLimit(startIdx, maxNum);
			}
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; customerList != null && i < customerList.size(); i++) {
				RowData row = new RowData(customerList.get(i), i + 1, (Include) getParent());
				list.add(row);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public RowRenderer getListRowRenderer() {
		// TODO Auto-generated method stub
		return customerListRenderer;
	}
	
	public void search() {
		try{
			Textbox nameTB = (Textbox)getFellow("name");
			if(nameTB.getValue().isEmpty()){
				this.queryType = Utility.QUERY_TYPE_NO;
			}else{
				searchName = nameTB.getValue();
				this.queryType = Utility.QUERY_TYPE_BYNAME;
			}
			this.initData();
		}catch(Exception e){
			Utility.logger.error(e);
			this.queryType = Utility.QUERY_TYPE_NO;
		}
	}
	
	private static final RowRenderer customerListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Customer customer = (Customer) cdata.getData();

			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);

			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_CUSTOMER, customer.getCustomerId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_CUSTOMER);
			cb.setParent(div);
			
			A ta = new A();
			ta.setHref(Utility.CUSTOMER_DETAIL_FILE_NAME+"?" + Utility.PARA_NAME_ID + "=" +customer.getCustomerId());
			ta.setTarget("_blank");
			ta.setLabel(customer.getName());
			ta.setParent(div);
			div.setParent(row);
			
			Label cellphoneLabel = new Label();
			cellphoneLabel.setValue(customer.getCellphone());
			cellphoneLabel.setParent(row);
			
			Label officephoneLabel = new Label();
			officephoneLabel.setValue(customer.getOfficephone());
			officephoneLabel.setParent(row);
			
			Label homephoneLabel = new Label();
			homephoneLabel.setValue(customer.getHomephone());
			homephoneLabel.setParent(row);
			
			Label companyNameLabel = new Label();
			companyNameLabel.setValue(customer.getCompanyname());
			companyNameLabel.setParent(row);
			
			A modifyA = new A();
			modifyA.setHref(Utility.MODIFY_CUSTOMER_FILE_NAME);
			modifyA.setAttribute(Utility.PARA_NAME_ID, customer.getCustomerId());
			modifyA.setLabel("修改");
			modifyA.addEventListener("onClick",
					(EventListener) (new AClickEventListener(cdata
							.getContentPage())));
			modifyA.setAttribute(Utility.RTN_PAGE, Utility.SELECT_CUSTOMER_FILE_NAME);
			modifyA.setParent(row);
		}
	};

}
