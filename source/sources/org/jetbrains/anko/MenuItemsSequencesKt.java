package org.jetbrains.anko;

import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, mo26107d2 = {"itemsSequence", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "commons_release"}, mo26108k = 2, mo26109mv = {1, 1, 5})
/* compiled from: menuItemsSequences.kt */
public final class MenuItemsSequencesKt {
    public static final Sequence<MenuItem> itemsSequence(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$receiver");
        return new MenuItemsSequence(menu);
    }
}
