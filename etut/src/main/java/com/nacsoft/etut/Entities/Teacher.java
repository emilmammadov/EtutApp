package com.nacsoft.etut.Entities;

import javax.persistence.*;
import com.nacsoft.etut.Entities.Teacher;
import lombok.Data;

@Entity                         
@Table(name="ogretmen")
@Data
public class Teacher {
	
	@Id
	@Column(name="ogretmen_id")
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
	
	@Column(name="ders_id")
	private int dersId;

}
