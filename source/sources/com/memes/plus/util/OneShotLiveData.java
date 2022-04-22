package com.memes.plus.util;

import androidx.lifecycle.LiveData;
import com.memes.commons.util.SingleLiveEvent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/util/OneShotLiveData;", "Lcom/memes/commons/util/SingleLiveEvent;", "", "()V", "fire", "", "pewpewpew", "shoot", "silkTouch", "Landroidx/lifecycle/LiveData;", "thahthah", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OneShotLiveData.kt */
public final class OneShotLiveData extends SingleLiveEvent<Boolean> {
    public final LiveData<Boolean> silkTouch() {
        return this;
    }

    public final void fire() {
        setValue(true);
    }

    public final void shoot() {
        setValue(true);
    }

    public final void pewpewpew() {
        setValue(true);
    }

    public final void thahthah() {
        setValue(true);
    }
}
