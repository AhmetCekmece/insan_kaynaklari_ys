package com.ahmet.dto;

import java.sql.Date;

import com.ahmet.enums.MilitaryStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCandidateIU {
	
	private Integer id;

	@NotEmpty(message = "Adnız boş bırakılamaz!")
	@Size(min = 3, max = 30, message = "Adnız 3-30 karakter aralığında olmalı")
	private String firstName;
	
	@NotEmpty(message = "Soyadınız boş bırakılamaz!")
	@Size(min = 3, max = 30, message = "Soyadınız 3-30 karakter aralığında olmalı.")
	private String lastName;
	
	@NotEmpty(message = "Pozisyon bilgisi boş bırakılamaz!")
	@Size(min = 3, max = 50, message = "Pozisyon bilgisi 3-50 karakter aralığında olmalı.")
	private String position;
	
	@NotNull(message = "Askerlik durumu boş bırakılamaz!")
	private MilitaryStatus militaryStatus;  
	
	@NotNull(message = "İhbar süresi boş bırakılamaz!")
	private Date noticePeriod;
	
	@Pattern(regexp = "^\\d{10}$", message = "Telefon numarası 10 haneli olmalı.")
	private String phone;  
	
	@NotEmpty(message = "Email boş bırakılamaz!")
	@Size(min = 3, max = 50, message = "Email bilgisi 3-50 karakter aralığında olmalı.")
	@Email(message = "Geçersiz Email biçimi.")
	private String email;
	
	@NotEmpty(message = "Cv boş bırakılamaz!")
	@Size(min = 3, max = 50, message = "Cv bilgisi 3-50 karakter aralığında olmalı.")
	private String cv;
	
}
