package com.dhacbang.dojos_and_ninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="ninjas")
public class Ninja {
	// Primary Key______________________________________________________
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		//Member Variable___________________________________________________
		
		@Size(min = 2, message = "Name must be be 2 letters long")
		private String name;
		
		@NotNull(message = "Must enter an age")
		@Min(0)
		private Integer age;
		

		
		
		
		//Date Creation Tracker_____________________________________________
		@Column(updatable = false)
		@DateTimeFormat(pattern ="yyyy-MM-dd")
		private Date createdAt;
		
		@DateTimeFormat(pattern ="yyyy-MM-dd")
		private Date updatedAt;
		
		//Relationships______________________________________________________
		
		@OneToMany(mappedBy = "ninja", fetch = FetchType.LAZY)
		private List<Dojo> dojos;
		//dog.getCollars();
		
		
		//Constructors________________________________________________________
		
		public Ninja() {}
		
		
		
		public Ninja(@Size(min = 2) String name, @Min(0) Integer age, Date updatedAt) {
			
			this.name = name;
			this.age = age;

			this.updatedAt = updatedAt;
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



		public Integer getAge() {
			return age;
		}



		public void setAge(Integer age) {
			this.age = age;
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



		public List<Dojo> getDojos() {
			return dojos;
		}



		public void setDojos(List<Dojo> dojos) {
			this.dojos = dojos;
		}



	}