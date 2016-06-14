package org.agarage.agaranas.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Nicholas on 2016/6/14.
 */
@SpringBootApplication
public class AGaranasApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AGaranasApplication.class, args);
    }

    public static boolean isWindows() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            return true;
        } else return false;
    }
}
