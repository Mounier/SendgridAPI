package fr.sendgrid.api2.domain;

public class WebhookSettings {
	private String bounce;
	private String click;
	private String deferred;
	private String delivered;
	private String dropped;
	private String enable;
	private String group_resubscribe;
	private String group_unsubscribe;
	private String open;
	private String processed;
	private String spam_report;
	private String unsubscribe;
	private String url;
	
	public WebhookSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebhookSettings(String bounce, String click, String deferred, String delivered, String dropped,
			String enable, String group_resubscribe, String group_unsubscribe, String open, String processed,
			String spam_report, String unsubscribe, String url) {
		super();
		this.bounce = bounce;
		this.click = click;
		this.deferred = deferred;
		this.delivered = delivered;
		this.dropped = dropped;
		this.enable = enable;
		this.group_resubscribe = group_resubscribe;
		this.group_unsubscribe = group_unsubscribe;
		this.open = open;
		this.processed = processed;
		this.spam_report = spam_report;
		this.unsubscribe = unsubscribe;
		this.url = url;
	}

	@Override
	public String toString() {
		return "WebhookSettings [bounce=" + bounce + ", click=" + click + ", deferred=" + deferred + ", delivered="
				+ delivered + ", dropped=" + dropped + ", enable=" + enable + ", group_resubscribe=" + group_resubscribe
				+ ", group_unsubscribe=" + group_unsubscribe + ", open=" + open + ", processed=" + processed
				+ ", spam_report=" + spam_report + ", unsubscribe=" + unsubscribe + ", url=" + url + "]";
	}

	public String getBounce() {
		return bounce;
	}

	public void setBounce(String bounce) {
		this.bounce = bounce;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getDeferred() {
		return deferred;
	}

	public void setDeferred(String deferred) {
		this.deferred = deferred;
	}

	public String getDelivered() {
		return delivered;
	}

	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}

	public String getDropped() {
		return dropped;
	}

	public void setDropped(String dropped) {
		this.dropped = dropped;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getGroup_resubscribe() {
		return group_resubscribe;
	}

	public void setGroup_resubscribe(String group_resubscribe) {
		this.group_resubscribe = group_resubscribe;
	}

	public String getGroup_unsubscribe() {
		return group_unsubscribe;
	}

	public void setGroup_unsubscribe(String group_unsubscribe) {
		this.group_unsubscribe = group_unsubscribe;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getSpam_report() {
		return spam_report;
	}

	public void setSpam_report(String spam_report) {
		this.spam_report = spam_report;
	}

	public String getUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(String unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
