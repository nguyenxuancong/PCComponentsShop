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
@Table(name = "payment_method")
public class Payment_method {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer payment_id;
	
	
	@Column(name = "card_number", columnDefinition = "varchar(20)", nullable = false) 
	private String card_number;
	
	
	@Column(name = "card_holder_name", columnDefinition = "VARCHAR(100)", nullable = false) 
	private String cardHolderName;
	
	
	@Column(name = "expiry_date", columnDefinition = "date", nullable = false) 
	private boolean expiryDate;
	
	@Column(name = "payment_type", columnDefinition = "VARCHAR(50)", nullable = false) 
	private String paymentType;
	
	@Column(name = "is_default")
	private boolean isDefault = false;
	
	
	@Column(name = "create_at") 
	private LocalDate createAt;

	@Column(name = "update_at") 
	private LocalDate updateAt;
	
//	@OneToMany(mappedBy = "payment_method", cascade = CascadeType.ALL, orphanRemoval = true) 
//	private List<Orders> listOrders;
}
