package org.agarage.agaranas.core.beans;

import org.hyperic.sigar.Sigar;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Nicholas on 2016/6/14.
 */

@Component
public class SigarBean {
    @Bean
    public Sigar sigar() {
        return new Sigar();
    }
}
