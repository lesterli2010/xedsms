package com.hxdq.xedsms.db.accessor;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.SSFactory;
import com.hxdq.xedsms.db.model.*;


public abstract class SalerAccessor {
public static void insert(Saler Saler) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		SalerMapper mapper = null;
		try{
			mapper = sqlSession.getMapper(SalerMapper.class);
			mapper.insert(Saler);
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}

public static void update(Saler Saler) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	SalerMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(SalerMapper.class);
		mapper.updateByPrimaryKey(Saler);
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
	SalerMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(SalerMapper.class);
	SalerExample example = new SalerExample();
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
	SalerMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(SalerMapper.class);
	mapper.deleteByPrimaryKey(cusId);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Saler getSalerById(int id) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	SalerMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(SalerMapper.class);
	Saler Saler = mapper.selectByPrimaryKey(id);
	sqlSession.commit();
	return Saler;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<Saler> getSaler() throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	SalerMapper mapper = null;
	try{
	mapper = (SalerMapper)sqlSession.getMapper(SalerMapper.class);
	SalerExample example = new SalerExample();
	List<Saler> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}
}
