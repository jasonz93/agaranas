package org.agarage.agaranas.core.interfaces;

import org.agarage.agaranas.core.models.MenuItem;

/**
 * Created by Nicholas on 2016/6/14.
 */
public interface FeatureInterface extends ServiceInterface {
    String getDisplayCategory();
    MenuItem getMenuItem();
}
