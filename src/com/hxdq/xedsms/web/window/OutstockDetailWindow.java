package com.hxdq.xedsms.web.window;

import java.util.List;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.accessor.OutstockAccessor;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.City;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.Outstock;
import com.hxdq.xedsms.db.model.OutstockProduct;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.db.model.Usageinfo;
import com.hxdq.xedsms.web.common.ContentWindow;

public class OutstockDetailWindow extends ContentWindow {
	private Outstock outstock = null;
	private List<OutstockProduct> outstockproList = null;
	public void onCreate(){
		try{
			String id = this.getPage().getDesktop().getExecution().getParameter(Utility.PARA_NAME_ID);
			int outId = Integer.parseInt(id);
			Utility.logger.info("Display info for outstock:" + outId);
			outstock = OutstockAccessor.getOutstockById(outId);
			outstockproList = OutstockAccessor.getOutstockProductductlistByOutid(outId);
			
			if(outstock == null || outstockproList == null){
				Utility.logger.error("Error when get info for outid:"+outId);
				return;
			}
			
			Label customer = (Label)getFellow("customer");
			try{
			Customer cus = CustomerAccessor.getCustomerById(outstock.getCustomerId());
			customer.setValue(cus.getName());
			}catch(Exception e){
				customer.setValue(Utility.UNKNOWN_NAME);
			}
			Label salerLb = (Label)getFellow("saler");
			try{
				Saler saler = SalerAccessor.getSalerById(outstock.getSalerId());
				salerLb.setValue(saler.getName());
			}catch(Exception e){
				salerLb.setValue(Utility.UNKNOWN_NAME);
			}
			Label saletime = (Label)getFellow("saletime");
			saletime.setValue(Utility.listDateFormat.format(outstock.getSaleTime()));
			
			Label outtime = (Label)getFellow("outtime");
			outtime.setValue(Utility.listTimeFormat.format(outstock.getOutTime()));
			
			City city = ConstAccessor.getCityById(outstock.getCityId());
			Label cityLb = (Label)getFellow("city");
			cityLb.setValue(city.getCityName() + " " + outstock.getAddress());
			
			Grid listGrid = (Grid)getFellow("listGrid");
			listGrid.setModel(this.getListModel());
			listGrid.setRowRenderer(this.outProRenderer);
			
			
			Label outidLabel = (Label)getFellow("outidLabel");
			outidLabel.setValue(String.valueOf(outstock.getOutId()));
			
			Label operator = (Label)getFellow("operator");
			operator.setValue(outstock.getOperator());
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	public ListModel getListModel(){
		return new SimpleListModel(this.outstockproList);
	}
	public RowRenderer getListRowRenderer() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return outProRenderer;
	}
	
	private static final RowRenderer outProRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			OutstockProduct outpro = (OutstockProduct)data;
			String proName;
			try{
				Productinfo pro = ConstAccessor.getProductById(outpro.getProductId());
				proName = Utility.getProductLongName(pro);
			}catch(Exception e){
				Utility.logger.error(e);
				proName = Utility.UNKNOWN_NAME;
			}
			
			Label nameLabel = new Label();
			nameLabel.setValue(proName);
			nameLabel.setParent(row);
			nameLabel.setStyle("font-size:12pt");
			
			Label countLabel = new Label();
			countLabel.setValue(String.valueOf(outpro.getCount()));
			countLabel.setParent(row);
			countLabel.setStyle("font-size:12pt");
			
			Label priceLabel = new Label();
			priceLabel.setValue(String.valueOf(outpro.getPrice()));
			priceLabel.setParent(row);
			priceLabel.setStyle("font-size:12pt");
			
			String usageName;
			try{
				Usageinfo usage = ConstAccessor.getUsageinfoById(outpro.getUsageId());
				usageName = usage.getUsageName();
			}catch(Exception e){
				Utility.logger.error(e);
				usageName = Utility.UNKNOWN_NAME;
			}
			Label usageLabel = new Label();
			usageLabel.setValue(usageName);
			usageLabel.setParent(row);
			usageLabel.setStyle("font-size:12pt");
			
			Image img = new Image();
			img.setSrc(Utility.getBarCodeImgSrc(outpro.getBarcode()));
			img.setWidth("80%");
			img.setHeight("80%");
			img.setParent(row);
		}
	};
	
	
}
