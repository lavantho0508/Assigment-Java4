package BussinessLayer.IServiceBUS;

import java.util.List;


import BussinessLayer.entities.Customer;

public interface IServiceCustomer {
	public Customer add(Customer  entity)throws Exception;
	public Customer  remove(Customer  entity)throws Exception;
	public Customer  update(Customer entity)throws Exception;
	public List<Customer>selectAll()throws Exception;
	public Customer selectByID(Customer  entity)throws Exception;
}
