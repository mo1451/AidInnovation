package com.mo1451.mapper;

import com.mo1451.model.Source;
import com.mo1451.model.SourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceMapper {
    long countByExample(SourceExample example);

    int deleteByExample(SourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Source record);

    int insertSelective(Source record);

    List<Source> selectByExample(SourceExample example);

    Source selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Source record, @Param("example") SourceExample example);

    int updateByExample(@Param("record") Source record, @Param("example") SourceExample example);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
}