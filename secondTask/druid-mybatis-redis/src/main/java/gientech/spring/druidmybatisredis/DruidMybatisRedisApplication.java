package gientech.spring.druidmybatisredis;

import gientech.spring.druidmybatisredis.converter.BytesToMoneyConverter;
import gientech.spring.druidmybatisredis.converter.MoneyToBytesConverter;
import gientech.spring.druidmybatisredis.mapper.CoffeeMapper;
import gientech.spring.druidmybatisredis.model.Coffee;
import gientech.spring.druidmybatisredis.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("gientech.spring.druidmybatisredis.mapper")
@EnableRedisRepositories
public class DruidMybatisRedisApplication implements ApplicationRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Autowired
    private CoffeeService coffeeService;

    public static void main(String[] args) {
        SpringApplication.run(DruidMybatisRedisApplication.class, args);
    }

    @Bean
    public RedisTemplate<String, Coffee> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Coffee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(
                Arrays.asList(new MoneyToBytesConverter(), new BytesToMoneyConverter()));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee c = Coffee.builder().name("ruixin")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        coffeeService.saveCoffee(c);
        log.info("Save {} Coffee: {}", c);

        c = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0)).build();
        coffeeService.saveCoffee(c);
        log.info("Save {} Coffee: {}", c);

        c = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0)).build();
        coffeeService.saveCoffee(c);
        log.info("Save {} Coffee: {}", c);

        c = Coffee.builder().name("mocha")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0)).build();
        coffeeService.saveCoffee(c);
        log.info("Save {} Coffee: {}", c);

        Coffee coffeess = coffeeService.getCoffeeById(1L);
        log.info("selectCoffeeById: {}", coffeess);

        c.setPrice(Money.of(CurrencyUnit.of("CNY"), 60.0));
        coffeeService.updateCoffee(c);

        Long[] array = {1L, 2L, 3L, 4L};
        List<Long> coffeeIds = Arrays.asList(array);
        List<Coffee> coffees = coffeeService.selectCoffeeListByIds(coffeeIds);
        log.info("????????????????????????  {}", coffees);

        log.info("??????coffee2222  {}", coffees);
        int count = coffeeService.deleteCoffee(c);
        log.info("????????????  {}", count);

        List<Coffee> coffees1 = coffeeService.selectAllCoffee();
        log.info("??????coffee  {}", coffees);
        coffeeService.selectCoffeeByName("ruixin");

        List<Coffee> allWithParam = coffeeService.findAllWithParam(1, 3);
        log.info("?????????????????? {}", allWithParam);
    }

}
