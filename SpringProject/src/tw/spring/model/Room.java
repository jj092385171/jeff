package tw.spring.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room {
	
	private int id;
	private String name;
	private String size;
	private SimpleDateFormat date;
	
	public Room() {
	}

	public Room(int id, String name, String size) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(Date date) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		this.date = sdFormat;
	}
	
}
