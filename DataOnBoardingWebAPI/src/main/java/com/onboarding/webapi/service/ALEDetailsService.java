package com.onboarding.webapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onboarding.webapi.adapter.IALEDetailsServiceAdapter;
import com.onboarding.webapi.bean.ALEDetails;
import com.onboarding.webapi.response.vo.ALEDetailsVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEDetailsListVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEDetailsOutputVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEDetailsVO;
import com.onboarding.webapi.util.CommonConstants;

@Component
@Path(value=CommonConstants.ALE_DETAILS_SERVICE)
public class ALEDetailsService {
	private final Logger logger = Logger.getLogger(ALEDetailsService.class);
	
	@Autowired
	private IALEDetailsServiceAdapter iALEDetailsServiceAdapter;
	
	@Path(CommonConstants.ADD_ALE_DETAILS)
	@POST
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processAddAleDetailsData(final ALEDetails aleDetails) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEDetailsService : processAddAleDetailsData : Method to processAddAleDetailsData");
		}
		CustomALEDetailsOutputVO customALEDetailsOutputVO = new CustomALEDetailsOutputVO();
		Integer result = null;
		try {
			result = iALEDetailsServiceAdapter.processAddAleDetailsData(aleDetails);

		} catch (Exception e) {
			logger.error("Error while invoking processAddAleDetailsData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEDetailsService : processAddAleDetailsData : Method to processAddAleDetailsData");
		}
		customALEDetailsOutputVO.setResult(result);
		
		return Response.ok(customALEDetailsOutputVO).build();
	}
	
	@Path(CommonConstants.UPDATE_ALE_DETAILS)
	@PUT
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processUpdateAleDetailsData(final ALEDetails aleDetails) {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEDetailsService : processUpdateAleDetailsData : Method to processUpdateAleDetailsData");
		}
		CustomALEDetailsOutputVO customALEDetailsOutputVO = new CustomALEDetailsOutputVO();
		Integer result = null;
		try {
			result = iALEDetailsServiceAdapter.processUpdateAleDetailsData(aleDetails);

		} catch (Exception e) {
			logger.error("Error while invoking processUpdateAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEDetailsService : processUpdateAleDetailsData : Method to processUpdateAleDetailsData");
		}
		customALEDetailsOutputVO.setResult(result);
		
		return Response.ok(customALEDetailsOutputVO).build();

	}
	
	@Path(CommonConstants.DELETE_ALE_DETAILS)
	@PUT
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processDeleteAleDetailsData(@HeaderParam("AleDetailsId") String aleDetailsId,
			@HeaderParam("AleId") String aleId,@HeaderParam("AleTaxYear") String aleTaxYear) {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processDeleteAleDetailsData : Method to processDeleteAleDetailsData");
		}
		CustomALEDetailsOutputVO customALEDetailsOutputVO = new CustomALEDetailsOutputVO();
		Integer result = null;
		try {
			result = iALEDetailsServiceAdapter.processDeleteAleDetailsData(aleDetailsId, aleId, aleTaxYear);
		} catch (Exception e) {
			logger.error("Error while invoking processDeleteAleDetailsData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processDeleteAleDetailsData : Method to processDeleteAleDetailsData");
		}
		customALEDetailsOutputVO.setResult(result);
		
		return Response.ok(customALEDetailsOutputVO).build();

	}
	
	
	@Path(CommonConstants.LOAD_ALL_ALE_DETAILS)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processLoadAllAleDetailsData() {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processLoadAllAleDetailsData : Method to processLoadAllAleDetailsData");
		}
		CustomALEDetailsListVO customALEDetailsListVO = new CustomALEDetailsListVO();
		List<ALEDetailsVO> aleDetailsList = new ArrayList<>();
		try {
			aleDetailsList = iALEDetailsServiceAdapter.processLoadAllAleDetailsData();
		} catch (Exception e) {
			logger.error("Error while invoking processLoadAllAleDetailsData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processLoadAllAleDetailsData : Method to processLoadAllAleDetailsData");
		}
		customALEDetailsListVO.setAleDetailsData(aleDetailsList);
		
		return Response.ok(customALEDetailsListVO).build();

	}
	
	@Path(CommonConstants.LOAD_ALE_DETAILS)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processLoadAleDetailsByUniqueKeys(@QueryParam("AleDetailsId") String aleDetailsId,
			@QueryParam("AleId") String aleId,@QueryParam("AleTaxYear") String aleTaxYear) {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processLoadAleDetailsByUniqueKeys : Method to processLoadAleDetailsByUniqueKeys");
		}
		CustomALEDetailsVO customALEDetailsVO = new CustomALEDetailsVO();
		ALEDetailsVO aleDetailsVO = new ALEDetailsVO();
		try {
			aleDetailsVO = iALEDetailsServiceAdapter.processLoadAleDetailsByUniqueKeys(aleDetailsId,
					aleId,aleTaxYear);
		} catch (Exception e) {
			logger.error("Error while invoking processLoadAleDetailsByUniqueKeys : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processLoadAleDetailsByUniqueKeys : Method to processLoadAleDetailsByUniqueKeys");
		}
		customALEDetailsVO.setAceDetails(aleDetailsVO);
		
		return Response.ok(customALEDetailsVO).build();

	}

}
