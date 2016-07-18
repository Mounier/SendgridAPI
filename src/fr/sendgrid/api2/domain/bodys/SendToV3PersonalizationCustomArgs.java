package fr.sendgrid.api2.domain.bodys;

public class SendToV3PersonalizationCustomArgs {
	private String newArgument1;
	private String activationAttempt;
	private String customerAccountNumber;
	
	public SendToV3PersonalizationCustomArgs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3PersonalizationCustomArgs(String newArgument1, String activationAttempt,
			String customerAccountNumber) {
		super();
		this.newArgument1 = newArgument1;
		this.activationAttempt = activationAttempt;
		this.customerAccountNumber = customerAccountNumber;
	}

	@Override
	public String toString() {
		return "SendToV3PersonalizationCustomArgs [newArgument1=" + newArgument1 + ", activationAttempt="
				+ activationAttempt + ", customerAccountNumber=" + customerAccountNumber + "]";
	}

	public String getNewArgument1() {
		return newArgument1;
	}

	public void setNewArgument1(String newArgument1) {
		this.newArgument1 = newArgument1;
	}

	public String getActivationAttempt() {
		return activationAttempt;
	}

	public void setActivationAttempt(String activationAttempt) {
		this.activationAttempt = activationAttempt;
	}

	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	
	
}
