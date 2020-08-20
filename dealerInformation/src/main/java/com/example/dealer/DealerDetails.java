package com.example.dealer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dealerdetails")
public class DealerDetails {

    @Id
	private Long id;
    
    @Column(name="name")
	private String name;
    
    @Column(name="city")
	private String city;
    
    @Column(name="total_sale")
	private int totalSale;
	
    public DealerDetails() {
        super();
     }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}
	
	
	
}
