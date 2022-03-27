package BussinessLayer.ServiceBUS;

import java.util.List;

import BussinessLayer.IServiceBUS.IServiceChangePassword;
import BussinessLayer.entities.ChangedPassword;

public class ServiceChangePassword implements IServiceChangePassword{
	DataAccessLayer.ServiceChangePassword scp;
	public ServiceChangePassword() {
	scp=new DataAccessLayer.ServiceChangePassword();
	}
	@Override
	public ChangedPassword add(ChangedPassword entity) throws Exception {
		return scp.add(entity);
	}
	@Override
	public ChangedPassword remove(ChangedPassword entity) throws Exception {
		return scp.remove(entity);
	}
	@Override
	public ChangedPassword update(ChangedPassword entity) throws Exception {
		return scp.update(entity);
	}
	@Override
	public List<ChangedPassword> selectAll() throws Exception {
		return scp.selectAll();
	}
	@Override
	public ChangedPassword selectByID(ChangedPassword entity) throws Exception {
		return scp.selectByID(entity);
	}

}
