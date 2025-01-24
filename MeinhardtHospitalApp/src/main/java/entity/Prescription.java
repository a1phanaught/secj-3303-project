package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "prescription")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "dosage")
	private int dosage;

	@Column(name = "registerDate")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registerDate;

	@Column(name = "expiryDate")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;

	@Column(name = "quantity")
	private int quantity;

	@Override
	public String toString() {
		return "Prescription data read ➡ [id=" + id + ", name=" + name + ", dosage=" + dosage + ", registerDate="
				+ registerDate + ", expiryDate=" + expiryDate + ", quantity=" + quantity + "]";
	}

	public Prescription() {
	}

	public Prescription(int id, String name, int dosage, LocalDate registerDate, LocalDate expiryDate, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.dosage = dosage;
		this.registerDate = registerDate;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
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

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}