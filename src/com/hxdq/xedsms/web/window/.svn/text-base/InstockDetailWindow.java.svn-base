package com.hxdq.xedsms.web.window;

import java.util.List;

import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.InstockAccessor;
import com.hxdq.xedsms.db.model.Instock;
import com.hxdq.xedsms.db.model.Instockproduct;
import com.hxdq.xedsms.db.model.OutstockProduct;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.web.common.ContentWindow;

public class InstockDetailWindow extends ContentWindow {
	private Instock instock = null;
	private List<Instockproduct> inproList = null;
	
	public void onCreate(){
		try{
			String id = this.getPage().getDesktop().getExecution().getParameter(Utility.PARA_NAME_ID);
			int inId = Integer.parseInt(id);
			Utility.logger.info("Display info for instock:" + inId);
			
			instock = InstockAccessor.getInstockByInid(inId);
			inproList = InstockAccessor.getInstockProductlistByInid(inId);
			
			if(instock == null || inproList == null){
				Utility.logger.error("Error when get info for outid:"+inId);
				return;
			}
			
			Label inidLabel = (Label)getFellow("inidLabel");
			inidLabel.setValue(String.valueOf(instock.getInId()));
			
			Label intime = (Label)getFellow("intime");
			intime.setValue(Utility.listTimeFormat.format(instock.getInTime()));
			
			Label operator = (Label)getFellow("operator");
			operator.setValue(instock.getOperator());
			
			Grid listGrid = (Grid)getFellow("listGrid");
			listGrid.setModel(this.getListModel());
			listGrid.setRowRenderer(this.inProRenderer);
		}catch(Exception e){
			Utility.logger.error("onCreate", e);
		}
	}
	
	public ListModel getListModel(){
		return new SimpleListModel(this.inproList);
	}
	public RowRenderer getListRowRenderer() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return inProRenderer;
	}
	
	private static final RowRenderer inProRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			Instockproduct inpro = (Instockproduct)data;
			
			String proName;
			try{
				Productinfo pro = ConstAccessor.getProductById(inpro.getProductId());
				proName = Utility.getProductLongName(pro);
			}catch(Exception e){
				Utility.logger.error(e);
				proName = Utility.UNKNOWN_NAME;
			}
			
			Label nameLabel = new Label();
			nameLabel.setValue(proName);
			nameLabel.setParent(row);
			nameLabel.setStyle("font-size:12pt");
			
			Label countLabel = new Label();
			countLabel.setValue(String.valueOf(inpro.getCount()));
			countLabel.setParent(row);
			countLabel.setStyle("font-size:12pt");
			
			Label priceLabel = new Label();
			priceLabel.setValue(String.valueOf(inpro.getPrice()));
			priceLabel.setParent(row);
			priceLabel.setStyle("font-size:12pt");
		}
	};
}
