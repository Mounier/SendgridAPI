package fr.sendgrid.api2.domain;

public class Metrics {
	int blocks;
	int bounce_drops;
	int bounces;
	int clicks;
	int deferred;
	int delivered;
	int invalid_emails;
	int opens;
	int processed;
	int requests;
	int spam_report_drops;
	int spam_reports;
	int unique_clicks;
	int unique_opens;
	int unsubscribe_drops;
	int unsubscribes;
	
	public Metrics(int blocks, int bounce_drops, int bounces, int clicks, int deferred, int delivered,
			int invalid_emails, int opens, int processed, int requests, int spam_report_drops, int spam_reports,
			int unique_clicks, int unique_opens, int unsubscribe_drops, int unsubscribes) {
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

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getBounce_drops() {
		return bounce_drops;
	}

	public void setBounce_drops(int bounce_drops) {
		this.bounce_drops = bounce_drops;
	}

	public int getBounces() {
		return bounces;
	}

	public void setBounces(int bounces) {
		this.bounces = bounces;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getDeferred() {
		return deferred;
	}

	public void setDeferred(int deferred) {
		this.deferred = deferred;
	}

	public int getDelivered() {
		return delivered;
	}

	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}

	public int getInvalid_emails() {
		return invalid_emails;
	}

	public void setInvalid_emails(int invalid_emails) {
		this.invalid_emails = invalid_emails;
	}

	public int getOpens() {
		return opens;
	}

	public void setOpens(int opens) {
		this.opens = opens;
	}

	public int getProcessed() {
		return processed;
	}

	public void setProcessed(int processed) {
		this.processed = processed;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public int getSpam_report_drops() {
		return spam_report_drops;
	}

	public void setSpam_report_drops(int spam_report_drops) {
		this.spam_report_drops = spam_report_drops;
	}

	public int getSpam_reports() {
		return spam_reports;
	}

	public void setSpam_reports(int spam_reports) {
		this.spam_reports = spam_reports;
	}

	public int getUnique_clicks() {
		return unique_clicks;
	}

	public void setUnique_clicks(int unique_clicks) {
		this.unique_clicks = unique_clicks;
	}

	public int getUnique_opens() {
		return unique_opens;
	}

	public void setUnique_opens(int unique_opens) {
		this.unique_opens = unique_opens;
	}

	public int getUnsubscribe_drops() {
		return unsubscribe_drops;
	}

	public void setUnsubscribe_drops(int unsubscribe_drops) {
		this.unsubscribe_drops = unsubscribe_drops;
	}

	public int getUnsubscribes() {
		return unsubscribes;
	}

	public void setUnsubscribes(int unsubscribes) {
		this.unsubscribes = unsubscribes;
	}

	public Metrics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
