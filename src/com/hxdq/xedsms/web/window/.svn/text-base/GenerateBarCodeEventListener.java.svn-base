package com.hxdq.xedsms.web.window;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.model.Productinfo;

public class GenerateBarCodeEventListener implements EventListener {

	private int _prodId;
	private int _cityId;
	private int _index;
	public GenerateBarCodeEventListener(int index){
		this._index = index;
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		Component parent = null;
		Combobox productCom = null;
		Combobox cityCom = null;
		try{
			parent = event.getTarget().getParent();			
			Image image = (Image)parent.getFellow(Utility.PRO_BAR_IMG+this._index);
			
			productCom = (Combobox)parent.getFellow(Utility.PRO_ID_NAME+this._index);
			cityCom = (Combobox)parent.getFellow("city");
			this._prodId = (Integer)productCom.getSelectedItem().getValue();
			this._cityId = (Integer)cityCom.getSelectedItem().getValue();
			
			Productinfo product = ConstAccessor.getProductById(this._prodId);
			int batchId = Utility.getNextProductBatchId(_prodId, _cityId);
			String barCode = Utility.getBarCode(product, _cityId, batchId);
			Utility.logger.info("getBarCode:" + barCode + ",batchId:" + batchId);
			String src = Utility.getBarCodeImgSrc(barCode);
			image.setSrc(src);
			image.setAttribute(Utility.PRO_BAR_VAL, barCode);
			image.setAttribute(Utility.PRO_BATCH_ID, batchId);
			image.setWidth("230");
			image.setHeight("80");
		}catch(Exception e){
			Utility.logger.error("Exception when generate BarCode:", e);
		}
	}

}
