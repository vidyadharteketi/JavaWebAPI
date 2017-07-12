package com.onboarding.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboarding.webapi.adapter.IALEServiceAdapter;
import com.onboarding.webapi.bean.ALEBean;
import com.onboarding.webapi.dao.IALEServiceDao;
import com.onboarding.webapi.response.vo.ALEVO;
@Service
public class ALEServiceAdapterImpl implements IALEServiceAdapter{
private final Logger logger = Logger.getLogger(ALEServiceAdapterImpl.class);

@Autowired
private IALEServiceDao iALEServiceDao;

	@Override
	@Transactional
	public int processAddAleData(ALEBean aleBean) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEServiceAdapterImpl : processAddAleData : Method to processAddAleData");
		}
		try {
			result = iALEServiceDao.processAddAleData(aleBean);
		} catch (Exception e) {
			logger.error("Error while fetching data processAddAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEServiceAdapterImpl : processAddAleData : Method to processAddAleData");
		}
		return result;
	}

	@Override
	@Transactional
	public int processUpdateAleData(ALEBean aleBean) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEServiceAdapterImpl : processUpdateAleData : Method to processUpdateAleData");
		}
		try {
			result = iALEServiceDao.processUpdateAleData(aleBean);
		} catch (Exception e) {
			logger.error("Error while fetching data processUpdateAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEServiceAdapterImpl : processUpdateAleData : Method to processUpdateAleData");
		}
		return result;
	}

	@Override
	@Transactional
	public int processDeleteAleData(String aleId, String aleName, String aleFein) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEServiceAdapterImpl : processDeleteAleData : Method to processDeleteAleData");
		}
		try {
			result = iALEServiceDao.processDeleteAleData(aleId, aleName, aleFein);
		} catch (Exception e) {
			logger.error("Error while fetching data processDeleteAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEServiceAdapterImpl : processDeleteAleData : Method to processDeleteAleData");
		}
		return result;
	}

	@Override
	public List<ALEVO> processLoadAllAleData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ALEServiceAdapterImpl : processLoadAllAleData : Method to processLoadAllAleData");
		}
		List<ALEVO> result = iALEServiceDao.processLoadAllAleData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: ALEServiceAdapterImpl : processLoadAllAleData : Method to processLoadAllAleData");
		}
		return result;
	}

	@Override
	public ALEVO processLoadAleByUniqueKeys(String aleId, String aleName, String aleFein) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ALEServiceAdapterImpl : processLoadAleByUniqueKeys : Method to processLoadAleByUniqueKeys");
		}
		ALEVO result = iALEServiceDao.processLoadAleByUniqueKeys(aleId, aleName,aleFein);
		if(logger.isDebugEnabled()){
			logger.debug("END :: ALEServiceAdapterImpl : processLoadAleByUniqueKeys : Method to processLoadAleByUniqueKeys");
		}
		return result;
	}

}
