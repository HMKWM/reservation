package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.ApiCategory;
import kr.or.connect.reservation.dto.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

    void save(Category category);

    Category findById(Long id);

    List<Category> findAll();

    void update(Category category);

    void delete(Long id);

    int count();

    List<ApiCategory> getCategoryList();
}
