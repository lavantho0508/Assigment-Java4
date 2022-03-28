package DataAccessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceProductDetail;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.ProductsDetail;

public class ServiceProductDetail implements IServiceProductDetail{
EntityManager em;
public ServiceProductDetail() {
	em=JpaUtil.createEntityManager();
}
	@Override
	public ProductsDetail add(ProductsDetail entity) {
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
	public ProductsDetail remove(ProductsDetail entity) {
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
	public ProductsDetail update(ProductsDetail entity) {
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
	public List<ProductsDetail> selectAll() {
		String query="SELECT p FROM ProductDetail p";
		TypedQuery<ProductsDetail>list=em.createQuery(query,ProductsDetail.class);
		List<ProductsDetail>rs=list.getResultList();
		return rs;
	}

	@Override
	public ProductsDetail selectByID(ProductsDetail entity) {
		ProductsDetail p=em.find(ProductsDetail.class, entity.getCtspid());
		return p;
	}

}
