package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.accessor.InstockAccessor;
import com.hxdq.xedsms.db.accessor.OutstockAccessor;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.City;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.Instockproduct;
import com.hxdq.xedsms.db.model.Outstock;
import com.hxdq.xedsms.db.model.OutstockProduct;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.web.common.AClickEventListener;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;

public class SelectOutstockWindow extends SelectListWindow {

private int queryType = Utility.QUERY_TYPE_NO;
	
	private Combobox prodCmbx = null;
	private Datebox startdb, enddb;
	private int prodId = 0;
	private String startTime=null, endTime=null;
	private String barCodeStr = null;
	private Textbox barcode;
	private int outId = 0;
	public void onCreate(){
		try{
			this.fileName = Utility.SELECT_OUTSTOCK_FILE_NAME;
			super.onCreate();	
			this.cbType = Utility.CB_TYPE_OUTSTOCK;
			this.prodCmbx = (Combobox)getFellow("prodCmbx");
			this.prodCmbx.setSelectedIndex(0);
			this.prodCmbx.setReadonly(true);
			
			startdb = (Datebox)getFellow("startdate");
			enddb = (Datebox)getFellow("enddate");
			
			Date now = new Date();
			Date oneMonthAgo = new Date(System.currentTimeMillis() - (long)30*24*3600*1000);
			startdb.setValue(oneMonthAgo);
			enddb.setValue(now);
			
			barcode = (Textbox)getFellow("barcode");
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int inId = Integer.parseInt(id);
		for (int i = 0; i < this.listData.size(); i++) {
			if (inId == ((Outstock)this.listData.get(i).getData()).getOutId()) {
				// First delete it from DB
				try{
					OutstockAccessor.deleteById(inId);
					// No error happen, delete it from list.
					this.listData.remove(i);
					Utility.logger.info("出库单号： " + inId + " is deleted.");
				}catch(Exception e){
					Utility.logger.error("Exception happened when delete outstock " + inId, e);
				}
			}
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
			switch(this.queryType){
			case Utility.QUERY_TYPE_NO:
				return OutstockAccessor.getTotalCount();
			case Utility.QUERY_TYPE_PROD:
				return OutstockAccessor.getTotalCountByProdId(this.prodId);
			case Utility.QUERY_TYPE_TIME:
				return OutstockAccessor.getTotalCountByTime(startTime, endTime);
			case Utility.QUERY_TYPE_PROD_TIME:
				return OutstockAccessor.getTotalCountByProdIdTime(prodId, startTime, endTime);
			case Utility.QUERY_TYPE_BARCODE:
				return OutstockAccessor.getTotalCountByBarCode(this.barCodeStr);
			case Utility.QUERY_TYPE_OUTID:
				return (OutstockAccessor.getOutstockById(this.outId) == null?0:1);
			default:
				return 0;
			}
		}catch(Exception e){
			Utility.logger.error(e);
			return 0;
		}
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		List<Outstock> outstockList = null;
		try{
			switch(this.queryType){
			case Utility.QUERY_TYPE_NO:
				outstockList = OutstockAccessor.getListLimit(startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_PROD:
				outstockList = OutstockAccessor.getListByProdId(this.prodId, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_TIME:
				outstockList = OutstockAccessor.getListByTime(startTime, endTime, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_PROD_TIME:
				outstockList = OutstockAccessor.getListByProdIdTime(this.prodId, startTime, endTime, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_BARCODE:
				outstockList = OutstockAccessor.getListByBarCode(this.barCodeStr, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_OUTID:
				outstockList = new ArrayList<Outstock>();
				Outstock out = OutstockAccessor.getOutstockById(this.outId);
				if(out!=null){
					outstockList.add(out);
				}
				break;
			default:
				Utility.logger.error("Unknown QueryType:" + this.queryType);
				return null;
			}
			
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; outstockList != null && i < outstockList.size(); i++) {
				RowData row = new RowData(outstockList.get(i), i + 1, (Include) getParent());
				list.add(row);
			}
			return list;
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}

	@Override
	public RowRenderer getListRowRenderer() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return outstockListRenderer;
	}
	
	private static final RowRenderer outstockListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Outstock out = (Outstock) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_OUTSTOCK, out.getOutId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_OUTSTOCK);
			cb.setParent(div);
			
			Label idLabel = new Label();
			idLabel.setValue(String.valueOf(out.getOutId()));
			idLabel.setParent(div);
			div.setParent(row);
			
			Label timeLabel = new Label();
			timeLabel.setValue(Utility.listTimeFormat.format(out.getOutTime()));
			timeLabel.setParent(row);
			
			String name;
			try{
				Saler saler = SalerAccessor.getSalerById(out.getSalerId());
				name = saler.getName();
			}catch(Exception e){
				name = Utility.UNKNOWN_NAME;
				Utility.logger.error(e);
			}
			Label salerLabel = new Label();
			salerLabel.setValue(name);
			salerLabel.setParent(row);
			
			try{
				Customer cus = CustomerAccessor.getCustomerById(out.getCustomerId());
				name = cus.getName();
			}catch(Exception e){
				Utility.logger.error(e);
				name = Utility.UNKNOWN_NAME;
			}
			
			Label cusLabel = new Label();
			cusLabel.setValue(name);
			cusLabel.setParent(row);
			
			try{
				City city = ConstAccessor.getCityById(out.getCityId());
				name = city.getCityName();
			}catch(Exception e){
				Utility.logger.error(e);
				name = Utility.UNKNOWN_NAME;
			}
			Label cityLabel = new Label();
			cityLabel.setValue(name + " " + out.getAddress());
			cityLabel.setParent(row);
			
			Grid detailGrid = new Grid();
			detailGrid.setStyle("border:0px;");
			Rows detailRows = new Rows();
			detailRows.setStyle("border:0px;");
			try{
				List<OutstockProduct> list = OutstockAccessor.getOutstockProductductlistByOutid(out.getOutId());
				OutstockProduct outpro = null;
				for(int i=0;i<list.size();i++){
					outpro = list.get(i);
					Productinfo prod = ConstAccessor.getProductById(outpro.getProductId());
					
					Row detailRow = new Row();
					detailRow.setStyle("border:0px;");
					
					Label nameLabel = new Label();
					nameLabel.setValue(prod.getName());
					nameLabel.setParent(detailRow);
					
					Label countLabel = new Label();
					countLabel.setValue(String.valueOf(outpro.getCount()));
					countLabel.setParent(detailRow);
					
					Label priceLabel = new Label();
					priceLabel.setValue(String.valueOf(outpro.getPrice()));
					priceLabel.setParent(detailRow);
					
					detailRow.setParent(detailRows);
				}
			}catch(Exception e){
				Utility.logger.error(e);
			}
			detailRows.setParent(detailGrid);
			detailGrid.setParent(row);
			
			A ta = new A();
			ta.setHref(Utility.OUTSTOCK_DETAIL_FILE_NAME+"?" + Utility.PARA_NAME_ID + "=" +out.getOutId());
			ta.setTarget("_blank");
			ta.setLabel("详情");
//			ta.setAttribute(Utility.PARA_NAME_ID, out.getOutId());
//			ta.setLabel("详情");
//			ta.addEventListener("onClick",
//					(EventListener) (new AClickEventListener(cdata
//							.getContentPage())));
//			ta.setAttribute(Utility.RTN_PAGE, Utility.SELECT_OUTSTOCK_FILE_NAME);
			ta.setParent(row);
		}
	};
	
	public ListModel getProdListModel(){
		return Utility.getProductListModel();
	}
	
	public ComboitemRenderer getProdListRenderer(){
		return Utility.productAllinOneItemRenderer;
	}
	
	public void query(){
		try{
			Checkbox prodbox = (Checkbox)getFellow("prodbox");
			Checkbox datebox = (Checkbox)getFellow("datebox");
			Checkbox barbox = (Checkbox)getFellow("barcodebox");
			Checkbox outidbox = (Checkbox)getFellow("outidbox");
			
			if(startdb.getValue() != null){
				startTime = Utility.startTimeFormat.format(startdb.getValue());
			}
			else{
				startTime = Utility.BEGIN_TIME;
			}
			if(enddb.getValue() != null){
				endTime = Utility.endTimeFormat.format(enddb.getValue());
			}else{
				endTime = Utility.endTimeFormat.format(new Date());
			}
			
			this.prodId = (Integer)this.prodCmbx.getSelectedItem().getValue();
			
			if(barbox.isChecked()){
				Textbox barcode = (Textbox)getFellow("barcode");
				this.barCodeStr = barcode.getValue();
				this.queryType = Utility.QUERY_TYPE_BARCODE;
			}else if(outidbox.isChecked()){
				Textbox outidtb = (Textbox)getFellow("outidtb");
				this.outId = Integer.parseInt(outidtb.getValue());
				this.queryType = Utility.QUERY_TYPE_OUTID;
			}else if(prodbox.isChecked() && !datebox.isChecked()){
				this.queryType = Utility.QUERY_TYPE_PROD;
			}else if(prodbox.isChecked() && datebox.isChecked()){
				this.queryType = Utility.QUERY_TYPE_PROD_TIME;
			}else if(!prodbox.isChecked() && datebox.isChecked()){
				this.queryType = Utility.QUERY_TYPE_TIME;
			}else{
				this.queryType = Utility.QUERY_TYPE_NO;
			}
			Utility.logger.info("queryType:" + this.queryType);
			this.initData();
		}catch(Exception e){
			Utility.logger.error(e);
			e.printStackTrace();
		}
	}

}
