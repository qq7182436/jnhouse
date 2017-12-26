package com.jnhouse.app.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jnhouse.app.bean.AnsFileRel;
import com.jnhouse.app.bean.FkeFile;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.dao.AnsFileRelDao;
import com.jnhouse.app.dao.FkeFileDao;
import com.jnhouse.app.dao.SupAnswerLineDao;
import com.jnhouse.app.service.FileService;

@Service
public class FileServiceImpl extends BaseServiceImpl<FkeFile> implements FileService{

	@Resource
	private FkeFileDao fkeFileDao;
	
	@Resource
	private AnsFileRelDao ansFileRelDao;
	
	@Resource
	private SupAnswerLineDao supAnswerLineDao;
	


	@Override
	public int save(FkeFile entity) {
		// TODO Auto-generated method stub
		
	
		int c = fkeFileDao.save(entity);
		return c;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return fkeFileDao.delete(id);
	}

	@Override
	public int update(FkeFile entity) {
		// TODO Auto-generated method stub
		return fkeFileDao.update(entity);
	}

	@Override
	public FkeFile getById(Integer id) {
		// TODO Auto-generated method stub
		return fkeFileDao.getById(id);
	}

	@Override
	public List<FkeFile> findAll() {
		// TODO Auto-generated method stub
		return fkeFileDao.findAll();
	}

	/**
	 * App 保存文件接口
	 */
	@Override
	public int saveFile(SupAnswerLine supAnswerLine, FkeFile fkeFile) {
		// TODO Auto-generated method stub

		// 保存文件信息
		int c = 0;

		Timestamp scurrtest = new Timestamp(System.currentTimeMillis());

		fkeFile.setCreated_time(scurrtest);
		fkeFile.setUpdated_time(scurrtest);
		fkeFile.setIs_delete(1);
		c = fkeFileDao.save(fkeFile);
		if (c == 1) {
			// 保存文件和考核明细的信息
			AnsFileRel ansFileRel = new AnsFileRel();
			ansFileRel.setAnswer_line_id(supAnswerLine.getId());
			ansFileRel.setFile_id(fkeFile.getId());
			ansFileRel.setIs_delete(1);
			ansFileRel.setUpdated_by(fkeFile.getUpdated_by());// 更新人
			ansFileRel.setCreated_by(fkeFile.getCreated_by());// 创建人
			ansFileRel.setCreated_time(scurrtest);
			ansFileRel.setUpdated_time(scurrtest);
			ansFileRelDao.save(ansFileRel);

			// 更新明细表

			SupAnswerLine supAnswerLine2 = supAnswerLineDao.getById(supAnswerLine.getId());

			if (supAnswerLine2 != null) {
				supAnswerLine.setUpdated_time(scurrtest);
				supAnswerLine.setCreated_time(scurrtest);
				c = supAnswerLineDao.updateByPrimaryKeySelective(supAnswerLine);
			}

		}
		// 手动回滚
		// throw new RuntimeException();

		return c;
	}

	

}
