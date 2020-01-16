package com.etm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
public class Students {
	
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(String nama, String alamat, String gender) {
		this.nama = nama;
		this.alamat = alamat;
		this.gender = gender;
	}

	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name ="gender")
	private String gender;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
