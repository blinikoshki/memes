package dagger.internal;

import java.lang.ref.WeakReference;
import javax.inject.Provider;

public final class ReferenceReleasingProvider<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object NULL = new Object();
    private final Provider<T> provider;
    private volatile Object strongReference;
    private volatile WeakReference<T> weakReference;

    private ReferenceReleasingProvider(Provider<T> provider2) {
        this.provider = provider2;
    }

    public void releaseStrongReference() {
        Object obj = this.strongReference;
        if (obj != null && obj != NULL) {
            synchronized (this) {
                this.weakReference = new WeakReference<>(obj);
                this.strongReference = null;
            }
        }
    }

    public void restoreStrongReference() {
        Object obj;
        Object obj2 = this.strongReference;
        if (this.weakReference != null && obj2 == null) {
            synchronized (this) {
                Object obj3 = this.strongReference;
                if (!(this.weakReference == null || obj3 != null || (obj = this.weakReference.get()) == null)) {
                    this.strongReference = obj;
                    this.weakReference = null;
                }
            }
        }
    }

    public T get() {
        T currentValue = currentValue();
        if (currentValue == null) {
            synchronized (this) {
                currentValue = currentValue();
                if (currentValue == null) {
                    currentValue = this.provider.get();
                    if (currentValue == null) {
                        currentValue = NULL;
                    }
                    this.strongReference = currentValue;
                }
            }
        }
        if (currentValue == NULL) {
            return null;
        }
        return currentValue;
    }

    private Object currentValue() {
        Object obj = this.strongReference;
        if (obj != null) {
            return obj;
        }
        if (this.weakReference != null) {
            return this.weakReference.get();
        }
        return null;
    }

    public static <T> ReferenceReleasingProvider<T> create(Provider<T> provider2, ReferenceReleasingProviderManager referenceReleasingProviderManager) {
        ReferenceReleasingProvider<T> referenceReleasingProvider = new ReferenceReleasingProvider<>((Provider) Preconditions.checkNotNull(provider2));
        referenceReleasingProviderManager.addProvider(referenceReleasingProvider);
        return referenceReleasingProvider;
    }
}
