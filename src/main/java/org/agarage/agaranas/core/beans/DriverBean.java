package org.agarage.agaranas.core.beans;

import org.agarage.agaranas.core.drivers.LinuxHDInfoDriver;
import org.agarage.agaranas.core.drivers.WindowsHDInfoDriver;
import org.agarage.agaranas.core.interfaces.HDInfoDriverInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nicholas on 2016/6/14.
 */
@Configuration
public class DriverBean {
    @Bean
    public HDInfoDriverInterface hdInfoDriver() {
        if (isWindows()) {
            return new WindowsHDInfoDriver();
        } else {
            return new LinuxHDInfoDriver();
        }
    }

    public static boolean isWindows() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            return true;
        } else return false;
    }
}
