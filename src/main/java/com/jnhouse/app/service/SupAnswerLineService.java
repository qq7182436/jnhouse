package com.jnhouse.app.service;

import java.util.List;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.dto.SupAnswerHeaderLineDTO;

public interface SupAnswerLineService extends BaseService<SupAnswerLine>{

	/**
	 * App 更新接口
	 * @param supAnswerLine
	 * @return
	 */
	int updateByPrimaryKeySelective(SupAnswerLine supAnswerLine);
	
	/**
	 * App 接口 批量更新考核明细信息
	 * @param supAnswerrLineLists
	 * @param supAnswerHeader
	 * @return
	 */
	int updateBatchLineAndSaveHeaderInfo(List<SupAnswerLine> supAnswerrLineLists,SupAnswerHeader supAnswerHeader);
}
