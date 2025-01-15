package com.base.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
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
@Table(name = "employees")
public class Employees {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // cột id nhân viên tự tăng
	private Integer employee_id;
	
	@Column(name = "last_name", columnDefinition = "NVARCHAR(50)", nullable = false) // cột họ nhân viên
	private String lastName;
	
	
	@Column(name = "first_name", columnDefinition = "NVARCHAR(50)", nullable = false) // cột tên nhân viên
	private String firstName;
	
	@Column(name = "gender", columnDefinition = "BIT", nullable = false) // cột giới tính nhân viên
	private boolean gender;
	
	@Column(name = "phone_number", columnDefinition = "VARCHAR(11)", nullable = false) // cột số điện thoại nhân viên
	private String phoneNumber;
	
	@Column(name = "date_of_birth") // cột ngày sinh
	private LocalDate dateOfBirth;
	
	@Column(name = "image_employee", columnDefinition = "VARCHAR(100)", nullable = false) // cột hình ảnh của nhân viên
	private String imageEmployee;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "varchar(50)", nullable = false) // cột enum để xác định vai trò
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "created_by") // cột FK người tạo ra nhân viên (phải có vai trò là admin thì mới được tạo, sửa, xóa) 
	private Employees employee;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY) // cột tạo ràng buộc 1 -1 với user 
	private Users user;
	
	
	
	@Column(name = "create_at") // cột ngày tạo
	private LocalDate createAt;

	@Column(name = "update_at") // cột ngày cập nhật
	private LocalDate updateAt; 
}