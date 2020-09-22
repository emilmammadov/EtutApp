package com.nacsoft.etut.Entities;

import java.text.DateFormat;
import javax.persistence.*;
import com.nacsoft.etut.Entities.Program;
import lombok.Data;


@Entity                         
@Table(name="program")
@Data
public class Program {
	
	@Id
	@Column(name="program_id")
	private int programId;
	
	@Column(name="ders_id")
	private int dersId;
	
	@Column(name="ogretmen_id")
	private int ogretmenId;
	
	@Column(name="ogrenci_id")
	private int ogrenciId;
	
	@Column(name="randevu_tarihi")
	private DateFormat randevuTarihi;
	
	@Column(name="statu")
	private boolean onayDurumu;

}
