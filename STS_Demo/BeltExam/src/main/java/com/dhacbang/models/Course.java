package com.dhacbang.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Course {
	// Primary Key______________________________________________________
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//Member Variable___________________________________________________
	
	@NotNull(message = "Name is required")
	@Size(min = 2, max = 30, message = "Name must be be 2 and 30 letters long")
	private String name;
	
	@NotNull(message = "Weekday Must Be Selected ")
	@Size(min = 2, message = "Day Must Be Weekday")
	private String day;
	
	@NotNull(message = "Must enter an price")
	@Min(1)
	@Max(120)
	private Double price;
	
	@NotNull(message = "description is required")
	@Size(min = 10, message = "description must be 10 and 100 letters long")
	private String description;
	
	//Date Creation Tracker_____________________________________________
	@Column(updatable = false)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date updatedAt;
	
	//Relationships______________________________________________________
	
	@ManyToOne
	(fetch = FetchType.LAZY)
	@JoinColumn
	(name = "user_id")
	private User creator;
	
	
	//Constructors________________________________________________________
	
	public Course() {}
	

	public Course(
			@NotNull(message = "Name is required") @Size(min = 2, max = 30, message = "Name must be be 2 and 30 letters long") String name,
			@NotNull(message = "Weekday Must Be Selected ") @Size(min = 2, message = "Day Must Be Weekday") String day,
			@NotNull(message = "Must enter an price") @Min(1) @Max(120) Double price,
			@NotNull(message = "description is required") @Size(min = 10, message = "description must be 10 and 100 letters long") String description) {
		super();
		this.name = name;
		this.day = day;
		this.price = price;
		this.description = description;
	}





	//Data Creation_______________________________________________________
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	//Getter and Setter___________________________________________________


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	

}
