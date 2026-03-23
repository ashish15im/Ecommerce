package com.ecommerce.sb_ecom.com.ecommerce.sb_ecom;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository<Category,Long> {

}
