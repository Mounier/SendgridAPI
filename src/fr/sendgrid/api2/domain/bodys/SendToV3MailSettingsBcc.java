package fr.sendgrid.api2.domain.bodys;

public class SendToV3MailSettingsBcc {
	private boolean enable;
	private String email;
	
	public SendToV3MailSettingsBcc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3MailSettingsBcc(boolean enable, String email) {
		super();
		this.enable = enable;
		this.email = email;
	}

	@Override
	public String toString() {
		return "SendToV3MailSettingsBcc [enable=" + enable + ", email=" + email + "]";
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
