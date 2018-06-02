package com.hxdq.xedsms.db.accessor;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.DBUtility;
import com.hxdq.xedsms.db.SSFactory;
import com.hxdq.xedsms.db.model.*;

public abstract class OutstockAccessor {
public static void insert(Outstock outstock, List<OutstockProduct> outstockProduct, List<Productbatch> productBarList) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		OutstockMapper OutstockMapper = null;
		OutstockProductMapper OutstockProMapper = null;
		ProductbatchMapper productBatchMapper = null;
		try{
			
			OutstockMapper = sqlSession.getMapper(OutstockMapper.class);
			OutstockProMapper  = sqlSession.getMapper(OutstockProductMapper.class);
			productBatchMapper = sqlSession.getMapper(ProductbatchMapper.class);
			OutstockMapper.insert(outstock);
			for(int i=0;outstockProduct!=null&&i<outstockProduct.size();i++){
				outstockProduct.get(i).setOutId(outstock.getOutId());
				OutstockProMapper.insert(outstockProduct.get(i));
				
				HashMap map = new HashMap();
				map.put("count", outstockProduct.get(i).getCount());
				map.put("product_id", outstockProduct.get(i).getProductId());
				String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.outstock";
				sqlSession.update(iqlPath, map);
			}
			for(int i=0;i<productBarList.size();i++){
				productBatchMapper.updateByPrimaryKey(productBarList.get(i));
			}
			
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}

public static void deleteById(int outId) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	OutstockProductMapper mapper = null;
	OutstockMapper outstockMapper = null;
	try{
		mapper = sqlSession.getMapper(OutstockProductMapper.class);
		OutstockProductExample ipexample = new OutstockProductExample();
		ipexample.createCriteria().andOutIdEqualTo(outId);
		List<OutstockProduct> outproList = mapper.selectByExample(ipexample);
		
		
		for(int i=0;outproList!=null&&i<outproList.size();i++){
			HashMap map = new HashMap();
			map.put("count", outproList.get(i).getCount());
			map.put("product_id", outproList.get(i).getProductId());
			String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.cancel_outstock";
			sqlSession.update(iqlPath, map);
		}
		outstockMapper = sqlSession.getMapper(OutstockMapper.class);
	OutstockProductExample example = new OutstockProductExample();
	example.createCriteria().andOutIdEqualTo(outId);
	mapper.deleteByExample(example);
	outstockMapper.deleteByPrimaryKey(outId);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static int getTotalCount() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	OutstockMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(OutstockMapper.class);
	InstockExample example = new InstockExample();
	int count = mapper.countByExample(example);
	sqlSession.commit();
	return count;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<Outstock> getOutstocklist() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	OutstockMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(OutstockMapper.class);
	OutstockExample example = new OutstockExample();
	List<Outstock> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Outstock getOutstockById(int outId) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	OutstockMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(OutstockMapper.class);
	Outstock outstock = mapper.selectByPrimaryKey(outId);
	sqlSession.commit();
	return outstock;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<OutstockProduct> getOutstockProductductlistByOutid(int outid) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	OutstockProductMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(OutstockProductMapper.class);
	OutstockProductExample example = new OutstockProductExample();
	example.createCriteria().andOutIdEqualTo(outid);
	List<OutstockProduct> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static int getTotalCountByProdId(int prod_id) throws Exception{
		HashMap map = new HashMap();
		map.put("product_id", prod_id);
		String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_count_by_prodid";
		return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static int getTotalCountByBarCode(String barcode) throws Exception{
	HashMap map = new HashMap();
	map.put("bar_code", barcode);
	String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_count_by_barcode";
	return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static List<Outstock> getListByProdId(int prod_id, int startIdx, int maxNum) throws Exception{
	HashMap map = new HashMap();
	map.put("product_id", prod_id);
	map.put("start_index", startIdx);
	map.put("max_result", maxNum);
	String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_list_by_prodid";
	return (List<Outstock>)DBUtility.selectList(map, iqlPath);
}

public static List<Outstock> getListByBarCode(String barCode, int startIdx, int maxNum) throws Exception{
	HashMap map = new HashMap();
	map.put("bar_code", barCode);
	map.put("start_index", startIdx);
	map.put("max_result", maxNum);
	String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_list_by_barcode";
	return (List<Outstock>)DBUtility.selectList(map, iqlPath);
}

public static List<Outstock> getListLimit(int startIdx, int maxNum) throws Exception{
	HashMap map = new HashMap();
	map.put("start_index", startIdx);
	map.put("max_result", maxNum);
	String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_list_limit";
	return (List<Outstock>)DBUtility.selectList(map, iqlPath);
}

///
public static int getTotalCountByProdIdTime(int prod_id, String start_date, String end_date) throws Exception{
	HashMap map = new HashMap();
	map.put("product_id", prod_id);
	map.put("start_date", start_date);
	map.put("end_date", end_date);
	String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_count_by_prodid_time";
	return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static List<Outstock> getListByProdIdTime(int prod_id, String start_date, String end_date, int startIdx, int maxNum) throws Exception{
HashMap map = new HashMap();
map.put("product_id", prod_id);
map.put("start_date", start_date);
map.put("end_date", end_date);
map.put("start_index", startIdx);
map.put("max_result", maxNum);
String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_list_by_prodid_time";
return (List<Outstock>)DBUtility.selectList(map, iqlPath);
}

//
public static int getTotalCountByTime(String start_date, String end_date) throws Exception{
	HashMap map = new HashMap();
	map.put("start_date", start_date);
	map.put("end_date", end_date);
	String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_count_by_time";
	return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static List<Outstock> getListByTime(String start_date, String end_date, int startIdx, int maxNum) throws Exception{
HashMap map = new HashMap();
map.put("start_date", start_date);
map.put("end_date", end_date);
map.put("start_index", startIdx);
map.put("max_result", maxNum);
String iqlPath = "com.hxdq.xedsms.db.prisql.OutstockMapper.get_list_by_time";
return (List<Outstock>)DBUtility.selectList(map, iqlPath);
}



}
