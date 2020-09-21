package com.nacsoft.etut.Entities;

import javax.persistence.*;
import com.nacsoft.etut.Entities.*;


import lombok.Data;

@Entity                         // bu bir veri tabanı nesnesidir demiş olıuyoruz
@Table(name="admin")
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
