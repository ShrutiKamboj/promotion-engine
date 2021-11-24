package com.engine.promote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SK_Unit_Price")
@Getter
@Setter
public class UnitPrice {

	@Id
	@Column(name = "ITEM")
	public String item;
	
	@Column(name = "PRICE")
	public int price;

}
