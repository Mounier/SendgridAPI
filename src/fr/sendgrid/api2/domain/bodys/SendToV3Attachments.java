package fr.sendgrid.api2.domain.bodys;

public class SendToV3Attachments {
	private String name;
	private String filename;
	private String content;
	private String disposition;
	private String content_id;
	private String type;
	
	public SendToV3Attachments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3Attachments(String name, String filename, String content, String disposition, String content_id,
			String type) {
		super();
		this.name = name;
		this.filename = filename;
		this.content = content;
		this.disposition = disposition;
		this.content_id = content_id;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "sendToV3Attachment [name=" + name + ", filename=" + filename + ", content=" + content + ", disposition="
				+ disposition + ", content_id=" + content_id + ", type=" + type + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDisposition() {
		return disposition;
	}
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
