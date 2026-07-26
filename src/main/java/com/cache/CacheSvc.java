package com.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class CacheSvc {

	// 1) Read from cache if available
	@Cacheable("products")
	public String getProductById(Long id) {
		return "karuna";
	}

	// 2) Always run method and update cache
	@CachePut(value = "products", key = "#result.id")
	public String updateProduct(String product) {
		return "";
	}

	// 3) Remove one item from cache
	@CacheEvict(value = "products", key = "#id")
	public void deleteProduct(Long id) {
	}

}
