package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.Dkspecinfo;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Specinfo;
import com.hxdq.xedsms.db.model.Usageinfo;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;

public class OtherDataWindow extends SelectListWindow {

	private int dataType = Utility.OTHER_DATA_TYPE_DKSPEC;
	private Combobox dataTypeCombobox = null;
	public void onCreate(){
		try{
			this.fileName = "other_data.zul";
			super.onCreate();	
			this.cbType = Utility.CB_TYPE_OTHERDATA;
			this.dataTypeCombobox = (Combobox)getFellow("dataTypeCombox");
			this.dataTypeCombobox.setSelectedIndex(0);
			this.dataTypeCombobox.setReadonly(true);
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		try{
			int idd = Integer.parseInt(id);
			switch(this.dataType){
			case Utility.OTHER_DATA_TYPE_DKSPEC:
				for (int i = 0; i < this.listData.size(); i++) {
					if (idd == ((Dkspecinfo)this.listData.get(i).getData()).getDkspecId()) {
						// First delete it from DB
						try{
							ConstAccessor.deleteDkspecById(idd);
							// No error happen, delete it from list.
							this.listData.remove(i);
							Utility.logger.info("Dkspec " + idd + " is deleted.");
						}catch(Exception e){
							Utility.logger.error("Exception" + idd, e);
						}
					}
				}
				break;
			case Utility.OTHER_DATA_TYPE_SPEC:
				for (int i = 0; i < this.listData.size(); i++) {
					if (idd == ((Specinfo)this.listData.get(i).getData()).getSpecId()) {
						// First delete it from DB
						try{
							ConstAccessor.deleteSpecById(idd);
							// No error happen, delete it from list.
							this.listData.remove(i);
							Utility.logger.info("Specinfo " + idd + " is deleted.");
						}catch(Exception e){
							Utility.logger.error("Exception" + idd, e);
						}
					}
				}
				break;
			case Utility.OTHER_DATA_TYPE_USAGE:
				for (int i = 0; i < this.listData.size(); i++) {
					if (idd == ((Usageinfo)this.listData.get(i).getData()).getUsageId()) {
						// First delete it from DB
						try{
							ConstAccessor.deleteUsageById(idd);
							// No error happen, delete it from list.
							this.listData.remove(i);
							Utility.logger.info("Usage " + idd + " is deleted.");
						}catch(Exception e){
							Utility.logger.error("Exception" + idd, e);
						}
					}
				}
				break;
			default:
				Utility.logger.error("Unknown dataType:" + this.dataType);
			}
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
		switch(this.dataType){
		case Utility.OTHER_DATA_TYPE_DKSPEC:
			return ConstAccessor.getTotalDkspecCount();
		case Utility.OTHER_DATA_TYPE_SPEC:
			return ConstAccessor.getTotalSpecCount();
		case Utility.OTHER_DATA_TYPE_USAGE:
			return ConstAccessor.getTotalUsageCount();
		}
		}catch(Exception e){
			Utility.logger.error(e);
		}
		return 0;
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		try{
			List<RowData> list = new ArrayList<RowData>();
			switch(this.dataType){
			case Utility.OTHER_DATA_TYPE_DKSPEC:
				List<Dkspecinfo> dkspecList = ConstAccessor.getDkSpec();
				for (int i = 0; dkspecList != null && i < dkspecList.size(); i++) {
					RowData row = new RowData(dkspecList.get(i), i + 1, (Include) getParent());
					list.add(row);
				}
				break;
			case Utility.OTHER_DATA_TYPE_SPEC:
				List<Specinfo> specList = ConstAccessor.getSpecinfo();
				for (int i = 0; specList != null && i < specList.size(); i++) {
					RowData row = new RowData(specList.get(i), i + 1, (Include) getParent());
					list.add(row);
				}
				break;
			case Utility.OTHER_DATA_TYPE_USAGE:
				List<Usageinfo> usageList = ConstAccessor.getUsageinfo();
				for (int i = 0; usageList != null && i < usageList.size(); i++) {
					RowData row = new RowData(usageList.get(i), i + 1, (Include) getParent());
					list.add(row);
				}
				break;
			default:
				Utility.logger.error("Unknown datType:" + this.dataType);
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
		switch(this.dataType){
		case Utility.OTHER_DATA_TYPE_DKSPEC:
			return this.dkSpecListRenderer;
		case Utility.OTHER_DATA_TYPE_SPEC:
			return this.specListRenderer;
		case Utility.OTHER_DATA_TYPE_USAGE:
			return this.usageListRenderer;
		default:
			Utility.logger.error("Unknown dataType:" + this.dataType);
		}
		return null;
	}
	
	private static final RowRenderer dkSpecListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Dkspecinfo dkspec = (Dkspecinfo) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);

			Label idLabel = new Label();
			idLabel.setValue(dkspec.getDkspecId().toString());
			idLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_OTHERDATA, dkspec.getDkspecId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_OTHERDATA);
			cb.setParent(div);
			
			Textbox nameTB = new Textbox();
			nameTB.setValue(dkspec.getDkspecName());
			nameTB.setId(Utility.OTHER_DATA_NAME + dkspec.getDkspecId());
			nameTB.setParent(div);
			div.setParent(row);
			
			Button modifyBtn = new Button();
			modifyBtn.setLabel("修改");
			modifyBtn.setId(Utility.MODIFY_BTN_NAME + dkspec.getDkspecId());
			modifyBtn.addEventListener("onClick",
					(EventListener) (new ModifyBtnClickEventListener(dkspec.getDkspecId(), Utility.OTHER_DATA_TYPE_DKSPEC)));
			modifyBtn.setParent(row);
		}
	};
	
	private static final RowRenderer specListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Specinfo spec = (Specinfo) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);

			Label idLabel = new Label();
			idLabel.setValue(spec.getSpecId().toString());
			idLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_OTHERDATA, spec.getSpecId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_OTHERDATA);
			cb.setParent(div);
			
			Textbox nameTB = new Textbox();
			nameTB.setValue(spec.getSpecName());
			nameTB.setId(Utility.OTHER_DATA_NAME + spec.getSpecId());
			nameTB.setParent(div);
			div.setParent(row);
			
			Button modifyBtn = new Button();
			modifyBtn.setLabel("修改");
			modifyBtn.setId(Utility.MODIFY_BTN_NAME + spec.getSpecId());
			modifyBtn.addEventListener("onClick",
					(EventListener) (new ModifyBtnClickEventListener(spec.getSpecId(), Utility.OTHER_DATA_TYPE_SPEC)));
			modifyBtn.setParent(row);
		}
	};
	
	private static final RowRenderer usageListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			Usageinfo usage = (Usageinfo) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);

			Label idLabel = new Label();
			idLabel.setValue(usage.getUsageId().toString());
			idLabel.setParent(row);
			
			Div div = new Div();
			Checkbox cb = new Checkbox();
			cb.setId(Utility.getCheckboxId(Utility.CB_TYPE_OTHERDATA, usage.getUsageId()));
			cb.setAttribute(Utility.CBTYPE_AttName, Utility.CB_TYPE_OTHERDATA);
			cb.setParent(div);
			
			Textbox nameTB = new Textbox();
			nameTB.setValue(usage.getUsageName());
			nameTB.setId(Utility.OTHER_DATA_NAME + usage.getUsageId());
			nameTB.setParent(div);
			div.setParent(row);
			
			Button modifyBtn = new Button();
			modifyBtn.setLabel("修改");
			modifyBtn.setId(Utility.MODIFY_BTN_NAME + usage.getUsageId());
			modifyBtn.addEventListener("onClick",
					(EventListener) (new ModifyBtnClickEventListener(usage.getUsageId(), Utility.OTHER_DATA_TYPE_USAGE)));
			modifyBtn.setParent(row);
		}
	};
	
	public ComboitemRenderer getDataTypeRenderer(){
		return Utility.getStringRenderer();
	}

	public ListModel getDataTypeModel() {
		try {
			return new SimpleListModel(Utility.OTHER_DATA_TYPE_NAME);
		} catch (Exception e) {
			Utility.logger.error(e);
			return null;
		}
	}
	
	public void changeDataType(){
		this.dataType = this.dataTypeCombobox.getSelectedIndex();
		
		this.initData();
	}
	
	public void add(){
		try{
			if(((Textbox)getFellow("name")).getValue().isEmpty()){
				((Textbox)getFellow("name")).setFocus(true);
				return;
			}
			boolean success = false;
			switch(this.dataType){
			case Utility.OTHER_DATA_TYPE_DKSPEC:
				Dkspecinfo dkspec = new Dkspecinfo();
				dkspec.setDkspecName(((Textbox)getFellow("name")).getValue());
				ConstAccessor.insert(dkspec);
				success = true;
				break;
			case Utility.OTHER_DATA_TYPE_SPEC:
				Specinfo spec = new Specinfo();
				spec.setSpecName(((Textbox)getFellow("name")).getValue());
				ConstAccessor.insert(spec);
				success = true;
				break;
			case Utility.OTHER_DATA_TYPE_USAGE:
				Usageinfo usage = new Usageinfo();
				usage.setUsageName(((Textbox)getFellow("name")).getValue());
				ConstAccessor.insert(usage);
				success = true;
				break;
			default:
				Utility.logger.error("Unknown dataType:" + this.dataType);
			}
			if(success){
				this.initData();
			}
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}

}
