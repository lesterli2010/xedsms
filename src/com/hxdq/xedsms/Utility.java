/**
 * 
 */
package com.hxdq.xedsms;

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;
import org.zkoss.zul.Button;
import org.zkoss.zul.Chart;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.West;
import org.zkoss.zul.Window;
import org.zkoss.zul.api.Radio;
import org.zkoss.zul.api.Textbox;

import com.hxdq.xedsms.db.SSFactory;
import com.hxdq.xedsms.db.accessor.ConstAccessor;
import com.hxdq.xedsms.db.accessor.CustomerAccessor;
import com.hxdq.xedsms.db.accessor.SalerAccessor;
import com.hxdq.xedsms.db.model.City;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.Dkspecinfo;
import com.hxdq.xedsms.db.model.Productbatch;
import com.hxdq.xedsms.db.model.Productinfo;
import com.hxdq.xedsms.db.model.Province;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.db.model.Specinfo;
import com.hxdq.xedsms.db.model.Usageinfo;
import com.hxdq.xedsms.web.common.*;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author zhiqiang
 *
 */
public abstract class Utility {
	public final static String LANGUAGE_EN = "en";
	public final static String LANGUAGE_CN = "zh-cn";
	public final static String CB_TYPE_SERV = "service";
	public final static String CB_TYPE_TAG = "tag";
	public final static String CB_TYPE_CHANNEL = "channel";
	public final static String CB_TYPE_AD = "ad";
	public final static String CB_TYPE_NOTICE = "notice";
	public final static String CB_TYPE_USER = "user";
	public final static String CB_TYPE_ITEM = "item";
	public final static String CB_TYPE_EVENT = "event";
	public final static String CB_TYPE_CUSTOMER = "cus";
	public final static String CB_TYPE_OTHERDATA = "oth";
	public final static String CB_TYPE_PRODUCT = "prod";
	public final static String CB_TYPE_SALER = "saler";
	public final static String CB_TYPE_INSTOCK = "instock";
	public final static String CB_TYPE_OUTSTOCK = "outstock";
	public final static String CBTYPE_AttName = "cbtype";
	public final static String IMGFILENAME_AttName = "imgfilename";
	public final static String APPID_AttName = "app-id";
	public final static String USERNAME_AttName = "user-name";
	public final static String APPNAME_SYSTEM = "system";
	public final static String OTHER_DATA_NAME = "othname";
	public final static String MODIFY_BTN_NAME = "mdy";
	public final static String MODIFY_CHANNEL_FILE_NAME = "modify_channel.zul";
	public final static String MODIFY_AD_FILE_NAME = "modify_ad.zul";
	public final static String MODIFY_NOTICE_FILE_NAME = "modify_notice.zul";
	public final static String MODIFY_ENDUSER_FILE_NAME = "modify_enduser.zul";
	public final static String SELECT_SALER_FILE_NAME = "select_saler.zul";
	public final static String MODIFY_ITEM_FILE_NAME = "modify_item.zul";
	public final static String MODIFY_CUSTOMER_FILE_NAME = "modify_customer.zul";
	public final static String CUSTOMER_DETAIL_FILE_NAME = "customer_detail.zul";
	public final static String MODIFY_PRODUCT_FILE_NAME = "modify_product.zul";
	public final static String MODIFY_SALER_FILE_NAME = "modify_saler.zul";
	public final static String SELECT_CUSTOMER_FILE_NAME = "select_customer.zul";
	public final static String SELECT_PRODUCT_FILE_NAME = "select_product.zul";
	public final static String MODIFY_OWNER_FILE_NAME = "modify_owner.zul";
	public final static String SELECT_INSTOCK_FILE_NAME = "select_instock.zul";
	public final static String SELECT_OUTSTOCK_FILE_NAME = "select_outstock.zul";
	public final static String OUTSTOCK_DETAIL_FILE_NAME = "outstock_detail.zul";
	public final static String INSTOCK_DETAIL_FILE_NAME = "instock_detail.zul";
	public final static String NOT_AUTHORIZED_FILE_NAME = "not_authorized.zul";
	public final static String PRO_ROW_NAME = "prodrow";
	public final static String PRO_ID_NAME = "proid";
	public final static String PRO_COUNT_NAME = "procount";
	public final static String PRO_PRICE_NAME = "proprice";
	public final static String PRO_REMAIN_NAME = "proremain";
	public final static String PRO_USAGE_NAME = "prousage";
	public final static String PRO_BAR_BTN = "probar";
	public final static String PRO_BAR_IMG = "probarimg";
	public final static String PRO_BAR_VAL = "probarval";
	public final static String PRO_BATCH_ID = "probatchid";
	
