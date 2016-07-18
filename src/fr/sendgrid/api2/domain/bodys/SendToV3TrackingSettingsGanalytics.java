package fr.sendgrid.api2.domain.bodys;

public class SendToV3TrackingSettingsGanalytics {
	
	private String utm_campaign;
	private boolean enable;
	private String utm_name;
	private String utm_term;
	private String utm_content;
	private String utm_medium;
	
	public SendToV3TrackingSettingsGanalytics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3TrackingSettingsGanalytics(String utm_campaign, boolean enable, String utm_name, String utm_term,
			String utm_content, String utm_medium) {
		super();
		this.utm_campaign = utm_campaign;
		this.enable = enable;
		this.utm_name = utm_name;
		this.utm_term = utm_term;
		this.utm_content = utm_content;
		this.utm_medium = utm_medium;
	}

	@Override
	public String toString() {
		return "SendToV3TrackingSettingsGanalytics [utm_campaign=" + utm_campaign + ", enable=" + enable + ", utm_name="
				+ utm_name + ", utm_term=" + utm_term + ", utm_content=" + utm_content + ", utm_medium=" + utm_medium
				+ "]";
	}

	public String getUtm_campaign() {
		return utm_campaign;
	}

	public void setUtm_campaign(String utm_campaign) {
		this.utm_campaign = utm_campaign;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getUtm_name() {
		return utm_name;
	}

	public void setUtm_name(String utm_name) {
		this.utm_name = utm_name;
	}

	public String getUtm_term() {
		return utm_term;
	}

	public void setUtm_term(String utm_term) {
		this.utm_term = utm_term;
	}

	public String getUtm_content() {
		return utm_content;
	}

	public void setUtm_content(String utm_content) {
		this.utm_content = utm_content;
	}

	public String getUtm_medium() {
		return utm_medium;
	}

	public void setUtm_medium(String utm_medium) {
		this.utm_medium = utm_medium;
	}
	
	
}
