public class Event {
	private String EventTitle, DataAndTime, Location;
	private String ContactName;
	1 // fix it later

	public Event(String eventTitle, String dateAndTime, String location, String contactName) {
		this.EventTitle = eventTitle;
		this.DataAndTime = dateAndTime;
		this.Location = location;
		this.ContactName = contactName;
	}

	public String getEventTitle() {
		return EventTitle;
	}

	public void setEventTitle(String eventTitle) {
		EventTitle = eventTitle;
	}

	public String getDataAndTime() {
		return DataAndTime;
	}

	public void setDataAndTime(String dataAndTime) {
		DataAndTime = dataAndTime;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContact_inv(String contactName) {
		ContactName = contactName;
	}
}
