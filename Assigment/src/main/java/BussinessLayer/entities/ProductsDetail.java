package BussinessLayer.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products_detail database table.
 * 
 */
@Entity
@Table(name="products_detail")
@NamedQuery(name="ProductsDetail.findAll", query="SELECT p FROM ProductsDetail p")
public class ProductsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ctspid;

	private float dongia;

	@Temporal(TemporalType.DATE)
	private Date ngaytao;

	private Long soluong;

	private String tensp;

	private String thongtinsp;

	private Integer tragthai;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="productsDetail")
	private List<Bill> bills;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="sanphamid")
	private Product product;

	public ProductsDetail() {
	}

	public String getCtspid() {
		return this.ctspid;
	}

	public void setCtspid(String ctspid) {
		this.ctspid = ctspid;
	}

	public float getDongia() {
		return this.dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public Date getNgaytao() {
		return this.ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public Long getSoluong() {
		return this.soluong;
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public String getTensp() {
		return this.tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getThongtinsp() {
		return this.thongtinsp;
	}

	public void setThongtinsp(String thongtinsp) {
		this.thongtinsp = thongtinsp;
	}

	public Integer getTragthai() {
		return this.tragthai;
	}

	public void setTragthai(Integer tragthai) {
		this.tragthai = tragthai;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setProductsDetail(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setProductsDetail(null);

		return bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}