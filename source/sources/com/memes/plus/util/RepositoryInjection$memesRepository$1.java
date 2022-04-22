package com.memes.plus.util;

import com.memes.plus.data.source.memes.MemesRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RepositoryInjection.kt */
final /* synthetic */ class RepositoryInjection$memesRepository$1 extends MutablePropertyReference0Impl {
    RepositoryInjection$memesRepository$1(RepositoryInjection repositoryInjection) {
        super(repositoryInjection, RepositoryInjection.class, "memesRepositoryInstance", "getMemesRepositoryInstance()Lcom/memes/plus/data/source/memes/MemesRepository;", 0);
    }

    public Object get() {
        return RepositoryInjection.access$getMemesRepositoryInstance$p((RepositoryInjection) this.receiver);
    }

    public void set(Object obj) {
        RepositoryInjection.memesRepositoryInstance = (MemesRepository) obj;
    }
}
