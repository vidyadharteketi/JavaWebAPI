package com.onboarding.webapi.dao;

import java.util.List;

import com.onboarding.webapi.bean.ALEDetails;
import com.onboarding.webapi.response.vo.ALEDetailsVO;

public interface IALEDetailsServiceDao {
public int processAddAleDetailsData(ALEDetails aleDetails) throws Exception;
	
	public int processUpdateAleDetailsData(ALEDetails aleDetails) throws Exception;
	
	public int processDeleteAleDetailsData(String aleDetailsId, String aleId, String aleTaxYear) throws Exception;
	
	public List<ALEDetailsVO> processLoadAllAleDetailsData() throws Exception;
	
	public ALEDetailsVO processLoadAleDetailsByUniqueKeys(String aleDetailsId, String aleId, String aleTaxYear) throws Exception;
}
