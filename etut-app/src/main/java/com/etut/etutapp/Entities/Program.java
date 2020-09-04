package com.etut.etutapp.Entities;

import java.text.DateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity                         
@Table(name="Program")
@Data
public class Program {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="dersId")
	private int dersId;
	
	@Column(name="ogretmenId")
	private int ogretmenId;
	
	@Column(name="grenciId")
	private int ogrenciId;
	
	@Column(name="tarih")
	private DateFormat tarih;
	
	@Column(name="saat")
	private DateFormat saat;

}
