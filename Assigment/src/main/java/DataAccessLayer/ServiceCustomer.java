package DataAccessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceCustomer;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.Customer;

public class ServiceCustomer implements IServiceCustomer{
 EntityManager em;
 public ServiceCustomer() {
	em=JpaUtil.createEntityManager();
}
	@Override
	public Customer add(Customer entity) {
	try {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	} catch (Exception e) {
       e.printStackTrace();
       em.getTransaction().rollback();
       throw e;
	} 
	}

	@Override
	public Customer remove(Customer entity) {
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
	public Customer update(Customer entity) {
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
	public List<Customer> selectAll() {
		String query="SELECT c FROM Customer c";
		TypedQuery<Customer> list=em.createQuery(query, Customer.class);
		List<Customer>rs=list.getResultList();
		return rs;
	}

	@Override
	public Customer selectByID(Customer entity) {
		Customer c=em.find(Customer.class, entity.getKhachhangid());
		return c;
	}

}
