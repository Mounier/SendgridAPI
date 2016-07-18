package fr.sendgrid.api2.domain.bodys;

public class SendToV3MailSettings {
	private SendToV3MailSettingsFooter footer;
	private SendToV3MailSettingsSpamCheck spam_check;
	private SendToV3MailSettingsByPassListManagement bypass_list_management;
	private SendToV3MailSettingsSandboxMode sandbox_mode;
	private SendToV3MailSettingsBcc bcc;
	
	public SendToV3MailSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3MailSettings(SendToV3MailSettingsFooter footer, SendToV3MailSettingsSpamCheck spam_check,
			SendToV3MailSettingsByPassListManagement bypass_list_management,
			SendToV3MailSettingsSandboxMode sandbox_mode, SendToV3MailSettingsBcc bcc) {
		super();
		this.footer = footer;
		this.spam_check = spam_check;
		this.bypass_list_management = bypass_list_management;
		this.sandbox_mode = sandbox_mode;
		this.bcc = bcc;
	}

	@Override
	public String toString() {
		return "SendToV3MailSettings [footer=" + footer + ", spam_check=" + spam_check + ", bypass_list_management="
				+ bypass_list_management + ", sandbox_mode=" + sandbox_mode + ", bcc=" + bcc + "]";
	}

	public SendToV3MailSettingsFooter getFooter() {
		return footer;
	}

	public void setFooter(SendToV3MailSettingsFooter footer) {
		this.footer = footer;
	}

	public SendToV3MailSettingsSpamCheck getSpam_check() {
		return spam_check;
	}

	public void setSpam_check(SendToV3MailSettingsSpamCheck spam_check) {
		this.spam_check = spam_check;
	}

	public SendToV3MailSettingsByPassListManagement getBypass_list_management() {
		return bypass_list_management;
	}

	public void setBypass_list_management(SendToV3MailSettingsByPassListManagement bypass_list_management) {
		this.bypass_list_management = bypass_list_management;
	}

	public SendToV3MailSettingsSandboxMode getSandbox_mode() {
		return sandbox_mode;
	}

	public void setSandbox_mode(SendToV3MailSettingsSandboxMode sandbox_mode) {
		this.sandbox_mode = sandbox_mode;
	}

	public SendToV3MailSettingsBcc getBcc() {
		return bcc;
	}

	public void setBcc(SendToV3MailSettingsBcc bcc) {
		this.bcc = bcc;
	}
	
}
