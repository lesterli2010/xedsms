package com.hxdq.xedsms.db.accessor;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.DBUtility;
import com.hxdq.xedsms.db.SSFactory;
import com.hxdq.xedsms.db.model.*;

public abstract class StockStatusAccessor {
public static void insert(Stockstatus Stockstatus) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		StockstatusMapper mapper = null;
		try{
			mapper = sqlSession.getMapper(StockstatusMapper.class);
			mapper.insert(Stockstatus);
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}

public static void update(Stockstatus Stockstatus) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	StockstatusMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(StockstatusMapper.class);
		mapper.updateByPrimaryKey(Stockstatus);
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
	StockstatusMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(StockstatusMapper.class);
	StockstatusExample example = new StockstatusExample();
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

public static void deleteById(int cusId) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	StockstatusMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(StockstatusMapper.class);
	mapper.deleteByPrimaryKey(cusId);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Stockstatus getStockstatusById(int id) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	StockstatusMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(StockstatusMapper.class);
	Stockstatus Stockstatus = mapper.selectByPrimaryKey(id);
	sqlSession.commit();
	return Stockstatus;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<Stockstatus> getStockstatus() throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	StockstatusMapper mapper = null;
	try{
	mapper = (StockstatusMapper)sqlSession.getMapper(StockstatusMapper.class);
	StockstatusExample example = new StockstatusExample();
	List<Stockstatus> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void updateInstock(int count, int product_id) throws Exception{
	HashMap map = new HashMap();
	map.put("count", count);
	map.put("product_id", product_id);
	String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.instock";
	DBUtility.update(map, iqlPath);
}

public static void updateOutstock(int count, int product_id) throws Exception{
	HashMap map = new HashMap();
	map.put("count", count);
	map.put("product_id", product_id);
	String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.outstock";
	DBUtility.update(map, iqlPath);
}

public static void updateCancelInstock(int count, int product_id) throws Exception{
	HashMap map = new HashMap();
	map.put("count", count);
	map.put("product_id", product_id);
	String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.cancel_instock";
	DBUtility.update(map, iqlPath);
}

public static void updateCancelOutstock(int count, int product_id) throws Exception{
	HashMap map = new HashMap();
	map.put("count", count);
	map.put("product_id", product_id);
	String iqlPath = "com.hxdq.xedsms.db.prisql.StockstatusMapper.cancel_outstock";
	DBUtility.update(map, iqlPath);
}
}
