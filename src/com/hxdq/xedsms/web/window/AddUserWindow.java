package com.hxdq.xedsms.web.window;

import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.UserAccessor;
import com.hxdq.xedsms.db.model.User;
import com.hxdq.xedsms.db.model.Userauthority;
import com.hxdq.xedsms.web.common.InsertWindow;

public class AddUserWindow extends InsertWindow {

	private User user = null;
	private Button submitBtn = null;
	private Div availableDiv, unavailableDiv;
	private Combobox authority;
	public void onCreate(){
		try{
			this.fileName = "create_user.zul";
			this.rtnPage = "create_user.zul";
			user = new User();
			
			this.beanID = "user";
			this.beanObj = user;
			super.onCreate();
			
			submitBtn = (Button)getFellow("submitBtn");
			submitBtn.setDisabled(true);
			
			unavailableDiv = (Div)getFellow("unavailableDiv");
			availableDiv = (Div)getFellow("availableDiv");
			authority = (Combobox)getFellow("authority");
			authority.setSelectedIndex(0);
			authority.setReadonly(true);
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void insertData() throws Exception {
		// TODO Auto-generated method stub
		String passwd = Utility.getMD5(Utility.DEFAULT_PASSWD);
		Utility.logger.info("passwd of " + Utility.DEFAULT_PASSWD + " is " + passwd);
		Utility.logger.info("userid: " + user.getUserid());
		
		user.setPassword(passwd);
		user.setStatus(true);
		Userauthority userA = new Userauthority();
		userA.setUserid(user.getUserid());
		userA.setAuthority((String)authority.getSelectedItem().getValue());
		
		UserAccessor.insert(user, userA);
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		return true;
	}
	public void onCheckUserID(InputEvent  event){
		try{
			String userID = event.getValue();
			if(userID == null || userID.isEmpty()){
				submitBtn.setDisabled(true);
				return;
			}
			boolean exist = UserAccessor.isUserIDExist(userID);		
			if(exist){
				this.availableDiv.setVisible(false);
				this.unavailableDiv.setVisible(true);
				this.submitBtn.setDisabled(true);
			}else{
				this.availableDiv.setVisible(true);
				this.unavailableDiv.setVisible(false);
				this.submitBtn.setDisabled(false);
			}
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	

}
