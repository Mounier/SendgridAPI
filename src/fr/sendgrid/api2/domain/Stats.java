package fr.sendgrid.api2.domain;

public class Stats {
	private Metrics metrics;

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}

	public Stats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stats(Metrics metrics) {
		super();
		this.metrics = metrics;
	}

	@Override
	public String toString() {
		return "Stats [metrics=" + metrics + "]";
	}
}

