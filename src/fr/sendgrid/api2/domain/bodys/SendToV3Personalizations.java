package fr.sendgrid.api2.domain.bodys;

import java.util.Arrays;

public class SendToV3Personalizations {
	
	private SendToV3PersonalizationTo[] to;
	private SendToV3PersonalizationCc[] cc;
	private SendToV3PersonalizationBcc[] bcc;
	private SendToV3PersonalizationCustomArgs custom_args = new SendToV3PersonalizationCustomArgs();
	private SendToV3PersonalizationHeaders headers = new SendToV3PersonalizationHeaders();
	private Integer send_at;
	private SendToV3PersonalizationSubstitutions substitutions = new SendToV3PersonalizationSubstitutions();
	private String subject;
	
	public SendToV3Personalizations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3Personalizations(SendToV3PersonalizationTo[] to, SendToV3PersonalizationCc[] cc,
			SendToV3PersonalizationBcc[] bcc, SendToV3PersonalizationCustomArgs custom_args,
			SendToV3PersonalizationHeaders headers, Integer sendAt, SendToV3PersonalizationSubstitutions substitutions,
			String subject) {
		super();
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.custom_args = custom_args;
		this.headers = headers;
		this.send_at = sendAt;
		this.substitutions = substitutions;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "SendToV3Personalization [to=" + Arrays.toString(to) + ", cc=" + Arrays.toString(cc) + ", bcc="
				+ Arrays.toString(bcc) + ", custom_args=" + custom_args + ", headers=" + headers + ", sendAt=" + send_at
				+ ", substitutions=" + substitutions + ", subject=" + subject + "]";
	}

	public SendToV3PersonalizationTo[] getTo() {
		return to;
	}

	public void setTo(SendToV3PersonalizationTo[] to) {
		this.to = to;
	}

	public SendToV3PersonalizationCc[] getCc() {
		return cc;
	}

	public void setCc(SendToV3PersonalizationCc[] cc) {
		this.cc = cc;
	}

	public SendToV3PersonalizationBcc[] getBcc() {
		return bcc;
	}

	public void setBcc(SendToV3PersonalizationBcc[] bcc) {
		this.bcc = bcc;
	}

	public SendToV3PersonalizationCustomArgs getCustom_args() {
		return custom_args;
	}

	public void setCustom_args(SendToV3PersonalizationCustomArgs custom_args) {
		this.custom_args = custom_args;
	}

	public SendToV3PersonalizationHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(SendToV3PersonalizationHeaders headers) {
		this.headers = headers;
	}

	public Integer getSendAt() {
		return send_at;
	}

	public void setSendAt(Integer sendAt) {
		this.send_at = sendAt;
	}

	public SendToV3PersonalizationSubstitutions getSubstitutions() {
		return substitutions;
	}

	public void setSubstitutions(SendToV3PersonalizationSubstitutions substitutions) {
		this.substitutions = substitutions;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
