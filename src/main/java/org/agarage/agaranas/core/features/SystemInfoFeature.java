package org.agarage.agaranas.core.features;

import org.agarage.agaranas.core.exceptions.MissingDependencyException;
import org.agarage.agaranas.core.interfaces.FeatureInterface;
import org.agarage.agaranas.core.interfaces.SystemInfoDriverInterface;
import org.agarage.agaranas.core.models.MenuItem;
import org.agarage.agaranas.core.models.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
@Service
@Controller
public class SystemInfoFeature implements FeatureInterface {
    @Autowired
    SystemInfoDriverInterface systemInfoDriver;

    @Override
    public String getDisplayCategory() {
        return "System";
    }

    @Override
    public MenuItem getMenuItem() {
        MenuItem item = new MenuItem();
        item.setDisplayName("System Info");
        return item;
    }

    @RequestMapping("/api/system/info")
    @ResponseBody
    public SystemInfo getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setCpus(systemInfoDriver.getCPUs());
        systemInfo.setOS(systemInfoDriver.getOS());
        systemInfo.setLoad(systemInfoDriver.getLoad());
        systemInfo.setUptime(systemInfoDriver.getUptime());
        return systemInfo;
    }
}
