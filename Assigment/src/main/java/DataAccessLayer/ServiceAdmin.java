package DataAccessLayer;

import java.util.HashMap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import BussinessLayer.IServiceBUS.IServiceAdmin;
import BussinessLayer.Utils.JpaUtil;
import BussinessLayer.entities.Admin;

public class ServiceAdmin implements IServiceAdmin{
	EntityManager em;
public ServiceAdmin() {
	em=JpaUtil.createEntityManager();
}
	@Override
	public Admin add(Admin entity) throws Exception{
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
	public Admin remove(Admin entity) throws Exception{
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
	public Admin update(Admin entity) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(null);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Admin> selectAll() throws Exception{
		String query="SELECT a FROM Admin a";
		TypedQuery<Admin> list=em.createQuery(query,Admin.class);
		List<Admin>rs=list.getResultList();
		return rs;
	}
	@Override
	public HashMap<String, String> checkError(String username,String passwd) throws Exception {
		HashMap<String, String>flagError=new HashMap<String, String>();
		if(username.isBlank()) {
			flagError.put("username_null", "Tài khoản không được để trống");
		}
		if(username.length()<5) {
			flagError.put("username_length", "Tài khoảng phải lớn hơn 6 ký tự");
		}
		if(!username.matches("^[a-zA-Z0-9]+$")) {
			flagError.put("username_invalid", "Tài khoản  không hợp lệ");
		}
		if(findByID(username)==null) {
			flagError.put("username_exist", "Tài khoản  không tồn tại");
		}
		return flagError;
		
	}
	@Override
	public Admin findByID(String id) {
	Admin ad=em.find(Admin.class, id);
	return ad;
	}

}
