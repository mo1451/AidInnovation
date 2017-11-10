package com.mo1451.mapper;

import com.mo1451.model.IdealRes;
import com.mo1451.model.IdealResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdealResMapper {
    long countByExample(IdealResExample example);

    int deleteByExample(IdealResExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IdealRes record);

    int insertSelective(IdealRes record);

    List<IdealRes> selectByExample(IdealResExample example);

    IdealRes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IdealRes record, @Param("example") IdealResExample example);

    int updateByExample(@Param("record") IdealRes record, @Param("example") IdealResExample example);

    int updateByPrimaryKeySelective(IdealRes record);

    int updateByPrimaryKey(IdealRes record);
}