package com.ace.cloud.component;

import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhangwanli on 2018/5/21.
 */
@Component
public class ApplicationInfoContributor implements InfoContributor, ApplicationListener<ApplicationReadyEvent>, EnvironmentAware {

    private Environment environment;
    private Date upTime = new Date();
    private final FastDateFormat timeFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", environment.getProperty("spring.application.name", "unknown"));
        builder.withDetail("startup-time", timeFormat.format(upTime));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        upTime = new Date();
    }

}
