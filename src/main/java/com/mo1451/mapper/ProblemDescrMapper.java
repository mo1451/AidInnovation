package com.mo1451.mapper;

import com.mo1451.model.ProblemDescr;
import com.mo1451.model.ProblemDescrExample;
import com.mo1451.model.ProblemDescrWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemDescrMapper {
    long countByExample(ProblemDescrExample example);

    int deleteByExample(ProblemDescrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProblemDescrWithBLOBs record);

    int insertSelective(ProblemDescrWithBLOBs record);

    List<ProblemDescrWithBLOBs> selectByExampleWithBLOBs(ProblemDescrExample example);

    List<ProblemDescr> selectByExample(ProblemDescrExample example);

    ProblemDescrWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProblemDescrWithBLOBs record, @Param("example") ProblemDescrExample example);

    int updateByExampleWithBLOBs(@Param("record") ProblemDescrWithBLOBs record, @Param("example") ProblemDescrExample example);

    int updateByExample(@Param("record") ProblemDescr record, @Param("example") ProblemDescrExample example);

    int updateByPrimaryKeySelective(ProblemDescrWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProblemDescrWithBLOBs record);

    int updateByPrimaryKey(ProblemDescr record);
}