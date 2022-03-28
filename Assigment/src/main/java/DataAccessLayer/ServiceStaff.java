package DataAccessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceStaff;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.Staff;

public class ServiceStaff implements IServiceStaff{
EntityManager em;
public ServiceStaff() {
	em=JpaUtil.createEntityManager();

}
	@Override
	public Staff add(Staff entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.flush();
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Staff remove(Staff entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Staff update(Staff entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Staff> selectAll() {
		String query="SELECT s FROM Staff s";
		TypedQuery<Staff> list=em.createQuery(query,Staff.class);
		return list.getResultList();
	}

	@Override
	public Staff selectByID(Staff entity) {		
		Staff s=em.find(Staff.class, entity.getNhanvienid());
		return s;
	}

}
