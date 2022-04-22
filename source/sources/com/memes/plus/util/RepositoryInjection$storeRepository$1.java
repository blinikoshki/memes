package com.memes.plus.util;

import com.memes.plus.data.source.purchase.StoreRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RepositoryInjection.kt */
final /* synthetic */ class RepositoryInjection$storeRepository$1 extends MutablePropertyReference0Impl {
    RepositoryInjection$storeRepository$1(RepositoryInjection repositoryInjection) {
        super(repositoryInjection, RepositoryInjection.class, "storeRepositoryInstance", "getStoreRepositoryInstance()Lcom/memes/plus/data/source/purchase/StoreRepository;", 0);
    }

    public Object get() {
        return RepositoryInjection.access$getStoreRepositoryInstance$p((RepositoryInjection) this.receiver);
    }

    public void set(Object obj) {
        RepositoryInjection.storeRepositoryInstance = (StoreRepository) obj;
    }
}
