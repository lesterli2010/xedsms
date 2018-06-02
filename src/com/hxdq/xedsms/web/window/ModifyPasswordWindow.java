package com.hxdq.xedsms.web.window;


import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import org.zkoss.zk.ui.event.InputEvent;
import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.UserAccessor;
import com.hxdq.xedsms.db.model.User;
import com.hxdq.xedsms.web.common.ModifyWindow;

public class ModifyPasswordWindow extends ModifyWindow {

	private Div availableDiv1,unavailableDiv1,availableDiv2,unavailableDiv2;
	private Button modifyBtn;
	private User user;
	public void onCreate() {
		try{
			String userID = Utility.getCurrentUserID();
			Label userid = (Label)getFellow("userid");
			userid.setValue(userID);
			
			user = UserAccessor.getUserByID(userID);
			
			if(user == null){
				Utility.logger.error("user is null for userID:" + userID);
			}
			
			this.fileName = "modify_password.zul";
			this.beanID = "user";
			this.beanObj = user;
			super.onCreate();
			availableDiv1 = (Div)getFellow("availableDiv1");
			unavailableDiv1 = (Div)getFellow("unavailableDiv1");
			availableDiv2 = (Div)getFellow("availableDiv2");
			unavailableDiv2 = (Div)getFellow("unavailableDiv2");
			modifyBtn = (Button)getFellow("modifyBtn");
			modifyBtn.setDisabled(true);
			
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	@Override
	public void modifyData() throws Exception {
		// TODO Auto-generated method stub
		String passwd = ((Textbox)getFellow("password1")).getValue();
		
		String md5Password = Utility.getMD5(passwd);
		user.setPassword(md5Password);
		UserAccessor.update(user);
	}

	@Override
	public boolean verifyInput() throws Exception {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void onPassword1Change(InputEvent  event){
		try{
			String password = event.getValue();
			String passwordConfirm = ((Textbox)getFellow("password2")).getValue();
			this.refreshPageLabel(password, passwordConfirm);			
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	public void onPassword2Change(InputEvent  event){
		try{
			String password = ((Textbox)getFellow("password1")).getValue();
			String passwordConfirm = event.getValue();
			this.refreshPageLabel(password, passwordConfirm);		
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	private void refreshPageLabel(String p1, String p2){
		
		if(p1.isEmpty() || p2.isEmpty()){
			modifyBtn.setDisabled(true);
			return;
		}
		
		if(!p1.equals(p2)){
			modifyBtn.setDisabled(true);
			availableDiv1.setVisible(false);
			unavailableDiv1.setVisible(true);
			availableDiv2.setVisible(false);
			unavailableDiv2.setVisible(true);
		}else{
			modifyBtn.setDisabled(false);
			if(p1.equals("")){
				availableDiv1.setVisible(false);
				unavailableDiv1.setVisible(false);
				availableDiv2.setVisible(false);
				unavailableDiv2.setVisible(false);
			}else{
				availableDiv1.setVisible(true);
				unavailableDiv1.setVisible(false);
				availableDiv2.setVisible(true);
				unavailableDiv2.setVisible(false);
			}
		}
	}

}
