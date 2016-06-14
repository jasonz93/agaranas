package org.agarage.agaranas.core.drivers;

import org.agarage.agaranas.core.interfaces.HDInfoDriverInterface;
import org.agarage.agaranas.core.models.HDInfo;
import org.agarage.agaranas.core.models.StorageAdapter;
import org.agarage.agaranas.core.utils.ShellUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nicholas on 2016/6/15.
 */
public class LinuxHDInfoDriver implements HDInfoDriverInterface {

    @Override
    public List<HDInfo> getHDInfos() {
        ShellUtils.CommandResult scanResult = ShellUtils.execCommand("smartctl --scan", true);
        String[] scanLines = scanResult.successMsg.split("\n");
        List<String> disks = new ArrayList<String>(scanLines.length);
        for (String scanLine : scanLines) {
            String[] parts = scanLine.split(" ");
            if (parts.length > 0) disks.add(parts[0]);
        }
        List<HDInfo> hdInfos = new ArrayList<HDInfo>(disks.size());
        for (String disk : disks) {
            HDInfo hdInfo = new HDInfo();
            ShellUtils.CommandResult infoResult = ShellUtils.execCommand("smartctl --info " + disk, true);
            String[] lines = infoResult.successMsg.split("\n");
            int i = 0;
            for (; i < lines.length; i ++) {
                if (lines[i].startsWith("=== START OF INFORMATION SECTION ===")) break;
            }
            Map<String, String> infoMap = new LinkedHashMap<String, String>();
            for (i ++; i < lines.length; i ++) {
                if (lines[i].startsWith("=== START OF READ SMART DATA SECTION ===")) break;
                int pos = lines[i].indexOf(':');
                infoMap.put(lines[i].substring(0, pos - 1), lines[i].substring(pos + 1).trim());
            }
            hdInfo.setId(disk);
            hdInfo.setName(infoMap.get("Product"));
            String capStr = infoMap.get("User Capacity");
            int pos = capStr.indexOf("bytes");
            hdInfo.setCapacity(Long.parseLong(capStr.substring(0, pos - 1).trim().replace(",", "")));
            String smartSupport = infoMap.get("SMART support is");
            if (smartSupport.startsWith("Enabled")) hdInfo.setSmartStatus(HDInfo.SMARTStatus.ENABLED);
            else if (smartSupport.startsWith("Disabled")) hdInfo.setSmartStatus(HDInfo.SMARTStatus.DISABLED);
            else hdInfo.setSmartStatus(HDInfo.SMARTStatus.UNAVAILABLE);
            hdInfos.add(hdInfo);
        }
        return hdInfos;
    }
}
