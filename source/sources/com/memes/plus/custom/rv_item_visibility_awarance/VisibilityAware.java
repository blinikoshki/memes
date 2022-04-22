package com.memes.plus.custom.rv_item_visibility_awarance;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/custom/rv_item_visibility_awarance/VisibilityAware;", "", "getVisibilityTargetView", "Landroid/view/View;", "onVisibilityChanged", "", "newVisibility", "", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: VisibilityAware.kt */
public interface VisibilityAware {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int INVISIBLE = 2;
    public static final int VISIBLE = 1;

    View getVisibilityTargetView();

    void onVisibilityChanged(int i);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/custom/rv_item_visibility_awarance/VisibilityAware$Companion;", "", "()V", "INVISIBLE", "", "VISIBLE", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: VisibilityAware.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int INVISIBLE = 2;
        public static final int VISIBLE = 1;

        private Companion() {
        }
    }
}
