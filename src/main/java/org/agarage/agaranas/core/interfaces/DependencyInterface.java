package org.agarage.agaranas.core.interfaces;

import org.agarage.agaranas.core.exceptions.MissingDependencyException;

import java.util.List;

/**
 * Created by Nicholas on 2016/6/14.
 */
public interface DependencyInterface {
    void checkDependencies() throws MissingDependencyException;
}
