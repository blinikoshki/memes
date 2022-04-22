package com.memes.plus.base.upgrades;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\t\u001a\u00020\u0004H&R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/base/upgrades/BindingAware;", "BINDING", "", "shouldDestroyBinding", "", "getShouldDestroyBinding", "()Z", "setShouldDestroyBinding", "(Z)V", "hasBinding", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BindingAware.kt */
public interface BindingAware<BINDING> {
    boolean getShouldDestroyBinding();

    boolean hasBinding();

    void setShouldDestroyBinding(boolean z);
}
