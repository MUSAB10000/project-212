import java.util.Date;
public class Event {
	private String EventTitle, Location;
	private Date DataAndTime;
	private String ContactName;

	public Event(String eventTitle, Date dateAndTime, String location, String contactName) {
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

	public Date getDataAndTime() {
		return DataAndTime;
	}

	public void setDataAndTime(Date dataAndTime) {
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
