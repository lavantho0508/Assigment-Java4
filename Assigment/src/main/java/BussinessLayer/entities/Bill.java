package BussinessLayer.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bills database table.
 * 
 */
@Entity
@Table(name="bills")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private float dongia;

	private Long soluong;

	private Integer trangthai;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="khachhangid")
	private Customer customer;

	//bi-directional many-to-one association to ProductsDetail
	@ManyToOne
	@JoinColumn(name="ctspid")
	private ProductsDetail productsDetail;

	public Bill() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getDongia() {
		return this.dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public Long getSoluong() {
		return this.soluong;
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public Integer getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(Integer trangthai) {
		this.trangthai = trangthai;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ProductsDetail getProductsDetail() {
		return this.productsDetail;
	}

	public void setProductsDetail(ProductsDetail productsDetail) {
		this.productsDetail = productsDetail;
	}

}