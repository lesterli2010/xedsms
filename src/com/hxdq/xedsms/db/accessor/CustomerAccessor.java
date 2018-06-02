/**
 * 
 */
package com.hxdq.xedsms.db.accessor;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.db.*;

/**
 * @author zhiqiang
 *
 */
public abstract class CustomerAccessor{
	
	public static void insert(Customer customer) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		CustomerMapper mapper = null;
		try{
			mapper = sqlSession.getMapper(CustomerMapper.class);
			mapper.insert(customer);
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
public static void update(Customer customer) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		CustomerMapper mapper = null;
		try{
			mapper = sqlSession.getMapper(CustomerMapper.class);
			mapper.updateByPrimaryKey(customer);
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
		CustomerMapper mapper = null;
		try{
		mapper = sqlSession.getMapper(CustomerMapper.class);
		CustomerExample example = new CustomerExample();
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
		CustomerMapper mapper = null;
		try{
		mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.deleteByPrimaryKey(cusId);
		sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
	public static Customer getCustomerById(int id) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		CustomerMapper mapper = null;
		try{
		mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.selectByPrimaryKey(id);
		sqlSession.commit();
		return customer;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	

	
public static int getTotalCountByName(String name) throws Exception{
		HashMap map = new HashMap();
		map.put("name", name);
		String iqlPath = "com.hxdq.xedsms.db.prisql.CustomerMapper.get_count_by_name";
		return (Integer)DBUtility.selectOne(map, iqlPath);
	}
	
	public static List<Customer> getAllCustomerLimit(int startIdx, int maxNum) throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start_index", startIdx);
		map.put("max_result", maxNum);
		String iqlPath = "com.hxdq.xedsms.db.prisql.CustomerMapper.get_all_limit";
		return DBUtility.selectList(map, iqlPath);
	}
	
	public static List<Customer> getAllCustomerLimit() throws Exception{
			SqlSession sqlSession = SSFactory.currentSession();
			CustomerMapper mapper = null;
			try{
			mapper = sqlSession.getMapper(CustomerMapper.class);
			CustomerExample example = new CustomerExample();
			List<Customer> list = mapper.selectByExample(example);
			sqlSession.commit();
			return list;
			}catch(Exception e){
				Utility.logger.error(e);
				throw e;
			}finally{
				SSFactory.closeSession();
			}
	}
	
	public static List<Customer> getAllCustomerLimitByName(String name, int startIdx, int maxNum) throws Exception{
		HashMap map = new HashMap();
		map.put("name", name);
		map.put("start_index", startIdx);
		map.put("max_result", maxNum);
		String iqlPath = "com.hxdq.xedsms.db.prisql.CustomerMapper.get_all_by_name_limit";
		return DBUtility.selectList(map, iqlPath);
	}
}
