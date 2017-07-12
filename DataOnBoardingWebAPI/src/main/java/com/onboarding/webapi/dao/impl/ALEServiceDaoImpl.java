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

import com.onboarding.webapi.bean.ALEBean;
import com.onboarding.webapi.dao.IALEServiceDao;
import com.onboarding.webapi.entity.ALEDTO;
import com.onboarding.webapi.response.vo.ALEVO;
import com.onboarding.webapi.util.CommonUtil;
@Repository
public class ALEServiceDaoImpl implements IALEServiceDao{
	private final Logger logger = Logger.getLogger(ALEServiceDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	private CommonUtil commonUtil;
	
	@Override
	public int processAddAleData(ALEBean aleBean) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEServiceDaoImpl : processAddAleData : Method to processAddAleData");
		}

		int result = 0;
		List<ALEVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ALEDTO aleDTO = new ALEDTO();

		try {
			
			aleDTO.setAleName(aleBean.getAleName());
			aleDTO.setAleFein(aleBean.getAleFein());
			aleDTO.setAleAddress1(aleBean.getAleAddress1());
			aleDTO.setAleAddress2(aleBean.getAleAddress2());
			aleDTO.setAleCity(aleBean.getAleCity());
			aleDTO.setAleProvince(aleBean.getAleProvince());
			aleDTO.setAleState(aleBean.getAleState());
			aleDTO.setAleZip(aleBean.getAleZip());
			aleDTO.setAleCountry(aleBean.getAleCountry());
			aleDTO.setAleContactFirstName(aleBean.getAleContactFirstName());
			aleDTO.setAleContactLastName(aleBean.getAleContactLastName());
			aleDTO.setAleContactContactNumber(aleBean.getAleContactContactNumber());
			aleDTO.setActive(aleBean.isActive());
			aleDTO.setDeleted(false);			
			aleDTO.setCreatedBy("UserName");
			aleDTO.setCreatedDate(commonUtil.convertStringToDate());
			aleDTO.setModifiedBy("UserName");
			aleDTO.setModifiedDate(commonUtil.convertStringToDate());
			
			session.save(aleDTO);
			tx.commit();

			// listVo = processLoadAllControlGroupData();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processAddAleData : " + e.getMessage());
			tx.rollback();
			
			logger.debug(" Setting the AleID to MAX+1  :: ");
			Transaction tx1 = session.getTransaction();
			String sqlQry = "ALTER TABLE tbl_data_ale AUTO_INCREMENT = 1";
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
					"END :: ALEServiceDaoImpl : processAddAleData : Method to processAddAleData");
		}

		return result;
	}
	
	@Override
	public int processUpdateAleData(ALEBean aleBean) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEServiceDaoImpl : processUpdateAleData : Method to processUpdateAleData");
		}
		int result = 0;
		List<ALEVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			String tranUpdQry = "UPDATE ALEDTO A SET A.aleAddress1=:aleAddress1, "
					+ " A.aleAddress2 = :aleAddress2, "
					+ " A.aleCity = :aleCity, "
					+ " A.aleProvince = :aleProvince, "
					+ " A.aleState = :aleState, "
					+ " A.aleZip = :aleZip, " 
					+ " A.aleCountry = :aleCountry, " 
					+ " A.aleContactFirstName = :aleContactFirstName, " 
					+ " A.aleContactLastName = :aleContactLastName, " 
					+ " A.aleContactContactNumber = :aleContactContactNumber " 
					+ " WHERE A.aleId = :aleId AND A.aleName=:aleName AND A.aleFein=:aleFein";
			Query transUpdQry = session.createQuery(tranUpdQry);
			
			transUpdQry.setParameter("aleAddress1", aleBean.getAleAddress1());
			transUpdQry.setParameter("aleAddress2", aleBean.getAleAddress2());
			transUpdQry.setParameter("aleCity", aleBean.getAleCity());
			transUpdQry.setParameter("aleProvince", aleBean.getAleProvince());
			transUpdQry.setParameter("aleState", aleBean.getAleState());
			transUpdQry.setParameter("aleZip", aleBean.getAleZip());
			transUpdQry.setParameter("aleCountry", aleBean.getAleCountry());
			transUpdQry.setParameter("aleContactFirstName", aleBean.getAleContactFirstName());
			transUpdQry.setParameter("aleContactLastName", aleBean.getAleContactLastName());
			transUpdQry.setParameter("aleContactContactNumber", aleBean.getAleContactContactNumber());
			transUpdQry.setParameter("aleId", Integer.parseInt(aleBean.getAleId()));
			transUpdQry.setParameter("aleName", aleBean.getAleName());
			transUpdQry.setParameter("aleFein", aleBean.getAleFein());
			transUpdQry.executeUpdate();
			tx.commit();

			// listVo = processLoadAllControlGroupData();

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
	public int processDeleteAleData(String aleId, String aleName,String aleFein)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"START :: ALEServiceDaoImpl : processDeleteAleData : Method to processDeleteAleData");
		}

		int result = 0;
		List<ALEVO> listVo = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			String tranUpdQry = "UPDATE ALEDTO A SET  A.deleted = :isDeleted "
					+ " WHERE A.aleId = :aleId AND A.aleName=:aleName AND A.aleFein=:aleFein";
			Query transUpdQry = session.createQuery(tranUpdQry);
			transUpdQry.setParameter("isDeleted", true);
			transUpdQry.setParameter("aleId", Integer.parseInt(aleId));
			transUpdQry.setParameter("aleName", aleName);
			transUpdQry.setParameter("aleFein", aleFein);
			transUpdQry.executeUpdate();
			tx.commit();
			

			// listVo = processLoadAllControlGroupData();

			result = 1;
		} catch (Exception e) {
			logger.error("Error while fetching data processDeleteAleData : " + e.getMessage());
			tx.rollback();
			result = 0;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(
					"END :: ALEServiceDaoImpl : processDeleteAleData : Method to processDeleteAleData");
		}

		System.out.println("result : " + result);
		return result;
	}
	
	
	public List<ALEVO> processLoadAllAleData() throws Exception {

		ALEVO aleVO = null;
		List<ALEVO> listVo = new ArrayList<>();
		
		String sqlQry = "SELECT ale_id,ale_name,ale_fein,ale_address1,ale_address2,ale_city,ale_province,ale_state,"
+ "ale_zip,ale_country,ale_contact_first_name,ale_contact_last_name,ale_contact_contact_number,"
+ "is_active,is_deleted,created_by,created_date,modified_by,modified_date" 
+ " FROM tbl_data_ale ";

		Session sqlSession = sessionFactory.openSession();
		Query query = sqlSession.createSQLQuery(sqlQry);

		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				aleVO = new ALEVO();
				if (null != column[0]) {
					aleVO.setAleId((column[0].toString()));
				}
				if (null != column[1]) {
					aleVO.setAleName((column[1].toString()));
				}
				if (null != column[2]) {
					aleVO.setAleFein((column[2].toString()));
				}
				if (null != column[3]) {
					aleVO.setAleAddress1((column[3].toString()));
				}
				if (null != column[4]) {
					aleVO.setAleAddress2((column[4].toString()));
				}
				if (null != column[5]) {
					aleVO.setAleCity((column[5].toString()));
				}
				if (null != column[6]) {
					aleVO.setAleProvince((column[6].toString()));
				}
				if (null != column[7]) {
					aleVO.setAleState((column[7].toString()));
				}
				if (null != column[8]) {
					aleVO.setAleZip((column[8].toString()));
				}
				if (null != column[9]) {
					aleVO.setAleCountry((column[9].toString()));
				}
				if (null != column[10]) {
					aleVO.setAleContactFirstName((column[10].toString()));
				}
				if (null != column[11]) {
					aleVO.setAleContactLastName((column[11].toString()));
				}
				if (null != column[12]) {
					aleVO.setAleContactContactNumber((column[12].toString()));
				}
				if (null != column[13]) {
					aleVO.setActive((column[13].toString()));
				}
				if (null != column[14]) {
					aleVO.setDeleted((column[14].toString()));
				}
				if (null != column[15]) {
					aleVO.setCreatedBy((column[15].toString()));
				}
				if (null != column[16]) {
					aleVO.setCreatedDate((column[16].toString()));
				}
				if (null != column[17]) {
					aleVO.setModifiedBy((column[17].toString()));
				}
				if (null != column[18]) {
					aleVO.setModifiedDate((column[18].toString()));
				}
				
				listVo.add(aleVO);
			}
		} else {
			listVo = null;
		}

		return listVo;
	}

	public ALEVO processLoadAleByUniqueKeys(String aleId, String aleName, String aleFein) throws Exception {

		ALEVO aleVO = null;
		List<ALEVO> listVo = new ArrayList<ALEVO>();

		Session sqlSession = sessionFactory.openSession();
		
		String sqlQry = "SELECT ale_id,ale_name,ale_fein,ale_address1,ale_address2,ale_city,ale_province,ale_state,"
+ "ale_zip,ale_country,ale_contact_first_name,ale_contact_last_name,ale_contact_contact_number,"
+ "is_active,is_deleted,created_by,created_date,modified_by,modified_date" 
+ " FROM tbl_data_ale WHERE "
+ "ale_id = ? AND ale_name = ? AND ale_fein = ?";
		Query query = sqlSession.createSQLQuery(sqlQry);
		query.setParameter(0, Integer.parseInt(aleId));
		query.setParameter(1, aleName);
		query.setParameter(2, aleFein);
		
		List<?> list = query.list();

		if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object column[] = (Object[]) iterator.next();
				aleVO = new ALEVO();
				if (null != column[0]) {
					aleVO.setAleId((column[0].toString()));
				}
				if (null != column[1]) {
					aleVO.setAleName((column[1].toString()));
				}
				if (null != column[2]) {
					aleVO.setAleFein((column[2].toString()));
				}
				if (null != column[3]) {
					aleVO.setAleAddress1((column[3].toString()));
				}
				if (null != column[4]) {
					aleVO.setAleAddress2((column[4].toString()));
				}
				if (null != column[5]) {
					aleVO.setAleCity((column[5].toString()));
				}
				if (null != column[6]) {
					aleVO.setAleProvince((column[6].toString()));
				}
				if (null != column[7]) {
					aleVO.setAleState((column[7].toString()));
				}
				if (null != column[8]) {
					aleVO.setAleZip((column[8].toString()));
				}
				if (null != column[9]) {
					aleVO.setAleCountry((column[9].toString()));
				}
				if (null != column[10]) {
					aleVO.setAleContactFirstName((column[10].toString()));
				}
				if (null != column[11]) {
					aleVO.setAleContactLastName((column[11].toString()));
				}
				if (null != column[12]) {
					aleVO.setAleContactContactNumber((column[12].toString()));
				}
				if (null != column[13]) {
					aleVO.setActive((column[13].toString()));
				}
				if (null != column[14]) {
					aleVO.setDeleted((column[14].toString()));
				}
				if (null != column[15]) {
					aleVO.setCreatedBy((column[15].toString()));
				}
				if (null != column[16]) {
					aleVO.setCreatedDate((column[16].toString()));
				}
				if (null != column[17]) {
					aleVO.setModifiedBy((column[17].toString()));
				}
				if (null != column[18]) {
					aleVO.setModifiedDate((column[18].toString()));
				}
				break;
		   }
		}

		return aleVO;
	}
	
		public List<ALEVO> processLoadAllControlGroupData() throws Exception {

			ALEVO aleVO = null;
			List<ALEVO> listVo = new ArrayList<>();
			
			String sqlQry = "SELECT ale_id,ale_name,ale_fein,ale_address1,ale_address2,ale_city,ale_province,ale_state,"
	+ "ale_zip,ale_country,ale_contact_first_name,ale_contact_last_name,ale_contact_contact_number,"
	+ "is_active,is_deleted,created_by,created_date,modified_by,modified_date" 
	+ " FROM tbl_data_ale ";

			Session sqlSession = sessionFactory.openSession();
			Query query = sqlSession.createSQLQuery(sqlQry);

			List<?> list = query.list();

			if (list != null && list.size() > 0) {
				Iterator<?> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object column[] = (Object[]) iterator.next();
					aleVO = new ALEVO();
					if (null != column[0]) {
						aleVO.setAleId((column[0].toString()));
					}
					if (null != column[1]) {
						aleVO.setAleName((column[1].toString()));
					}
					if (null != column[2]) {
						aleVO.setAleFein((column[2].toString()));
					}
					if (null != column[3]) {
						aleVO.setAleAddress1((column[3].toString()));
					}
					if (null != column[4]) {
						aleVO.setAleAddress2((column[4].toString()));
					}
					if (null != column[5]) {
						aleVO.setAleCity((column[5].toString()));
					}
					if (null != column[6]) {
						aleVO.setAleProvince((column[6].toString()));
					}
					if (null != column[7]) {
						aleVO.setAleState((column[7].toString()));
					}
					if (null != column[8]) {
						aleVO.setAleZip((column[8].toString()));
					}
					if (null != column[9]) {
						aleVO.setAleCountry((column[9].toString()));
					}
					if (null != column[10]) {
						aleVO.setAleContactFirstName((column[10].toString()));
					}
					if (null != column[11]) {
						aleVO.setAleContactLastName((column[11].toString()));
					}
					if (null != column[12]) {
						aleVO.setAleContactContactNumber((column[12].toString()));
					}
					if (null != column[13]) {
						aleVO.setActive((column[13].toString()));
					}
					if (null != column[14]) {
						aleVO.setDeleted((column[14].toString()));
					}
					if (null != column[15]) {
						aleVO.setCreatedBy((column[15].toString()));
					}
					if (null != column[16]) {
						aleVO.setCreatedDate((column[16].toString()));
					}
					if (null != column[17]) {
						aleVO.setModifiedBy((column[17].toString()));
					}
					if (null != column[18]) {
						aleVO.setModifiedDate((column[18].toString()));
					}
					
					listVo.add(aleVO);
				}
			} else {
				listVo = null;
			}

			return listVo;
		}
}
