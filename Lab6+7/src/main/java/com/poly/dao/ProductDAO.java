package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.model.Product;
import com.poly.model.Report;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	@Query("SELECT o.category AS group, sum(o.price) AS sum, count(o) AS count " + " FROM Product o "
			+ " GROUP BY o.category" + " ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByCategory();

}
