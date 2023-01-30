package com.acc.joins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponce {
	private String cname;
	private String pname;
	
	
	public OrderResponce(String cname, String pname) {
		super();
		this.cname = cname;
		this.pname = pname;
	}
	private String cgender;
	private String cemail;
	private int price;
	private int qty;
	
}
