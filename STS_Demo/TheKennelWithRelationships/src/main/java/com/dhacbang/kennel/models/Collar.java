package com.dhacbang.kennel.models;

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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="collars")
public class Collar {
	// Primary Key______________________________________________________
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			//Member Variable___________________________________________________
			
			@Size(min = 2)
			public String color;
			
			
			//Date Creation Tracker_____________________________________________
			@Column(updatable = false)
			@DateTimeFormat(pattern ="yyyy-MM-dd")
			private Date createdAt;
			
			@DateTimeFormat(pattern ="yyyy-MM-dd")
			private Date updatedAt;
			
			//Relationships______________________________________________________
			
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "dog_id")
			private Dog dog;
			
			
			//Constructors________________________________________________________
			
			public Collar() {}
			
			public Collar(String color) {
				this.color = color;
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

			public String getColor() {
				return color;
			}

			public void setColor(String color) {
				this.color = color;
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

			public Dog getDog() {
				return dog;
			}

			public void setDog(Dog dog) {
				this.dog = dog;
			}

			

}
