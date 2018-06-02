/**
 * 
 */
package com.hxdq.xedsms.web.window;

import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.web.common.InsertWindow;

/**
 * @author zhiqiang
 *
 */
public class AddSalerWindow extends InsertWindow {

	private Saler saler = null;
	public void onCreate(){
		try{
			this.fileName = "add_saler.zul";
			this.rtnPage = "add_saler.zul";
			saler = new Saler();
			
			this.beanID = "saler";
			this.beanObj = saler;
			super.onCreate();
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
		SalerAccessor.insert(saler);
	}

	/* (non-Javadoc)
	 * @see com.hxdq.xedsms.web.common.InsertWindow#verifyInput()
	 */
	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(((Textbox)getFellow("name")).isValid() == false){
			((Textbox)getFellow("name")).setFocus(true);
			return false;
		}
		return true;
	}

}
