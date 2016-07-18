package fr.sendgrid.api2.domain.bodys;

public class SendToV3PersonalizationSubstitutions {
	private String type;
	private String id;
	
	public SendToV3PersonalizationSubstitutions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3PersonalizationSubstitutions(String type, String id) {
		super();
		this.type = type;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Substitutions [type=" + type + ", id=" + id + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
