package tw.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name = "bird")
@Component
public class Bird {
	
	@Id @Column(name = "BID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "BNAME")
	private String bname;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "SIZE")
	private String size;
	
	@Column(name = "AGE")
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getColor() {
		return color;
	}

	public void setColoe(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Bird() {
	}

	public Bird(String bname, String color, String size, int age) {
		super();
		this.bname = bname;
		this.color = color;
		this.size = size;
		this.age = age;
	}

	public Bird(int id, String bname, String color, String size, int age) {
		super();
		this.id = id;
		this.bname = bname;
		this.color = color;
		this.size = size;
		this.age = age;
	}
	
}
