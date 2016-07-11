package fr.sendgrid.api2.domain;

public class TemplateBody {
	
	private String name;
	private String html_content;
	private String plain_content;
	Integer active;
	private String templateId;
	private String subject;
	
	public TemplateBody(String name, String html_content, String plain_content, Integer active, String templateId,
			String subject) {
		super();
		this.name = name;
		this.html_content = html_content;
		this.plain_content = plain_content;
		this.active = active;
		this.templateId = templateId;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHtml_content() {
		return html_content;
	}

	public void setHtml_content(String html_content) {
		this.html_content = html_content;
	}

	public String getPlain_content() {
		return plain_content;
	}

	public void setPlain_content(String plain_content) {
		this.plain_content = plain_content;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "TemplateBody [name=" + name + ", html_content=" + html_content + ", plain_content=" + plain_content
				+ ", active=" + active + ", templateId=" + templateId + ", subject=" + subject + "]";
	}
	
	
	
}
