package com.dhacbang.pokeBook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="items")
public class Item {
	// Primary Key______________________________________________________
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		//Member Variable___________________________________________________
		
		@Size(min = 1, message = "Name must be be 1 letters long")
		private String name;
		
		@NotNull(message = "Must enter an amount")
		@Min(0)
		private Double amount;
		
		@Size(min = 2, message = "Must have vendor name")
		private String vendor;
		
		
		
		//Date Creation Tracker_____________________________________________
		@Column(updatable = false)
		@DateTimeFormat(pattern ="yyyy-MM-dd")
		private Date createdAt;
		
		@DateTimeFormat(pattern ="yyyy-MM-dd")
		private Date updatedAt;
		
		//Constructors________________________________________________________
		
		public Item() {}
		
		
		
		public Item(@Size(min = 2) String name, @Min(0) Double amount, @Size(min = 2) String vendor, Date updatedAt) {
			
			this.name = name;
			this.amount = amount;
			this.vendor = vendor;
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



		public Double getAmount() {
			return amount;
		}



		public void setAmount(Double amount) {
			this.amount = amount;
		}



		public String getVendor() {
			return vendor;
		}



		public void setVendor(String vendor) {
			this.vendor = vendor;
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
		

	