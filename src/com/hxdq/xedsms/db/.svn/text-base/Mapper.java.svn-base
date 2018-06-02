package com.hxdq.xedsms.db;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;


public interface Mapper {
	int countByExample(Example example);

	int deleteByExample(Example example);

	int deleteByPrimaryKey(Integer mblogId);

	int insert(Entity record);

	int insertSelective(Entity record);

	List<Entity> selectByExampleWithRowbounds(Example example, RowBounds rowBounds);

	List<Entity> selectByExample(Example example);

//	Entity selectByPrimaryKey(Integer mblogId);

	int updateByExampleSelective(@Param("record") Entity record, @Param("example") Example example);

	int updateByExample(@Param("record") Entity record, @Param("example") Example example);

	int updateByPrimaryKeySelective(Entity record);

	int updateByPrimaryKey(Entity record);
}