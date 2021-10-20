package com.dhacbang.dojos_and_ninjas.models;

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
@Table(name="dojos")
public class Dojo {
	// Primary Key______________________________________________________
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			//Member Variable___________________________________________________
			
			@Size(min = 2)
			public String name;
			
			
			//Date Creation Tracker_____________________________________________
			@Column(updatable = false)
			@DateTimeFormat(pattern ="yyyy-MM-dd")
			private Date createdAt;
			
			@DateTimeFormat(pattern ="yyyy-MM-dd")
			private Date updatedAt;
			
			//Relationships______________________________________________________
			
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "ninja_id")
			private Ninja ninja;
			
			
			//Constructors________________________________________________________
			
			public Dojo() {}
			
			public Dojo(String name) {
				this.name = name;
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

			public Ninja getNinja() {
				return ninja;
			}

			public void setNinja(Ninja ninja) {
				this.ninja = ninja;
			}


	}
			