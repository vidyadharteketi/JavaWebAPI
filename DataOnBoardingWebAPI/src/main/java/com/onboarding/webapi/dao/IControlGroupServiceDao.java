package com.onboarding.webapi.dao;

import java.util.List;

import com.onboarding.webapi.bean.ControlGroupBean;
import com.onboarding.webapi.response.vo.ControlGroupVO;

public interface IControlGroupServiceDao {

	public int processAddControlGroupData(ControlGroupBean controlGroupBean) throws Exception;
	
	public int processUpdateControlGroupData(ControlGroupBean controlGroupBean) throws Exception;
	
	public int processDeleteControlGroupData(String controlGroupId, String controlGroupName) throws Exception;
	
	public List<ControlGroupVO> processLoadAllControlGroupData() throws Exception;
	
	public ControlGroupVO processLoadControlGroupByUniqueKeys(String controlGroupId, String controlGroupName) throws Exception;

}
