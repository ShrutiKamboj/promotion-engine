package com.engine.promote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROMOTIONS")
@Getter
@Setter
public class Promotions {

	@Id
	@Column(name = "ITEM")
	public String Item;
	
	@Column(name = "ACTIVE")
	public boolean active;
	
	@Column(name = "PROMOTION")
	public String promotion;
	
	@Column(name = "PROMOLIMIT")
	public int limit;
	
	@Column(name = "Price")
	public double pPrice;
	
}
