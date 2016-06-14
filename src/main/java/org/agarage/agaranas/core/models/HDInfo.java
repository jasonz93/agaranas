package org.agarage.agaranas.core.models;

import java.util.Map;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class HDInfo {
    private String id;
    private String name;
    private Long capacity;
    private Map<Integer, SMARTValue> smart;
    private StorageAdapter adapter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Map<Integer, SMARTValue> getSmart() {
        return smart;
    }

    public void setSmart(Map<Integer, SMARTValue> smart) {
        this.smart = smart;
    }

    public StorageAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(StorageAdapter adapter) {
        this.adapter = adapter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
