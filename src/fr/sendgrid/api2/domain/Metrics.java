package fr.sendgrid.api2.domain;

public class Metrics {
	String blocks;
	String bounce_drops;
	String bounces;
	String clicks;
	String deferred;
	String delivered;
	String invalid_emails;
	String opens;
	String processed;
	String requests;
	String spam_report_drops;
	String spam_reports;
	String unique_clicks;
	String unique_opens;
	String unsubscribe_drops;
	String unsubscribes;
	
	public Metrics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Metrics(String blocks, String bounce_drops, String bounces, String clicks, String deferred, String delivered,
			String invalid_emails, String opens, String processed, String requests, String spam_report_drops,
			String spam_reports, String unique_clicks, String unique_opens, String unsubscribe_drops,
			String unsubscribes) {
		super();
		this.blocks = blocks;
		this.bounce_drops = bounce_drops;
		this.bounces = bounces;
		this.clicks = clicks;
		this.deferred = deferred;
		this.delivered = delivered;
		this.invalid_emails = invalid_emails;
		this.opens = opens;
		this.processed = processed;
		this.requests = requests;
		this.spam_report_drops = spam_report_drops;
		this.spam_reports = spam_reports;
		this.unique_clicks = unique_clicks;
		this.unique_opens = unique_opens;
		this.unsubscribe_drops = unsubscribe_drops;
		this.unsubscribes = unsubscribes;
	}
	
	@Override
	public String toString() {
		return "Metrics [blocks=" + blocks + ", bounce_drops=" + bounce_drops + ", bounces=" + bounces + ", clicks="
				+ clicks + ", deferred=" + deferred + ", delivered=" + delivered + ", invalid_emails=" + invalid_emails
				+ ", opens=" + opens + ", processed=" + processed + ", requests=" + requests + ", spam_report_drops="
				+ spam_report_drops + ", spam_reports=" + spam_reports + ", unique_clicks=" + unique_clicks
				+ ", unique_opens=" + unique_opens + ", unsubscribe_drops=" + unsubscribe_drops + ", unsubscribes="
				+ unsubscribes + "]";
	}
	
	public String getBlocks() {
		return blocks;
	}
	public void setBlocks(String blocks) {
		this.blocks = blocks;
	}
	public String getBounce_drops() {
		return bounce_drops;
	}
	public void setBounce_drops(String bounce_drops) {
		this.bounce_drops = bounce_drops;
	}
	public String getBounces() {
		return bounces;
	}
	public void setBounces(String bounces) {
		this.bounces = bounces;
	}
	public String getClicks() {
		return clicks;
	}
	public void setClicks(String clicks) {
		this.clicks = clicks;
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
	public String getInvalid_emails() {
		return invalid_emails;
	}
	public void setInvalid_emails(String invalid_emails) {
		this.invalid_emails = invalid_emails;
	}
	public String getOpens() {
		return opens;
	}
	public void setOpens(String opens) {
		this.opens = opens;
	}
	public String getProcessed() {
		return processed;
	}
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	public String getRequests() {
		return requests;
	}
	public void setRequests(String requests) {
		this.requests = requests;
	}
	public String getSpam_report_drops() {
		return spam_report_drops;
	}
	public void setSpam_report_drops(String spam_report_drops) {
		this.spam_report_drops = spam_report_drops;
	}
	public String getSpam_reports() {
		return spam_reports;
	}
	public void setSpam_reports(String spam_reports) {
		this.spam_reports = spam_reports;
	}
	public String getUnique_clicks() {
		return unique_clicks;
	}
	public void setUnique_clicks(String unique_clicks) {
		this.unique_clicks = unique_clicks;
	}
	public String getUnique_opens() {
		return unique_opens;
	}
	public void setUnique_opens(String unique_opens) {
		this.unique_opens = unique_opens;
	}
	public String getUnsubscribe_drops() {
		return unsubscribe_drops;
	}
	public void setUnsubscribe_drops(String unsubscribe_drops) {
		this.unsubscribe_drops = unsubscribe_drops;
	}
	public String getUnsubscribes() {
		return unsubscribes;
	}
	public void setUnsubscribes(String unsubscribes) {
		this.unsubscribes = unsubscribes;
	}
	
}
