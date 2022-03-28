package BussinessLayer.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the staffs database table.
 * 
 */
@Entity
@Table(name="staffs")
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nhanvienid;

	private String diachi;

	private String email;

	private Boolean gioitinh;

	private String hoten;

	@Temporal(TemporalType.DATE)
	private Date namsinh;

	@Temporal(TemporalType.DATE)
	private Date ngaytao;

	private String password;

	private String sdt;

	private Integer trangthai;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="staff")
	private List<Product> products;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="adminid")
	private Admin admin;

	public Staff() {
	}

	public String getNhanvienid() {
		return this.nhanvienid;
	}

	public void setNhanvienid(String nhanvienid) {
		this.nhanvienid = nhanvienid;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getHoten() {
		return this.hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Date getNamsinh() {
		return this.namsinh;
	}

	public void setNamsinh(Date namsinh) {
		this.namsinh = namsinh;
	}

	public Date getNgaytao() {
		return this.ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Integer getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(Integer trangthai) {
		this.trangthai = trangthai;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setStaff(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setStaff(null);

		return product;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}