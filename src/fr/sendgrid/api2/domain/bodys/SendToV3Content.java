package fr.sendgrid.api2.domain.bodys;

public class SendToV3Content {
	private String type;
	private String value;
	
	public SendToV3Content() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SendToV3Content(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "SendToV3Content [type=" + type + ", value=" + value + "]";
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
