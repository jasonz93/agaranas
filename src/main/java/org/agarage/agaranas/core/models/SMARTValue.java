package org.agarage.agaranas.core.models;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class SMARTValue {
    private Integer id;
    private Integer threshold;
    private Integer normalized;
    private Integer worst;
    private Integer raw;
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getNormalized() {
        return normalized;
    }

    public void setNormalized(Integer normalized) {
        this.normalized = normalized;
    }

    public Integer getWorst() {
        return worst;
    }

    public void setWorst(Integer worst) {
        this.worst = worst;
    }

    public Integer getRaw() {
        return raw;
    }

    public void setRaw(Integer raw) {
        this.raw = raw;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    enum Status {
        NORMAL, WARNING, FAILURE;
    }
}
