package com.hxdq.xedsms.web.window;

import java.util.List;

import org.zkoss.zul.RowRenderer;

import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Tabbox;

import com.hxdq.xedsms.*;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.accessor.StockStatusAccessor;
import com.hxdq.xedsms.web.common.AClickEventListener;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;
import org.zkoss.zul.Include;
import org.zkoss.zul.api.Textbox;

public class SelectProductWindow extends SelectListWindow {

	public void onCreate(){
		try{
			this.fileName = "select_product.zul";
			super.onCreate();	
			this.cbType = Utility.CB_TYPE_PRODUCT;
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int proId = Integer.parseInt(id);
		for (int i = 0; i < this.listData.size(); i++) {
			if (proId == ((Productinfo)this.listData.get(i).getData()).getProductId()) {
				// First delete it from DB
				try{
					ConstAccessor.deleteProductById(proId);
					StockStatusAccessor.deleteById(proId);
					// No error happen, delete it from list.
					this.listData.remove(i);
					Utility.logger.info("Customer " + proId + " is deleted.");
				}catch(Exception e){
					Utility.logger.error("Exception happened when delete AD " + proId, e);
				}
			}
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
			return ConstAccessor.getTotalProductCount();
		}catch(Exception e){
			Utility.logger.error(e);
			return 0;
		}
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		try{
			List<Productinfo> productList = ConstAccessor.getTotalProduct();
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; productList != null && i < productList.size(); i++) {
				RowData row = new RowData(productList.get(i), i + 1, (Include) getParent());
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
		return productListRenderer;
	}
	
	private static final RowRenderer productListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Productinfo product = (Productinfo) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_PRODUCT, product.getProductId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_PRODUCT);
			cb.setParent(div);
			
			A ta = new A();
			ta.setHref(Utility.MODIFY_PRODUCT_FILE_NAME);
			ta.setAttribute(Utility.PARA_NAME_ID, product.getProductId());
			ta.setLabel(product.getName());
			ta.addEventListener("onClick",
					(EventListener) (new AClickEventListener(cdata
							.getContentPage())));
			ta.setAttribute(Utility.RTN_PAGE, Utility.SELECT_PRODUCT_FILE_NAME);
			ta.setParent(div);
			div.setParent(row);
			
			
			String dkName;
			try{
				Dkspecinfo dkspec = ConstAccessor.getDkSpecById(product.getDkspecId());
				dkName = dkspec.getDkspecName();
			}catch(Exception e){
				Utility.logger.error(e);
				dkName = Utility.UNKNOWN_NAME;
			}
			
			Label dkLabel = new Label();
			dkLabel.setValue(dkName);
			dkLabel.setParent(row);
			
			String specName;
			try{
				Specinfo spec = ConstAccessor.getSpecinfoById(product.getSpecId());
				specName = spec.getSpecName();
			}catch(Exception e){
				Utility.logger.error(e);
				specName = Utility.UNKNOWN_NAME;
			}
			
			Label specLabel = new Label();
			specLabel.setValue(specName);
			specLabel.setParent(row);
			
			Label tempLabel = new Label();
			tempLabel.setValue(product.getTemp() + "K");
			tempLabel.setParent(row);
		}
	};

}
