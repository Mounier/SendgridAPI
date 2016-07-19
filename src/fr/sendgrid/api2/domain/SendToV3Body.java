package fr.sendgrid.api2.domain;

import fr.sendgrid.api2.domain.bodys.SendToV3Categories;
import java.util.Arrays;
import fr.sendgrid.api2.domain.bodys.SendToV3Asm;
import fr.sendgrid.api2.domain.bodys.SendToV3Attachments;
import fr.sendgrid.api2.domain.bodys.SendToV3Content;
import fr.sendgrid.api2.domain.bodys.SendToV3CustomArgs;
import fr.sendgrid.api2.domain.bodys.SendToV3From;
import fr.sendgrid.api2.domain.bodys.SendToV3Headers;
import fr.sendgrid.api2.domain.bodys.SendToV3MailSettings;
import fr.sendgrid.api2.domain.bodys.SendToV3Personalizations;
import fr.sendgrid.api2.domain.bodys.SendToV3ReplyTo;
import fr.sendgrid.api2.domain.bodys.SendToV3TrackingSettings;

public class SendToV3Body {
	
	private SendToV3CustomArgs custom_args;
	private SendToV3From from;
	private SendToV3Attachments attachments;
	private SendToV3Personalizations personalizations;
	private String subject;
	private String ipPoolName;
	private SendToV3Content content[];
	private SendToV3Headers headers;
	private SendToV3Asm asm;
	private String batch_id;
	private SendToV3TrackingSettings tracking_settings;
	private SendToV3MailSettings mail_settings;
	private SendToV3ReplyTo reply_to;
/*	\"sections\": { \"section\": {\":sectionName2\":\"section 2 text\", \":sectionName1\":\"section 1 text\"} } */
	private String template_id;
	private SendToV3Categories[] categories;
	private Integer send_at;
	
	public SendToV3Body() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3Body(SendToV3CustomArgs custom_args, SendToV3From from, SendToV3Attachments attachments,
			SendToV3Personalizations personalizations, String subject, String ipPoolName, SendToV3Content[] content,
			SendToV3Headers headers, SendToV3Asm asm, String batch_id, SendToV3TrackingSettings tracking_settings,
			SendToV3MailSettings mail_settings, SendToV3ReplyTo reply_to, String template_id,
			SendToV3Categories[] categories, Integer send_at) {
		super();
		this.custom_args = custom_args;
		this.from = from;
		this.attachments = attachments;
		this.personalizations = personalizations;
		this.subject = subject;
		this.ipPoolName = ipPoolName;
		this.content = content;
		this.headers = headers;
		this.asm = asm;
		this.batch_id = batch_id;
		this.tracking_settings = tracking_settings;
		this.mail_settings = mail_settings;
		this.reply_to = reply_to;
		this.template_id = template_id;
		this.categories = categories;
		this.send_at = send_at;
	}
	
	

	public SendToV3Body(SendToV3From from, SendToV3Personalizations personalizations, String subject,
			String template_id) {
		super();
		this.from = from;
		this.personalizations = personalizations;
		this.subject = subject;
		this.template_id = template_id;
	}

	public SendToV3Body(SendToV3From from, SendToV3Personalizations personalizations, String subject,
			SendToV3Content[] content) {
		super();
		this.from = from;
		this.personalizations = personalizations;
		this.subject = subject;
		this.content = content;
	}
	
	public SendToV3Body(SendToV3From from, SendToV3Personalizations personalizations, SendToV3Content[] content) {
		super();
		this.from = from;
		this.personalizations = personalizations;
		this.content = content;
	}

	@Override
	public String toString() {
		return "SendToV3Body [custom_args=" + custom_args + ", from=" + from + ", attachments=" + attachments
				+ ", personalizations=" + personalizations + ", subject=" + subject + ", ipPoolName=" + ipPoolName
				+ ", content=" + Arrays.toString(content) + ", headers=" + headers + ", asm=" + asm + ", batch_id="
				+ batch_id + ", tracking_settings=" + tracking_settings + ", mail_settings=" + mail_settings
				+ ", reply_to=" + reply_to + ", template_id=" + template_id + ", categories="
				+ Arrays.toString(categories) + ", send_at=" + send_at + "]";
	}

	public SendToV3CustomArgs getCustom_args() {
		return custom_args;
	}

	public void setCustom_args(SendToV3CustomArgs custom_args) {
		this.custom_args = custom_args;
	}

	public SendToV3From getFrom() {
		return from;
	}

	public void setFrom(SendToV3From from) {
		this.from = from;
	}

	public SendToV3Attachments getAttachments() {
		return attachments;
	}

	public void setAttachments(SendToV3Attachments attachments) {
		this.attachments = attachments;
	}

	public SendToV3Personalizations getPersonalizations() {
		return personalizations;
	}

	public void setPersonalizations(SendToV3Personalizations personalizations) {
		this.personalizations = personalizations;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIpPoolName() {
		return ipPoolName;
	}

	public void setIpPoolName(String ipPoolName) {
		this.ipPoolName = ipPoolName;
	}

	public SendToV3Content[] getContent() {
		return content;
	}

	public void setContent(SendToV3Content[] content) {
		this.content = content;
	}

	public SendToV3Headers getHeaders() {
		return headers;
	}

	public void setHeaders(SendToV3Headers headers) {
		this.headers = headers;
	}

	public SendToV3Asm getAsm() {
		return asm;
	}

	public void setAsm(SendToV3Asm asm) {
		this.asm = asm;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public SendToV3TrackingSettings getTracking_settings() {
		return tracking_settings;
	}

	public void setTracking_settings(SendToV3TrackingSettings tracking_settings) {
		this.tracking_settings = tracking_settings;
	}

	public SendToV3MailSettings getMail_settings() {
		return mail_settings;
	}

	public void setMail_settings(SendToV3MailSettings mail_settings) {
		this.mail_settings = mail_settings;
	}

	public SendToV3ReplyTo getReply_to() {
		return reply_to;
	}

	public void setReply_to(SendToV3ReplyTo reply_to) {
		this.reply_to = reply_to;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public SendToV3Categories[] getCategories() {
		return categories;
	}

	public void setCategories(SendToV3Categories[] categories) {
		this.categories = categories;
	}

	public Integer getSend_at() {
		return send_at;
	}

	public void setSend_at(Integer send_at) {
		this.send_at = send_at;
	}
	
	
}
