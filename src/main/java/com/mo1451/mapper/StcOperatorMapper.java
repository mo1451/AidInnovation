package com.mo1451.mapper;

import com.mo1451.model.StcOperator;
import com.mo1451.model.StcOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StcOperatorMapper {
    long countByExample(StcOperatorExample example);

    int deleteByExample(StcOperatorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StcOperator record);

    int insertSelective(StcOperator record);

    List<StcOperator> selectByExample(StcOperatorExample example);

    StcOperator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StcOperator record, @Param("example") StcOperatorExample example);

    int updateByExample(@Param("record") StcOperator record, @Param("example") StcOperatorExample example);

    int updateByPrimaryKeySelective(StcOperator record);

    int updateByPrimaryKey(StcOperator record);
}