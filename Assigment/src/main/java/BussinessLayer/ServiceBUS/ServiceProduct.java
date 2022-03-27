package BussinessLayer.ServiceBUS;

import java.util.List;

import BussinessLayer.IServiceBUS.IServiceProduct;
import BussinessLayer.entities.Product;

public class ServiceProduct implements IServiceProduct{
	DataAccessLayer.ServiceProduct sp;
    public ServiceProduct() {
    sp=new DataAccessLayer.ServiceProduct();
    }
	@Override
	public Product add(Product entity) throws Exception {
		return sp.add(entity);
	}

	@Override
	public Product remove(Product entity) throws Exception {
		return sp.remove(entity);
	}

	@Override
	public Product update(Product entity) throws Exception {
		return sp.update(entity);
	}

	@Override
	public List<Product> selectAll() throws Exception {
		return sp.selectAll();
	}

	@Override
	public Product selectByID(Product entity) throws Exception {
		return sp.selectByID(entity);
	}

}
