package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.config;

//import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.controllers")).paths(PathSelectors.any()).build();
	}

	 //Acceso a localhost swagger2 - http://localhost:9001/v2/api-docs y http://localhost:9001/swagger-ui.html
}