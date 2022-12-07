package MidtermProject01;


public class highwayShoulderTable {

	private String route;//路線
	private String segment;//路段
	private String mileage;//里程數
	private String timePeriod;//時段
	private String shoulderSpeedLimit;//路肩速限
	private String shoulderType;//路肩類型
	
	public highwayShoulderTable() {
		
	}
	
	public highwayShoulderTable(String route, String segment, String mileage, String timePeriod,
			String shoulderSpeedLimit, String shoulderType) {
		super();
		this.route = route;
		this.segment = segment;
		this.mileage = mileage;
		this.timePeriod = timePeriod;
		this.shoulderSpeedLimit = shoulderSpeedLimit;
		this.shoulderType = shoulderType;
	}
	public String getRoute() {
		return route;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("highwayShoulderTable [route=");
		builder.append(route);
		builder.append(", segment=");
		builder.append(segment);
		builder.append(", mileage=");
		builder.append(mileage);
		builder.append(", timePeriod=");
		builder.append(timePeriod);
		builder.append(", shoulderSpeedLimit=");
		builder.append(shoulderSpeedLimit);
		builder.append(", shoulderType=");
		builder.append(shoulderType);
		builder.append("]");
		return builder.toString();
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	public String getShoulderSpeedLimit() {
		return shoulderSpeedLimit;
	}
	public void setShoulderSpeedLimit(String shoulderSpeedLimit) {
		this.shoulderSpeedLimit = shoulderSpeedLimit;
	}
	public String getShoulderType() {
		return shoulderType;
	}
	public void setShoulderType(String shoulderType) {
		this.shoulderType = shoulderType;
	}
	
}

