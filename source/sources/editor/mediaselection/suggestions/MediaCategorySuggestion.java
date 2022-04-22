package editor.mediaselection.suggestions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, mo26107d2 = {"Leditor/mediaselection/suggestions/MediaCategorySuggestion;", "", "icon", "", "title", "", "selected", "", "(ILjava/lang/String;Z)V", "getIcon", "()I", "getSelected", "()Z", "setSelected", "(Z)V", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "getIdentifier", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaCategorySuggestion.kt */
public final class MediaCategorySuggestion {
    private final int icon;
    private boolean selected;
    private final String title;

    public static /* synthetic */ MediaCategorySuggestion copy$default(MediaCategorySuggestion mediaCategorySuggestion, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mediaCategorySuggestion.icon;
        }
        if ((i2 & 2) != 0) {
            str = mediaCategorySuggestion.title;
        }
        if ((i2 & 4) != 0) {
            z = mediaCategorySuggestion.selected;
        }
        return mediaCategorySuggestion.copy(i, str, z);
    }

    public final int component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.selected;
    }

    public final MediaCategorySuggestion copy(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new MediaCategorySuggestion(i, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaCategorySuggestion)) {
            return false;
        }
        MediaCategorySuggestion mediaCategorySuggestion = (MediaCategorySuggestion) obj;
        return this.icon == mediaCategorySuggestion.icon && Intrinsics.areEqual((Object) this.title, (Object) mediaCategorySuggestion.title) && this.selected == mediaCategorySuggestion.selected;
    }

    public int hashCode() {
        int i = this.icon * 31;
        String str = this.title;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.selected;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "MediaCategorySuggestion(icon=" + this.icon + ", title=" + this.title + ", selected=" + this.selected + ")";
    }

    public MediaCategorySuggestion(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.icon = i;
        this.title = str;
        this.selected = z;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaCategorySuggestion(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final String getIdentifier() {
        return this.title;
    }
}
