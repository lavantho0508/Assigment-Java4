package BussinessLayer.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the changed_passwords database table.
 * 
 */
@Entity
@Table(name="changed_passwords")
@NamedQuery(name="ChangedPassword.findAll", query="SELECT c FROM ChangedPassword c")
public class ChangedPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date ngaydoi;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="khachhangid")
	private Customer customer;

	public ChangedPassword() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getNgaydoi() {
		return this.ngaydoi;
	}

	public void setNgaydoi(Date ngaydoi) {
		this.ngaydoi = ngaydoi;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}