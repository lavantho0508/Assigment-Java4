package BussinessLayer.IServiceBUS;

import java.util.List;


import BussinessLayer.entities.Staff;

public interface IServiceStaff {
	public Staff add(Staff  entity)throws Exception;
	public Staff  remove(Staff  entity)throws Exception;
	public Staff  update(Staff entity)throws Exception;
	public List<Staff>selectAll()throws Exception;
	public Staff selectByID(Staff  entity)throws Exception;
}
