package com.hxdq.xedsms.web.window;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.model.Dkspecinfo;
import com.hxdq.xedsms.db.model.Specinfo;
import com.hxdq.xedsms.db.model.Usageinfo;

public class ModifyBtnClickEventListener implements EventListener {

	private int _id;
	private int _type;
	public ModifyBtnClickEventListener(int id, int type){
		this._id = id;
		this._type = type;
	}
	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		Component parent;
		Textbox tb = null;
		Button btn = null;
		boolean success = false;
		try{
			parent = event.getTarget().getParent();
			tb = (Textbox)parent.getFellow(Utility.OTHER_DATA_NAME+_id);
			btn = (Button)parent.getFellow(Utility.MODIFY_BTN_NAME+_id);
			switch(_type){
			case Utility.OTHER_DATA_TYPE_DKSPEC:
				Dkspecinfo dkspec = new Dkspecinfo();
				dkspec.setDkspecId(_id);
				dkspec.setDkspecName(tb.getValue());
				ConstAccessor.update(dkspec);
				success = true;
				break;
			case Utility.OTHER_DATA_TYPE_SPEC:
				Specinfo spec = new Specinfo();
				spec.setSpecId(_id);
				spec.setSpecName(tb.getValue());
				ConstAccessor.update(spec);
				success = true;
				break;
			case Utility.OTHER_DATA_TYPE_USAGE:
				Usageinfo usage = new Usageinfo();
				usage.setUsageId(_id);
				usage.setUsageName(tb.getValue());
				ConstAccessor.update(usage);
				success = true;
				break;
			default:
				Utility.logger.error("Unknown type:" + _type);
			}
			if(success){
				btn.setLabel("修改成功");
				btn.setDisabled(true);
			}
			Utility.logger.info("Modify data" + tb.getValue() + ", " + _id);
		}catch(Exception e){
			Utility.logger.error(e);
		}

	}

}
