package com.ahmet.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ahmet.enums.MilitaryStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Integer id;
	   
    @Column(name = "first_name", nullable = false, length = 30)
	private String firstName;
	
    @Column(name = "last_name", nullable = false, length = 30)
	private String lastName;
	
    @Column(name = "position", nullable = false, length = 50)
	private String position;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "military_status", nullable = false, length = 10)
	private MilitaryStatus militaryStatus;  //tamamlandi - muaf - tecilli
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "notice_period", nullable = false)
	private Date noticePeriod;
	
	@Column(name = "phone", nullable = false, length = 10)    
	private String phone;  
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "cv", nullable = false, length = 50)
	private String cv;
	
}
