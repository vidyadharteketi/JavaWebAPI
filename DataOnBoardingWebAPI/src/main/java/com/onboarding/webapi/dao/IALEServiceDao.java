package com.onboarding.webapi.dao;

import java.util.List;

import com.onboarding.webapi.bean.ALEBean;
import com.onboarding.webapi.response.vo.ALEVO;

public interface IALEServiceDao {
public int processAddAleData(ALEBean aleBean) throws Exception;
	
	public int processUpdateAleData(ALEBean aleBean) throws Exception;
	
	public int processDeleteAleData(String aleId, String aleName,String aleFein) throws Exception;
	
	public List<ALEVO> processLoadAllAleData() throws Exception;
	
	public ALEVO processLoadAleByUniqueKeys(String aleId, String aleName, String aleFein) throws Exception;
}
