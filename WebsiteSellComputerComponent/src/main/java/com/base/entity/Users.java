package com.base.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // cột id người dùng tự động tăng
	private Integer user_id;

	@Column(name = "username", columnDefinition = "varchar(50)", nullable = false) // cột tên người dùng
	private String username;

	@Column(name = "password", columnDefinition = "varchar(150)", nullable = false) // cột mật khẩu
	private String password;

	@Column(name = "email", columnDefinition = "varchar(50)", nullable = false, unique = true) // cột email nhưng phải là duy nhất
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "varchar(50)", nullable = false) // cột enum để xác định vai trò và phân quyền
	private Role role;

	@Column(name = "create_at") // cột ngày tạo
	private LocalDate createAt;

	@Column(name = "update_at") // cột ngày cập nhật
	private LocalDate updateAt;
	
	@ManyToOne
	@JoinColumn(name = "customer_id") // cột FK id khách hàng
	private Customers customer;
	
	@JoinColumn(name = "employee_id") // cột FK id của nhân viên quan hệ 1 - 1 với user
	@OneToOne(fetch = FetchType.LAZY)
	private Employees employee;
	

}
