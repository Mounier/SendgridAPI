package fr.sendgrid.api2.domain.bodys;

public class SendToV3MailSettingsSandboxMode {
	private boolean enable;

	public SendToV3MailSettingsSandboxMode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3MailSettingsSandboxMode(boolean enable) {
		super();
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "SendToV3MailSettingsSandboxMode [enable=" + enable + "]";
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
