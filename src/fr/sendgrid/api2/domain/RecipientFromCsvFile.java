package fr.sendgrid.api2.domain;

public class RecipientFromCsvFile{
	
	protected String email;
	protected String firstName;
	protected String lastName;
	protected String region;
	protected String city;
	protected Integer Id;
	
	public RecipientFromCsvFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipientFromCsvFile(String email, String firstName, String lastName, String region, String city,
			Integer id) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.region = region;
		this.city = city;
		Id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "RecipientFromCsvFile [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", region=" + region + ", city=" + city + ", Id=" + Id + "]";
	}
	
	

}
