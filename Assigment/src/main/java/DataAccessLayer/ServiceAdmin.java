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
		if(findByID(username)==null) {
			flagError.put("username_exist", "Tài khoản  không tồn tại");
		}
		if(passwd.isBlank()) {
			flagError.put("passwd_null", "Mật khẩu không được để trống");
		}
		if(passwd.length()<5) {
			flagError.put("passwd_length", "mật khẩu phải lớn hơn 6 ký tự");
		}
		if(selectAdmin(username, passwd)==null) {
			flagError.put("account_exist", "Tài khoản hoặc mật khẩu không chính xác");
		}
		
		return flagError;
		
	}
	@Override
	public Admin findByID(String id) {
	Admin ad=em.find(Admin.class, id);
	return ad;
	}
	@Override
	public Admin selectAdmin(String username, String passwd) {
		try {
			String query="SELECT a FROM Admin a WHERE a.adminid=:adminid AND a.password=:password";
			TypedQuery<Admin> list=em.createQuery(query, Admin.class);
		    Admin a=list.setParameter("adminid",username)
		    		.setParameter("password",passwd).getSingleResult();
		    return a;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
