package BussinessLayer.IServiceBUS;

import java.util.List;
import BussinessLayer.entities.ProductsDetail;

public interface IServiceProductDetail {
	public ProductsDetail add(ProductsDetail  entity)throws Exception;
	public ProductsDetail  remove(ProductsDetail  entity)throws Exception;
	public ProductsDetail  update(ProductsDetail entity)throws Exception;
	public List<ProductsDetail>selectAll()throws Exception;
	public ProductsDetail selectByID(ProductsDetail  entity)throws Exception;
}
