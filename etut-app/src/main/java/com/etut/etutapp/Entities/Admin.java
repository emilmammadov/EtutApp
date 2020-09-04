package com.etut.etutapp.Entities;

import javax.persistence.*;
import lombok.*;

@Entity                         // bu bir veri tabanı nesnesidir demiş olıuyoruz
@Table(name="Admin")
@Data
public class Admin {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

}

