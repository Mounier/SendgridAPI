package fr.sendgrid.api2.domain.bodys;

public class SendToV3PersonalizationHeaders {
	private String xAcceptLanguage;
	private String xMailer;
	
	public SendToV3PersonalizationHeaders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3PersonalizationHeaders(String xAcceptLanguage, String xMailer) {
		super();
		this.xAcceptLanguage = xAcceptLanguage;
		this.xMailer = xMailer;
	}

	@Override
	public String toString() {
		return "Headers [xAcceptLanguage=" + xAcceptLanguage + ", xMailer=" + xMailer + "]";
	}

	public String getxAcceptLanguage() {
		return xAcceptLanguage;
	}

	public void setxAcceptLanguage(String xAcceptLanguage) {
		this.xAcceptLanguage = xAcceptLanguage;
	}

	public String getxMailer() {
		return xMailer;
	}

	public void setxMailer(String xMailer) {
		this.xMailer = xMailer;
	}
	
}