	public final static String DEFAULT_PASSWD = "888888";
	
	public final static String UNKNOWN_NAME = "未知";
	public final static String[] GENDER_NAME = {
		"男",
		"女"
	};
	
	private static HashMap<String, String> authorityName = new HashMap<String, String>();
	
	public static final int OTHER_DATA_TYPE_DKSPEC = 0;
	public static final int OTHER_DATA_TYPE_SPEC = 1;
	public static final int OTHER_DATA_TYPE_USAGE = 2;
	
	public final static String[] OTHER_DATA_TYPE_NAME = {
		"灯口规格",
		"型号",
		"产品用途"
	};
	
	public static final int QUERY_TYPE_NO = 0;
	public static final int QUERY_TYPE_BYNAME = 1;
	public static final int QUERY_TYPE_PROD = 2;
	public static final int QUERY_TYPE_TIME = 3;
	public static final int QUERY_TYPE_PROD_TIME = 4;
	public static final int QUERY_TYPE_BARCODE = 5;
	public static final int QUERY_TYPE_OUTID = 6;
	public static final int QUERY_TYPE_INID = 7;
	
	public final static int DB_FAIL = 0;
	public final static int DB_SUCCESS = 1;
	
	public final static String PARA_NAME_ID = "id";
	public final static String RTN_PAGE = "rtn";
	
	public final static String MODIFY_ICO_SRC = "/img/Modify.png";

	public final static int DEFAULT_CHANNEL_RATING = 5; //

	private static int imgSequence = 0;

	public static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public static SimpleDateFormat listDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static SimpleDateFormat listTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat startTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd 00:00:00");
	public static SimpleDateFormat endTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd 23:59:59");
	
	public static SimpleDateFormat shortDateFormat = new SimpleDateFormat(
	"yyMMdd");
	
	public static DecimalFormat fourDecimalFormat = new DecimalFormat("0000");
	public static DecimalFormat threeDecimalFormat = new DecimalFormat("000");
   
	
	public static String BEGIN_TIME = "1970-01-01 00:00:00";
	
	public static Logger logger = null;
	private static Map<String, MenuCategory> _cateMap = new LinkedHashMap<String, MenuCategory>();
	private static HashMap<String, Integer> _productBatchMap = new HashMap<String, Integer>();
	
	public static String menuFileRealPath = null;
	
	public static void loadMenuConfig(InputStream is)
	throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(is);

		Element root = document.getRootElement();

		List<Element> cateList = (List<Element>) root.elements("category");
		Element cate, item;
		String mid, iid;

