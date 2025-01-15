package com.base.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // cột id khách hàng tự động tăng
	private Integer customer_id;
	
	
	@Column(name = "last_name", columnDefinition = "NVARCHAR(50)", nullable = false) // cột họ của khách hàng
	private String lastName;
	
	
	@Column(name = "first_name", columnDefinition = "NVARCHAR(50)", nullable = false) // cột tên của khách hàng
	private String firstName;
	
	
	@Column(name = "gender", columnDefinition = "BIT", nullable = false) // cột giới tính của khách hàng
	private boolean gender;
	
	@Column(name = "phone_number", columnDefinition = "VARCHAR(11)", nullable = false) // cột số điện thoại của khách hàng
	private String phoneNumber;
	
	@Column(name = "date_of_birth") // cột ngày sinh của khách hàng
	private LocalDate dateOfBirth;
	
	@Column(name = "create_at") // cột ngày tạo
	private LocalDate createAt;

	@Column(name = "update_at") // cột ngày cập nhật
	private LocalDate updateAt;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true) // lấy danh sách user
	private List<Users> listUsers;
}
