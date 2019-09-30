package com.web_services.instant_pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Order implements Serializable {
	@Id
	@Column (name="order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="order")
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_order_owner")
	
	private Customer orderOwner;
	
	private String orderDetail;
	
	private String orderStatus;
	
	private String orderPayment;
	
	
	public String getOrderOwner(){
		return orderOwner;
	}
	
	public void setOrderOwner(String orderOwner){
		this.orderOwner = orderOwner;
	} 
	
	public String getOrderDetail(){
		return orderDetail;
	}
	
	
	public void setOrderDetail(String orderDetail){
		this.orderDetail = orderDetail;
	}
	
	public String getOrderStatus(){
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus){
		this.orderStatus =  orderStatus;
	}
	
	public double getOrderPayment(){
		return orderPayment;
	}
	
	public void setOrderPayment(String orderPayment){
		this.orderPayment = orderPayment;
	}
	
	
	@Override
	public String toString() {
		return "Order Details: ID=" + this.id + "Name=" + this.name + ", Description= " + this.orderDetail + ", Status= " + this.orderStatus + ", Order Owner= '" + this.orderOwner + "', Order Payment= " + this.orderPayment;
	}
}