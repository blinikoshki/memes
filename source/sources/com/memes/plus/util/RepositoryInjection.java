package com.memes.plus.util;

import android.content.Context;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.source.memes.RemoteMemesDataSource;
import com.memes.plus.data.source.purchase.RemoteStoreDataSource;
import com.memes.plus.data.source.purchase.StoreRepository;
import com.memes.plus.data.storage.SharedPrefStorageDataSource;
import com.memes.plus.data.storage.StorageRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/util/RepositoryInjection;", "", "()V", "memesRepositoryInstance", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepositoryInstance", "Lcom/memes/plus/data/storage/StorageRepository;", "storeRepositoryInstance", "Lcom/memes/plus/data/source/purchase/StoreRepository;", "memesRepository", "storageRepository", "context", "Landroid/content/Context;", "storeRepository", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RepositoryInjection.kt */
public final class RepositoryInjection {
    public static final RepositoryInjection INSTANCE = new RepositoryInjection();
    /* access modifiers changed from: private */
    public static MemesRepository memesRepositoryInstance;
    /* access modifiers changed from: private */
    public static StorageRepository storageRepositoryInstance;
    /* access modifiers changed from: private */
    public static StoreRepository storeRepositoryInstance;

    private RepositoryInjection() {
    }

    public static final /* synthetic */ MemesRepository access$getMemesRepositoryInstance$p(RepositoryInjection repositoryInjection) {
        MemesRepository memesRepository = memesRepositoryInstance;
        if (memesRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memesRepositoryInstance");
        }
        return memesRepository;
    }

    public static final /* synthetic */ StorageRepository access$getStorageRepositoryInstance$p(RepositoryInjection repositoryInjection) {
        StorageRepository storageRepository = storageRepositoryInstance;
        if (storageRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageRepositoryInstance");
        }
        return storageRepository;
    }

    public static final /* synthetic */ StoreRepository access$getStoreRepositoryInstance$p(RepositoryInjection repositoryInjection) {
        StoreRepository storeRepository = storeRepositoryInstance;
        if (storeRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeRepositoryInstance");
        }
        return storeRepository;
    }

    public final MemesRepository memesRepository() {
        if (memesRepositoryInstance == null) {
            memesRepositoryInstance = new MemesRepository(new RemoteMemesDataSource());
        }
        MemesRepository memesRepository = memesRepositoryInstance;
        if (memesRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memesRepositoryInstance");
        }
        return memesRepository;
    }

    public final StoreRepository storeRepository() {
        if (storeRepositoryInstance == null) {
            storeRepositoryInstance = new StoreRepository(new RemoteStoreDataSource());
        }
        StoreRepository storeRepository = storeRepositoryInstance;
        if (storeRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeRepositoryInstance");
        }
        return storeRepository;
    }

    public final StorageRepository storageRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (storageRepositoryInstance == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            storageRepositoryInstance = new StorageRepository(new SharedPrefStorageDataSource(applicationContext));
        }
        StorageRepository storageRepository = storageRepositoryInstance;
        if (storageRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageRepositoryInstance");
        }
        return storageRepository;
    }
}
