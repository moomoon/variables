package com.dxm.variable;

/**
 * Created by phoebe on 21/12/2016.
 */

public interface Var<T> extends Val<T> {
    void set(T t);
}
