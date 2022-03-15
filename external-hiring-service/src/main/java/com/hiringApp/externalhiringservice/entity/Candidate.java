package com.hiringApp.externalhiringservice.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@NotNull
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="CandidateSkills",joinColumns=@JoinColumn(name="id"))
	private Set<String> skillSets=new HashSet<String>();

	public Candidate(int id, String name, HashSet<String> skillSets) {
		super();
		this.id = id;
		this.name = name;
		this.skillSets = skillSets;
	}

	public Candidate() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getSkillSets() {
		return skillSets;
	}

	public void setSkillSets(Set<String> skillSets) {
		this.skillSets = skillSets;
	}





}
