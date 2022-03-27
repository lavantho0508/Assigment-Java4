package DataAccessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceProduct;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.Product;

public class ServiceProduct implements IServiceProduct{
EntityManager em;
public ServiceProduct() {	

	em=JpaUtil.createEntityManager();
}
	@Override
	public Product add(Product entity) {
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
	public Product remove(Product entity) {
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
	public Product update(Product entity) {
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
	public List<Product> selectAll() {
		String query="SELECT p FROM Product p";
		TypedQuery<Product> list=em.createQuery(query,Product.class);
		List<Product>rs=list.getResultList();
		return rs;
	}

	@Override
	public Product selectByID(Product entity) {
		Product p=em.find(Product.class, entity.getSanphamid());
		return p;
	}

}
