package com.onboarding.webapi.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
			if (StringUtils.isNotBlank(controlGroupBean.getMeasurementStartDate())) {
				controlGroupDTO.setMeasurementStartDate(
						commonUtil.convertStringToDate(controlGroupBean.getMeasurementStartDate()));
			}
			if (StringUtils.isNotBlank(controlGroupBean.getMeasurementEndDate())) {
				controlGroupDTO.setMeasurementEndDate(
						commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate()));
			}
			if (StringUtils.isNotBlank(controlGroupBean.getMeasurementEndDate1())) {
				controlGroupDTO.setMeasurementEndDate1(
						commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate1()));
			}
			if (StringUtils.isNotBlank(controlGroupBean.getMeasurementEndDate2())) {
				controlGroupDTO.setMeasurementEndDate2(
						commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate2()));
			}
			if (StringUtils.isNotBlank(controlGroupBean.getMeasurementEndDate3())) {
				controlGroupDTO.setMeasurementEndDate3(
						commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate3()));
			}
			if (StringUtils.isNotBlank(controlGroupBean.getMeasurementEndDate4())) {
				controlGroupDTO.setMeasurementEndDate4(
						commonUtil.convertStringToDate(controlGroupBean.getMeasurementEndDate4()));
			}
			controlGroupDTO.setActive(controlGroupBean.isActive());
			controlGroupDTO.setDeleted(false);
			controlGroupDTO.setCreatedBy("UserName");
			controlGroupDTO.setCreatedDate(commonUtil.convertStringToDate());
			controlGroupDTO.setModifiedBy("UserName");
			controlGroupDTO.setModifiedDate(commonUtil.convertStringToDate());
			session.save(controlGroupDTO);
			tx.commit();

			// listVo = processLoadAllControlGroupData();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processAddControlGroupData : " + e.getMessage());
			tx.rollback();

			logger.debug(" Setting the ControlGroupID to MAX+1  :: ");
			Transaction tx1 = session.getTransaction();
			String sqlQry = "ALTER TABLE tbl_data_control_group AUTO_INCREMENT = 1;";
			Query transUpdQry = session.createSQLQuery(sqlQry);
			transUpdQry.executeUpdate();
			tx1.commit();

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
					+ " CG.active = :isActive "
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

			// listVo = processLoadAllControlGroupData();

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

			String tranUpdQry = "UPDATE ControlGroupDTO CG SET  CG.deleted = :isDeleted "
					+ " WHERE CG.controlGroupId = :controlGroupId AND CG.controlGroupName=:controlGroupName";
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("isDeleted", true);
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
		
		String sqlQry = "select control_group_id,control_group_ein,control_group_name,created_by,created_date,is_active,is_deleted,"
				+ "measurement_end_date,measurement_end_date_1,measurement_end_date_2,measurement_end_date_3,"
				+ "measurement_end_date_4,measurement_start_date,modified_by,modified_date from tbl_data_control_group where is_deleted = 0";

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
					controlGroupVO.setActive((column[5].toString()));
				}
				if (null != column[6]) {
					controlGroupVO.setDeleted((column[6].toString()));
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
				if (null != column[14]) {
					controlGroupVO.setModifiedDate((column[14].toString()));
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

		Session sqlSession = sessionFactory.openSession();
		
		String sqlQry = "select control_group_id, control_group_ein, control_group_name, created_by, created_date, is_active, is_deleted,"
				+ "measurement_end_date, measurement_end_date_1, measurement_end_date_2, measurement_end_date_3, measurement_end_date_4,"
				+ "measurement_start_date,modified_by,modified_date from tbl_data_control_group"
				+ " WHERE control_group_id = ? AND control_group_name = ?";
		Query query = sqlSession.createSQLQuery(sqlQry);
		query.setParameter(0, Integer.parseInt(controlGroupId));
		query.setParameter(1, controlGroupName);
		
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
					controlGroupVO.setActive((column[5].toString()));
				}
				if (null != column[6]) {
					controlGroupVO.setDeleted((column[6].toString()));
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
				if (null != column[14]) {
					controlGroupVO.setModifiedDate((column[14].toString()));
				}
				break;
			}
		}

		return controlGroupVO;
	}
	
}
