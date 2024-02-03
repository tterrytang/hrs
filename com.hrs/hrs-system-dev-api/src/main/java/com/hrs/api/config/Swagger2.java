package com.hrs.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    //    http://localhost:8088/swagger-ui.html
    //    http://localhost:8088/doc.html

    // swagger2 docket
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> adminPredicate = RequestHandlerSelectors.basePackage("com.hrs.admin.controller");
//        Predicate<RequestHandler> articlePredicate = RequestHandlerSelectors.basePackage("com.hrs.article.controller");
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors.basePackage("com.hrs.user.controller");
        Predicate<RequestHandler> filesPredicate = RequestHandlerSelectors.basePackage("com.hrs.files.controller");

        return new Docket(DocumentationType.SWAGGER_2)  // api swagger2
                .apiInfo(apiInfo())                 // api
                .select()
                .apis(Predicates.or(userPredicate, adminPredicate, filesPredicate))
//                .apis(Predicates.or(adminPredicate, articlePredicate, userPredicate, filesPredicate))
                .paths(PathSelectors.any())         // controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API")                       //
                .contact(new Contact("hrs",
                        "https://www.hrs.com",
                        "hrs@hrs.com"))                   //
                .description("api documentation")      //
                .version("1.0.1")                               //
                .termsOfServiceUrl("https://www.hrs.com")     //
                .build();
    }
}
