package com.wyc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * Swagger2配置类
 * @author 方雷(Rayson)
 * @微信公众号: rayson_666(Rayson开发分享) 、
 * 分享springBoot springCloud技术, 以及python,大数据学习系列
 * @个人博客: http://blog.chargingbunk.cn/
 * @简书: https://www.jianshu.com/u/5b0de5c8dc56
 * 2018年6月9日
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket defaultApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("默认分组").select()
                .apis(RequestHandlerSelectors.basePackage("com.wyc.controller")).paths(PathSelectors.any()).build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    // 预览地址:swagger-ui.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("利用swagger构建测试系统api文档")
                .description("接口访问地址：http://localhost:7004/, by 王越超")
                .termsOfServiceUrl("http://localhost:8080/")
                //.contact("方雷")
                .version("1.0")
                .build();
    }
}
