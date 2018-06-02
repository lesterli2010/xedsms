package com.hxdq.xedsms.db.accessor;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.DBUtility;
import com.hxdq.xedsms.db.SSFactory;
import com.hxdq.xedsms.db.model.*;

public abstract class InstockAccessor {
public static void insert(Instock instock, List<Instockproduct> instockProduct) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		InstockMapper instockMapper = null;
		InstockproductMapper instockProMapper = null;
		try{
			
			instockMapper = sqlSession.getMapper(InstockMapper.class);
			instockProMapper = sqlSession.getMapper(InstockproductMapper.class);
			instockMapper.insert(instock);
			for(int i=0;instockProduct!=null&&i<instockProduct.size();i++){
				instockProduct.get(i).setInId(instock.getInId());
				instockProMapper.insert(instockProduct.get(i));
				
				HashMap map = new HashMap();
				map.put("count", instockProduct.get(i).getCount());
				map.put("product_id", instockProduct.get(i).getProductId());
				String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.instock";
				sqlSession.update(iqlPath, map);
			}
			
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}

public static void deleteById(int inId) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	InstockproductMapper mapper = null;
	InstockMapper instockMapper = null;
	try{
		mapper = sqlSession.getMapper(InstockproductMapper.class);
		InstockproductExample ipexample = new InstockproductExample();
		ipexample.createCriteria().andInIdEqualTo(inId);
		List<Instockproduct> inproList = mapper.selectByExample(ipexample);
		
		
		for(int i=0;inproList!=null&&i<inproList.size();i++){
			HashMap map = new HashMap();
			map.put("count", inproList.get(i).getCount());
			map.put("product_id", inproList.get(i).getProductId());
			String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.cancel_instock";
			sqlSession.update(iqlPath, map);
		}
	instockMapper = sqlSession.getMapper(InstockMapper.class);
	InstockproductExample example = new InstockproductExample();
	example.createCriteria().andInIdEqualTo(inId);
	mapper.deleteByExample(example);
	instockMapper.deleteByPrimaryKey(inId);
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
	InstockMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(InstockMapper.class);
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

public static List<Instock> getInstocklist() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	InstockMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(InstockMapper.class);
	InstockExample example = new InstockExample();
	List<Instock> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Instock getInstockByInid(int inId) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	InstockMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(InstockMapper.class);
	Instock instock = mapper.selectByPrimaryKey(inId);
	sqlSession.commit();
	return instock;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<Instockproduct> getInstockProductlistByInid(int inid) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	InstockproductMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(InstockproductMapper.class);
	InstockproductExample example = new InstockproductExample();
	example.createCriteria().andInIdEqualTo(inid);
	List<Instockproduct> list = mapper.selectByExample(example);
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
		String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_count_by_prodid";
		return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static List<Instock> getListByProdId(int prod_id, int startIdx, int maxNum) throws Exception{
	HashMap map = new HashMap();
	map.put("product_id", prod_id);
	map.put("start_index", startIdx);
	map.put("max_result", maxNum);
	String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_list_by_prodid";
	return (List<Instock>)DBUtility.selectList(map, iqlPath);
}

public static List<Instock> getListLimit(int startIdx, int maxNum) throws Exception{
	HashMap map = new HashMap();
	map.put("start_index", startIdx);
	map.put("max_result", maxNum);
	String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_list_limit";
	return (List<Instock>)DBUtility.selectList(map, iqlPath);
}

///
public static int getTotalCountByProdIdTime(int prod_id, String start_date, String end_date) throws Exception{
	HashMap map = new HashMap();
	map.put("product_id", prod_id);
	map.put("start_date", start_date);
	map.put("end_date", end_date);
	String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_count_by_prodid_time";
	return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static List<Instock> getListByProdIdTime(int prod_id, String start_date, String end_date, int startIdx, int maxNum) throws Exception{
HashMap map = new HashMap();
map.put("product_id", prod_id);
map.put("start_date", start_date);
map.put("end_date", end_date);
map.put("start_index", startIdx);
map.put("max_result", maxNum);
String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_list_by_prodid_time";
return (List<Instock>)DBUtility.selectList(map, iqlPath);
}

//
public static int getTotalCountByTime(String start_date, String end_date) throws Exception{
	HashMap map = new HashMap();
	map.put("start_date", start_date);
	map.put("end_date", end_date);
	String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_count_by_time";
	return (Integer)DBUtility.selectOne(map, iqlPath);
}

public static List<Instock> getListByTime(String start_date, String end_date, int startIdx, int maxNum) throws Exception{
HashMap map = new HashMap();
map.put("start_date", start_date);
map.put("end_date", end_date);
map.put("start_index", startIdx);
map.put("max_result", maxNum);
String iqlPath = "com.hxdq.xedsms.db.prisql.InstockMapper.get_list_by_time";
return (List<Instock>)DBUtility.selectList(map, iqlPath);
}



}
