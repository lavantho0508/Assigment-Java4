package DataAccessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceBill;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.Bill;

public class ServiceBill implements IServiceBill{
	EntityManager em;
public ServiceBill() {
	em=JpaUtil.createEntityManager();
}
	@Override
	public Bill add(Bill entity) {
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
	public Bill remove(Bill entity) {
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
	public Bill update(Bill entity) {
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
	public List<Bill> selectAll() {
	String query="SELECT b FROM Bill b";
	TypedQuery<Bill> list=em.createQuery(query,Bill.class);
	List<Bill>rs=list.getResultList();
	return rs;
	}

	@Override
	public Bill selectByID(Bill entity) {
		Bill e=em.find(Bill.class, entity.getId());
		return e;
	}

}
