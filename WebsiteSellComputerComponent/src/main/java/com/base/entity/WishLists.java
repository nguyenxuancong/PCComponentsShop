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
@Table(name = "wishlists")
public class WishLists {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer wishlist_id;
	
	
	@Column(name = "create_at") 
	private LocalDate createAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
}
