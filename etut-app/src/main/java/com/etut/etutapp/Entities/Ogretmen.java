package com.etut.etutapp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity                         
@Table(name="Ogrenci")
@Data
public class Ogretmen {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="adi")
	private String adi;
	
	@Column(name="soyadi")
	private String soyadi;
	
	@Column(name="dersId")
	private int dersId;

}
