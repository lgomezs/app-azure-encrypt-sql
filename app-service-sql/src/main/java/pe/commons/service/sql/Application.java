package pe.commons.service.sql;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "pe.commons")
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .application()
                .run(args);
    }
}
