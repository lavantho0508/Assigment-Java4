package BussinessLayer.IServiceBUS;

import java.util.HashMap;
import java.util.List;

import BussinessLayer.entities.Admin;

public interface IServiceAdmin {
public Admin add(Admin entity) throws Exception;
public Admin remove(Admin entity)throws Exception;
public Admin update(Admin entity)throws Exception;
public List<Admin>selectAll()throws Exception;
public HashMap<String, String>checkError(String username,String passwd) throws Exception;
public Admin findByID(String id);
}
