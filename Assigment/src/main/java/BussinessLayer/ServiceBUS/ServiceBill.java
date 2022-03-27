package BussinessLayer.ServiceBUS;

import java.util.List;

import BussinessLayer.IServiceBUS.IServiceBill;
import BussinessLayer.entities.Bill;

public class ServiceBill implements IServiceBill{
	DataAccessLayer.ServiceBill sb;
     public ServiceBill() {
    	sb=new DataAccessLayer.ServiceBill();
	}
	@Override
	public Bill add(Bill entity) throws Exception {
		return sb.add(entity);
	}

	@Override
	public Bill remove(Bill entity) throws Exception {
		return sb.remove(entity);
	}

	@Override
	public Bill update(Bill entity) throws Exception {
		return sb.update(entity);
	}

	@Override
	public List<Bill> selectAll() throws Exception {
		return sb.selectAll();
	}

	@Override
	public Bill selectByID(Bill entity) throws Exception {
		return sb.selectByID(entity);
	}

}
