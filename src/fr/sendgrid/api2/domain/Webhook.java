package fr.sendgrid.api2.domain;

public class Webhook {
	private boolean group_resubscribe;
	private boolean delivered;
	private boolean group_unsubscribe;
	private boolean spam_report;
	private String url;
	private boolean enabled;
	private boolean bounce;
	private boolean deferred;
	private boolean unsubscribe;
	private boolean dropped;
	private boolean open;
	private boolean click;
	private boolean processed;
	
	public Webhook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Webhook(boolean group_resubscribe, boolean delivered, boolean group_unsubscribe, boolean spam_report,
			String url, boolean enabled, boolean bounce, boolean deferred, boolean unsubscribe, boolean dropped,
			boolean open, boolean click, boolean processed) {
		super();
		this.group_resubscribe = group_resubscribe;
		this.delivered = delivered;
		this.group_unsubscribe = group_unsubscribe;
		this.spam_report = spam_report;
		this.url = url;
		this.enabled = enabled;
		this.bounce = bounce;
		this.deferred = deferred;
		this.unsubscribe = unsubscribe;
		this.dropped = dropped;
		this.open = open;
		this.click = click;
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "WebhookSettings [group_resubscribe=" + group_resubscribe + ", delivered=" + delivered
				+ ", group_unsubscribe=" + group_unsubscribe + ", spam_report=" + spam_report + ", url=" + url
				+ ", enabled=" + enabled + ", bounce=" + bounce + ", deferred=" + deferred + ", unsubscribe="
				+ unsubscribe + ", dropped=" + dropped + ", open=" + open + ", click=" + click + ", processed="
				+ processed + "]";
	}

	public boolean isGroup_resubscribe() {
		return group_resubscribe;
	}

	public void setGroup_resubscribe(boolean group_resubscribe) {
		this.group_resubscribe = group_resubscribe;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public boolean isGroup_unsubscribe() {
		return group_unsubscribe;
	}

	public void setGroup_unsubscribe(boolean group_unsubscribe) {
		this.group_unsubscribe = group_unsubscribe;
	}

	public boolean isSpam_report() {
		return spam_report;
	}

	public void setSpam_report(boolean spam_report) {
		this.spam_report = spam_report;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isBounce() {
		return bounce;
	}

	public void setBounce(boolean bounce) {
		this.bounce = bounce;
	}

	public boolean isDeferred() {
		return deferred;
	}

	public void setDeferred(boolean deferred) {
		this.deferred = deferred;
	}

	public boolean isUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(boolean unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	public boolean isDropped() {
		return dropped;
	}

	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
}
