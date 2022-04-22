package com.memes.plus.util;

import com.memes.plus.data.storage.StorageRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RepositoryInjection.kt */
final /* synthetic */ class RepositoryInjection$storageRepository$1 extends MutablePropertyReference0Impl {
    RepositoryInjection$storageRepository$1(RepositoryInjection repositoryInjection) {
        super(repositoryInjection, RepositoryInjection.class, "storageRepositoryInstance", "getStorageRepositoryInstance()Lcom/memes/plus/data/storage/StorageRepository;", 0);
    }

    public Object get() {
        return RepositoryInjection.access$getStorageRepositoryInstance$p((RepositoryInjection) this.receiver);
    }

    public void set(Object obj) {
        RepositoryInjection.storageRepositoryInstance = (StorageRepository) obj;
    }
}
