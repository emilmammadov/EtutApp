package com.nacsoft.etut.Entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

import com.nacsoft.etut.Entities.Program;
import lombok.Data;


@Entity                         
@Table(name="program")
@Data
public class Program {
	
	@Id
	@Column(name="program_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int programId;
	
	@Column(name="ogretmen_id")
	private int ogretmenId;
	
	@Column(name="ogrenci_id")
	private int ogrenciId;
	
	@Column(name="randevu_start")
	private Timestamp randevuStart;
	
	@Column(name="randevu_end")
	private Timestamp randevuEnd;
	
	@Column(name="statu")
	private boolean status;

}
