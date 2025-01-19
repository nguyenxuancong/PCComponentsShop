package com.base.entity;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipping_methods")
public class Shipping_Methods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer shipping_id;

	@Column(name = "shipping_name", columnDefinition = "nvarchar(255)", nullable = false) 
	private String shippingName;

	@Column(name = "delivery_time", columnDefinition = "date", nullable = false) 
	private String deliveryTime;

	@Column(name = "cost", columnDefinition = "demical(10, 2)", nullable = false) 
	private String cost;


	@Column(name = "create_at") 
	private LocalDate createAt;

	@Column(name = "update_at") 
	private LocalDate updateAt;
	
//	@OneToMany(mappedBy = "shipping_method", cascade = CascadeType.ALL, orphanRemoval = true) 
//	private List<Orders> listOrders;

}
