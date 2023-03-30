package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    Product product = null;

    @BeforeEach
    void before(){
        product = new Product();
        product.setCategoryId(1L);
    }

    @Test
    @Transactional
    void crud() {
        //save
        productDao.save(product);
        Long id = product.getId();
        Assertions.assertThat(id).isNotNull();

        //find
        Product findProduct = productDao.findById(id);
        Assertions.assertThat(findProduct).isNotNull();

        //update
        product.setCategoryId(2L);
        productDao.update(product);
        Product findUpdateProduct = productDao.findById(id);
        Assertions.assertThat(findUpdateProduct.getCategoryId()).isEqualTo(2L);

        //delete
        productDao.delete(id);
        Product findDeleteProduct = productDao.findById(id);
        Assertions.assertThat(findDeleteProduct).isNull();
    }
}