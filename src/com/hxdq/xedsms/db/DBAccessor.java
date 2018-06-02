package com.hxdq.xedsms.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public abstract class DBAccessor<T extends Mapper> {

	protected SqlSession sqlSession;
	protected String mapperClass;
	protected T mapper;

	protected DBAccessor(Class<T> mapper) {
		this.sqlSession = SSFactory.currentSession();
		this.mapperClass = mapper.getName() ;
		this.mapper =  this.sqlSession.getMapper(mapper);;
	}

	public void select(Example example) throws Exception {
		sqlSession = SSFactory.currentSession();
		List<Entity> list = this.mapper.selectByExample(example);
	}
	
	public void insert(Entity entry) throws Exception{
		sqlSession = SSFactory.currentSession();
		this.mapper.insert(entry);
			
	}
	
	
	/*
	 * 
	 * 
	 */
	public void insertBySql(Object entry, String sqlPath) throws Exception{
		sqlSession = SSFactory.currentSession();
		sqlSession.insert(sqlPath, entry);
	}
}
