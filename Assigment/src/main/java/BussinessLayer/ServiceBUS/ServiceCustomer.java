package BussinessLayer.ServiceBUS;

import java.util.List;
import BussinessLayer.IServiceBUS.IServiceCustomer;
import BussinessLayer.entities.Customer;

public class ServiceCustomer implements IServiceCustomer{
	DataAccessLayer.ServiceCustomer sc;
public ServiceCustomer() {
	sc=new DataAccessLayer.ServiceCustomer();
}
	@Override
	public Customer add(Customer entity) throws Exception {
		return sc.add(entity);
	}

	@Override
	public Customer remove(Customer entity) throws Exception {
		return sc.remove(entity);
	}

	@Override
	public Customer update(Customer entity) throws Exception {
		return sc.update(entity);
	}

	@Override
	public List<Customer> selectAll() throws Exception {
		return sc.selectAll();
	}

	@Override
	public Customer selectByID(Customer entity) throws Exception {
		return sc.selectByID(entity);
	}

}
