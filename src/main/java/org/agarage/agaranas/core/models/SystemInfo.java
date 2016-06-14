package org.agarage.agaranas.core.models;

import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class SystemInfo {
    private List<String> cpus;
    private String os;
    private double[] load;
    private double uptime;

    public List<String> getCpus() {
        return cpus;
    }

    public void setCpus(List<String> cpus) {
        this.cpus = cpus;
    }

    public String getOS() {
        return os;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public double[] getLoad() {
        return load;
    }

    public void setLoad(double[] load) {
        this.load = load;
    }

    public double getUptime() {
        return uptime;
    }

    public void setUptime(double uptime) {
        this.uptime = uptime;
    }
}
