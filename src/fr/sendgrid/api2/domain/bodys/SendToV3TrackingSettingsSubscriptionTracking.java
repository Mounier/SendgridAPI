package fr.sendgrid.api2.domain.bodys;

public class SendToV3TrackingSettingsSubscriptionTracking {
	
	private String text;
	private boolean enable;
	private String html; 
	private String substitution_tag;
	
	public SendToV3TrackingSettingsSubscriptionTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3TrackingSettingsSubscriptionTracking(String text, boolean enable, String html,
			String substitution_tag) {
		super();
		this.text = text;
		this.enable = enable;
		this.html = html;
		this.substitution_tag = substitution_tag;
	}

	@Override
	public String toString() {
		return "SendToV3TrackingSettingsSubscriptionTracking [text=" + text + ", enable=" + enable + ", html=" + html
				+ ", substitution_tag=" + substitution_tag + "]";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getSubstitution_tag() {
		return substitution_tag;
	}

	public void setSubstitution_tag(String substitution_tag) {
		this.substitution_tag = substitution_tag;
	}
	
	
}
