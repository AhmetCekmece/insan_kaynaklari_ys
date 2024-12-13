package com.ahmet.dto;

import java.sql.Date;

import com.ahmet.enums.MilitaryStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCandidate {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String position;
	
	private MilitaryStatus militaryStatus;  
	
	private Date noticePeriod;
	
	private String phone;  
	
	private String email;
	
	private String cv;
}
