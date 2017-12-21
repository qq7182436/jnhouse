package com.jnhouse.app.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.dto.SupAnswerHeaderDTO;
import com.jnhouse.app.dto.SupAnswerHeaderLineDTO;



public interface SupAnswerHeaderDao extends BaseDao<SupAnswerHeader>{
	
	/**
	 * App 接口  保存  主表和明细表的考核信息
	 * @param supAnswerHeader
	 * @param supAnswerHeaderDaoList
	 * @return
	 */
	int insertBatchSupAnswerLine(@Param("header_id")Integer header_id,@Param("supAnsLineList") List<SupAnswerHeaderLineDTO> supAnswerHeaderDTOList);
	
	

	/**
	 * @param method  查询主表的id
	 * @param supAnswerHeader
	 * @return
	 */
     SupAnswerHeaderDTO getByHeaderId(SupAnswerHeader supAnswerHeader);
     
     
     /**
      * 
      * @param supAnswerHeader
      * @return
      */
     List<SupAnswerHeaderDTO> findAnswerHeaderAndLine(SupAnswerHeaderDTO supAnswerHeaderDTO);
     
     List<SupAnswerHeaderDTO> supAnswerHeaderDao(SupAnswerHeaderDTO supAnswerHeaderDTO);
     
     
     List<SupAnswerHeaderDTO> findSecondHeader(SupAnswerHeaderDTO supAnswerHeaderDTO);

}