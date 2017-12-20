package com.jnhouse.app.dao;

import java.util.List;

import com.jnhouse.app.bean.FkeEast;
import com.jnhouse.app.bean.FkeFile;
import com.jnhouse.app.bean.SupAnswerHeader;

public interface FkeEastDao extends BaseDao<FkeFile> {

	List<FkeEast> findStoreInfoList(SupAnswerHeader supAnswerHeader);
}
