package BussinessLayer.IServiceBUS;

import java.util.List;

import BussinessLayer.entities.Admin;

public interface IServiceAdmin {
public Admin add(Admin entity) throws Exception;
public Admin remove(Admin entity)throws Exception;
public Admin update(Admin entity)throws Exception;
public List<Admin>selectAll()throws Exception;
}
