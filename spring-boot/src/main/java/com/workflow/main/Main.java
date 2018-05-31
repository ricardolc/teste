package com.workflow.main;



import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://www.ciceroednilson.com.br/desenvolvendo-uma-aplicacao-web-com-angular-4-e-spring-boot-parte-2-criando-o-banco-de-dados/

@SpringBootApplication
@EnableSwagger2

@ComponentScan({"com.workflow.controller"})
@EntityScan("com.workflow.model")
@EnableJpaRepositories("com.workflow.repository")


public class Main {

	public static void main(String[] args) {
		System.getProperties().put( "server.port", 8183 );  //8181 port is set here
		SpringApplication.run(Main.class, args);
	}
	

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("greetings")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/service.*"))
                .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WorkFlow - Documentação Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
	



}
