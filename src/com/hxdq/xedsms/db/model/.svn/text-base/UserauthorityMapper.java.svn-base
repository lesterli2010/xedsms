package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Userauthority;
import com.hxdq.xedsms.db.model.UserauthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserauthorityMapper extends Mapper {
    int countByExample(UserauthorityExample example);

    int deleteByExample(UserauthorityExample example);

    int deleteByPrimaryKey(String userid);

    int insert(Userauthority record);

    int insertSelective(Userauthority record);

    List<Userauthority> selectByExampleWithRowbounds(UserauthorityExample example, RowBounds rowBounds);

    List<Userauthority> selectByExample(UserauthorityExample example);

    Userauthority selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") Userauthority record, @Param("example") UserauthorityExample example);

    int updateByExample(@Param("record") Userauthority record, @Param("example") UserauthorityExample example);

    int updateByPrimaryKeySelective(Userauthority record);

    int updateByPrimaryKey(Userauthority record);
}