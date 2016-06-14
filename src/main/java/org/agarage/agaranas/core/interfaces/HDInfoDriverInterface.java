package org.agarage.agaranas.core.interfaces;

import org.agarage.agaranas.core.models.HDInfo;
import org.agarage.agaranas.core.models.StorageAdapter;

import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
public interface HDInfoDriverInterface extends DriverInterface {
    List<HDInfo> getHDInfos();
}
