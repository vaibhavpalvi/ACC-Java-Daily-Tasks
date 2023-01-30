package com.acc.joins;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerEntity {
	@Id
	private int cid;
	private String cname;
	private String cgender;
	private String cemail;
	
	@OneToMany(targetEntity = ProductEntity.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_pr" , referencedColumnName = "cid")
	@Fetch(FetchMode.JOIN)
	private List<ProductEntity> products;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "CustomerEntity [cid=" + cid + ", cname=" + cname + ", cgender=" + cgender + ", cemail=" + cemail
				+ ", products=" + products + "]";
	}
	
	
}
