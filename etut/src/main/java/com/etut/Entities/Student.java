package com.etut.Entities;

import javax.persistence.*;

import com.etut.Entities.Student;

import lombok.Data;

@Entity                         
@Table(name="ogrenci")
@Data
public class Student {

	@Id
	@Column(name="ogrenci_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ogrenciId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="adi")
	private String adi;
	
	@Column(name="soyadi")
	private String soyadi;
	
}
