package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.Category;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@Log4j
@SpringBootTest
class CategoryDaoTest {

    @Autowired
    CategoryDao categoryDao;

    Category category = null;

    @BeforeEach
    void before(){
        category = new Category();
        category.setName("test");
    }

    @Test
    @Transactional
    void crud() {
        //save
        categoryDao.save(category);
        Long id = category.getId();
        Assertions.assertThat(id).isNotNull();

        //find
        Category findCategory = categoryDao.findById(id);
        Assertions.assertThat(findCategory.getId()).isEqualTo(id);

        //update
        category.setName("update");
        categoryDao.update(category);

        Category findUpdateCategory = categoryDao.findById(id);
        Assertions.assertThat(findUpdateCategory.getName()).isEqualTo("update");

        //delete
        categoryDao.delete(id);
        Category deleteCategory = categoryDao.findById(id);
        Assertions.assertThat(deleteCategory).isNull();
    }
}