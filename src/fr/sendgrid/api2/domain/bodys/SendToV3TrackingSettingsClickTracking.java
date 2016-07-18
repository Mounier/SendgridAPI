package fr.sendgrid.api2.domain.bodys;

public class SendToV3TrackingSettingsClickTracking {
	private boolean enble;
	private boolean enable_text;
	
	public SendToV3TrackingSettingsClickTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3TrackingSettingsClickTracking(boolean enble, boolean enable_text) {
		super();
		this.enble = enble;
		this.enable_text = enable_text;
	}

	@Override
	public String toString() {
		return "SendToV3TrackingSettingsClickTracking [enble=" + enble + ", enable_text=" + enable_text + "]";
	}

	public boolean isEnble() {
		return enble;
	}

	public void setEnble(boolean enble) {
		this.enble = enble;
	}

	public boolean isEnable_text() {
		return enable_text;
	}

	public void setEnable_text(boolean enable_text) {
		this.enable_text = enable_text;
	}
	
	
}
