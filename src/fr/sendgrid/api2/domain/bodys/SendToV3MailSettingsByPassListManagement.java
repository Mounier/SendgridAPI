package fr.sendgrid.api2.domain.bodys;

public class SendToV3MailSettingsByPassListManagement {
	private boolean enable;

	public SendToV3MailSettingsByPassListManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3MailSettingsByPassListManagement(boolean enable) {
		super();
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "SendToV3MailSettingsByPassListManagement [enable=" + enable + "]";
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
}
