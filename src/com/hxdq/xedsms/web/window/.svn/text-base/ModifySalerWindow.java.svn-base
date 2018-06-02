package com.hxdq.xedsms.web.window;

import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.web.common.ModifyWindow;

public class ModifySalerWindow extends ModifyWindow {

	private Saler saler = null;
	
	private void getCurrentSaler() {
		try {
			int id = (Integer)Utility.getParaID(this);
			rtnPage = (String)Utility.getRtnPage(this);
			if(rtnPage == null){
				this.rtnPage = Utility.SELECT_SALER_FILE_NAME;
			}
			saler = SalerAccessor.getSalerById(id);
		} catch (Exception e) {
			Utility.logger.error(e);
		}
	}
	
	public void onCreate() {
		getCurrentSaler();
		this.fileName = Utility.MODIFY_SALER_FILE_NAME;
		this.beanID = "saler";
		this.beanObj = saler;
		try{
			super.onCreate();
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
		
	@Override
	public void modifyData() throws Exception {
		// TODO Auto-generated method stub
		SalerAccessor.update(saler);
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		if(((Textbox)getFellow("name")).isValid() == false){
			((Textbox)getFellow("name")).setFocus(true);
			return false;
		}
		return true;
	}

}
