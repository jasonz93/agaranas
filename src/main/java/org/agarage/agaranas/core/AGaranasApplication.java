package org.agarage.agaranas.core;

import org.agarage.agaranas.core.utils.ShellUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;


/**
 * Created by Nicholas on 2016/6/14.
 */
@SpringBootApplication
@PropertySource("classpath:agaranas.properties")
public class AGaranasApplication {

    @Value("${system.rootpwd}")
    private String rootPwd;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AGaranasApplication.class, args);
    }

    @PostConstruct
    public void setStaticConfigurations() {
        ShellUtils.setRootPwd(rootPwd);
        LoggerFactory.getLogger("System").info("Root Password: " + rootPwd);
    }

    public static boolean isWindows() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            return true;
        } else return false;
    }
}
