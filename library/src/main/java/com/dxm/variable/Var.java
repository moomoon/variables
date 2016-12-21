package com.dxm.variable;

/**
 * Created by phoebe on 21/12/2016.
 */

interface Var<T> extends Val<T> {
    void set(T t);
}
