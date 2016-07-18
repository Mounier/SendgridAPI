package fr.sendgrid.api2.domain.bodys;

public class SendToV3MailSettingsFooter {
	private String text;
	private boolean enable;
	private String html;
	
	public SendToV3MailSettingsFooter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SendToV3MailSettingsFooter(String text, boolean enable, String html) {
		super();
		this.text = text;
		this.enable = enable;
		this.html = html;
	}
	
	@Override
	public String toString() {
		return "SendToV3MailSettingsFooter [text=" + text + ", enable=" + enable + ", html=" + html + "]";
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
	
	
}
