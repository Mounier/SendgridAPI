package fr.sendgrid.api2.domain;

public class Version {
	private String id;
	private String template_id;
	private Integer active;
	private String name;
	private String subject;
	private String updated_at;
	
	public Version() {
		super();
	}

	public Version(String id, String template_id, Integer active, String name, String subject, String updated_at) {
		super();
		this.id = id;
		this.template_id = template_id;
		this.active = active;
		this.name = name;
		this.subject = subject;
		this.updated_at = updated_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
