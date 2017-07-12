package com.onboarding.webapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.onboarding.webapi.adapter.IALEServiceAdapter;
import com.onboarding.webapi.bean.ALEBean;
import com.onboarding.webapi.response.vo.ALEVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEListVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEMapVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEOutputVO;
import com.onboarding.webapi.responsewrapper.vo.CustomALEVO;
import com.onboarding.webapi.util.CommonConstants;
import com.onboarding.webapi.util.CommonUtil;

@Component
@Path(value=CommonConstants.ALE_SERVICE)
public class ALEService {
	private final Logger logger = Logger.getLogger(ALEService.class);
	
	@Autowired
	private IALEServiceAdapter iALEServiceAdapter;
	
	@Path(CommonConstants.ADD_ALE)
	@POST
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processAddAleData(final ALEBean aleBean) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processAddAleData : Method to processAddAleData");
		}
		CustomALEOutputVO customALEOutputVO = new CustomALEOutputVO();
		Integer result = null;
		try {
			result = iALEServiceAdapter.processAddAleData(aleBean);
		} catch (Exception e) {
			logger.error("Error while invoking processAddAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processAddAleData : Method to processAddAleData");
		}
		customALEOutputVO.setResult(result);

		return Response.ok(customALEOutputVO).build();
	}
	
	@Path(CommonConstants.UPDATE_ALE)
	@PUT
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processUpdateAleData(final ALEBean aleBean) {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processUpdateAleData : Method to processUpdateAleData");
		}
		CustomALEOutputVO customALEOutputVO = new CustomALEOutputVO();
		Integer result = null;
		try {
			result = iALEServiceAdapter.processUpdateAleData(aleBean);
		} catch (Exception e) {
			logger.error("Error while invoking processUpdateAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processUpdateAleData : Method to processUpdateAleData");
		}
		customALEOutputVO.setResult(result);
		
		return Response.ok(customALEOutputVO).build();

	}
	
	@Path(CommonConstants.DELETE_ALE)
	@PUT
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processDeleteAleData(
			@HeaderParam("AleId") String aleId,
			@HeaderParam("AleName") String aleName, @HeaderParam("AleFein") String aleFein) {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processDeleteAleData : Method to processDeleteAleData");
		}
		CustomALEOutputVO customALEOutputVO = new CustomALEOutputVO();
		Integer result = null;
		try {
			result = iALEServiceAdapter.processDeleteAleData(aleId, aleName, aleFein);
		} catch (Exception e) {
			logger.error("Error while invoking processDeleteAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processDeleteAleData : Method to processDeleteAleData");
		}
		customALEOutputVO.setResult(result);

		return Response.ok(customALEOutputVO).build();

	}
	
	
	@Path(CommonConstants.LOAD_ALL_ALE)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processLoadAllAleData() {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processLoadAllAleData : Method to processLoadAllAleData");
		}
		CustomALEListVO customALEListVO = new CustomALEListVO();
		List<ALEVO> aleList = new ArrayList<>();
		try {
			aleList = iALEServiceAdapter.processLoadAllAleData();
		} catch (Exception e) {
			logger.error("Error while invoking processLoadAllAleData : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processLoadAllAleData : Method to processLoadAllAleData");
		}
		customALEListVO.setAleData(aleList);
		
		return Response.ok(customALEListVO).build();

	}
	
	
	@Path(CommonConstants.LOAD_ALL_ALE_MAP)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processLoadAllAleMap() {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processLoadAllAleMap : Method to processLoadAllAleMap");
		}
		CustomALEMapVO customALEMapVO = new CustomALEMapVO();
		List<ALEVO> aleList = new ArrayList<>();
		Map<String,String> aleMap = new HashMap<>();
		try {
			aleList = iALEServiceAdapter.processLoadAllAleData();
		} catch (Exception e) {
			logger.error("Error while invoking processLoadAllAleMap : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processLoadAllAleMap : Method to processLoadAllAleMap");
		}
		for(ALEVO aleVO : aleList) {
			aleMap.put(aleVO.getAleId(), aleVO.getAleName());
		}
		aleMap = CommonUtil.sortByKeys(aleMap);
		customALEMapVO.setAleMap(aleMap);
		
		return Response.ok(customALEMapVO).build();

	}
	
	
	@Path(CommonConstants.LOAD_ALE)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response processLoadAleByUniqueKeys(@QueryParam("AleId") String aleId,
			@QueryParam("AleName") String aleName,@QueryParam("AleFein") String aleFein) {

		if (logger.isDebugEnabled()) {
			logger.debug("START :: ALEService : processLoadAleByUniqueKeys : Method to processLoadAleByUniqueKeys");
		}
		CustomALEVO customALEVO = new CustomALEVO();
		ALEVO aleVO = new ALEVO();
		try {
			aleVO = iALEServiceAdapter.processLoadAleByUniqueKeys(aleId, aleName,aleFein);
		} catch (Exception e) {
			logger.error("Error while invoking processLoadAleByUniqueKeys : " + e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END :: ALEService : processLoadAleByUniqueKeys : Method to processLoadAleByUniqueKeys");
		}
		customALEVO.setAle(aleVO);
		
		return Response.ok(customALEVO).build();

	}
}
