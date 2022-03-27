package BussinessLayer.ServiceBUS;

import java.util.List;

import BussinessLayer.IServiceBUS.IServiceProductDetail;
import BussinessLayer.entities.ProductsDetail;

public class ServiceProductDetail implements IServiceProductDetail{
	DataAccessLayer.ServiceProductDetail spd;
public ServiceProductDetail() {
spd=new DataAccessLayer.ServiceProductDetail();
}
	@Override
	public ProductsDetail add(ProductsDetail entity) throws Exception {
		return spd.add(entity);
	}

	@Override
	public ProductsDetail remove(ProductsDetail entity) throws Exception {
		return spd.remove(entity);
	}

	@Override
	public ProductsDetail update(ProductsDetail entity) throws Exception {
		return spd.update(entity);
	}

	@Override
	public List<ProductsDetail> selectAll() throws Exception {
		return spd.selectAll();
	}

	@Override
	public ProductsDetail selectByID(ProductsDetail entity) throws Exception {
		return spd.selectByID(entity);
	}
	
}
