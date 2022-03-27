package BussinessLayer.ServiceBUS;

import java.util.List;

import BussinessLayer.IServiceBUS.IServiceAdmin;
import BussinessLayer.entities.Admin;

public class ServiceAdmin implements IServiceAdmin{
DataAccessLayer.ServiceAdmin admin;
public ServiceAdmin() {
	admin=new DataAccessLayer.ServiceAdmin();
	// TODO Auto-generated constructor stub
}
	@Override
	public Admin add(Admin entity) throws Exception {
		return admin.add(entity);
	}

	@Override
	public Admin remove(Admin entity) throws Exception {
		return admin.remove(entity);
	}

	@Override
	public Admin update(Admin entity) throws Exception {
		return admin.update(entity);
	}

	@Override
	public List<Admin> selectAll() throws Exception {
		return admin.selectAll();
	}

}
