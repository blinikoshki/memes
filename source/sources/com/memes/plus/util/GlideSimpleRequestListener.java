package com.memes.plus.util;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B,\u0012%\b\u0002\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ4\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016JC\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0017R+\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/util/GlideSimpleRequestListener;", "T", "Lcom/bumptech/glide/request/RequestListener;", "loadCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "loaded", "", "(Lkotlin/jvm/functions/Function1;)V", "onLoadFailed", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GlideSimpleRequestListener.kt */
public final class GlideSimpleRequestListener<T> implements RequestListener<T> {
    private final Function1<Boolean, Unit> loadCallback;

    public GlideSimpleRequestListener() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    public GlideSimpleRequestListener(Function1<? super Boolean, Unit> function1) {
        this.loadCallback = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlideSimpleRequestListener(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    public boolean onResourceReady(T t, Object obj, Target<T> target, DataSource dataSource, boolean z) {
        Function1<Boolean, Unit> function1 = this.loadCallback;
        if (function1 == null) {
            return false;
        }
        Unit invoke = function1.invoke(true);
        return false;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<T> target, boolean z) {
        Function1<Boolean, Unit> function1 = this.loadCallback;
        if (function1 != null) {
            Unit invoke = function1.invoke(false);
        }
        return false;
    }
}
