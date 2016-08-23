package fr.sendgrid.api2.domain;

public class GlobalStatsElement {
	String date;
	Stats stats;
	
	public GlobalStatsElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GlobalStatsElement(String date, Stats stats) {
		super();
		this.date = date;
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "GlobalStatsElement [date=" + date + ", stats=" + stats + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
