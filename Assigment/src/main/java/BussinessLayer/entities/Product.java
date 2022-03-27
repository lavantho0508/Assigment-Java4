package BussinessLayer.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String sanphamid;

	private Long soluong;

	private String tenloaihang;

	private Integer trangthai;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="nhanvienid")
	private Staff staff;

	//bi-directional many-to-one association to ProductsDetail
	@OneToMany(mappedBy="product")
	private List<ProductsDetail> productsDetails;

	public Product() {
	}

	public String getSanphamid() {
		return this.sanphamid;
	}

	public void setSanphamid(String sanphamid) {
		this.sanphamid = sanphamid;
	}

	public Long getSoluong() {
		return this.soluong;
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public String getTenloaihang() {
		return this.tenloaihang;
	}

	public void setTenloaihang(String tenloaihang) {
		this.tenloaihang = tenloaihang;
	}

	public Integer getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(Integer trangthai) {
		this.trangthai = trangthai;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<ProductsDetail> getProductsDetails() {
		return this.productsDetails;
	}

	public void setProductsDetails(List<ProductsDetail> productsDetails) {
		this.productsDetails = productsDetails;
	}

	public ProductsDetail addProductsDetail(ProductsDetail productsDetail) {
		getProductsDetails().add(productsDetail);
		productsDetail.setProduct(this);

		return productsDetail;
	}

	public ProductsDetail removeProductsDetail(ProductsDetail productsDetail) {
		getProductsDetails().remove(productsDetail);
		productsDetail.setProduct(null);

		return productsDetail;
	}

}