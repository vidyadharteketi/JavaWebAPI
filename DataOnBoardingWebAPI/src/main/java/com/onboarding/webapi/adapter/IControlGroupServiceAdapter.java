package com.onboarding.webapi.adapter;

import java.util.List;

import com.onboarding.webapi.bean.ControlGroupBean;
import com.onboarding.webapi.response.vo.ControlGroupVO;

public interface IControlGroupServiceAdapter {
	
	public int processAddControlGroupData(ControlGroupBean controlGroupBean) throws Exception;
	
	public int processUpdateControlGroupData(ControlGroupBean controlGroupBean) throws Exception;
	
	public int processDeleteControlGroupData(String controlGroupId, String controlGroupName) throws Exception;
	
	public List<ControlGroupVO> processLoadAllControlGroupData() throws Exception;
	
	public ControlGroupVO processLoadControlGroupByUniqueKeys(String controlGroupId, String controlGroupName) throws Exception;

}
