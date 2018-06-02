package com.hxdq.xedsms.web.window;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;

import com.hxdq.xedsms.db.accessor.*;
import com.hxdq.xedsms.db.model.Stockstatus;
import com.hxdq.xedsms.Utility;

public class SelectProdComboEventListener implements EventListener {

	private int _index;
	public SelectProdComboEventListener(int index){
		this._index = index;
	}
	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		Component parent = null;
		Image img = null;
		try{
			parent = event.getTarget().getParent();
			try{
			img = (Image)parent.getFellow(Utility.PRO_BAR_IMG+this._index);
			if(img != null){
				img.removeAttribute(Utility.PRO_BAR_VAL);
				img.setSrc("");
			}}
			catch(Exception e){}
			
			Combobox proCom = (Combobox)parent.getFellow(Utility.PRO_ID_NAME+this._index);
			Stockstatus status = StockStatusAccessor.getStockstatusById((Integer) proCom.getSelectedItem().getValue());
			Label label = (Label)parent.getFellow(Utility.PRO_REMAIN_NAME+this._index);
			label.setValue(String.valueOf(status.getRemaincount()));
			
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}

}
