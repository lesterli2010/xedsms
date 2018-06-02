package com.hxdq.xedsms.web.window;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.accessor.UserAccessor;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.db.model.User;
import com.hxdq.xedsms.db.model.Userauthority;
import com.hxdq.xedsms.web.common.RowData;
import com.hxdq.xedsms.web.common.SelectListWindow;

public class SelectUserWindow extends SelectListWindow {

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try{
			return UserAccessor.getTotalUserCount();
		}catch(Exception e){
			Utility.logger.error(e);
			return 0;
		}
	}

	@Override
	public List<RowData> getListData(int startIdx, int maxNum) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try{
			List<User> userList = UserAccessor.getUserList();
			List<RowData> list = new ArrayList<RowData>();
			
			for (int i = 0; userList != null && i < userList.size(); i++) {
				RowData row = new RowData(userList.get(i), i + 1, (Include) getParent());
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
		// TODO Auto-generated method stub
		return this.userListRenderer;
	}
	
	private static final RowRenderer userListRenderer = new RowRenderer() {
		public void render(Row row, Object data) {
			RowData cdata = (RowData) data;
			User user = (User) cdata.getData();
			
			Label indexLabel = new Label();
			indexLabel.setValue(String.valueOf(cdata.getIndex()));
			indexLabel.setParent(row);
			
			Label useridLabel = new Label();
			useridLabel.setValue(user.getUserid());
			useridLabel.setParent(row);
			
			String auth = Utility.UNKNOWN_NAME;
			try{
				Userauthority authority = UserAccessor.getUserAuthorityByID(user.getUserid());
				auth = Utility.getAuthorityName(authority.getAuthority());
			}catch(Exception e){
				Utility.logger.error(e);
			}
			
			Label authLabel = new Label();
			authLabel.setValue(auth);
			authLabel.setParent(row);
			
			Label nameLabel = new Label();
			nameLabel.setValue(user.getName());
			nameLabel.setParent(row);
			
			Label phoneLabel = new Label();
			phoneLabel.setValue(user.getPhone());
			phoneLabel.setParent(row);
		}
	};

}
