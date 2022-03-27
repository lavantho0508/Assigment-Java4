package BussinessLayer.IServiceBUS;

import java.util.List;


import BussinessLayer.entities.Bill;

public interface IServiceBill {
	public Bill add(Bill entity)throws Exception;
	public Bill remove(Bill entity)throws Exception;
	public Bill update(Bill entity)throws Exception;
	public List<Bill>selectAll()throws Exception;
	public Bill selectByID(Bill entity)throws Exception;
	
}
