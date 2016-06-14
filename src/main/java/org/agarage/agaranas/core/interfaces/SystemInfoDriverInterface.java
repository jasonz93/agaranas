package org.agarage.agaranas.core.interfaces;

import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
public interface SystemInfoDriverInterface extends DriverInterface {
    List<String> getCPUs();
    String getOS();
    double[] getLoad();
    double getUptime();
}
