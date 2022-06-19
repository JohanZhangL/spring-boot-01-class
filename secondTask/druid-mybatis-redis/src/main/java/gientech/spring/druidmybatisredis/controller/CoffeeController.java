package gientech.spring.druidmybatisredis.controller;

import gientech.spring.druidmybatisredis.model.Coffee;
import gientech.spring.druidmybatisredis.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "/",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Coffee> selectAllCoffee() {
        return coffeeService.selectAllCoffee();

    }
}
