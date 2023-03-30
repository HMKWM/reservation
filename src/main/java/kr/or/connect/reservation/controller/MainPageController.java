package kr.or.connect.reservation.controller;

import kr.or.connect.reservation.dto.ApiCategory;
import kr.or.connect.reservation.dto.ApiProduct;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping("/api/categories")
    @ResponseBody
    public Map<String, Object> categories(){
        Map map = new LinkedHashMap();
        int size = mainPageService.getCategorySize();
        List<ApiCategory> categoryList = mainPageService.getCategoryList();

        map.put("size", size);
        map.put("items", categoryList);

        return map;
    }

    @GetMapping("/api/displayinfos")
    public Map<String, Object> displayInfos(
            @RequestParam(defaultValue = "0" ,required = false) Long categoryId,
            @RequestParam(defaultValue = "0" ,required = false) Integer start){

        System.out.println("categoryId = " + categoryId);
        Map map = new LinkedHashMap();
        int totalCount = mainPageService.getProductTotalSize(categoryId);
        List<ApiProduct> productList = mainPageService.getProductList(categoryId, start);

        map.put("totalCount", totalCount);
        map.put("productCount", "4");
        map.put("products", productList);

        return map;
    }
}

