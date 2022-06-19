package geektime.spring.springbucks.controller;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author BFSI1_BUTF_DEL4_SD3_P0130317_廖秋冰
 * @site http://www.pactera-fintech.com/
 * @company 中电金信软件有限公司
 * @create 2022-06-11 21:35
 */
@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;


    //返回json数据格式
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Coffee getCoffeeById(@PathVariable Long id) {
        Coffee coffee = coffeeService.getCoffeeById(id);
        return coffee;
    }

    //返回xml数据格式
    @GetMapping(path = "/",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Coffee> selectAllCoffee() {
        return coffeeService.selectAllCoffee();

    }


}
