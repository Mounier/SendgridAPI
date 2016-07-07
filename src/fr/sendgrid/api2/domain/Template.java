package fr.sendgrid.api2.domain;

import java.util.Arrays;

public class Template {

	protected String name;
	protected String id;
	protected String[] versions;

	public Template() {
		super();
	}

	public Template(String pName) {
		super();
		this.name = pName;
	}

	public Template(String name, String id, String[] versions) {
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

	public String[] getVersions() {
		return versions;
	}

	public void setVersions(String[] versions) {
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
