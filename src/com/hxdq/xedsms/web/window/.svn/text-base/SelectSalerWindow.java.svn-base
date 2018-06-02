package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.web.common.AClickEventListener;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;

public class SelectSalerWindow extends SelectListWindow {

	public void onCreate(){
		try{
			this.fileName = Utility.SELECT_SALER_FILE_NAME;
			super.onCreate();	
			this.cbType = Utility.CB_TYPE_SALER;
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		int salerId = Integer.parseInt(id);
		for (int i = 0; i < this.listData.size(); i++) {
			if (salerId == ((Saler)this.listData.get(i).getData()).getSalerId()) {
				// First delete it from DB
				try{
					SalerAccessor.deleteById(salerId);
					// No error happen, delete it from list.
					this.listData.remove(i);
					Utility.logger.info("Saler " + salerId + " is deleted.");
				}catch(Exception e){
					Utility.logger.error("Exception happened when delete AD " + salerId, e);
				}
			}
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
			return SalerAccessor.getTotalCount();
		}catch(Exception e){
			Utility.logger.error(e);
			return 0;
		}
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		try{
			List<Saler> salerList = SalerAccessor.getSaler();
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; salerList != null && i < salerList.size(); i++) {
				RowData row = new RowData(salerList.get(i), i + 1, (Include) getParent());
				list.add(row);
			}
			return list;
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}

	@Override
	public RowRenderer getListRowRenderer() {
		// TODO Auto-generated method stub
		return this.salerListRenderer;
	}
	
	private static final RowRenderer salerListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Saler saler = (Saler) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_SALER, saler.getSalerId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_SALER);
			cb.setParent(div);
			
			A ta = new A();
			ta.setHref(Utility.MODIFY_SALER_FILE_NAME);
			ta.setAttribute(Utility.PARA_NAME_ID, saler.getSalerId());
			ta.setLabel(saler.getName());
			ta.addEventListener("onClick",
					(EventListener) (new AClickEventListener(cdata
							.getContentPage())));
			ta.setAttribute(Utility.RTN_PAGE, Utility.SELECT_SALER_FILE_NAME);
			ta.setParent(div);
			div.setParent(row);
			
			Label phoneLabel = new Label();
			phoneLabel.setValue(saler.getPhone());
			phoneLabel.setParent(row);
			
			Label positionLabel = new Label();
			positionLabel.setValue(saler.getPosition());
			positionLabel.setParent(row);
		}
	};

}
