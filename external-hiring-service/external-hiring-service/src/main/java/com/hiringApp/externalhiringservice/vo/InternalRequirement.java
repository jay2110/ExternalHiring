package com.hiringApp.externalhiringservice.vo;
import java.util.HashSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternalRequirement {
	private int id;	
	private String designation;
	private HashSet<String> requiredSkills=new HashSet<String>();
	private HashSet<String> optionalSkills=new HashSet<String>();
	public InternalRequirement() {
		super();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public HashSet<String> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(HashSet<String> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public HashSet<String> getOptionalSkills() {
		return optionalSkills;
	}
	public void setOptionalSkills(HashSet<String> optionalSkills) {
		this.optionalSkills = optionalSkills;
	}
	public InternalRequirement(int id, String designation, HashSet<String> requiredSkills, HashSet<String> optionalSkills) {
		super();
		this.id = id;
		this.designation = designation;
		this.requiredSkills = requiredSkills;
		this.optionalSkills = optionalSkills;
	}








}
