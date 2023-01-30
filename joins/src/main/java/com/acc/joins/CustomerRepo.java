package com.acc.joins;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{
	
	@Query("SELECT new com.acc.joins.OrderResponce(c.cname, p.pname) FROM CustomerEntity c LEFT JOIN c.products p")
	public List<OrderResponce> getLeftJoin();
	
	@Query("SELECT new com.acc.joins.OrderResponce(c.cname, p.pname) FROM CustomerEntity c RIGHT JOIN c.products p")
	public List<OrderResponce> getRightJoin();
	
	@Query("SELECT new com.acc.joins.OrderResponce(c.cname, p.pname) FROM CustomerEntity c INNER JOIN c.products p")
	public List<OrderResponce> getInner();
}
