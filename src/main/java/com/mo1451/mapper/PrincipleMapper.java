package com.mo1451.mapper;

import com.mo1451.model.Principle;
import com.mo1451.model.PrincipleExample;
import com.mo1451.model.Tech;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrincipleMapper {
    long countByExample(PrincipleExample example);

    int deleteByExample(PrincipleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Principle record);

    int insertSelective(Principle record);

    List<Principle> selectByExample(PrincipleExample example);

    Principle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Principle record, @Param("example") PrincipleExample example);

    int updateByExample(@Param("record") Principle record, @Param("example") PrincipleExample example);

    int updateByPrimaryKeySelective(Principle record);

    int updateByPrimaryKey(Principle record);
    
    String selectMatrixByPara(Tech t);
    
    List<Principle> selectByIds(int[] ids);
}