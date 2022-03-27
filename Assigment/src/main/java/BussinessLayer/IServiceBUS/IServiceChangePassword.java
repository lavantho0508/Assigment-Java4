package BussinessLayer.IServiceBUS;

import java.util.List;


import BussinessLayer.entities.ChangedPassword;

public interface IServiceChangePassword {
	public ChangedPassword add(ChangedPassword  entity)throws Exception;
	public ChangedPassword  remove(ChangedPassword  entity)throws Exception;
	public ChangedPassword  update(ChangedPassword  entity)throws Exception;
	public List<ChangedPassword >selectAll()throws Exception;
	public ChangedPassword  selectByID(ChangedPassword  entity)throws Exception;
}
