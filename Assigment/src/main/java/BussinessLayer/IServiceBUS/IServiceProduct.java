package BussinessLayer.IServiceBUS;

import java.util.List;


import BussinessLayer.entities.Product;

public interface IServiceProduct {
	public Product add(Product  entity)throws Exception;
	public Product  remove(Product  entity)throws Exception;
	public Product  update(Product entity)throws Exception;
	public List<Product>selectAll()throws Exception;
	public Product selectByID(Product  entity)throws Exception;
}
