package com.etut.Entities;

import javax.persistence.*;

import com.etut.Entities.*;

import lombok.Data;

@Entity                         // bu bir veri tabanı nesnesidir demiş olıuyoruz
@Table(name="admin")
@Data
public class Admin {
	
	@Id
	@Column(name="admin_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

}
