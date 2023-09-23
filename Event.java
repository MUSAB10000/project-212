public class Event {
private String EventTitle, DataAndTime, Location;
private Contact Contact_inv;

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
	public Contact getContact_inv() {
		return Contact_inv;
	}
	public void setContact_inv(Contact contact_inv) {
		Contact_inv = contact_inv;
    }
}
