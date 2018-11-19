package com.onlineshop.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name="User_tab")
	public class User {
		
		@Id
		private String email;
		private String name;
		private String password;
		private String phone;
		private String role;
		
		
		public User(){
			
		}
		
		public User(String email, String name, String password,
				String password2, String phone, String role, boolean enabled) {
			
			this.email = email;
			this.name = name;
			this.password = password;
			this.phone = phone;
			this.role = role;
			
			}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		

		@Override
		public String toString() {
			return "User [email=" + email + ", name=" + name + ", password="
				+ password + ",phone="
					+ phone + ", role=" + role + "]";
		}

		
		}
		
		
		


