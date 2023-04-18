package tads.eaj.ufrn.aularevisao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AulaRevisaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AulaRevisaoApplication.class, args);
    }

}
