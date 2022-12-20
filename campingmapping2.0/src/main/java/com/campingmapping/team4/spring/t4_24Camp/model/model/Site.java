package T4_24.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class Site {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "siteID")
	private Integer siteID;
	
	@Column(name = "siteName")
	private String siteName;
	
	@Column(name = "sitePictures")
	private Blob sitePictures;
	
	@Column(name = "totalSites")
	private Integer totalSites;
	
	@Column(name = "siteMoney")
	private Integer siteMoney;
	
	@ManyToOne
	@JoinColumn(name = "fk_campID")
	private Camp camp;
	
	
	public Site() {
	}

	
	public Integer getSiteID() {
		return siteID;
	}

	public void setSiteID(Integer siteID) {
		this.siteID = siteID;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Blob getSitePictures() {
		return sitePictures;
	}

	public void setSitePictures(Blob sitePictures) {
		this.sitePictures = sitePictures;
	}

	public Integer getTotalSites() {
		return totalSites;
	}

	public void setTotalSites(Integer totalSites) {
		this.totalSites = totalSites;
	}

	public Integer getSiteMoney() {
		return siteMoney;
	}

	public void setSiteMoney(Integer siteMoney) {
		this.siteMoney = siteMoney;
	}

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Site [siteID=");
		builder.append(siteID);
		builder.append(", siteName=");
		builder.append(siteName);
		builder.append(", sitePictures=");
		builder.append(sitePictures);
		builder.append(", totalSites=");
		builder.append(totalSites);
		builder.append(", siteMoney=");
		builder.append(siteMoney);
		builder.append(", fk_camp=");
		builder.append(camp.getCampID());
		builder.append("]");
		return builder.toString();
	}


}
