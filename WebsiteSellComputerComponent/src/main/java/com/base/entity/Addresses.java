package com.base.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer address_id;
	
	
	@Column(name = "address_line1", columnDefinition = "varchar(50)", nullable = false)
	private String address_line1;
	
	@Column(name = "address_line2", columnDefinition = "varchar(50)", nullable = false)
	private String address_line2;
	
	
	@Column(name = "city", columnDefinition = "varchar(50)", nullable = false)
	private String city;
	
	
	@Column(name = "state", columnDefinition = "varchar(50)", nullable = false)
	private String state;
	
	
	@Column(name = "post_code", columnDefinition = "varchar(50)", nullable = false)
	private String post_code;
	
	@Column(name = "country", columnDefinition = "varchar(50)", nullable = false)
	private String country;
	
	@Column(name = "is_default")
	private boolean is_default = false;
	
	
	@Column(name = "create_at") // cột ngày tạo
	private LocalDate createAt;

	@Column(name = "update_at") // cột ngày cập nhật
	private LocalDate updateAt;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;


	
	
	
	


}
