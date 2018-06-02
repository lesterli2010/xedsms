/**
 * 
 */
package com.hxdq.xedsms.web.window;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Button;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.InstockAccessor;
import com.hxdq.xedsms.db.accessor.StockStatusAccessor;
import com.hxdq.xedsms.db.model.Instock;
import com.hxdq.xedsms.db.model.Instockproduct;
import com.hxdq.xedsms.db.model.Stockstatus;
import com.hxdq.xedsms.web.common.InsertWindow;

/**
 * @author zhiqiang
 *
 */
public class InstockWindow extends InsertWindow {
	private Rows listRow = null;
	private int productCount = 0;
	private Button delBtn = null;
	private Label errorInputLabel = null;
	private ArrayList<Instockproduct> instockProductList = new ArrayList<Instockproduct>();
	private Datebox intime = null;
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
			this.fileName = "instock.zul";
			this.rtnPage = "instock.zul";
			
			super.onCreate();
			listRow = (Rows)getFellow("listRow");
			delBtn = (Button)getFellow("delBtn");
			delBtn.setDisabled(true);
			this.addProductRow();
			errorInputLabel = (Label)getFellow("errorInputLabel");
			
			intime = (Datebox)getFellow("intime");
			intime.setValue(new Date());
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	/* (non-Javadoc)
	 * @see com.hxdq.xedsms.web.common.InsertWindow#insertData()
	 */
	@Override
	public void insertData() throws Exception {
		// TODO Auto-generated method stub
		Instock instock = null;
		try{
			instock = new Instock();
			instock.setInTime(intime.getValue());
			instock.setOperator(Utility.getCurrentUserID());
			InstockAccessor.insert(instock, this.instockProductList);
			
		}catch(Exception e){
			Utility.logger.error(e);
			this.errorInputLabel.setVisible(true);
			this.errorInputLabel.setValue("数据库操作失败！");
			this.instockProductList.clear();
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.hxdq.xedsms.web.common.InsertWindow#verifyInput()
	 */
	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		try{
			
			Combobox proId;
			Textbox countTb;
			Textbox priceTb;
			if(productCount <=0){
				Utility.logger.error("productCount should not be 0");
				errorInputLabel.setVisible(true);
				errorInputLabel.setValue("产品不能为空！");
				return false;
			}
			for(int i=0;i<this.productCount;i++){
				proId = (Combobox)getFellow(Utility.PRO_ID_NAME+i);
				countTb = (Textbox)getFellow(Utility.PRO_COUNT_NAME+i);
				priceTb = (Textbox)getFellow(Utility.PRO_PRICE_NAME+i);
				
				Instockproduct inpro = new Instockproduct();
				inpro.setProductId((Integer)proId.getSelectedItem().getValue());
				inpro.setCount(Integer.parseInt(countTb.getValue()));
				inpro.setPrice(Float.parseFloat(priceTb.getValue()));
				this.instockProductList.add(inpro);
			}
			
			return true;
		}catch(Exception e){
			errorInputLabel.setVisible(true);
			this.instockProductList.clear();
			return false;
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
