package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.hxdq.xedsms.db.accessor.StockStatusAccessor;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.Instock;
import com.hxdq.xedsms.db.model.Instockproduct;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;

public class SelectInstockWindow extends SelectListWindow {

	
	
	private int queryType = Utility.QUERY_TYPE_NO;
	
	private Combobox prodCmbx = null;
	private Datebox startdb, enddb;
	private int prodId = 0;
	private int inId = 0;
	private String startTime=null, endTime=null;
	public void onCreate(){
		try{
			this.fileName = Utility.SELECT_INSTOCK_FILE_NAME;
			super.onCreate();	
			this.cbType = Utility.CB_TYPE_INSTOCK;
			this.prodCmbx = (Combobox)getFellow("prodCmbx");
			this.prodCmbx.setSelectedIndex(0);
			this.prodCmbx.setReadonly(true);
			
			startdb = (Datebox)getFellow("startdate");
			enddb = (Datebox)getFellow("enddate");
			
			Date now = new Date();
			Date oneMonthAgo = new Date(System.currentTimeMillis() - (long)30*24*3600*1000);
			startdb.setValue(oneMonthAgo);
			enddb.setValue(now);
			
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		int inId = Integer.parseInt(id);
		for (int i = 0; i < this.listData.size(); i++) {
			if (inId == ((Instock)this.listData.get(i).getData()).getInId()) {
				// First delete it from DB
				try{
					InstockAccessor.deleteById(inId);
					// No error happen, delete it from list.
					this.listData.remove(i);
					Utility.logger.info("入库单号： " + inId + " is deleted.");
				}catch(Exception e){
					Utility.logger.error("Exception happened when delete Instock " + inId, e);
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
				return InstockAccessor.getTotalCount();
			case Utility.QUERY_TYPE_PROD:
				return InstockAccessor.getTotalCountByProdId(this.prodId);
			case Utility.QUERY_TYPE_TIME:
				return InstockAccessor.getTotalCountByTime(startTime, endTime);
			case Utility.QUERY_TYPE_PROD_TIME:
				return InstockAccessor.getTotalCountByProdIdTime(prodId, startTime, endTime);
			case Utility.QUERY_TYPE_INID:
				return (InstockAccessor.getInstockByInid(this.inId)==null?0:1);
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
		List<Instock> instockList = null;
		try{
			switch(this.queryType){
			case Utility.QUERY_TYPE_NO:
				instockList = InstockAccessor.getListLimit(startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_PROD:
				instockList = InstockAccessor.getListByProdId(this.prodId, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_TIME:
				instockList = InstockAccessor.getListByTime(startTime, endTime, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_PROD_TIME:
				instockList = InstockAccessor.getListByProdIdTime(this.prodId, startTime, endTime, startIdx, maxNum);
				break;
			case Utility.QUERY_TYPE_INID:
				Instock instock = InstockAccessor.getInstockByInid(this.inId);
				instockList = new ArrayList<Instock>();
				if(instock !=null){
					instockList.add(instock);
				}
				break;
			default:
				Utility.logger.error("Unknown QueryType:" + this.queryType);
				return null;
			}
			
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; instockList != null && i < instockList.size(); i++) {
				RowData row = new RowData(instockList.get(i), i + 1, (Include) getParent());
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
		return instockListRenderer;
	}
	
	private static final RowRenderer instockListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Instock instock = (Instock) cdata.getData();

			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_INSTOCK, instock.getInId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_INSTOCK);
			cb.setParent(div);
			
			Label idLabel = new Label();
			idLabel.setValue(String.valueOf(instock.getInId()));
			idLabel.setParent(div);
			div.setParent(row);
			
			Label timeLabel = new Label();
			String time = Utility.listTimeFormat.format(instock.getInTime());
			timeLabel.setValue(time);
			timeLabel.setParent(row);
			
			Label operatorLabel = new Label();
			operatorLabel.setValue(instock.getOperator());
			operatorLabel.setParent(row);
			
			Grid detailGrid = new Grid();
			detailGrid.setStyle("border:0px;");
			Rows detailRows = new Rows();
			detailRows.setStyle("border:0px;");
			
			try{
				List<Instockproduct> list = InstockAccessor.getInstockProductlistByInid(instock.getInId());
				Instockproduct inpro = null;
				for(int i=0;i<list.size();i++){
					inpro = list.get(i);
					Productinfo prod = ConstAccessor.getProductById(inpro.getProductId());
					
					Row detailRow = new Row();
					detailRow.setStyle("border:0px;");
					
					Label nameLabel = new Label();
					nameLabel.setValue(prod.getName());
					nameLabel.setParent(detailRow);
					
					Label countLabel = new Label();
					countLabel.setValue(String.valueOf(inpro.getCount()));
					countLabel.setParent(detailRow);
					
					Label priceLabel = new Label();
					priceLabel.setValue(String.valueOf(inpro.getPrice()));
					priceLabel.setParent(detailRow);
					
					detailRow.setParent(detailRows);
				}
			}catch(Exception e){
				Utility.logger.error(e);
			}
			
			detailRows.setParent(detailGrid);
			detailGrid.setParent(row);
			
			A ta = new A();
			ta.setHref(Utility.INSTOCK_DETAIL_FILE_NAME+"?" + Utility.PARA_NAME_ID + "=" +instock.getInId());
			ta.setTarget("_blank");
			ta.setLabel("详情");
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
			Checkbox inidbox = (Checkbox)getFellow("inidbox");
			
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
			
			if(inidbox.isChecked()){
				Textbox inidtb = (Textbox)getFellow("inidtb");
				this.inId = Integer.parseInt(inidtb.getValue());
				this.queryType = Utility.QUERY_TYPE_INID;
			}else if(prodbox.isChecked() && !datebox.isChecked()){
				this.queryType = Utility.QUERY_TYPE_PROD;
			}else if(prodbox.isChecked() && datebox.isChecked()){
				this.queryType = Utility.QUERY_TYPE_PROD_TIME;
			}else if(!prodbox.isChecked() && datebox.isChecked()){
				this.queryType = Utility.QUERY_TYPE_TIME;
			}else{
				this.queryType = Utility.QUERY_TYPE_NO;
			}
			
			this.initData();
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}

}
