package com.hxdq.xedsms.db.accessor;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.SSFactory;
import com.hxdq.xedsms.db.model.Customer;
import com.hxdq.xedsms.db.model.CustomerMapper;
import com.hxdq.xedsms.db.model.User;
import com.hxdq.xedsms.db.model.UserExample;
import com.hxdq.xedsms.db.model.UserMapper;
import com.hxdq.xedsms.db.model.Userauthority;
import com.hxdq.xedsms.db.model.UserauthorityMapper;

public abstract class UserAccessor {

public static void insert(User user, Userauthority userAutho) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		UserMapper mapper = null;
		UserauthorityMapper authmapper = null;
		try{
			mapper = sqlSession.getMapper(UserMapper.class);
			authmapper = sqlSession.getMapper(UserauthorityMapper.class);
			mapper.insert(user);
			authmapper.insert(userAutho);
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}

public static void update(User user) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UserMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(UserMapper.class);
		mapper.updateByPrimaryKey(user);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void update(Userauthority userAutho) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UserauthorityMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(UserauthorityMapper.class);
		mapper.updateByPrimaryKey(userAutho);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Userauthority getUserAuthorityByID(String userID) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UserauthorityMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(UserauthorityMapper.class);
	Userauthority userA = mapper.selectByPrimaryKey(userID);
	sqlSession.commit();
	return userA;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static User getUserByID(String userID) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UserMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(UserMapper.class);
	User user = mapper.selectByPrimaryKey(userID);
	sqlSession.commit();
	return user;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static int getTotalUserCount() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UserMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(UserMapper.class);
	UserExample example = new UserExample();
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

public static List<User> getUserList() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UserMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(UserMapper.class);
	UserExample example = new UserExample();
	List<User> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static boolean isUserIDExist(String userID) throws Exception{
	if(UserAccessor.getUserByID(userID) == null){
		return false;
	}else{
		return true;
	}
}
}
