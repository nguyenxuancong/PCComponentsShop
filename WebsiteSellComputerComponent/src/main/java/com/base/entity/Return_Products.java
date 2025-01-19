package com.base.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "return_products")
public class Return_Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer return_id;
	
	
	@Column(name = "reason", columnDefinition = "NVARCHAR(255)", nullable = false) 
	private String reason;
	
	
	@Column(name = "status", columnDefinition = "NVARCHAR(50)", nullable = false) 
	private String status;
	
	
	
	@Column(name = "create_at") 
	private LocalDate createAt;
	
//	@OneToMany(mappedBy = "return_product", cascade = CascadeType.ALL, orphanRemoval = true) 
//	private List<Products> listProducts;
	
//	@ManyToOne
//	@JoinColumn(name = "order_id") 
//	private Orders order;
//	


	

}
