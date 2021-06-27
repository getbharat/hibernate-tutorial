package one.to.one.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Laptop")
public class Laptop {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int laptopId;
	
	@Column(name="name")
	private String laptopName;
	
	@Column(name = "mac_address")
	private String laptopMacAddress;
	
	@OneToOne(mappedBy = "laptop")
	private Student student;

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getLaptopMacAddress() {
		return laptopMacAddress;
	}

	public void setLaptopMacAddress(String laptopMacAddress) {
		this.laptopMacAddress = laptopMacAddress;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getLaptopId() {
		return laptopId;
	}
	

}
