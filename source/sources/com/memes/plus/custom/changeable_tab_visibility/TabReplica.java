package com.memes.plus.custom.changeable_tab_visibility;

import android.graphics.drawable.Drawable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/plus/custom/changeable_tab_visibility/TabReplica;", "", "title", "", "icon", "Landroid/graphics/drawable/Drawable;", "identifier", "(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;)V", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "getIdentifier", "()Ljava/lang/CharSequence;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TabReplica.kt */
public final class TabReplica {
    private Drawable icon;
    private final CharSequence identifier;
    private final CharSequence title;

    public static /* synthetic */ TabReplica copy$default(TabReplica tabReplica, CharSequence charSequence, Drawable drawable, CharSequence charSequence2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = tabReplica.title;
        }
        if ((i & 2) != 0) {
            drawable = tabReplica.icon;
        }
        if ((i & 4) != 0) {
            charSequence2 = tabReplica.identifier;
        }
        return tabReplica.copy(charSequence, drawable, charSequence2);
    }

    public final CharSequence component1() {
        return this.title;
    }

    public final Drawable component2() {
        return this.icon;
    }

    public final CharSequence component3() {
        return this.identifier;
    }

    public final TabReplica copy(CharSequence charSequence, Drawable drawable, CharSequence charSequence2) {
        return new TabReplica(charSequence, drawable, charSequence2);
    }

    public String toString() {
        return "TabReplica(title=" + this.title + ", icon=" + this.icon + ", identifier=" + this.identifier + ")";
    }

    public TabReplica(CharSequence charSequence, Drawable drawable, CharSequence charSequence2) {
        this.title = charSequence;
        this.icon = drawable;
        this.identifier = charSequence2;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final CharSequence getIdentifier() {
        return this.identifier;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.memes.plus.custom.changeable_tab_visibility.TabReplica");
        if (!Intrinsics.areEqual((Object) this.identifier, (Object) ((TabReplica) obj).identifier)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.identifier;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }
}
