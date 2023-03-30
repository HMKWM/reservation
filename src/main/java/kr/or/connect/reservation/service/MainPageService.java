package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.ApiProduct;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.ApiCategory;
import kr.or.connect.reservation.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageService {

    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    public int getCategorySize(){
        return categoryDao.count();
    }

    public List<ApiCategory> getCategoryList(){
        return categoryDao.getCategoryList();
    }

    public int getProductTotalSize(Long categoryId){
        return productDao.count(categoryId);
    }

    public List<ApiProduct> getProductList(Long categoryId, Integer start){
        List<ApiProduct> list = productDao.findAll(categoryId, start);
        return list;
    }
}
