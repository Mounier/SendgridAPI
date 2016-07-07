package fr.sendgrid.api2.domain;

public class RecipientFromSendgrid {
	String createdAt;
	String email;
	String firstName;
	String id;
	String lastClicked;
	String lastEmailed;
	String lastOpened;
	String updatedAt;
	
	public RecipientFromSendgrid() {
		super();
	}

	public RecipientFromSendgrid(String createdAt, String email, String firstName, String id, String lastClicked,
			String lastEmailed, String lastOpened, String updatedAt) {
		super();
		this.createdAt = createdAt;
		this.email = email;
		this.firstName = firstName;
		this.id = id;
		this.lastClicked = lastClicked;
		this.lastEmailed = lastEmailed;
		this.lastOpened = lastOpened;
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastClicked() {
		return lastClicked;
	}

	public void setLastClicked(String lastClicked) {
		this.lastClicked = lastClicked;
	}

	public String getLastEmailed() {
		return lastEmailed;
	}

	public void setLastEmailed(String lastEmailed) {
		this.lastEmailed = lastEmailed;
	}

	public String getLastOpened() {
		return lastOpened;
	}

	public void setLastOpened(String lastOpened) {
		this.lastOpened = lastOpened;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Recipient [createdAt=" + createdAt + ", email=" + email + ", firstName=" + firstName + ", id=" + id
				+ ", lastClicked=" + lastClicked + ", lastEmailed=" + lastEmailed + ", lastOpened=" + lastOpened
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
}
