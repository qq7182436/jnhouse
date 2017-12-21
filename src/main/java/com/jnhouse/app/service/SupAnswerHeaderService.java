package com.jnhouse.app.service;

import java.util.List;

import com.jnhouse.app.bean.FkeEast;
import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.dto.SupAnswerHeaderDTO;
import com.jnhouse.app.dto.SupAnswerHeaderLineDTO;




public interface SupAnswerHeaderService extends BaseService<SupAnswerHeader> {

	
	/**
	 * App 接口 保存订单信息
	 * @param supAnswerHeader
	 * @param 
	 * @return supAnswerHeaderDTOs
	 */
	List<SupAnswerLine> saveAndBackLineIds(SupAnswerHeader supAnswerHeader,List<SupAnswerHeaderLineDTO> supAnswerHeaderDTOs);
	

	/**
	 * App 接口
	 * @param interface 查询所有督察门店信息
	 * @return
	 */
	List<FkeEast> findStoreInfoList(SupAnswerHeader supAnswerHeader);
	
	/**
	 * App 接口 
	 * @param interface 查询订单明细详情
	 * @return
	 */

    SupAnswerHeaderDTO supAnswerHeader(SupAnswerHeader supAnswerHeader);
    
    
    List<SupAnswerHeaderDTO> findSecondHeader(SupAnswerHeaderDTO supAnswerHeaderDTO);
	
	
	
	List<SupAnswerHeaderDTO> findAnswerHeaderAndLine(SupAnswerHeaderDTO supAnswerHeaderDTO);
}




