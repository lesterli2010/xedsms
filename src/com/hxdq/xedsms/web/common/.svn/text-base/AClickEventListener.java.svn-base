/**
 * 
 */
package com.hxdq.xedsms.web.common;

import java.util.Collection;
import java.util.Iterator;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Include;

import com.hxdq.xedsms.*;
/**
 * @author zhiqiang
 *
 */
public class AClickEventListener implements EventListener {

	private Include content = null;
	
	public AClickEventListener(Include _content){
		this.content = _content;
	}
	
	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.event.EventListener#onEvent(org.zkoss.zk.ui.event.Event)
	 */
	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		A a= (A)event.getTarget();
		
		if(content != null){
			content.setDynamicProperty(Utility.PARA_NAME_ID, a.getAttribute(Utility.PARA_NAME_ID));
			content.setDynamicProperty(Utility.RTN_PAGE, a.getAttribute(Utility.RTN_PAGE));
			content.setSrc(a.getHref());
		}
	}

}
