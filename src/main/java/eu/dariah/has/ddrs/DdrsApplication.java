package eu.dariah.has.ddrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by yoann on 12.06.17.
 */
@SpringBootApplication
@EnableCaching
public class DdrsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DdrsApplication.class, args);
    }
}
