package com.mo1451.mapper;

import com.mo1451.model.Tech;
import com.mo1451.model.TechExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechMapper {
    long countByExample(TechExample example);

    int deleteByExample(TechExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tech record);

    int insertSelective(Tech record);

    List<Tech> selectByExample(TechExample example);

    Tech selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tech record, @Param("example") TechExample example);

    int updateByExample(@Param("record") Tech record, @Param("example") TechExample example);

    int updateByPrimaryKeySelective(Tech record);

    int updateByPrimaryKey(Tech record);
}