package com.dxm.variable;

/**
 * Created by phoebe on 21/12/2016.
 */

public class Variables {
    private Variables() {

    }

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

        protected abstract T create();
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

    public static abstract class Vetoable<T> extends Observable<T> {
        public Vetoable(T initialValue) {
            super(initialValue);
        }

        @Override public boolean beforeChange(T oldValue, T newValue) {
            return shouldChange(oldValue, newValue);
        }

        protected abstract boolean shouldChange(T oldValue, T newValue);

        @Override protected void onChange(T oldValue, T newValue) {

        }
    }

    public static abstract class Observable<T> extends BaseVariable<T> {
        public Observable(T initialValue) {
            super(initialValue);
        }

        public boolean beforeChange(T oldValue, T newValue) {
            return true;
        }

        @Override public void set(T t) {
            if (!beforeChange(get(), requireNotNull(t))) return;
            T current = get();
            super.set(t);
            onChange(current, t);

        }

        protected abstract void onChange(T oldValue, T newValue);
    }
}
