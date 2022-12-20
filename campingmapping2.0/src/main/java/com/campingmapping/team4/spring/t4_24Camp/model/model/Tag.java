package T4_24.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tagID")
	private Integer tagID;
	
	@Column(name = "tagName")
	private String tagName;
	
	@ManyToMany(mappedBy = "tags")
	private Set<Camp> camps = new HashSet<>();
	

	public Tag() {
	}


	public Integer getTagID() {
		return tagID;
	}

	public void setTagID(Integer tagID) {
		this.tagID = tagID;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	

	public Set<Camp> getCamps() {
		return camps;
	}

	public void setCamps(Set<Camp> camps) {
		this.camps = camps;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [tagID=");
		builder.append(tagID);
		builder.append(", tagName=");
		builder.append(tagName);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
