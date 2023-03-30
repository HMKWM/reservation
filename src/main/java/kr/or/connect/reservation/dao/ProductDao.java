package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.ApiProduct;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {

    void save(Product product);

    Product findById(Long id);

    List<ApiProduct> findAll(@Param("categoryId")Long categoryId, @Param("start") int start);

    void update(Product product);

    void delete(Long id);

    int count(Long categoryId);
}
