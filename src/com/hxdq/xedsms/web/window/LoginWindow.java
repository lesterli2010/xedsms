package com.hxdq.xedsms.web.window;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.web.common.*;

public class LoginWindow extends ContentWindow {
	public void onCreate() {
		Label loginErrorLabel = (Label) getFellow("loginErrorLabel");

		String error = (String) Executions.getCurrent().getParameter("error");

		if (error != null && error.equals("true")) {
			loginErrorLabel.setVisible(true);
		}

		Textbox userID = (Textbox) getFellow("userID");
		userID.setFocus(true);
	}
}
