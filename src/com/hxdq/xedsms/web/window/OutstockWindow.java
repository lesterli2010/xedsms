package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Image;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.InstockAccessor;
import com.hxdq.xedsms.db.accessor.OutstockAccessor;
import com.hxdq.xedsms.db.accessor.StockStatusAccessor;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.web.common.InsertWindow;

public class OutstockWindow extends InsertWindow {

	private Rows listRow = null;
	private int productCount = 0;
	private Button delBtn = null;
	private Label errorInputLabel = null;
	private ArrayList<OutstockProduct> outstockProductList = new ArrayList<OutstockProduct>();
	private ArrayList<Productbatch> productBatchList = new ArrayList<Productbatch>();
	private int provId = 15; // default to shang dong province.
	private HashMap<Integer, Integer> proCountMap = new HashMap<Integer, Integer>();
	private Combobox city = null;
	private Combobox province = null;
	private Combobox customer = null;
	private Combobox saler = null;
	private Datebox saledate = null;
	private Datebox outtime = null;
	private Textbox address = null;
	private void addProductRow() throws Exception{
		Row row = new Row();
		row.setId(Utility.PRO_ROW_NAME+productCount);
		Label indexLabel = new Label();
		indexLabel.setValue(String.valueOf(this.productCount + 1));
		indexLabel.setParent(row);
		
		Combobox prodCom = new Combobox();
		prodCom.setModel(Utility.getProductListModel());
		prodCom.setItemRenderer(Utility.productAllinOneItemRenderer);
		prodCom.setId(Utility.PRO_ID_NAME+this.productCount);
		prodCom.setReadonly(true);
		prodCom.addEventListener("onChange",
				(EventListener) (new SelectProdComboEventListener(this.productCount)));
		prodCom.setWidth("80%");
		prodCom.setParent(row);
		
		Textbox countTb = new Textbox();
		countTb.setId(Utility.PRO_COUNT_NAME+this.productCount);
		countTb.setValue("0");
		countTb.setWidth("80%");
		countTb.setParent(row);
		
		Textbox priceTb = new Textbox();
		priceTb.setId(Utility.PRO_PRICE_NAME+this.productCount);
		priceTb.setValue("0");
		priceTb.setWidth("80%");
		priceTb.setParent(row);
		
		Combobox usageCom = new Combobox();
		usageCom.setModel(Utility.getUsageListModel());
		usageCom.setItemRenderer(Utility.usageItemRenderer);
		usageCom.setId(Utility.PRO_USAGE_NAME+this.productCount);
		usageCom.setReadonly(true);
		usageCom.setWidth("80%");
		usageCom.setParent(row);
		
		Button barBtn = new Button();
		barBtn.setId(Utility.PRO_BAR_BTN+this.productCount);
		barBtn.setLabel("生成条码");
		barBtn.addEventListener("onClick",
				(EventListener) (new GenerateBarCodeEventListener(this.productCount)));
		barBtn.setParent(row);
		
		Image image = new Image();
		image.setId(Utility.PRO_BAR_IMG+this.productCount);
		image.setParent(row);
		
		Label statusLabel = new Label();
		statusLabel.setId(Utility.PRO_REMAIN_NAME+this.productCount);
		statusLabel.setValue("0");
		statusLabel.setParent(row);
		
		row.setParent(this.listRow);
		
		this.productCount++;
		if(this.productCount>1){
			delBtn.setDisabled(false);
		}
	}
	
