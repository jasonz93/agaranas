package org.agarage.agaranas.core.controllers;

import org.agarage.agaranas.core.interfaces.FeatureInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Nicholas on 2016/6/14.
 */
@Controller
public class MainController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @RequestMapping("/api/features")
    @ResponseBody
    public Collection<FeatureInterface> getFeatures() {
        Map<String, FeatureInterface> featureMap = applicationContext.getBeansOfType(FeatureInterface.class);
        return featureMap.values();
    }
}
