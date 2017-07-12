package com.onboarding.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboarding.webapi.adapter.IControlGroupServiceAdapter;
import com.onboarding.webapi.bean.ControlGroupBean;
import com.onboarding.webapi.dao.IControlGroupServiceDao;
import com.onboarding.webapi.response.vo.ControlGroupVO;

@Service
public class ControlGroupServiceAdapterImpl implements IControlGroupServiceAdapter{

private final Logger logger = Logger.getLogger(ControlGroupServiceAdapterImpl.class);
	
	@Autowired
	private IControlGroupServiceDao iControlGroupServiceDao;
	
	@Override
	@Transactional
	public int processAddControlGroupData(ControlGroupBean controlGroupBean) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ControlGroupServiceAdapterImpl : processAddControlGroupData : Method to processAddControlGroupData");
		}
		try {
			result = iControlGroupServiceDao.processAddControlGroupData(controlGroupBean);
		} catch (Exception e) {
			logger.error("Error while fetching data processAddControlGroupData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ControlGroupServiceAdapterImpl : processAddControlGroupData : Method to processAddControlGroupData");
		}
		return result;
	}

	@Override
	@Transactional
	public int processUpdateControlGroupData(ControlGroupBean controlGroupBean) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ControlGroupServiceAdapterImpl : processUpdateControlGroupData : Method to processUpdateControlGroupData");
		}
		try {
			result = iControlGroupServiceDao.processUpdateControlGroupData(controlGroupBean);
		} catch (Exception e) {
			logger.error("Error while fetching data processUpdateControlGroupData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ControlGroupServiceAdapterImpl : processUpdateControlGroupData : Method to processUpdateControlGroupData");
		}
		return result;
	}
	
	@Override
	@Transactional
	public int processDeleteControlGroupData(String controlGroupId, String controlGroupName) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ControlGroupServiceAdapterImpl : processDeleteControlGroupData : Method to processDeleteControlGroupData");
		}
		try {
			result = iControlGroupServiceDao.processDeleteControlGroupData(controlGroupId, controlGroupName);
		} catch (Exception e) {
			logger.error("Error while fetching data processDeleteControlGroupData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ControlGroupServiceAdapterImpl : processDeleteControlGroupData : Method to processDeleteControlGroupData");
		}
		return result;
	}

	@Override
	public List<ControlGroupVO> processLoadAllControlGroupData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ControlGroupServiceAdapterImpl : processLoadAllControlGroupData : Method to processLoadAllControlGroupData");
		}
		List<ControlGroupVO> result = iControlGroupServiceDao.processLoadAllControlGroupData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: ControlGroupServiceAdapterImpl : processLoadAllControlGroupData : Method to processLoadAllControlGroupData");
		}
		return result;
	}

	@Override
	public ControlGroupVO processLoadControlGroupByUniqueKeys(String controlGroupId, String controlGroupName)
			throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ControlGroupServiceAdapterImpl : processLoadAllControlGroupData : Method to processLoadAllControlGroupData");
		}
		ControlGroupVO result = iControlGroupServiceDao.processLoadControlGroupByUniqueKeys(controlGroupId, controlGroupName);
		if(logger.isDebugEnabled()){
			logger.debug("END :: ControlGroupServiceAdapterImpl : processLoadAllControlGroupData : Method to processLoadAllControlGroupData");
		}
		return result;
	}
	
	
}
