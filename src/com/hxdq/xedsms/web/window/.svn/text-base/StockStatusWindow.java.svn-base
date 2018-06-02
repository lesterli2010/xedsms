package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.accessor.StockStatusAccessor;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.db.model.Stockstatus;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;

public class StockStatusWindow extends SelectListWindow {
	public void onCreate(){
		try{
			Label currentTime = (Label)getFellow("currentTime");
			currentTime.setValue(Utility.listTimeFormat.format(new java.util.Date()));
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
			return StockStatusAccessor.getTotalCount();
		}catch(Exception e){
			Utility.logger.error(e);
		}
		return 0;
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		try{
			List<Stockstatus> statusList = StockStatusAccessor.getStockstatus();
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; statusList != null && i < statusList.size(); i++) {
				RowData row = new RowData(statusList.get(i), i + 1, (Include) getParent());
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
		return this.statusListRenderer;
	}
	
	private static final RowRenderer statusListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Stockstatus status = (Stockstatus) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);
			indexLabel.setStyle("font-size:12pt");
			
			String proName;
			try{
				Productinfo pro = ConstAccessor.getProductById(status.getProductId());
				proName = Utility.getProductLongName(pro);
			}catch(Exception e){
				Utility.logger.error(e);
				proName = Utility.UNKNOWN_NAME;
			}
			
			Label nameLabel = new Label();
			nameLabel.setValue(proName);
			nameLabel.setParent(row);
			nameLabel.setStyle("font-size:12pt");
			
			Label inLabel = new Label();
			inLabel.setValue(String.valueOf(status.getIncount()));
			inLabel.setParent(row);
			inLabel.setStyle("font-size:12pt");
			Label outLabel = new Label();
			outLabel.setValue(String.valueOf(status.getOutcount()));
			outLabel.setParent(row);
			outLabel.setStyle("font-size:12pt");
			Label remainLabel = new Label();
			remainLabel.setValue(String.valueOf(status.getRemaincount()));
			remainLabel.setParent(row);
			remainLabel.setStyle("font-size:12pt");
			String time;
			try{
				time = Utility.listTimeFormat.format(status.getUpdatetime());
			}catch(Exception e){
				time = Utility.UNKNOWN_NAME;
				Utility.logger.error(e);
			}
			Label timeLabel = new Label();
			timeLabel.setValue(time);
			timeLabel.setParent(row);
			timeLabel.setStyle("font-size:12pt");
		}
	};

}
