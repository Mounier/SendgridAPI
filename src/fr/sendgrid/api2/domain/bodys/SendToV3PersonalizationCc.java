package fr.sendgrid.api2.domain.bodys;

public class SendToV3PersonalizationCc {
	private String email;
	private String name;
	
	public SendToV3PersonalizationCc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3PersonalizationCc(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SendToV3PersonalizationCc [email=" + email + ", name=" + name + "]";
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
