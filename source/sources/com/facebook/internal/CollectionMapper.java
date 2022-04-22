package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionMapper {

    public interface Collection<T> {
        Object get(T t);

        Iterator<T> keyIterator();

        void set(T t, Object obj, OnErrorListener onErrorListener);
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    public static <T> void iterate(final Collection<T> collection, ValueMapper valueMapper, final OnMapperCompleteListener onMapperCompleteListener) {
        final Mutable mutable = new Mutable(false);
        final Mutable mutable2 = new Mutable(1);
        final C14581 r3 = new OnMapperCompleteListener() {
            public void onComplete() {
                if (!((Boolean) mutable.value).booleanValue()) {
                    Mutable mutable = mutable2;
                    T valueOf = Integer.valueOf(((Integer) mutable.value).intValue() - 1);
                    mutable.value = valueOf;
                    if (valueOf.intValue() == 0) {
                        onMapperCompleteListener.onComplete();
                    }
                }
            }

            public void onError(FacebookException facebookException) {
                if (!((Boolean) mutable.value).booleanValue()) {
                    mutable.value = true;
                    onMapperCompleteListener.onError(facebookException);
                }
            }
        };
        Iterator<T> keyIterator = collection.keyIterator();
        LinkedList linkedList = new LinkedList();
        while (keyIterator.hasNext()) {
            linkedList.add(keyIterator.next());
        }
        for (final Object next : linkedList) {
            Object obj = collection.get(next);
            C14592 r5 = new OnMapValueCompleteListener() {
                public void onComplete(Object obj) {
                    collection.set(next, obj, r3);
                    r3.onComplete();
                }

                public void onError(FacebookException facebookException) {
                    r3.onError(facebookException);
                }
            };
            Integer num = (Integer) mutable2.value;
            mutable2.value = Integer.valueOf(((Integer) mutable2.value).intValue() + 1);
            valueMapper.mapValue(obj, r5);
        }
        r3.onComplete();
    }

    private CollectionMapper() {
    }
}
