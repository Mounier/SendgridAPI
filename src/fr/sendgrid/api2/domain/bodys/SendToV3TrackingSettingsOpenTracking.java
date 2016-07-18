package fr.sendgrid.api2.domain.bodys;

public class SendToV3TrackingSettingsOpenTracking {
	private boolean enable;
	private String substitution_tag;
	
	public SendToV3TrackingSettingsOpenTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3TrackingSettingsOpenTracking(boolean enable, String substitution_tag) {
		super();
		this.enable = enable;
		this.substitution_tag = substitution_tag;
	}

	@Override
	public String toString() {
		return "SendToV3TrackingSettingsOpenTracking [enable=" + enable + ", substitution_tag=" + substitution_tag
				+ "]";
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getSubstitution_tag() {
		return substitution_tag;
	}

	public void setSubstitution_tag(String substitution_tag) {
		this.substitution_tag = substitution_tag;
	} 
	
}
