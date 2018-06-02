package com.hxdq.xedsms.web.common;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import com.hxdq.xedsms.*;

public abstract class ContentWindow extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String lang;
	protected String fileName = null;
	
	public void onCreate(){
		
	}
}
