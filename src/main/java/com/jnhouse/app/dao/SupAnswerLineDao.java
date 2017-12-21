package com.jnhouse.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.dto.SupAnswerHeaderDTO;
import com.jnhouse.app.dto.SupAnswerHeaderLineDTO;



public interface SupAnswerLineDao extends BaseDao<SupAnswerLine>{
	
	/** 
     * insert:插入操作. <br/> 
     * 
     * @author 许晨
     * @param method 插入操作的方法名 
     * @param entity 查询参数或实体类 
     * @return 返回影响的行数 
     * @since JDK 1.6 
     */  
	
	int insertBatchSupAnswerLine(@Param("header_id")Integer header_id,@Param("supAnsLineList") List<SupAnswerHeaderLineDTO> supAnswerHeaderDTOs);
	
	
	/**
	 * App 接口 
	 * @param method 查询订单(主表)考核明细的id
	 * @return 考核明细的id 的集合
	 */
	List<SupAnswerLine> findAllLineId(SupAnswerLine supAnswerLine);
	
	
	/**
	 * App 接口
	 * @param  method 批量更新
	 * @return 返回影响的行数 
	 */
	int updateBatch(@Param("supAnswerLineList") List<SupAnswerLine> supAnswerLineList);
	
	
	/**
	 * App 接口  上传文件更新考核明细表
	 * @param supAnswerLine
	 * @return 返回影响的行数 
	 */
	int updateByPrimaryKeySelective(SupAnswerLine supAnswerLine);
	
	SupAnswerLine findByHeaderId(SupAnswerLine supAnswerLine);

}