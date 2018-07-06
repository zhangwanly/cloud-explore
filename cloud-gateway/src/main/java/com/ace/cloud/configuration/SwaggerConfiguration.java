package com.ace.cloud.configuration;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangwanli on 2018/6/12.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private List<ResponseMessage> globalResponseMessage = Lists.newArrayList();

    @Bean
    public Docket appDoc() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(appApiInfo())
                .directModelSubstitute(Date.class, Double.class)
                .directModelSubstitute(LocalDate.class, Double.class)
                .directModelSubstitute(Byte.class, Integer.class)
                .globalOperationParameters(pars)
                .globalResponseMessage(RequestMethod.GET, globalResponseMessage)
                .globalResponseMessage(RequestMethod.POST, globalResponseMessage)
                .globalResponseMessage(RequestMethod.PUT, globalResponseMessage)
                .globalResponseMessage(RequestMethod.DELETE, globalResponseMessage)
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ace.explore.cloud.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo appApiInfo() {
        List<String> descs = Lists.newArrayList(
                "401:\t{\"message\":\"用户未登录\"}",
                "403:\t{\"message\":\"禁止访问\"}",
                "406:\t业务条件不满足,具体信息参照message",
                "500:\t{\"message\":\"服务器开小差了\"}"
        );
        return new ApiInfoBuilder()
                .title("gateway 接口文档")
                .description(Joiner.on("\n").join(descs))
                .version("1.0.0")
                .build();
    }

}
