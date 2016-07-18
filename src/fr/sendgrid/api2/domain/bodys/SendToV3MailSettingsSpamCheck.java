package fr.sendgrid.api2.domain.bodys;

public class SendToV3MailSettingsSpamCheck {
	private Integer threshold;
	private String post_to_url;
	private boolean enable;
	
	public SendToV3MailSettingsSpamCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SendToV3MailSettingsSpamCheck(Integer threshold, String post_to_url, boolean enable) {
		super();
		this.threshold = threshold;
		this.post_to_url = post_to_url;
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "SendToV3MailSettingsSpamCheck [threshold=" + threshold + ", post_to_url=" + post_to_url + ", enable="
				+ enable + "]";
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public String getPost_to_url() {
		return post_to_url;
	}

	public void setPost_to_url(String post_to_url) {
		this.post_to_url = post_to_url;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
}
