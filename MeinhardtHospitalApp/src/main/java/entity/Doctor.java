package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "phoneNum")
	private String phoneNum;

	@Override
	public String toString() {
		return "Doctor data read ➡ [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phoneNum=" + phoneNum + "]";
	}

	public Doctor() {
	}

	public Doctor(int id, String name, String email, String address, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}