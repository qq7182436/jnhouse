package com.jnhouse.app.service;

import com.jnhouse.app.bean.FkeFile;
import com.jnhouse.app.bean.SupAnswerLine;


public interface FileService extends BaseService<FkeFile>{

	/**
	 * App 接口
	 * 保存文件(图片)和答案明细
	 */
	int saveFile(SupAnswerLine supAnswerLine,FkeFile fkeFile);
}
