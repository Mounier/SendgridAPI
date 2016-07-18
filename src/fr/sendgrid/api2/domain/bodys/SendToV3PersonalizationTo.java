package fr.sendgrid.api2.domain.bodys;

public class SendToV3PersonalizationTo {
	private String email;
	private String name;
	
	public SendToV3PersonalizationTo(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	
	public SendToV3PersonalizationTo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SendToV3PersonalizationTo [email=" + email + ", name=" + name + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
