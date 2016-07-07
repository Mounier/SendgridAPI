package fr.sendgrid.api2.domain;

import java.util.List;

public class Campaign {

	private String customUnsubscribeUrl;
	private String htmlContent;
	private List<Long> listIds;
	private String senderId;
	private String subject;
	private String plainContent;
	private String suppressionGroupId;
	private String title;
	private List<Long> segmentIds;
	private List<String> categories;
	private String ipPool;
	
	public Campaign() {
		super();
	}


	public Campaign(String customUnsubscribeUrl, String htmlContent, List<Long> listIds, String senderId,
			String subject, String plainContent, String suppressionGroupId, String title, List<Long> segmentIds,
			List<String> categories, String ipPool) {
		super();
		this.customUnsubscribeUrl = customUnsubscribeUrl;
		this.htmlContent = htmlContent;
		this.listIds = listIds;
		this.senderId = senderId;
		this.subject = subject;
		this.plainContent = plainContent;
		this.suppressionGroupId = suppressionGroupId;
		this.title = title;
		this.segmentIds = segmentIds;
		this.categories = categories;
		this.ipPool = ipPool;
	}
	
	
	public String getCustomUnsubscribeUrl() {
		return customUnsubscribeUrl;
	}
	public void setCustomUnsubscribeUrl(String customUnsubscribeUrl) {
		this.customUnsubscribeUrl = customUnsubscribeUrl;
	}
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	public List<Long> getListIds() {
		return listIds;
	}
	public void setListIds(List<Long> listIds) {
		this.listIds = listIds;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPlainContent() {
		return plainContent;
	}
	public void setPlainContent(String plainContent) {
		this.plainContent = plainContent;
	}
	public String getSuppressionGroupId() {
		return suppressionGroupId;
	}
	public void setSuppressionGroupId(String suppressionGroupId) {
		this.suppressionGroupId = suppressionGroupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Long> getSegmentIds() {
		return segmentIds;
	}
	public void setSegmentIds(List<Long> segmentIds) {
		this.segmentIds = segmentIds;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getIpPool() {
		return ipPool;
	}
	public void setIpPool(String ipPool) {
		this.ipPool = ipPool;
	}	
}
