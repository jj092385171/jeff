package T4_01.beans;
//權限
public class Limits {
	// UID
	private int UID;
	// 帳號
	private String account;
	// 一般
	private String nomore;
	// 買家
	private String buy;
	// 賣家
	private String sell;
	// 發文
	private String publisher;
	// 留言
	private String message;
	// 雇主
	private String enterprise;
	// 應徵者
	private String applier;
	// 揪團主
	private String mainhoster;
	// 參加者
	private String attender;
	// 營主
	private String campingowner;
	// 營地預定
	private String customer;

	public Limits() {
	}

	public Limits(int uID, String account, String nomore, String buy,
			String sell, String publisher, String message, String enterprise,
			String applier, String mainhoster, String attender,
			String campingowner, String customer) {
		super();
		UID = uID;
		this.account = account;
		this.nomore = nomore;
		this.buy = buy;
		this.sell = sell;
		this.publisher = publisher;
		this.message = message;
		this.enterprise = enterprise;
		this.applier = applier;
		this.mainhoster = mainhoster;
		this.attender = attender;
		this.campingowner = campingowner;
		this.customer = customer;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNomore() {
		return nomore;
	}

	public void setNomore(String nomore) {
		this.nomore = nomore;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getApplier() {
		return applier;
	}

	public void setApplier(String applier) {
		this.applier = applier;
	}

	public String getMainhoster() {
		return mainhoster;
	}

	public void setMainhoster(String mainhoster) {
		this.mainhoster = mainhoster;
	}

	public String getAttender() {
		return attender;
	}

	public void setAttender(String attender) {
		this.attender = attender;
	}

	public String getCampingowner() {
		return campingowner;
	}

	public void setCampingowner(String campingowner) {
		this.campingowner = campingowner;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return String.format(
				"limits [UID=%s, account=%s, nomore=%s, buy=%s, sell=%s, publisher=%s, message=%s, enterprise=%s, applier=%s, mainhoster=%s, attender=%s, campingowner=%s, customer=%s]",
				UID, account, nomore, buy, sell, publisher, message, enterprise,
				applier, mainhoster, attender, campingowner, customer);
	}

}
