package org.agarage.agaranas.core.drivers;

import org.agarage.agaranas.core.interfaces.HDInfoDriverInterface;
import org.agarage.agaranas.core.models.HDInfo;
import org.agarage.agaranas.core.models.StorageAdapter;
import org.agarage.agaranas.core.utils.CMDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class WindowsHDInfoDriver implements HDInfoDriverInterface {
    private final static int BUFFER_SIZE = 4096;

    @Override
    public List<StorageAdapter> getStorageAdapters() {
        List<StorageAdapter> storageAdapters = new ArrayList<StorageAdapter>();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("wmic idecontroller");
            byte[] buffer = new byte[BUFFER_SIZE];
            int count;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((count = process.getInputStream().read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            String result = baos.toString("GBK");
            List<Map<String, String>> adapterMaps = CMDUtils.tableToMaps(result);
            for (Map<String, String> adapterMap : adapterMaps) {
                StorageAdapter storageAdapter = new StorageAdapter();
                storageAdapter.setName(adapterMap.get("Name"));
                storageAdapters.add(storageAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return storageAdapters;
        }
    }

    @Override
    public List<HDInfo> getHDInfos() {
        List<HDInfo> hdInfos = new ArrayList<HDInfo>();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("wmic diskdrive");
            byte[] buffer = new byte[BUFFER_SIZE];
            int count;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((count = process.getInputStream().read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            String result = baos.toString("GBK");
            List<Map<String, String>> hdInfoMaps = CMDUtils.tableToMaps(result);
            for (Map<String, String> hdInfoMap : hdInfoMaps) {
                HDInfo hdInfo = new HDInfo();
                hdInfo.setId(hdInfoMap.get("DeviceID"));
                hdInfo.setName(hdInfoMap.get("Model"));
                hdInfo.setCapacity(Long.parseLong(hdInfoMap.get("Size")));
                hdInfos.add(hdInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return hdInfos;
        }
    }
}
