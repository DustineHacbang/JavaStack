package com.dhacbang.kennel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	// Primary Key______________________________________________________
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Member Variable___________________________________________________

	@NotEmpty(message = "First name is required!")
	@Size(min = 2, max = 30, message = "First name must be between 3 and 30 characters")
	private String firstName;

	@NotEmpty(message = "Last name is required!")
	@Size(min = 2, max = 30, message = "Last name must be between 3 and 30 characters")
	private String lastName;
	
	@NotEmpty(message = "Email required")
	@Email(message = "Please enter a valid email!")
	private String email;

	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 130, message = "Password must be between 3 and 30 characters")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm is password!")
	@Size(min = 8, max = 130, message = "Password must match")
	private String confirmPassword;
	


	// Date Creation Tracker_____________________________________________
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// Relationships______________________________________________________

	// Constructors________________________________________________________
	public User() {}
	
	// Data Creation_______________________________________________________
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	// Getter and Setter___________________________________________________

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

}
