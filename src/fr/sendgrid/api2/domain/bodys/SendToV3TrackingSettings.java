package fr.sendgrid.api2.domain.bodys;

public class SendToV3TrackingSettings {
	private SendToV3TrackingSettingsSubscriptionTracking subscription_tracking;
	private SendToV3TrackingSettingsOpenTracking open_tracking;
	private SendToV3TrackingSettingsClickTracking click_tracking;
	private SendToV3TrackingSettingsGanalytics ganalytics;
	
	public SendToV3TrackingSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3TrackingSettings(SendToV3TrackingSettingsSubscriptionTracking subscription_tracking,
			SendToV3TrackingSettingsOpenTracking open_tracking, SendToV3TrackingSettingsClickTracking click_tracking,
			SendToV3TrackingSettingsGanalytics ganalytics) {
		super();
		this.subscription_tracking = subscription_tracking;
		this.open_tracking = open_tracking;
		this.click_tracking = click_tracking;
		this.ganalytics = ganalytics;
	}

	@Override
	public String toString() {
		return "SendToV3TrackingSettings [subscription_tracking=" + subscription_tracking + ", open_tracking="
				+ open_tracking + ", click_tracking=" + click_tracking + ", ganalytics=" + ganalytics + "]";
	}

	public SendToV3TrackingSettingsSubscriptionTracking getSubscription_tracking() {
		return subscription_tracking;
	}

	public void setSubscription_tracking(SendToV3TrackingSettingsSubscriptionTracking subscription_tracking) {
		this.subscription_tracking = subscription_tracking;
	}

	public SendToV3TrackingSettingsOpenTracking getOpen_tracking() {
		return open_tracking;
	}

	public void setOpen_tracking(SendToV3TrackingSettingsOpenTracking open_tracking) {
		this.open_tracking = open_tracking;
	}

	public SendToV3TrackingSettingsClickTracking getClick_tracking() {
		return click_tracking;
	}

	public void setClick_tracking(SendToV3TrackingSettingsClickTracking click_tracking) {
		this.click_tracking = click_tracking;
	}

	public SendToV3TrackingSettingsGanalytics getGanalytics() {
		return ganalytics;
	}

	public void setGanalytics(SendToV3TrackingSettingsGanalytics ganalytics) {
		this.ganalytics = ganalytics;
	}
	
	
}
