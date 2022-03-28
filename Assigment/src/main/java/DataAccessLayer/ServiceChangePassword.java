package DataAccessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceChangePassword;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.ChangedPassword;

public class ServiceChangePassword implements IServiceChangePassword{
	EntityManager em;
public ServiceChangePassword() {
em=JpaUtil.createEntityManager();
}
	@Override
	public ChangedPassword add(ChangedPassword entity) {
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
	public ChangedPassword remove(ChangedPassword entity) {
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
	public ChangedPassword update(ChangedPassword entity) {
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
	public List<ChangedPassword> selectAll() {
		String query="SELECT c FROm ChangePassword c";
		TypedQuery<ChangedPassword> list=em.createQuery(query, ChangedPassword.class);
		List<ChangedPassword>rs=list.getResultList();
		return rs;
	}

	@Override
	public ChangedPassword selectByID(ChangedPassword entity) {
		ChangedPassword p=em.find(ChangedPassword.class, entity.getId());
		return p;
		
	}

}
