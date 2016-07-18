package fr.sendgrid.api2.domain.bodys;

import java.util.Arrays;

public class SendToV3Asm {
	
	private Integer[] groups_to_display;
	private Integer group_id;
	
	public SendToV3Asm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendToV3Asm(Integer[] groups_to_display, Integer group_id) {
		super();
		this.groups_to_display = groups_to_display;
		this.group_id = group_id;
	}

	@Override
	public String toString() {
		return "SendToV3Asm [groups_to_display=" + Arrays.toString(groups_to_display) + ", group_id=" + group_id + "]";
	}

	public Integer[] getGroups_to_display() {
		return groups_to_display;
	}

	public void setGroups_to_display(Integer[] groups_to_display) {
		this.groups_to_display = groups_to_display;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	
	
}
