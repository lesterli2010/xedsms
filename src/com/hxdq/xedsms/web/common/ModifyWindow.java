package com.hxdq.xedsms.web.common;

import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;

import com.hxdq.xedsms.*;

public abstract class ModifyWindow extends ContentWindow {
	protected String rtnPage;
	protected AnnotateDataBinder binder = null;
	protected Object beanObj;
	protected String beanID;
	protected boolean success = false;
	private Div p1, p2;

	public abstract void modifyData() throws Exception;

	public abstract boolean verifyInput() throws Exception;

	public void onCreate() {
		if (binder == null) {
			binder = new AnnotateDataBinder(this);
		}
		binder.bindBean(beanID, beanObj);
		// initialize UI components
		binder.loadAll();

		p1 = (Div) getFellow("panel1");
		p2 = (Div) getFellow("panel2");
		super.onCreate();
	}

	public void update() {
		// copy UI components values to data bean properties in one method call.
		binder.saveAll();
	}

	public void modify() {
		try {

			if (!verifyInput()) {
				Utility.logger.error("Input is not valid!");
				return;
			}

			success = false;
			p1.setVisible(false);
			p2.setVisible(true);

			modifyData();

			success = true;
			Hbox hb = (Hbox) getFellow("allsucchbx");
			hb.setVisible(true);

		} catch (Exception e) {
			Utility.logger.error("Exception happened when modify information:"
					+ e.getMessage());
			Hbox hbx = (Hbox) getFellow("errorchbx");
			hbx.setVisible(true);
			Label lb = (Label) getFellow("errorDetailLabel");
			lb.setValue(e.getMessage());
		} finally {
			Div rtnDiv = (Div) getFellow("rtnDiv");
			rtnDiv.setVisible(true);
		}
	}

	public void back() {
		Include include = (Include) this.getParent();
		include.setSrc(null);
		include.setSrc(rtnPage);
	}

	public void rtn() {
		if (success) {
			success = false;
			back();
			return;
		}

		p1.setVisible(true);
		p2.setVisible(false);

		Div rtnDiv = (Div) getFellow("rtnDiv");
		rtnDiv.setVisible(false);

		Hbox hb = (Hbox) getFellow("allsucchbx");
		hb.setVisible(false);

		Hbox hbx = (Hbox) getFellow("errorchbx");
		hbx.setVisible(false);
	}
}
