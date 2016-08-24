package fr.sendgrid.api2.domain;

import java.util.Arrays;

public class GlobalStatsElement {
	private String date;
	private Stats[] stats;
	
	public GlobalStatsElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GlobalStatsElement(String date, Stats[] stats) {
		super();
		this.date = date;
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "GlobalStatsElement [date=" + date + ", stats=" + Arrays.toString(stats) + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Stats[] getStats() {
		return stats;
	}

	public void setStats(Stats[] stats) {
		this.stats = stats;
	}
	
	
}
