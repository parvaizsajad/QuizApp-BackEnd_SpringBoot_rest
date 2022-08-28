package com.examportal.Entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	private String title;
	private String description;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Quiz> quizes=new LinkedHashSet<Quiz>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(Set<Quiz> quizes) {
		this.quizes = quizes;
	}

	public Category(Integer cid, String title, String description, Set<Quiz> quizes) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.quizes = quizes;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
