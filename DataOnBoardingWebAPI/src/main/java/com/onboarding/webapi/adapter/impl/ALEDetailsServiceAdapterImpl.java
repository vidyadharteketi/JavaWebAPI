package com.onboarding.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboarding.webapi.adapter.IALEDetailsServiceAdapter;
import com.onboarding.webapi.bean.ALEDetails;
import com.onboarding.webapi.dao.IALEDetailsServiceDao;
import com.onboarding.webapi.response.vo.ALEDetailsVO;
@Service
public class ALEDetailsServiceAdapterImpl implements IALEDetailsServiceAdapter{
	private final Logger logger = Logger.getLogger(ALEDetailsServiceAdapterImpl.class);

	@Autowired
	private IALEDetailsServiceDao iALEDetailsServiceDao;
	
	@Override
	@Transactional
	public int processAddAleDetailsData(ALEDetails aleDetails) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEDetailsServiceAdapterImpl : processAddAleDetailsData : Method to processAddAleDetailsData");
		}
		try {
			result = iALEDetailsServiceDao.processAddAleDetailsData(aleDetails);
		} catch (Exception e) {
			logger.error("Error while fetching data processAddAleDetailsData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ALEDetailsServiceAdapterImpl : processAddAleDetailsData : Method to processAddAleDetailsData");
		}
		return result;
	}

	@Override
	@Transactional
	public int processUpdateAleDetailsData(ALEDetails aleDetails) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEDetailsServiceAdapterImpl : processUpdateAleDetailsData : Method to processUpdateAleDetailsData");
		}
		try {
			result = iALEDetailsServiceDao.processUpdateAleDetailsData(aleDetails);
		} catch (Exception e) {
			logger.error("Error while fetching data processUpdateAleDetailsData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ALEDetailsServiceAdapterImpl : processUpdateAleDetailsData : Method to processUpdateAleDetailsData");
		}
		return result;
	}

	@Override
	@Transactional
	public int processDeleteAleDetailsData(String aleDetailsId, String aleId, String aleTaxYear) throws Exception {
		int result = 0;
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEDetailsServiceAdapterImpl : processDeleteAleDetailsData : Method to processDeleteAleDetailsData");
		}
		try {
			result = iALEDetailsServiceDao.processDeleteAleDetailsData(aleDetailsId, aleId, aleTaxYear);
		} catch (Exception e) {
			logger.error("Error while fetching data processDeleteAleDetailsData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ALEDetailsServiceAdapterImpl : processDeleteAleDetailsData : Method to processDeleteAleDetailsData");
		}
		return result;
	}

	@Override
	public List<ALEDetailsVO> processLoadAllAleDetailsData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ALEDetailsServiceAdapterImpl : processLoadAllAleDetailsData : Method to processLoadAllAleDetailsData");
		}
		List<ALEDetailsVO> result = iALEDetailsServiceDao.processLoadAllAleDetailsData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: ALEDetailsServiceAdapterImpl : processLoadAllAleDetailsData : Method to processLoadAllAleDetailsData");
		}
		return result;
	}

	@Override
	public ALEDetailsVO processLoadAleDetailsByUniqueKeys(String aleDetailsId, String aleId, String aleTaxYear)
			throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ALEDetailsServiceAdapterImpl : processLoadAleDetailsByUniqueKeys : Method to processLoadAleDetailsByUniqueKeys");
		}
		ALEDetailsVO result = iALEDetailsServiceDao.processLoadAleDetailsByUniqueKeys(aleDetailsId, aleId, aleTaxYear);
		if(logger.isDebugEnabled()){
			logger.debug("END :: ALEDetailsServiceAdapterImpl : processLoadAleDetailsByUniqueKeys : Method to processLoadAleDetailsByUniqueKeys");
		}
		return result;
	}

}
