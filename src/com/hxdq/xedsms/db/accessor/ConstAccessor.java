package com.hxdq.xedsms.db.accessor;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;
import com.hxdq.xedsms.db.model.*;
import com.hxdq.xedsms.db.*;

public abstract class ConstAccessor {
	public static List<Dkspecinfo> getDkSpec() throws Exception{
		SqlSession sqlSession = SSFactory.currentSession();
		DkspecinfoMapper mapper = null;
		try{
		mapper = (DkspecinfoMapper)sqlSession.getMapper(DkspecinfoMapper.class);
		DkspecinfoExample example = new DkspecinfoExample();
		List<Dkspecinfo> list = mapper.selectByExample(example);
		sqlSession.commit();
		return list;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
	public static List<Specinfo> getSpecinfo() throws Exception{
		SqlSession sqlSession = SSFactory.currentSession();
		SpecinfoMapper mapper = null;
		try{
		mapper = (SpecinfoMapper)sqlSession.getMapper(SpecinfoMapper.class);
		SpecinfoExample example = new SpecinfoExample();
		List<Specinfo> list = mapper.selectByExample(example);
		sqlSession.commit();
		return list;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
	public static List<Usageinfo> getUsageinfo() throws Exception{
		SqlSession sqlSession = SSFactory.currentSession();
		UsageinfoMapper mapper = null;
		try{
		mapper = sqlSession.getMapper(UsageinfoMapper.class);
		UsageinfoExample example = new UsageinfoExample();
		List<Usageinfo> list = mapper.selectByExample(example);
		sqlSession.commit();
		return list;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
	public static Dkspecinfo getDkSpecById(int id) throws Exception{
		SqlSession sqlSession = SSFactory.currentSession();
		DkspecinfoMapper mapper = null;
		try{
		mapper = (DkspecinfoMapper)sqlSession.getMapper(DkspecinfoMapper.class);
		Dkspecinfo spec = mapper.selectByPrimaryKey(id);
		sqlSession.commit();
		return spec;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
	public static Specinfo getSpecinfoById(int id) throws Exception{
		SqlSession sqlSession = SSFactory.currentSession();
		SpecinfoMapper mapper = null;
		try{
		mapper = (SpecinfoMapper)sqlSession.getMapper(SpecinfoMapper.class);
		Specinfo spec = mapper.selectByPrimaryKey(id);
		sqlSession.commit();
		return spec;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
	public static Usageinfo getUsageinfoById(int id) throws Exception{
		SqlSession sqlSession = SSFactory.currentSession();
		UsageinfoMapper mapper = null;
		try{
		mapper = sqlSession.getMapper(UsageinfoMapper.class);
		Usageinfo spec = mapper.selectByPrimaryKey(id);
		sqlSession.commit();
		return spec;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
public static Productinfo getProductById(int id) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		ProductinfoMapper mapper = null;
		try{
		mapper = sqlSession.getMapper(ProductinfoMapper.class);
		Productinfo product = mapper.selectByPrimaryKey(id);
		sqlSession.commit();
		return product;
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}
	
public static void insert(Productinfo product) throws Exception{
		
		SqlSession sqlSession = SSFactory.currentSession();
		ProductinfoMapper mapper = null;
		try{
			mapper = sqlSession.getMapper(ProductinfoMapper.class);
			mapper.insert(product);
			sqlSession.commit();
		}catch(Exception e){
			Utility.logger.error(e);
			throw e;
		}finally{
			SSFactory.closeSession();
		}
	}

public static void insert(Dkspecinfo specinfo) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	DkspecinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(DkspecinfoMapper.class);
		mapper.insert(specinfo);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void insert(Specinfo spec) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	SpecinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(SpecinfoMapper.class);
		mapper.insert(spec);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void insert(Usageinfo usage) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UsageinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(UsageinfoMapper.class);
		mapper.insert(usage);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static int getTotalProductCount() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	ProductinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(ProductinfoMapper.class);
	ProductinfoExample example = new ProductinfoExample();
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

public static int getTotalDkspecCount() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	DkspecinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(DkspecinfoMapper.class);
	DkspecinfoExample example = new DkspecinfoExample();
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

public static int getTotalSpecCount() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	SpecinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(SpecinfoMapper.class);
	SpecinfoExample example = new SpecinfoExample();
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

public static int getTotalUsageCount() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UsageinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(UsageinfoMapper.class);
	SpecinfoExample example = new SpecinfoExample();
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

public static List<Productinfo> getTotalProduct() throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	ProductinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(ProductinfoMapper.class);
	ProductinfoExample example = new ProductinfoExample();
	List<Productinfo> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void update(Productinfo product) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	ProductinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(ProductinfoMapper.class);
		mapper.updateByPrimaryKey(product);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void update(Dkspecinfo dkspec) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	DkspecinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(DkspecinfoMapper.class);
		mapper.updateByPrimaryKey(dkspec);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void update(Specinfo spec) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	SpecinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(SpecinfoMapper.class);
		mapper.updateByPrimaryKey(spec);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void update(Usageinfo usage) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	UsageinfoMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(UsageinfoMapper.class);
		mapper.updateByPrimaryKey(usage);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void deleteProductById(int proId) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	ProductinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(ProductinfoMapper.class);
	mapper.deleteByPrimaryKey(proId);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void deleteDkspecById(int id) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	DkspecinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(DkspecinfoMapper.class);
	mapper.deleteByPrimaryKey(id);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void deleteSpecById(int id) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	SpecinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(SpecinfoMapper.class);
	mapper.deleteByPrimaryKey(id);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void deleteUsageById(int id) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	UsageinfoMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(UsageinfoMapper.class);
	mapper.deleteByPrimaryKey(id);
	sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<Province> getAllProvince() throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	ProvinceMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(ProvinceMapper.class);
	ProvinceExample example = new ProvinceExample();
	List<Province> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<City> getCityByProvinceId(int id) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	CityMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(CityMapper.class);
	CityExample example = new CityExample();
	example.createCriteria().andProvIdEqualTo(id);
	List<City> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static City getCityById(int id) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	CityMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(CityMapper.class);
	CityExample example = new CityExample();
	City city = mapper.selectByPrimaryKey(id);
	sqlSession.commit();
	return city;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Province getProvinceById(int id) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	ProvinceMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(ProvinceMapper.class);
	ProvinceExample example = new ProvinceExample();
	Province prov = mapper.selectByPrimaryKey(id);
	sqlSession.commit();
	return prov;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}


public static void insert(Productbatch batch) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	ProductbatchMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(ProductbatchMapper.class);
		mapper.insert(batch);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static void update(Productbatch batch) throws Exception{
	
	SqlSession sqlSession = SSFactory.currentSession();
	ProductbatchMapper mapper = null;
	try{
		mapper = sqlSession.getMapper(ProductbatchMapper.class);
		mapper.updateByPrimaryKey(batch);
		sqlSession.commit();
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static List<Productbatch> getAllProductBatch() throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	ProductbatchMapper mapper = null;
	try{
	mapper = sqlSession.getMapper(ProductbatchMapper.class);
	ProductbatchExample example = new ProductbatchExample();
	List<Productbatch> list = mapper.selectByExample(example);
	sqlSession.commit();
	return list;
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}

public static Productbatch getProductBatch(int proId, int cityId) throws Exception{
	SqlSession sqlSession = SSFactory.currentSession();
	ProductbatchMapper mapper = null;
	try{
		
	mapper = sqlSession.getMapper(ProductbatchMapper.class);
	ProductbatchExample example = new ProductbatchExample();
	example.createCriteria().andProductIdEqualTo(proId).andCityIdEqualTo(cityId);
	List<Productbatch> list = mapper.selectByExample(example);
	
	Productbatch batch = null;
	if(list==null||list.size()==0){
		batch = new Productbatch();
		batch.setProductId(proId);
		batch.setCityId(cityId);
		batch.setBatchId(1);
		mapper.insert(batch);
	}
	
	sqlSession.commit();
	if(list==null||list.size()==0){
		return batch;
	}else{
		return list.get(0);
	}
	}catch(Exception e){
		Utility.logger.error(e);
		throw e;
	}finally{
		SSFactory.closeSession();
	}
}
}
