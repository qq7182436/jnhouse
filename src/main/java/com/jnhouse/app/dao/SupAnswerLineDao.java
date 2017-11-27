package com.jnhouse.app.dao;

import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.bean.SupAnswerLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupAnswerLineMapper {
    long countByExample(SupAnswerLineExample example);

    int deleteByExample(SupAnswerLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupAnswerLine record);

    int insertSelective(SupAnswerLine record);

    List<SupAnswerLine> selectByExample(SupAnswerLineExample example);

    SupAnswerLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupAnswerLine record, @Param("example") SupAnswerLineExample example);

    int updateByExample(@Param("record") SupAnswerLine record, @Param("example") SupAnswerLineExample example);

    int updateByPrimaryKeySelective(SupAnswerLine record);

    int updateByPrimaryKey(SupAnswerLine record);
}