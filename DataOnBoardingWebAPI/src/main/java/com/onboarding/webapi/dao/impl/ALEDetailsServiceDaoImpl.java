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

import com.onboarding.webapi.bean.ALEDetails;
import com.onboarding.webapi.dao.IALEDetailsServiceDao;
import com.onboarding.webapi.entity.ALEDetailsDTO;
import com.onboarding.webapi.response.vo.ALEDetailsVO;
import com.onboarding.webapi.util.CommonUtil;
@Repository
public class ALEDetailsServiceDaoImpl implements IALEDetailsServiceDao{
	private final Logger logger = Logger.getLogger(ALEDetailsServiceDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	private CommonUtil commonUtil;

	@Override
	public int processAddAleDetailsData(ALEDetails aleDetails) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEServiceDaoImpl : processAddAleDetailsData : Method to processAddAleDetailsData");
		}

		int result = 0;
		List<ALEDetailsVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ALEDetailsDTO aleDetailsDTO = new ALEDetailsDTO();

		try {

			aleDetailsDTO.setAleDetailsId(aleDetails.getAleDetailsId());
			aleDetailsDTO.setAleId(aleDetails.getAleId());
			aleDetailsDTO.setAleTaxYear(aleDetails.getAleTaxYear());
			aleDetailsDTO.setIsAcaSubscriber(aleDetails.getIsAcaSubscriber());
			aleDetailsDTO.setIsFilingAuthoritative1094c(aleDetails.getIsFilingAuthoritative1094c());
			aleDetailsDTO.setIsAcaReportingShared(aleDetails.getIsAcaReportingShared());
			aleDetailsDTO.sethTransitionRelief(aleDetails.gethTransitionRelief());
			aleDetailsDTO.setAdditional1095cCount(aleDetails.getAdditional1095cCount());
			aleDetailsDTO.setControlGroupId(aleDetails.getControlGroupId());
			aleDetailsDTO.setAdditiontionalFulltimeEeJan(aleDetails.getAdditiontionalFulltimeEeJan());
			aleDetailsDTO.setAdditiontionalFulltimeEeFeb(aleDetails.getAdditiontionalFulltimeEeFeb());
			aleDetailsDTO.setAdditiontionalFulltimeEeMar(aleDetails.getAdditiontionalFulltimeEeMar());
			aleDetailsDTO.setAdditiontionalFulltimeEeApr(aleDetails.getAdditiontionalFulltimeEeApr());
			aleDetailsDTO.setAdditiontionalFulltimeEeMay(aleDetails.getAdditiontionalFulltimeEeMay());
			aleDetailsDTO.setAdditiontionalFulltimeEeJun(aleDetails.getAdditiontionalFulltimeEeJun());
			aleDetailsDTO.setAdditiontionalFulltimeEeJul(aleDetails.getAdditiontionalFulltimeEeJul());
			aleDetailsDTO.setAdditiontionalFulltimeEeAug(aleDetails.getAdditiontionalFulltimeEeAug());
			aleDetailsDTO.setAdditiontionalFulltimeEeSep(aleDetails.getAdditiontionalFulltimeEeSep());
			aleDetailsDTO.setAdditiontionalFulltimeEeOct(aleDetails.getAdditiontionalFulltimeEeOct());
			aleDetailsDTO.setAdditiontionalFulltimeEeNov(aleDetails.getAdditiontionalFulltimeEeNov());
			aleDetailsDTO.setAdditiontionalFulltimeEeDec(aleDetails.getAdditiontionalFulltimeEeDec());
			aleDetailsDTO.setAdditiontionalTotalEeJan(aleDetails.getAdditiontionalTotalEeJan());
			aleDetailsDTO.setAdditiontionalTotalEeFeb(aleDetails.getAdditiontionalTotalEeFeb());
			aleDetailsDTO.setAdditiontionalTotalEeMar(aleDetails.getAdditiontionalTotalEeMar());
			aleDetailsDTO.setAdditiontionalTotalEeApr(aleDetails.getAdditiontionalTotalEeApr());
			aleDetailsDTO.setAdditiontionalTotalEeMay(aleDetails.getAdditiontionalTotalEeMay());
			aleDetailsDTO.setAdditiontionalTotalEeJun(aleDetails.getAdditiontionalTotalEeJun());
			aleDetailsDTO.setAdditiontionalTotalEeJul(aleDetails.getAdditiontionalTotalEeJul());
			aleDetailsDTO.setAdditiontionalTotalEeAug(aleDetails.getAdditiontionalTotalEeAug());
			aleDetailsDTO.setAdditiontionalTotalEeSep(aleDetails.getAdditiontionalTotalEeSep());
			aleDetailsDTO.setAdditiontionalTotalEeOct(aleDetails.getAdditiontionalTotalEeOct());
			aleDetailsDTO.setAdditiontionalTotalEeNov(aleDetails.getAdditiontionalTotalEeNov());
			aleDetailsDTO.setAdditiontionalTotalEeDec(aleDetails.getAdditiontionalTotalEeDec());
			aleDetailsDTO.setActive(aleDetails.isActive());
			aleDetailsDTO.setDeleted(false);
			aleDetailsDTO.setCreatedBy("UserName");
			aleDetailsDTO.setCreatedDate(commonUtil.convertStringToDate());
			aleDetailsDTO.setModifiedBy("UserName");
			aleDetailsDTO.setModifiedDate(commonUtil.convertStringToDate());
			
			session.save(aleDetailsDTO);
			tx.commit();

			// listVo = processLoadAllAleDetails();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processAddAleDetailsData : " + e.getMessage());
			tx.rollback();
			
			logger.debug(" Setting the AleDetailsID to MAX+1  :: ");
			Transaction tx1 = session.getTransaction();
			String sqlQry = "ALTER TABLE tbl_data_ale_details AUTO_INCREMENT = 1";
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
					"END :: ALEServiceDaoImpl : processAddAleDetailsData : Method to processAddAleDetailsData");
		}

		return result;
	}

	@Override
	public int processUpdateAleDetailsData(ALEDetails aleDetails) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEServiceDaoImpl : processUpdateAleData : Method to processUpdateAleData");
		}
		int result = 0;
		List<ALEDetailsVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			String tranUpdQry = "UPDATE ALEDetailsDTO AD SET AD.isAcaSubscriber=:isAcaSubscriber, "
					+ " AD.isFilingAuthoritative1094c = :isFilingAuthoritative1094c, "
					+ " AD.isAcaReportingShared = :isAcaReportingShared, "
					+ " AD.hTransitionRelief = :hTransitionRelief, "
					+ " AD.additional1095cCount = :additional1095cCount, "
					+ " AD.controlGroupId = :controlGroupId, " 
					+ " AD.additiontionalFulltimeEeJan = :additiontionalFulltimeEeJan, " 
					+ " AD.additiontionalFulltimeEeFeb = :additiontionalFulltimeEeFeb, " 
					+ " AD.additiontionalFulltimeEeMar = :additiontionalFulltimeEeMar, " 
					+ " AD.additiontionalFulltimeEeApr = :additiontionalFulltimeEeApr, " 
					+ " AD.additiontionalFulltimeEeMay = :additiontionalFulltimeEeMay, " 
					+ " AD.additiontionalFulltimeEeJun = :additiontionalFulltimeEeJun, " 
					+ " AD.additiontionalFulltimeEeJul = :additiontionalFulltimeEeJul, " 
					+ " AD.additiontionalFulltimeEeAug = :additiontionalFulltimeEeAug, " 
					+ " AD.additiontionalFulltimeEeSep = :additiontionalFulltimeEeSep, " 
					+ " AD.additiontionalFulltimeEeOct = :additiontionalFulltimeEeOct, " 
					+ " AD.additiontionalFulltimeEeNov = :additiontionalFulltimeEeNov, " 
					+ " AD.additiontionalFulltimeEeDec = :additiontionalFulltimeEeDec, " 
					+ " AD.additiontionalTotalEeJan = :additiontionalTotalEeJan, " 
					+ " AD.additiontionalTotalEeFeb = :additiontionalTotalEeFeb, " 
					+ " AD.additiontionalTotalEeMar = :additiontionalTotalEeMar, " 
					+ " AD.additiontionalTotalEeApr = :additiontionalTotalEeApr, " 
					+ " AD.additiontionalTotalEeMay = :additiontionalTotalEeMay, " 
					+ " AD.additiontionalTotalEeJun = :additiontionalTotalEeJun, " 
					+ " AD.additiontionalTotalEeJul = :additiontionalTotalEeJul, " 
					+ " AD.additiontionalTotalEeAug = :additiontionalTotalEeAug, " 
					+ " AD.additiontionalTotalEeSep = :additiontionalTotalEeSep, " 
					+ " AD.additiontionalTotalEeOct = :additiontionalTotalEeOct, " 
					+ " AD.additiontionalTotalEeNov = :additiontionalTotalEeNov, " 
					+ " AD.additiontionalTotalEeDec = :additiontionalTotalEeDec, " 
					+ " AD.active = :isActive "
					+ " WHERE AD.aleDetailsId = :aleDetailsId AND AD.aleId=:aleId AND AD.aleTaxYear=:aleTaxYear";
			
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("isAcaSubscriber", aleDetails.getIsAcaSubscriber());
			transUpdQry.setParameter("isFilingAuthoritative1094c", aleDetails.getIsFilingAuthoritative1094c());
			transUpdQry.setParameter("isAcaReportingShared", aleDetails.getIsAcaReportingShared());
			transUpdQry.setParameter("hTransitionRelief", aleDetails.gethTransitionRelief());
			transUpdQry.setParameter("additional1095cCount", aleDetails.getAdditional1095cCount());
			transUpdQry.setParameter("controlGroupId",aleDetails.getControlGroupId());
			transUpdQry.setParameter("additiontionalFulltimeEeJan", aleDetails.getAdditiontionalFulltimeEeJan());
			transUpdQry.setParameter("additiontionalFulltimeEeFeb", aleDetails.getAdditiontionalFulltimeEeFeb());
			transUpdQry.setParameter("additiontionalFulltimeEeMar", aleDetails.getAdditiontionalFulltimeEeMar());
			transUpdQry.setParameter("additiontionalFulltimeEeApr", aleDetails.getAdditiontionalFulltimeEeApr());
			transUpdQry.setParameter("additiontionalFulltimeEeMay", aleDetails.getAdditiontionalFulltimeEeMay());
			transUpdQry.setParameter("additiontionalFulltimeEeJun", aleDetails.getAdditiontionalFulltimeEeJun());
			transUpdQry.setParameter("additiontionalFulltimeEeJul", aleDetails.getAdditiontionalFulltimeEeJul());
			transUpdQry.setParameter("additiontionalFulltimeEeAug", aleDetails.getAdditiontionalFulltimeEeAug());
			transUpdQry.setParameter("additiontionalFulltimeEeSep", aleDetails.getAdditiontionalFulltimeEeSep());
			transUpdQry.setParameter("additiontionalFulltimeEeOct", aleDetails.getAdditiontionalFulltimeEeOct());
			transUpdQry.setParameter("additiontionalFulltimeEeNov", aleDetails.getAdditiontionalFulltimeEeNov());
			transUpdQry.setParameter("additiontionalFulltimeEeDec", aleDetails.getAdditiontionalFulltimeEeDec());
			transUpdQry.setParameter("additiontionalTotalEeJan", aleDetails.getAdditiontionalTotalEeJan());
			transUpdQry.setParameter("additiontionalTotalEeFeb", aleDetails.getAdditiontionalTotalEeFeb());
			transUpdQry.setParameter("additiontionalTotalEeMar", aleDetails.getAdditiontionalTotalEeMar());
			transUpdQry.setParameter("additiontionalTotalEeApr", aleDetails.getAdditiontionalTotalEeApr());
			transUpdQry.setParameter("additiontionalTotalEeMay", aleDetails.getAdditiontionalTotalEeMay());
			transUpdQry.setParameter("additiontionalTotalEeJun", aleDetails.getAdditiontionalTotalEeJun());
			transUpdQry.setParameter("additiontionalTotalEeJul", aleDetails.getAdditiontionalTotalEeJul());
			transUpdQry.setParameter("additiontionalTotalEeAug", aleDetails.getAdditiontionalTotalEeAug());
			transUpdQry.setParameter("additiontionalTotalEeSep", aleDetails.getAdditiontionalTotalEeSep());
			transUpdQry.setParameter("additiontionalTotalEeOct", aleDetails.getAdditiontionalTotalEeOct());
			transUpdQry.setParameter("additiontionalTotalEeNov", aleDetails.getAdditiontionalTotalEeNov());
			transUpdQry.setParameter("additiontionalTotalEeDec", aleDetails.getAdditiontionalTotalEeDec());
			transUpdQry.setParameter("isActive", aleDetails.isActive());
			transUpdQry.setParameter("aleDetailsId", aleDetails.getAleDetailsId());
			transUpdQry.setParameter("aleId", aleDetails.getAleId());
			transUpdQry.setParameter("aleTaxYear", aleDetails.getAleTaxYear());
			transUpdQry.executeUpdate();
			tx.commit();

			// listVo = processLoadAllAleDetails();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processUpdateAleData : " + e.getMessage());
			tx.rollback();
			result = 0;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ALEServiceDaoImpl : processUpdateAleData : Method to processUpdateAleData");
		}
		System.out.println("result : " + result);
		return result;
	}

	@Override
	public int processDeleteAleDetailsData(String aleDetailsId, String aleId, String aleTaxYear)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEServiceDaoImpl : processDeleteAleDetailsData : Method to processDeleteAleDetailsData");
		}

		int result = 0;
		List<ALEDetailsVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			String tranUpdQry = "UPDATE ALEDetailsDTO AD SET  AD.deleted = :isDeleted "
					+ " WHERE AD.aleDetailsId = :aleDetailsId AND AD.aleId=:aleId AND AD.aleTaxYear=:aleTaxYear";
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("isDeleted", true);
			transUpdQry.setParameter("aleDetailsId", Integer.parseInt(aleDetailsId));
			transUpdQry.setParameter("aleId", Integer.parseInt(aleId));
			transUpdQry.setParameter("aleTaxYear", Integer.parseInt(aleTaxYear));
			transUpdQry.executeUpdate();
			tx.commit();

			listVo = processLoadAllAleDetails();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processDeleteAleDetailsData : " + e.getMessage());
			tx.rollback();
			result = 0;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ALEServiceDaoImpl : processDeleteAleDetailsData : Method to processDeleteAleDetailsData");
		}

		System.out.println("result : " + result);
		return result;
	}


	public List<ALEDetailsVO> processLoadAllAleDetailsData() throws Exception {

		ALEDetailsVO aleDetailsVO = null;
		List<ALEDetailsVO> listVo = new ArrayList<>();

		String sqlQry = "SELECT ale_details_id,ale_id,ale_tax_year,is_aca_subscriber,is_filing_authoritative_1094c,is_aca_reporting_shared,4980h_transition_relief,"
				+ "additional_1095c_count,control_group_id,additiontional_fulltime_ee_jan,additiontional_fulltime_ee_feb,additiontional_fulltime_ee_mar,"
				+ "additiontional_fulltime_ee_apr,additiontional_fulltime_ee_may,additiontional_fulltime_ee_jun,additiontional_fulltime_ee_jul,"
				+ "additiontional_fulltime_ee_aug,additiontional_fulltime_ee_sep,additiontional_fulltime_ee_oct,additiontional_fulltime_ee_nov,"
				+ "additiontional_fulltime_ee_dec,additiontional_total_ee_jan,additiontional_total_ee_feb,additiontional_total_ee_mar,"
				+ "additiontional_total_ee_apr,additiontional_total_ee_may,additiontional_total_ee_jun,additiontional_total_ee_jul,"
				+ "additiontional_total_ee_aug,additiontional_total_ee_sep,additiontional_total_ee_oct,additiontional_total_ee_nov,additiontional_total_ee_dec,"
				+ "is_active,is_deleted,created_by,created_date,modified_by,modified_date " 
				+ "FROM tbl_data_ale_details where is_deleted = 0";

		Session sqlSession = sessionFactory.openSession();
		Query query = sqlSession.createSQLQuery(sqlQry);

		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				aleDetailsVO = new ALEDetailsVO();
				if (null != column[0]) {
					aleDetailsVO.setAleDetailsId((column[0].toString()));
				}
				if (null != column[1]) {
					aleDetailsVO.setAleId((column[1].toString()));
				}
				if (null != column[2]) {
					aleDetailsVO.setAleTaxYear((column[2].toString()));
				}
				if (null != column[3]) {
					aleDetailsVO.setIsAcaSubscriber((column[3].toString()));
				}
				if (null != column[4]) {
					aleDetailsVO.setIsFilingAuthoritative1094c((column[4].toString()));
				}
				if (null != column[5]) {
					aleDetailsVO.setIsAcaReportingShared((column[5].toString()));
				}
				if (null != column[6]) {
					aleDetailsVO.sethTransitionRelief((column[6].toString()));
				}
				if (null != column[7]) {
					aleDetailsVO.setAdditional1095cCount((column[7].toString()));
				}
				if (null != column[8]) {
					aleDetailsVO.setControlGroupId((column[8].toString()));
				}
				if (null != column[9]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJan((column[9].toString()));
				}
				if (null != column[10]) {
					aleDetailsVO.setAdditiontionalFulltimeEeFeb((column[10].toString()));
				}
				if (null != column[11]) {
					aleDetailsVO.setAdditiontionalFulltimeEeMar((column[11].toString()));
				}
				if (null != column[12]) {
					aleDetailsVO.setAdditiontionalFulltimeEeApr((column[12].toString()));
				}
				if (null != column[13]) {
					aleDetailsVO.setAdditiontionalFulltimeEeMay((column[13].toString()));
				}

				if (null != column[14]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJun((column[14].toString()));
				}
				if (null != column[15]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJul((column[15].toString()));
				}
				if (null != column[16]) {
					aleDetailsVO.setAdditiontionalFulltimeEeAug((column[16].toString()));
				}
				if (null != column[17]) {
					aleDetailsVO.setAdditiontionalFulltimeEeSep((column[17].toString()));
				}
				if (null != column[18]) {
					aleDetailsVO.setAdditiontionalFulltimeEeOct((column[18].toString()));
				}
				if (null != column[19]) {
					aleDetailsVO.setAdditiontionalFulltimeEeNov((column[19].toString()));
				}
				if (null != column[20]) {
					aleDetailsVO.setAdditiontionalFulltimeEeDec((column[20].toString()));
				}
				if (null != column[21]) {
					aleDetailsVO.setAdditiontionalTotalEeJan((column[21].toString()));
				}
				if (null != column[22]) {
					aleDetailsVO.setAdditiontionalTotalEeFeb((column[22].toString()));
				}
				if (null != column[23]) {
					aleDetailsVO.setAdditiontionalTotalEeMar((column[23].toString()));
				}
				if (null != column[24]) {
					aleDetailsVO.setAdditiontionalTotalEeApr((column[24].toString()));
				}
				if (null != column[25]) {
					aleDetailsVO.setAdditiontionalTotalEeMay((column[25].toString()));
				}
				if (null != column[26]) {
					aleDetailsVO.setAdditiontionalTotalEeJun((column[26].toString()));
				}
				if (null != column[27]) {
					aleDetailsVO.setAdditiontionalTotalEeJul((column[27].toString()));
				}
				if (null != column[28]) {
					aleDetailsVO.setAdditiontionalTotalEeAug((column[28].toString()));
				}
				if (null != column[29]) {
					aleDetailsVO.setAdditiontionalTotalEeSep((column[29].toString()));
				}
				if (null != column[30]) {
					aleDetailsVO.setAdditiontionalTotalEeOct((column[30].toString()));
				}
				if (null != column[31]) {
					aleDetailsVO.setAdditiontionalTotalEeNov((column[31].toString()));
				}
				if (null != column[32]) {
					aleDetailsVO.setAdditiontionalTotalEeDec((column[32].toString()));
				}
				if (null != column[33]) {
					aleDetailsVO.setActive((column[33].toString()));
				}
				if (null != column[34]) {
					aleDetailsVO.setDeleted((column[34].toString()));
				}
				if (null != column[35]) {
					aleDetailsVO.setCreatedBy((column[35].toString()));
				}
				if (null != column[36]) {
					aleDetailsVO.setCreatedDate((column[36].toString()));
				}
				if (null != column[37]) {
					aleDetailsVO.setModifiedBy((column[37].toString()));
				}
				if (null != column[38]) {
					aleDetailsVO.setModifiedDate((column[38].toString()));
				}

				listVo.add(aleDetailsVO);
			}
		} else {
			listVo = null;
		}

		return listVo;
	}

	public ALEDetailsVO processLoadAleDetailsByUniqueKeys(String aleDetailsId, String aleId, String aleTaxYear) throws Exception {

		ALEDetailsVO aleDetailsVO = null;
		List<ALEDetailsVO> listVo = new ArrayList<ALEDetailsVO>();

		Session sqlSession = sessionFactory.openSession();

		String sqlQry = "SELECT ale_details_id,ale_id,ale_tax_year,is_aca_subscriber,is_filing_authoritative_1094c,is_aca_reporting_shared,4980h_transition_relief,"
				+ "additional_1095c_count,control_group_id,additiontional_fulltime_ee_jan,additiontional_fulltime_ee_feb,additiontional_fulltime_ee_mar,"
				+ "additiontional_fulltime_ee_apr,additiontional_fulltime_ee_may,additiontional_fulltime_ee_jun,additiontional_fulltime_ee_jul,"
				+ "additiontional_fulltime_ee_aug,additiontional_fulltime_ee_sep,additiontional_fulltime_ee_oct,additiontional_fulltime_ee_nov,"
				+ "additiontional_fulltime_ee_dec,additiontional_total_ee_jan,additiontional_total_ee_feb,additiontional_total_ee_mar,"
				+ "additiontional_total_ee_apr,additiontional_total_ee_may,additiontional_total_ee_jun,additiontional_total_ee_jul,"
				+ "additiontional_total_ee_aug,additiontional_total_ee_sep,additiontional_total_ee_oct,additiontional_total_ee_nov,additiontional_total_ee_dec,"
				+ "is_active,is_deleted,created_by,created_date,modified_by,modified_date " 
				+ " FROM tbl_data_ale_details WHERE "
				+ "ale_details_id = ? AND ale_id = ? AND ale_tax_year = ?";
		Query query = sqlSession.createSQLQuery(sqlQry);
		query.setParameter(0, Integer.parseInt(aleDetailsId));
		query.setParameter(1, Integer.parseInt(aleId));
		query.setParameter(2, Integer.parseInt(aleTaxYear));

		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				aleDetailsVO = new ALEDetailsVO();
				if (null != column[0]) {
					aleDetailsVO.setAleDetailsId((column[0].toString()));
				}
				if (null != column[1]) {
					aleDetailsVO.setAleId((column[1].toString()));
				}
				if (null != column[2]) {
					aleDetailsVO.setAleTaxYear((column[2].toString()));
				}
				if (null != column[3]) {
					aleDetailsVO.setIsAcaSubscriber((column[3].toString()));
				}
				if (null != column[4]) {
					aleDetailsVO.setIsFilingAuthoritative1094c((column[4].toString()));
				}
				if (null != column[5]) {
					aleDetailsVO.setIsAcaReportingShared((column[5].toString()));
				}
				if (null != column[6]) {
					aleDetailsVO.sethTransitionRelief((column[6].toString()));
				}
				if (null != column[7]) {
					aleDetailsVO.setAdditional1095cCount((column[7].toString()));
				}
				if (null != column[8]) {
					aleDetailsVO.setControlGroupId((column[8].toString()));
				}
				if (null != column[9]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJan((column[9].toString()));
				}
				if (null != column[10]) {
					aleDetailsVO.setAdditiontionalFulltimeEeFeb((column[10].toString()));
				}
				if (null != column[11]) {
					aleDetailsVO.setAdditiontionalFulltimeEeMar((column[11].toString()));
				}
				if (null != column[12]) {
					aleDetailsVO.setAdditiontionalFulltimeEeApr((column[12].toString()));
				}
				if (null != column[13]) {
					aleDetailsVO.setAdditiontionalFulltimeEeMay((column[13].toString()));
				}

				if (null != column[14]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJun((column[14].toString()));
				}
				if (null != column[15]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJul((column[15].toString()));
				}
				if (null != column[16]) {
					aleDetailsVO.setAdditiontionalFulltimeEeAug((column[16].toString()));
				}
				if (null != column[17]) {
					aleDetailsVO.setAdditiontionalFulltimeEeSep((column[17].toString()));
				}
				if (null != column[18]) {
					aleDetailsVO.setAdditiontionalFulltimeEeOct((column[18].toString()));
				}
				if (null != column[19]) {
					aleDetailsVO.setAdditiontionalFulltimeEeNov((column[19].toString()));
				}
				if (null != column[20]) {
					aleDetailsVO.setAdditiontionalFulltimeEeDec((column[20].toString()));
				}
				if (null != column[21]) {
					aleDetailsVO.setAdditiontionalTotalEeJan((column[21].toString()));
				}
				if (null != column[22]) {
					aleDetailsVO.setAdditiontionalTotalEeFeb((column[22].toString()));
				}
				if (null != column[23]) {
					aleDetailsVO.setAdditiontionalTotalEeMar((column[23].toString()));
				}
				if (null != column[24]) {
					aleDetailsVO.setAdditiontionalTotalEeApr((column[24].toString()));
				}
				if (null != column[25]) {
					aleDetailsVO.setAdditiontionalTotalEeMay((column[25].toString()));
				}
				if (null != column[26]) {
					aleDetailsVO.setAdditiontionalTotalEeJun((column[26].toString()));
				}
				if (null != column[27]) {
					aleDetailsVO.setAdditiontionalTotalEeJul((column[27].toString()));
				}
				if (null != column[28]) {
					aleDetailsVO.setAdditiontionalTotalEeAug((column[28].toString()));
				}
				if (null != column[29]) {
					aleDetailsVO.setAdditiontionalTotalEeSep((column[29].toString()));
				}
				if (null != column[30]) {
					aleDetailsVO.setAdditiontionalTotalEeOct((column[30].toString()));
				}
				if (null != column[31]) {
					aleDetailsVO.setAdditiontionalTotalEeNov((column[31].toString()));
				}
				if (null != column[32]) {
					aleDetailsVO.setAdditiontionalTotalEeDec((column[32].toString()));
				}
				if (null != column[33]) {
					aleDetailsVO.setActive((column[33].toString()));
				}
				if (null != column[34]) {
					aleDetailsVO.setDeleted((column[34].toString()));
				}
				if (null != column[35]) {
					aleDetailsVO.setCreatedBy((column[35].toString()));
				}
				if (null != column[36]) {
					aleDetailsVO.setCreatedDate((column[36].toString()));
				}
				if (null != column[37]) {
					aleDetailsVO.setModifiedBy((column[37].toString()));
				}
				if (null != column[38]) {
					aleDetailsVO.setModifiedDate((column[38].toString()));
				}
				break;
			}
		}

		return aleDetailsVO;
	}

	public List<ALEDetailsVO> processLoadAllAleDetails() throws Exception {

		ALEDetailsVO aleDetailsVO = null;
		List<ALEDetailsVO> listVo = new ArrayList<>();

		String sqlQry = "SELECT ale_details_id,ale_id,ale_tax_year,is_aca_subscriber,is_filing_authoritative_1094c,is_aca_reporting_shared,4980h_transition_relief,"
				+ "additional_1095c_count,control_group_id,additiontional_fulltime_ee_jan,additiontional_fulltime_ee_feb,additiontional_fulltime_ee_mar,"
				+ "additiontional_fulltime_ee_apr,additiontional_fulltime_ee_may,additiontional_fulltime_ee_jun,additiontional_fulltime_ee_jul,"
				+ "additiontional_fulltime_ee_aug,additiontional_fulltime_ee_sep,additiontional_fulltime_ee_oct,additiontional_fulltime_ee_nov,"
				+ "additiontional_fulltime_ee_dec,additiontional_total_ee_jan,additiontional_total_ee_feb,additiontional_total_ee_mar,"
				+ "additiontional_total_ee_apr,additiontional_total_ee_may,additiontional_total_ee_jun,additiontional_total_ee_jul,"
				+ "additiontional_total_ee_aug,additiontional_total_ee_sep,additiontional_total_ee_oct,additiontional_total_ee_nov,additiontional_total_ee_dec,"
				+ "is_active,is_deleted,created_by,created_date,modified_by,modified_date " 
				+ "FROM tbl_data_ale_details where is_deleted = 0";

		Session sqlSession = sessionFactory.openSession();
		Query query = sqlSession.createSQLQuery(sqlQry);

		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				aleDetailsVO = new ALEDetailsVO();
				if (null != column[0]) {
					aleDetailsVO.setAleDetailsId((column[0].toString()));
				}
				if (null != column[1]) {
					aleDetailsVO.setAleId((column[1].toString()));
				}
				if (null != column[2]) {
					aleDetailsVO.setAleTaxYear((column[2].toString()));
				}
				if (null != column[3]) {
					aleDetailsVO.setIsAcaSubscriber((column[3].toString()));
				}
				if (null != column[4]) {
					aleDetailsVO.setIsFilingAuthoritative1094c((column[4].toString()));
				}
				if (null != column[5]) {
					aleDetailsVO.setIsAcaReportingShared((column[5].toString()));
				}
				if (null != column[6]) {
					aleDetailsVO.sethTransitionRelief((column[6].toString()));
				}
				if (null != column[7]) {
					aleDetailsVO.setAdditional1095cCount((column[7].toString()));
				}
				if (null != column[8]) {
					aleDetailsVO.setControlGroupId((column[8].toString()));
				}
				if (null != column[9]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJan((column[9].toString()));
				}
				if (null != column[10]) {
					aleDetailsVO.setAdditiontionalFulltimeEeFeb((column[10].toString()));
				}
				if (null != column[11]) {
					aleDetailsVO.setAdditiontionalFulltimeEeMar((column[11].toString()));
				}
				if (null != column[12]) {
					aleDetailsVO.setAdditiontionalFulltimeEeApr((column[12].toString()));
				}
				if (null != column[13]) {
					aleDetailsVO.setAdditiontionalFulltimeEeMay((column[13].toString()));
				}

				if (null != column[14]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJun((column[14].toString()));
				}
				if (null != column[15]) {
					aleDetailsVO.setAdditiontionalFulltimeEeJul((column[15].toString()));
				}
				if (null != column[16]) {
					aleDetailsVO.setAdditiontionalFulltimeEeAug((column[16].toString()));
				}
				if (null != column[17]) {
					aleDetailsVO.setAdditiontionalFulltimeEeSep((column[17].toString()));
				}
				if (null != column[18]) {
					aleDetailsVO.setAdditiontionalFulltimeEeOct((column[18].toString()));
				}
				if (null != column[19]) {
					aleDetailsVO.setAdditiontionalFulltimeEeNov((column[19].toString()));
				}
				if (null != column[20]) {
					aleDetailsVO.setAdditiontionalFulltimeEeDec((column[20].toString()));
				}
				if (null != column[21]) {
					aleDetailsVO.setAdditiontionalTotalEeJan((column[21].toString()));
				}
				if (null != column[22]) {
					aleDetailsVO.setAdditiontionalTotalEeFeb((column[22].toString()));
				}
				if (null != column[23]) {
					aleDetailsVO.setAdditiontionalTotalEeMar((column[23].toString()));
				}
				if (null != column[24]) {
					aleDetailsVO.setAdditiontionalTotalEeApr((column[24].toString()));
				}
				if (null != column[25]) {
					aleDetailsVO.setAdditiontionalTotalEeMay((column[25].toString()));
				}
				if (null != column[26]) {
					aleDetailsVO.setAdditiontionalTotalEeJun((column[26].toString()));
				}
				if (null != column[27]) {
					aleDetailsVO.setAdditiontionalTotalEeJul((column[27].toString()));
				}
				if (null != column[28]) {
					aleDetailsVO.setAdditiontionalTotalEeAug((column[28].toString()));
				}
				if (null != column[29]) {
					aleDetailsVO.setAdditiontionalTotalEeSep((column[29].toString()));
				}
				if (null != column[30]) {
					aleDetailsVO.setAdditiontionalTotalEeOct((column[30].toString()));
				}
				if (null != column[31]) {
					aleDetailsVO.setAdditiontionalTotalEeNov((column[31].toString()));
				}
				if (null != column[32]) {
					aleDetailsVO.setAdditiontionalTotalEeDec((column[32].toString()));
				}
				if (null != column[33]) {
					aleDetailsVO.setActive((column[33].toString()));
				}
				if (null != column[34]) {
					aleDetailsVO.setDeleted((column[34].toString()));
				}
				if (null != column[35]) {
					aleDetailsVO.setCreatedBy((column[35].toString()));
				}
				if (null != column[36]) {
					aleDetailsVO.setCreatedDate((column[36].toString()));
				}
				if (null != column[37]) {
					aleDetailsVO.setModifiedBy((column[37].toString()));
				}
				if (null != column[38]) {
					aleDetailsVO.setModifiedDate((column[38].toString()));
				}
				
				listVo.add(aleDetailsVO);
			}
		} else {
			listVo = null;
		}

		return listVo;
	}
}
