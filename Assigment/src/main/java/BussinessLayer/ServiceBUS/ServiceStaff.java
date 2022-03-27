package BussinessLayer.ServiceBUS;

import java.util.List;

import BussinessLayer.IServiceBUS.IServiceStaff;
import BussinessLayer.entities.Staff;

public class ServiceStaff implements IServiceStaff{
DataAccessLayer.ServiceStaff ss;
public ServiceStaff() {
	ss=new DataAccessLayer.ServiceStaff();
}
	@Override
	public Staff add(Staff entity) throws Exception {
		return ss.add(entity);
	}

	@Override
	public Staff remove(Staff entity) throws Exception {
		return ss.remove(entity);
	}

	@Override
	public Staff update(Staff entity) throws Exception {
		return ss.update(entity);
	}

	@Override
	public List<Staff> selectAll() throws Exception {
		return ss.selectAll();
	}

	@Override
	public Staff selectByID(Staff entity) throws Exception {
		return ss.selectByID(entity);
	}

}
