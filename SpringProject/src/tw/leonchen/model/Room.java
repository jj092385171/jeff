package tw.leonchen.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room {
	private int id;
	private String name;
	private String size;
	private Date date;

	public Room() {
	}

	public Room(int id, String name, String size) {
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

	public Date getDate() {
		return date;
	}
	public String getSimpDateFormat() {
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
