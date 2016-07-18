package fr.sendgrid.api2.domain;

import java.util.Arrays;

import fr.sendgrid.api2.domain.bodys.TemplateVersion;

// pour cr�er un template (dans le main) :
// String nomTemplate = "test template 2";
// Template template = new Template(nomTemplate);
// templateService.createTemplate(apiKey, template); 

public class TemplateBody {

	protected String name;
	protected String id;
	protected TemplateVersion[] versions; //creer la classe version en mettant dedans tous els nouveaux attributs

	public TemplateBody() {
		super();
	}

	public TemplateBody(String pName) {
		super();
		this.name = pName;
	}

	public TemplateBody(String name, String id, TemplateVersion[] versions) {
		super();
		this.name = name;
		this.id = id;
		this.versions = versions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TemplateVersion[] getVersions() {
		return versions;
	}

	public void setVersions(TemplateVersion[] versions) {
		this.versions = versions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", id=" + id + ", versions=" + Arrays.toString(versions) + "]";
	}
	
	
}
