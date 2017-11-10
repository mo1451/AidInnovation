package com.mo1451.mapper;

import com.mo1451.model.Word;
import com.mo1451.model.WordExample;
import com.mo1451.model.WordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WordMapper {
    long countByExample(WordExample example);

    int deleteByExample(WordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WordWithBLOBs record);

    int insertSelective(WordWithBLOBs record);

    List<WordWithBLOBs> selectByExampleWithBLOBs(WordExample example);

    List<Word> selectByExample(WordExample example);

    WordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WordWithBLOBs record, @Param("example") WordExample example);

    int updateByExampleWithBLOBs(@Param("record") WordWithBLOBs record, @Param("example") WordExample example);

    int updateByExample(@Param("record") Word record, @Param("example") WordExample example);

    int updateByPrimaryKeySelective(WordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WordWithBLOBs record);

    int updateByPrimaryKey(Word record);
}