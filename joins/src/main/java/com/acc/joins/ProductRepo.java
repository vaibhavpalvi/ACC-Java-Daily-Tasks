package com.acc.joins;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{
	
	@Query("SELECT new com.acc.joins.OrderResponce(c.cname, p.pname) FROM CustomerEntity c INNER JOIN c.products p")
	public List<OrderResponce> getInnerJoin();
	
	@Query("SELECT new com.acc.joins.OrderResponce(c.cname, p.pname) FROM CustomerEntity c JOIN c.products p")
	public List<OrderResponce> getCrossJoin();
}
