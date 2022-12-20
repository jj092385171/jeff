package tw.hibernatedemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class MyGroup {
	
	@Id //刪除群組就刪除朋友 (對面沒寫所以不會)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "groups_id")
	private Integer Id;
	
	@Column(name = "groupName")
	private String groupName;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//連中介表格
	@JoinTable(name = "friend_group",
	joinColumns = {@JoinColumn(name = "fk_group_id",referencedColumnName = "groups_id")},
	inverseJoinColumns = {@JoinColumn(name = "fk_friend_id",referencedColumnName = "friends_id")}) 
	private Set<Friend> friends = new HashSet<Friend>();
	
	
	
	public MyGroup() {
	}



	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}



	public String getGroupName() {
		return groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	public Set<Friend> getFriends() {
		return friends;
	}



	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}
	
}
