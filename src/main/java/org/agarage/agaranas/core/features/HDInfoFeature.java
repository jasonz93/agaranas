package org.agarage.agaranas.core.features;

import org.agarage.agaranas.core.interfaces.FeatureInterface;
import org.agarage.agaranas.core.interfaces.HDInfoDriverInterface;
import org.agarage.agaranas.core.models.HDInfo;
import org.agarage.agaranas.core.models.MenuItem;
import org.agarage.agaranas.core.models.StorageAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
@Controller
public class HDInfoFeature implements FeatureInterface {
    @Autowired
    private HDInfoDriverInterface hdInfoDriver;

    @Override
    public String getDisplayCategory() {
        return "System";
    }

    @Override
    public MenuItem getMenuItem() {
        MenuItem item = new MenuItem();
        item.setDisplayName("Harddisk Info");
        return item;
    }

    @RequestMapping("/api/storage/hdinfos")
    @ResponseBody
    public List<HDInfo> getHDInfos() {
        return hdInfoDriver.getHDInfos();
    }

    @RequestMapping("/api/storage/adapters")
    @ResponseBody
    public List<StorageAdapter> getStorageAdapters() {
        return hdInfoDriver.getStorageAdapters();
    }
}
