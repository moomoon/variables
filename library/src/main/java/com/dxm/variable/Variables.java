package com.dxm.variable;

/**
 * Created by phoebe on 21/12/2016.
 */

public class Variables {

    public static <T> T requireNotNull(T o) {
        if (null == o) throw new IllegalArgumentException("value should not be null");
        return o;
    }

    public abstract static class Lazy<T> implements Val<T> {
        private volatile T value;

        @Override public T get() {
            T v;
            if (null == (v = value)) {
                synchronized (this) {
                    if (null == (v = value)) {
                        v = value = requireNotNull(create());
                    }
                }
            }
            return v;
        }

        public abstract T create();
    }

    private abstract static class BaseVariable<T> implements Var<T> {
        private T value;

        private BaseVariable(T initialValue) {
            this.value = requireNotNull(initialValue);
        }

        @Override public T get() {
            return value;
        }

        @Override public void set(T t) {
            value = requireNotNull(t);
        }

    }

    public static abstract class Vetoable<T> extends BaseVariable<T> {
        public Vetoable(T initialValue) {
            super(initialValue);
        }

        @Override public void set(T t) {
            if (shouldChange(get(), requireNotNull(t)))
                super.set(t);
        }

        public abstract boolean shouldChange(T oldValue, T newValue);

    }

    public static abstract class Observable<T> extends Vetoable<T> {
        public Observable(T initialValue) {
            super(initialValue);
        }

        @Override public boolean shouldChange(T oldValue, T newValue) {
            onChange(oldValue, newValue);
            return true;
        }

        public abstract void onChange(T oldValue, T newValue);
    }
}
