package BussinessLayer.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String khachhangid;

	private String diachi;

	private String email;

	private Boolean gioitinh;

	private String hoten;

	@Temporal(TemporalType.DATE)
	private Date ngaytao;

	private String password;

	private String sdt;

	private Integer trangthai;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="customer")
	private List<Bill> bills;

	//bi-directional many-to-one association to ChangedPassword
	@OneToMany(mappedBy="customer")
	private List<ChangedPassword> changedPasswords;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="nhanvienid")
	private Staff staff;

	public Customer() {
	}

	public String getKhachhangid() {
		return this.khachhangid;
	}

	public void setKhachhangid(String khachhangid) {
		this.khachhangid = khachhangid;
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

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setCustomer(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setCustomer(null);

		return bill;
	}

	public List<ChangedPassword> getChangedPasswords() {
		return this.changedPasswords;
	}

	public void setChangedPasswords(List<ChangedPassword> changedPasswords) {
		this.changedPasswords = changedPasswords;
	}

	public ChangedPassword addChangedPassword(ChangedPassword changedPassword) {
		getChangedPasswords().add(changedPassword);
		changedPassword.setCustomer(this);

		return changedPassword;
	}

	public ChangedPassword removeChangedPassword(ChangedPassword changedPassword) {
		getChangedPasswords().remove(changedPassword);
		changedPassword.setCustomer(null);

		return changedPassword;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}