		for (int i = 0; i < cateList.size(); i++) {
			cate = cateList.get(i);
			mid = cate.attributeValue("id");
			MenuCategory mcate = new MenuCategory(mid, cate
				.elementText("icon-url"), cate.elementText("label"), cate
				.elementText("href"));
			
			List<Element> itemList = (List<Element>) cate.elements("item");
			for (int j = 0; j < itemList.size(); j++) {
			item = itemList.get(j);

			iid = item.attributeValue("id");
			MenuItem mitem = new MenuItem(iid, mid, item
					.elementText("file-url"), item.elementText("icon-url"),
					item.elementText("label"));
			mcate.addItem(mitem);
		}
		_cateMap.put(mid, mcate);
	}
	}
	
	public static void initLog(URL url, String name) throws Exception {
		PropertyConfigurator.configure(url);
		logger = Logger.getLogger(name);
		logger.info("Log4j is initialized! Log Config File" + url.getPath());
	}
	
	public static void initDB(InputStream is) throws Exception {
		SSFactory.setConfigFile(is);
	}
	
	public static Map<String, MenuCategory> getMenuMap() {
		return _cateMap;
	}
	
	public static String getCurrentUserID() {
		try {
			 UserDetails userDetails = (UserDetails)
			 SecurityContextHolder.getContext()
			 .getAuthentication()
			 .getPrincipal();
			 
			 String userName = Utility.UNKNOWN_NAME;
			 
			 if(userDetails != null){
				 userName = userDetails.getUsername();
			 }
			return userName;
		} catch (Exception e) {
			Utility.logger.error("Exception when get current UserID", e);
			return Utility.UNKNOWN_NAME;
		}
	}
	
	public static String getCurrentUserAuthority() {
		try {
		
			 UserDetails userDetails = (UserDetails)
			 SecurityContextHolder.getContext()
			 .getAuthentication()
			 .getPrincipal();
			 
			 if(userDetails != null){
			 Collection<GrantedAuthority> au = userDetails.getAuthorities();
			 Iterator it = au.iterator();
			 while(it.hasNext()){
				 GrantedAuthority auth = (GrantedAuthority) it.next();
				 return auth.getAuthority();
			 }
			 }
			return null;
		} catch (Exception e) {
			Utility.logger.error("Exception when get current Authority", e);
			return null;
		}
	}
	
	private static final ComboitemRenderer stringComboItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			String str = (String) data;
			item.setLabel(str);
		}
	};
	
	private static final ComboitemRenderer dkComboItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Dkspecinfo dk = (Dkspecinfo) data;
			item.setLabel(dk.getDkspecName());
			item.setValue(dk.getDkspecId());
		}
	};
	
	private static final ComboitemRenderer specComboItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Specinfo spec = (Specinfo) data;
			item.setLabel(spec.getSpecName());
			item.setValue(spec.getSpecId());
		}
	};
	
	public static ComboitemRenderer getStringRenderer()
	{
		return Utility.stringComboItemRenderer;
	}
	
	public static ComboitemRenderer getDkRenderer()
	{
		return Utility.dkComboItemRenderer;
	}
	
	public static ComboitemRenderer getSpecRenderer()
	{
		return Utility.specComboItemRenderer;
	}
	
    public static ListModel getDkModel() {
		try {
			List<Dkspecinfo> list = ConstAccessor.getDkSpec();
			return new ShowAllListModel(list);
		} catch (Exception e) {
			Utility.logger.error(e);
			return null;
		}
	}
    
    public static ListModel getSpecinfoModel() {
		try {
			List<Specinfo> list = ConstAccessor.getSpecinfo();
			return new ShowAllListModel(list);
		} catch (Exception e) {
			Utility.logger.error(e);
			return null;
		}
	}
    
	public static Object getParaID(Window win) throws Exception {
		Component com = win.getParent();
		if (com instanceof Include) {
			Include include = (Include) com;
			return include.getDynamicProperty(Utility.PARA_NAME_ID);
		}
		return null;
	}
	
	public static Object getRtnPage(Window win) throws Exception {
		Component com = win.getParent();
		if (com instanceof Include) {
			Include include = (Include) com;
			return include.getDynamicProperty(Utility.RTN_PAGE);
		}
		return null;
	}
	
	public static int parseCheckboxId(String id) throws Exception {
		String[] str = id.split("_");
		return Integer.parseInt(str[1]);
	}

	public static String getCheckboxId(String type, int id) {
		return type + "_" + id;
	}

	public static String getCheckboxId(String type, String id) {
		return type + "_" + id;
	}

	public static String parseCheckboxId2Str(String id) throws Exception {
		int firstIndex = id.indexOf("_");
		return id.substring(firstIndex + 1);
	}
	
	public static ListModel getProductListModel(){
		try{
			List<Productinfo> prodList = ConstAccessor.getTotalProduct();
			return new ShowAllListModel(prodList);
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static ListModel getCustomerListModel(){
		try{
			List<Customer> cusList = CustomerAccessor.getAllCustomerLimit();
			return new ShowAllListModel(cusList);
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static final ComboitemRenderer customerItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Customer cus = (Customer)data;
			item.setLabel(cus.getName());
			item.setValue(cus.getCustomerId());
		}
	};
	
	public static ListModel getSalerListModel(){
		try{
			List<Saler> salerList = SalerAccessor.getSaler();
			return new ShowAllListModel(salerList);
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static final ComboitemRenderer salerItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Saler cus = (Saler)data;
			item.setLabel(cus.getName());
			item.setValue(cus.getSalerId());
		}
	};
	
	public static ListModel getProvinceListModel(){
		try{
			List<Province> provList = ConstAccessor.getAllProvince();
			return new ShowAllListModel(provList);
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static final ComboitemRenderer provinceItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Province prov = (Province)data;
			item.setLabel(prov.getProvName());
			item.setValue(prov.getProvId());
		}
	};
	
	public static ListModel getCityListModel(int provId){
		try{
			List<City> cityList = ConstAccessor.getCityByProvinceId(provId);
			return new ShowAllListModel(cityList);
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static final ComboitemRenderer cityItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			City city = (City)data;
			item.setLabel(city.getCityName());
			item.setValue(city.getCityId());
		}
	};
	
	public static ListModel getUsageListModel(){
		try{
			List<Usageinfo> usageList = ConstAccessor.getUsageinfo();
			return new ShowAllListModel(usageList);
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static final ComboitemRenderer usageItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Usageinfo usage = (Usageinfo) data;
			item.setLabel(usage.getUsageName());
			item.setValue(usage.getUsageId());
		}
	};
	
	public static String getProductLongName(Productinfo prod){
		try{
			String dkName = null;
			try{
			Dkspecinfo dkspec = ConstAccessor.getDkSpecById(prod.getDkspecId());
			dkName = dkspec.getDkspecName();
			}catch(Exception e){
				Utility.logger.error(e);
				dkName = Utility.UNKNOWN_NAME;
			}
			String specName = null;
			try{
				Specinfo spec = ConstAccessor.getSpecinfoById(prod.getSpecId());
				specName = spec.getSpecName();
			}catch(Exception e){
				Utility.logger.error(e);
				specName = Utility.UNKNOWN_NAME;
			}
			
			return prod.getName() + "_" + dkName + "_" + specName;
			
		}catch(Exception e){
			Utility.logger.error(e);
			return Utility.UNKNOWN_NAME;
		}
	}
	public static final ComboitemRenderer productAllinOneItemRenderer = new ComboitemRenderer() {
		public void render(Comboitem item, Object data) {
			Productinfo prod = (Productinfo) data;
			
			item.setLabel(Utility.getProductLongName(prod));
			item.setValue(prod.getProductId());
		}
	};
	
	public static String getProCityKey(int proId, int cityId){
		return proId+"_"+cityId;
	}
	
	public static void initProductBatchMap(){
		try{
			List<Productbatch> batchList = ConstAccessor.getAllProductBatch();
			Productbatch batch = null;
			for(int i=0;i<batchList.size();i++){
				batch = batchList.get(i);
				String key = Utility.getProCityKey(batch.getProductId(), batch.getCityId());
				Utility._productBatchMap.put(key, batch.getBatchId());
				Utility.logger.info("prodid:"+batch.getProductId()+",cityid:"+batch.getCityId()+",batchid:"+batch.getBatchId());
			}
			Utility.logger.info("init product batch successully");
			
		}catch(Exception e){
			Utility.logger.error(e);
		}
	}
	
	public static synchronized int getNextProductBatchId(int prodId, int cityId){
		try{
			Integer batchId = Utility._productBatchMap.get(Utility.getProCityKey(prodId, cityId));
			if(batchId == null){
				// Insert one
				Productbatch batch = new Productbatch();
				batch.setBatchId(1);
				batch.setCityId(cityId);
				batch.setProductId(prodId);
				ConstAccessor.insert(batch);
				Utility._productBatchMap.put(Utility.getProCityKey(prodId, cityId), 1);
				return 1;
			}
			
			batchId++;
			Utility._productBatchMap.put(Utility.getProCityKey(prodId, cityId), batchId);
			return batchId;
		}catch(Exception e){
			Utility.logger.error(e);
			return 0;
		}
	}
	
	public static String getBarCode(Productinfo product, int cityId, int batchId){
		//XED-G150W6000K120610001001
	//	Date date = new Date();
	//	Utility.shortDateFormat.format(new Date())
		return "XED-" + 
			product.getName() + 
			product.getTemp()+"K"+
			Utility.shortDateFormat.format(new Date())+
			Utility.threeDecimalFormat.format(cityId)+
			Utility.fourDecimalFormat.format(batchId);
	}
	
	public static String getBarCodeImgSrc(String barCode){
		//XED-G150W6000K120610001001
	//	Date date = new Date();
	//	Utility.shortDateFormat.format(new Date())
		//image.setSrc("/barcode?msg=XED-G150W6000K120610001001&type=code128");
		return "/barcode?msg="+barCode+"&type=code128";// type code128
	}
	
	public static String getMD5(String input){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
 
			byte byteData[] = md.digest();
 
			//convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			return sb.toString();
		}catch(Exception e){
			Utility.logger.error(e);
			return null;
		}
	}
	
	public static String getAuthorityName(String role){
		String name = Utility.authorityName.get(role);
		if(name == null){
			return "未知权限";
		}
		return name;
	}
	
	public static void initAuthNameHashMap(){
		Utility.authorityName.put("ROLE_ADMIN", "系统管理员");
		Utility.authorityName.put("ROLE_STOCKER", "仓库管理员");
		Utility.authorityName.put("ROLE_SALER", "销售员");
	}
}
