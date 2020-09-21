package com.nacsoft.etut.Entities;

import javax.persistence.*;

import com.nacsoft.etut.Entities.Dersler;

import lombok.Data;

@Entity                         
@Table(name="dersler")
@Data
public class Dersler {
	
	@Id
	@Column(name="ders_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ders_adi")
	private String dersAdi;

}
