package org.agarage.agaranas.core.drivers;

import org.agarage.agaranas.core.exceptions.MissingDependencyException;
import org.agarage.agaranas.core.interfaces.SystemInfoDriverInterface;
import org.agarage.agaranas.core.models.SystemInfo;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
@Service
public class SigarSystemInfoDriver implements SystemInfoDriverInterface {
    @Autowired
    private Sigar sigar;

    @Override
    public List<String> getCPUs() {
        try {
            CpuInfo[] cpuInfos = sigar.getCpuInfoList();
            List<String> cpuList = new ArrayList<String>(cpuInfos.length);
            for (int i = 0; i < cpuInfos.length; i ++) {
                cpuList.add(String.format("%s %s", cpuInfos[i].getVendor(), cpuInfos[i].getModel()));
            }
            return cpuList;
        } catch (SigarException e) {
            e.printStackTrace();
            return new ArrayList<String>(0);
        }
    }

    @Override
    public String getOS() {
        return System.getProperty("os.name");
    }

    @Override
    public double[] getLoad() {
        try {
            return sigar.getLoadAverage();
        } catch (SigarException e) {
            e.printStackTrace();
            return new double[]{-1, -1, -1};
        }
    }

    @Override
    public double getUptime() {
        try {
            return sigar.getUptime().getUptime();
        } catch (SigarException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