	private void delProductRow() throws Exception{
		if(this.productCount <=1){
			return;
		}
		productCount--;
		Row row = (Row)getFellow(Utility.PRO_ROW_NAME+this.productCount);
		this.listRow.removeChild(row);
		
		if(this.productCount <= 1){
			delBtn.setDisabled(true);
		}
	}
	public void onCreate(){
		try{
			this.fileName = "outstock.zul";
			this.rtnPage = "outstock.zul";
			
			super.onCreate();
			listRow = (Rows)getFellow("listRow");
			delBtn = (Button)getFellow("delBtn");
			delBtn.setDisabled(true);
			this.addProductRow();
			errorInputLabel = (Label)getFellow("errorInputLabel");
			
			city = (Combobox)getFellow("city");
			province = (Combobox)getFellow("province");
			saler = (Combobox)getFellow("saler");
			customer = (Combobox)getFellow("customer");
			
			customer.setSelectedIndex(0);
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
			customer.setReadonly(true);
			
			Date now = new Date();
			saledate = (Datebox)getFellow("saledate");
			saledate.setValue(now);
			outtime = (Datebox)getFellow("outtime");
			outtime.setValue(now);
			
			address = (Textbox)getFellow("address");
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void insertData() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Outstock outstock = null;
		try{
			outstock = new Outstock();
			outstock.setOutTime(outtime.getValue());
			outstock.setCityId((Integer)city.getSelectedItem().getValue());
			outstock.setCustomerId((Integer)customer.getSelectedItem().getValue());
			outstock.setSalerId((Integer)saler.getSelectedItem().getValue());
			outstock.setSaleTime(saledate.getValue());
			outstock.setAddress(address.getValue());
			outstock.setOperator(Utility.getCurrentUserID());
			OutstockAccessor.insert(outstock, this.outstockProductList, this.productBatchList);
		}catch(Exception e){
			Utility.logger.error(e);
			this.errorInputLabel.setVisible(true);
			this.errorInputLabel.setValue("数据库操作失败！");
			this.outstockProductList.clear();
			this.proCountMap.clear();
			this.productBatchList.clear();
			throw e;
		}
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try{
			
			Combobox proId;
			Combobox usageId;
			Textbox countTb;
			Textbox priceTb;
			Image barImg;
			boolean barSuccess = true;
			if(productCount <=0){
				Utility.logger.error("productCount should not be 0");
				errorInputLabel.setVisible(true);
				errorInputLabel.setValue("产品不能为空！");
				return false;
			}
			
			for(int i=0;i<this.productCount;i++){
				proId = (Combobox)getFellow(Utility.PRO_ID_NAME+i);
				usageId = (Combobox)getFellow(Utility.PRO_USAGE_NAME+i);
				countTb = (Textbox)getFellow(Utility.PRO_COUNT_NAME+i);
				priceTb = (Textbox)getFellow(Utility.PRO_PRICE_NAME+i);
				barImg = (Image)getFellow(Utility.PRO_BAR_IMG+i);
				
				String barCode = (String)barImg.getAttribute(Utility.PRO_BAR_VAL);
				if(barCode == null){
					Utility.logger.error("条形码失败！");
					errorInputLabel.setValue("条形码产生失败！");
			    	errorInputLabel.setVisible(true);
					this.outstockProductList.clear();
					this.proCountMap.clear();
					return false;
				}
				
				Productbatch batch = ConstAccessor.getProductBatch((Integer)proId.getSelectedItem().getValue(), 
						(Integer)city.getSelectedItem().getValue());
				batch.setBatchId((Integer)barImg.getAttribute(Utility.PRO_BATCH_ID));
				this.productBatchList.add(batch);
						
				OutstockProduct outpro = new OutstockProduct();
				outpro.setProductId((Integer)proId.getSelectedItem().getValue());
				outpro.setCount(Integer.parseInt(countTb.getValue()));
				outpro.setPrice(Float.parseFloat(priceTb.getValue()));
				outpro.setUsageId((Integer)usageId.getSelectedItem().getValue());
				outpro.setBarcode(barCode);
				this.outstockProductList.add(outpro);
				
				
				
				Integer count = proCountMap.get(outpro.getProductId());
				if(count != null){
					count += outpro.getCount();
				}else{
					count = outpro.getCount();
				}
				
				proCountMap.put(outpro.getProductId(), count);
			}
			
			
			Iterator iter = proCountMap.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry entry = (Map.Entry) iter.next();
			    Integer key = (Integer)entry.getKey();
			    Integer val = (Integer)entry.getValue();
			    Utility.logger.info("key:" + key + ",value:" + val);
			    Stockstatus status = StockStatusAccessor.getStockstatusById(key);
			    if(val > status.getRemaincount()){
			    	errorInputLabel.setValue("产品库存不足！");
			    	errorInputLabel.setVisible(true);
					this.outstockProductList.clear();
					this.proCountMap.clear();
					this.productBatchList.clear();
					return false;
			    }
			} 
			
			return true;
		}catch(Exception e){
			errorInputLabel.setValue("出库信息不完整，请完善信息！");
			errorInputLabel.setVisible(true);
			this.proCountMap.clear();
			this.outstockProductList.clear();
			this.productBatchList.clear();
			return false;
		}
	}
	
	public ListModel getCustomerModel(){
		return Utility.getCustomerListModel();
	}
	
	public ComboitemRenderer getCustomerRenderer(){
		return Utility.customerItemRenderer;
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
	
	public void add(){
		try{
			this.addProductRow();
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	public void delete(){
		try{
			this.delProductRow();
		}catch(Exception e){
			Utility.logger.error(e);
		}
		
	}

	
	

}
