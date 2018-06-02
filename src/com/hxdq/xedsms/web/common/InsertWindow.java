package com.hxdq.xedsms.web.common;

import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;
import com.hxdq.xedsms.*;

public abstract class InsertWindow extends ContentWindow {
	protected String rtnPage;
	private AnnotateDataBinder binder = null;
	protected Object beanObj;
	protected String beanID;
	protected boolean success = false;
	private Div p1,p2;
	
	public abstract void insertData() throws Exception;
	public abstract boolean verifyInput() throws Exception;
	
	public void onCreate(){
		binder = new AnnotateDataBinder(this);
		binder.bindBean(beanID, beanObj);
		// initialize UI components
		binder.loadAll();
		
		p1 = (Div)getFellow("panel1");
		p2 = (Div)getFellow("panel2");
	}
	
	public void update() {
		// copy UI components values to data bean properties in one method call.
		binder.saveAll();
	}
	
	public void insert(){
		try{
			if(!verifyInput()){
				Utility.logger.error("Input is not correct");
				return;
			}
			p1.setVisible(false);
			p2.setVisible(true);
			
			insertData();
			
			Hbox succhbx = (Hbox)getFellow("allsucchbx");
			succhbx.setVisible(true);
			success = true;
		}catch(Exception e){
			Utility.logger.error("Exception when submit Data.", e);
			Hbox errorchbx = (Hbox)getFellow("errorchbx");
			errorchbx.setVisible(true);
			Label error = (Label)getFellow("errorDetailLabel");
			error.setValue(e.toString());
		}finally{
			Div rtnDiv = (Div)getFellow("rtnDiv");
			rtnDiv.setVisible(true);
		}
	}
	
	public void back(){
		if(success){
			success = false;
			addNextOne();
			return;
		}

		Hbox hbx = (Hbox)getFellow("allsucchbx");
		hbx.setVisible(false);
		hbx = (Hbox)getFellow("errorchbx");
		hbx.setVisible(false);
		Div rtnDiv = (Div)getFellow("rtnDiv");
		rtnDiv.setVisible(false);

		p1.setVisible(true);
		p2.setVisible(false);
	}
	
	public void addNextOne(){
		Include include = (Include)this.getParent();
		include.setSrc(null);
		include.setSrc(this.fileName);
	}
}
