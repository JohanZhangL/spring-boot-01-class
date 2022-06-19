package geektime.spring.springbucks.mapper;

import geektime.spring.springbucks.model.Coffee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CoffeeMapper {

    void saveCoffee(Coffee coffee);

    List<Coffee> selectCoffeeListByIds(@Param("coffeeIds") List<Long> coffeeIds);

    Coffee selectCoffeeByName(String name);

    Coffee getCoffeeById(Long id);

    List<Coffee> selectAllCoffee();

    void updateCoffee(Coffee coffee);

    int deleteCoffee(Coffee coffee);

    //分页操作
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}
