package com.study.springboot202210changwoo.web.controller;

import com.study.springboot202210changwoo.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition() {
        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request) {
//        System.out.println(request.getParameter("price"));
//        return "product/product_view";
//    }

//    @PostMapping("/api/product") // 가능한 어노테이션 적으셈: 얘가 파라미터다라는 표기를 해야함
//    public String registerProduct(@RequestParam String productCode,
//                                  @RequestParam String productName,
//                                  @RequestParam("price") int price,
//                                  @RequestParam int stock) {
//        System.out.println(productName);
//        System.out.println(price);
//        return "product/product_view";
//    }

    @PostMapping("/api/product") // 가능한 어노테이션 적으셈: 얘가 파라미터다라는 표기를 해야함
    public String registerProduct(Model model, ProductDto productDto) {
        model.addAttribute("productDto", productDto);
        System.out.println(productDto);
        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2() {
        return "product/product_add2";
    }

    // 받는 쪽
    @ResponseBody
    @PostMapping("/api/product/2") // ajax
    public String registerProduct(@RequestBody ProductDto productDto) { // 이 안에 어노테이션 리퀘스트바디가 있으면, 제이슨 형태로 받을 수 있음. // 보내는쪽도 받는 쪽도 제이슨으로 세팅을 해야함.
        System.out.println(productDto);
        return productDto.toString();
        
        // ResponseBody 일 때  public String 스트링이면 텍스트 플레인이고, 그게 아니면 리턴 자료형이 제이슨 형식임
        // ResponseBody 빼먹으면 return "" => 쌍따옴표 안에 들어가있는 텍스트를 Html 파일로 봄. 그래서 주의해야함
        // ResponseBody 때문에 컨트롤러안에 어노테이션 리스폰스바디가 붙으면 데이터 응답이고,
        // 얘가 없으면 리턴에 'view' 를 리턴 해주는거임
        // 뷰리졸버랑 뷰객체가 일할 필요 없이, 걍 컨트롤러에서 디스페쳐서블릿 거쳐서 클라이언트한테 응답됨.
        // 나는 데이터를 응답할것이다라면, 꼭 ResponseBody 를 붙여줘야함.
    }
}
