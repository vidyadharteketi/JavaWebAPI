package com.onboarding.webapi.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onboarding.webapi.bean.ControlGroupBean;
import com.onboarding.webapi.dao.IControlGroupServiceDao;
import com.onboarding.webapi.entity.ControlGroupDTO;
import com.onboarding.webapi.response.vo.ControlGroupVO;
import com.onboarding.webapi.util.CommonUtil;

@Repository
public class ControlGroupServiceDaoImpl implements IControlGroupServiceDao{

	private final Logger logger = Logger.getLogger(ControlGroupServiceDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	private CommonUtil commonUtil;
	
	@Override
	public int processAddControlGroupData(ControlGroupBean controlGroupBean) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ControlGroupServiceDaoImpl : processAddControlGroupData : Method to processAddControlGroupData");
		}

		int result = 0;
		List<ControlGroupVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ControlGroupDTO controlGroupDTO = new ControlGroupDTO();

		try {
			controlGroupDTO.setControlGroupName(controlGroupBean.getControlGroupName());
			controlGroupDTO.setControlGroupEIN(controlGroupBean.getControlGroupEIN());
			controlGroupDTO
					.setMeasurementStartDate(commonUtil.convertStringToDate(controlGroupBean.getMeasurementStartDate()));
			controlGroupDTO
					.setMeasurementEndDate(commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate()));
			controlGroupDTO
					.setMeasurementEndDate1(commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate1()));
			controlGroupDTO
					.setMeasurementEndDate2(commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate2()));
			controlGroupDTO
					.setMeasurementEndDate3(commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate3()));
			controlGroupDTO
			.setMeasurementEndDate4(commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate4()));
			controlGroupDTO.setActive(controlGroupBean.isActive());
			controlGroupDTO.setDeleted(true);
			controlGroupDTO.setCreatedBy("UserName");
			controlGroupDTO.setCreatedDate(commonUtil.convertStringToDate());
			controlGroupDTO.setModifiedBy("UserName");
			session.save(controlGroupDTO);
			tx.commit();

			listVo = processLoadAllControlGroupData();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processAddControlGroupData : " + e.getMessage());
			tx.rollback();
			result = 0;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ControlGroupServiceDaoImpl : processAddControlGroupData : Method to processAddControlGroupData");
		}

		return result;
	}
	
	@Override
	public int processUpdateControlGroupData(ControlGroupBean controlGroupBean) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ControlGroupServiceDaoImpl : processUpdateControlGroupData : Method to processUpdateControlGroupData");
		}
		int result = 0;
		List<ControlGroupVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			String tranUpdQry = "UPDATE ControlGroupDTO CG SET CG.controlGroupEIN=:controlGroupEIN, "
					+ " CG.measurementStartDate = :measurementStartDate, "
					+ " CG.measurementEndDate = :measurementEndDate, "
					+ " CG.measurementEndDate1 = :measurementEndDate1, "
					+ " CG.measurementEndDate2 = :measurementEndDate2, "
					+ " CG.measurementEndDate3 = :measurementEndDate3, " 
					+ " CG.measurementEndDate4 = :measurementEndDate4, " 
					+ " CG.isActive = :isActive "
					+ " WHERE CG.controlGroupId = :controlGroupId AND CG.controlGroupName=:controlGroupName";
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("controlGroupEIN", controlGroupBean.getControlGroupEIN());
			transUpdQry.setParameter("measurementStartDate",
					commonUtil.convertStringToDate(controlGroupBean.getMeasurementStartDate()));
			transUpdQry.setParameter("measurementEndDate",
					commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate()));
			transUpdQry.setParameter("measurementEndDate1",
					commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate1()));
			transUpdQry.setParameter("measurementEndDate2",
					commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate2()));
			transUpdQry.setParameter("measurementEndDate3",
					commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate3()));
			transUpdQry.setParameter("measurementEndDate4",
					commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate4()));
			transUpdQry.setParameter("isActive", controlGroupBean.isActive());
			transUpdQry.setParameter("controlGroupId", Integer.parseInt(controlGroupBean.getControlGroupId()));
			transUpdQry.setParameter("controlGroupName", controlGroupBean.getControlGroupName());
			transUpdQry.executeUpdate();
			tx.commit();

			listVo = processLoadAllControlGroupData();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processUpdateControlGroupData : " + e.getMessage());
			tx.rollback();
			result = 0;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ControlGroupServiceDaoImpl : processUpdateControlGroupData : Method to processUpdateControlGroupData");
		}
		System.out.println("result : " + result);
		return result;
	}
	
	@Override
	public int processDeleteControlGroupData(String controlGroupId, String controlGroupName)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ControlGroupServiceDaoImpl : processDeleteControlGroupData : Method to processDeleteControlGroupData");
		}

		int result = 0;
		List<ControlGroupVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			String tranUpdQry = "UPDATE ControlGroupDTO CG SET  CG.isDeleted = :isDeleted "
					+ " WHERE CG.controlGroupId = :controlGroupId AND CG.controlGroupName=:controlGroupName";
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("isDeleted", false);
			transUpdQry.setParameter("controlGroupId", Integer.parseInt(controlGroupId));
			transUpdQry.setParameter("controlGroupName", controlGroupName);
			transUpdQry.executeUpdate();
			tx.commit();
			
			/*String tranUpdQry = "DELETE FROM ControlGroupDTO CG "
					+ " WHERE CG.controlGroupId = :controlGroupId AND CG.controlGroupName=:controlGroupName";
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("controlGroupId", Integer.parseInt(controlGroupId));
			transUpdQry.setParameter("controlGroupName", controlGroupName);
			transUpdQry.executeUpdate();
			tx.commit();*/

			listVo = processLoadAllControlGroupData();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processDeleteControlGroupData : " + e.getMessage());
			tx.rollback();
			result = 0;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ControlGroupServiceDaoImpl : processDeleteControlGroupData : Method to processDeleteControlGroupData");
		}

		System.out.println("result : " + result);
		return result;
	}
	
	
	public List<ControlGroupVO> processLoadAllControlGroupData() throws Exception {

		ControlGroupVO controlGroupVO = null;
		List<ControlGroupVO> listVo = new ArrayList<>();
		
		String sqlQry = "select CONTROL_GROUP_ID,CONTROL_GROUP_EIN,CONTROL_GROUP_NAME,CREATED_BY,CREATED_DATE,IS_ACTIVE,IS_DELETED,"
				+ "MEASUREMENT_END_DATE,MEASUREMENT_END_DATE_1,MEASUREMENT_END_DATE_2,MEASUREMENT_END_DATE_3,"
				+ "MEASUREMENT_END_DATE_4,MEASUREMENT_START_DATE,MODIFIED_BY from tbl_data_control_group";

		Session sqlSession = sessionFactory.openSession();
		Query query = sqlSession.createSQLQuery(sqlQry);

		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				controlGroupVO = new ControlGroupVO();
				if (null != column[0]) {
					controlGroupVO.setControlGroupId((column[0].toString()));
				}
				if (null != column[1]) {
					controlGroupVO.setControlGroupEIN((column[1].toString()));
				}
				if (null != column[2]) {
					controlGroupVO.setControlGroupName((column[2].toString()));
				}
				if (null != column[3]) {
					controlGroupVO.setCreatedBy((column[3].toString()));
				}
				if (null != column[4]) {
					controlGroupVO.setCreatedDate((column[4].toString()));
				}
				if (null != column[5]) {
					controlGroupVO.setActive((Boolean.parseBoolean(column[5].toString())));
				}
				if (null != column[6]) {
					controlGroupVO.setIsDeleted((column[6].toString()));
				}
				if (null != column[7]) {
					controlGroupVO.setMeasurementEndDate((column[7].toString()));
				}
				if (null != column[8]) {
					controlGroupVO.setMeasurementEndDate1((column[8].toString()));
				}
				if (null != column[9]) {
					controlGroupVO.setMeasurementEndDate2((column[9].toString()));
				}
				if (null != column[10]) {
					controlGroupVO.setMeasurementEndDate3((column[10].toString()));
				}
				if (null != column[11]) {
					controlGroupVO.setMeasurementEndDate4((column[11].toString()));
				}
				if (null != column[12]) {
					controlGroupVO.setMeasurementStartDate((column[12].toString()));
				}
				if (null != column[13]) {
					controlGroupVO.setModifiedBy((column[13].toString()));
				}
				listVo.add(controlGroupVO);
			}
		} else {
			listVo = null;
		}

		return listVo;
	}

	public ControlGroupVO processLoadControlGroupByUniqueKeys(String controlGroupId, String controlGroupName) throws Exception {

		ControlGroupVO controlGroupVO = null;
		List<ControlGroupVO> listVo = new ArrayList<ControlGroupVO>();

		String sqlQry = "select CONTROL_GROUP_ID, CONTROL_GROUP_EIN, CONTROL_GROUP_NAME, CREATED_BY, CREATED_DATE, IS_ACTIVE, IS_DELETED,"
				+ "MEASUREMENT_END_DATE, MEASUREMENT_END_DATE_1, MEASUREMENT_END_DATE_2, MEASUREMENT_END_DATE_3, MEASUREMENT_END_DATE_4,"
				+ "MEASUREMENT_START_DATE,MODIFIED_BY from tbl_data_control_group"
				+ "WHERE CONTROL_GROUP_ID = :controlGroupId AND CONTROL_GROUP_NAME = :controlGroupName";

		Session sqlSession = sessionFactory.openSession();
		Query query = sqlSession.createSQLQuery(sqlQry);
		query.setParameter("controlGroupId", Integer.parseInt(controlGroupId));
		query.setParameter("controlGroupName", controlGroupName);
		
		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				controlGroupVO = new ControlGroupVO();
				if (null != column[0]) {
					controlGroupVO.setControlGroupId((column[0].toString()));
				}
				if (null != column[1]) {
					controlGroupVO.setControlGroupEIN((column[1].toString()));
				}
				if (null != column[2]) {
					controlGroupVO.setControlGroupName((column[2].toString()));
				}
				if (null != column[3]) {
					controlGroupVO.setCreatedBy((column[3].toString()));
				}
				if (null != column[4]) {
					controlGroupVO.setCreatedDate((column[4].toString()));
				}
				if (null != column[5]) {
					controlGroupVO.setActive((Boolean.parseBoolean(column[5].toString())));
				}
				if (null != column[6]) {
					controlGroupVO.setIsDeleted((column[6].toString()));
				}
				if (null != column[7]) {
					controlGroupVO.setMeasurementEndDate((column[7].toString()));
				}
				if (null != column[8]) {
					controlGroupVO.setMeasurementEndDate1((column[8].toString()));
				}
				if (null != column[9]) {
					controlGroupVO.setMeasurementEndDate2((column[9].toString()));
				}
				if (null != column[10]) {
					controlGroupVO.setMeasurementEndDate3((column[10].toString()));
				}
				if (null != column[11]) {
					controlGroupVO.setMeasurementEndDate4((column[11].toString()));
				}
				if (null != column[12]) {
					controlGroupVO.setMeasurementStartDate((column[12].toString()));
				}
				if (null != column[13]) {
					controlGroupVO.setModifiedBy((column[13].toString()));
				}
				break;
			}
		}

		return controlGroupVO;
	}
	
}
