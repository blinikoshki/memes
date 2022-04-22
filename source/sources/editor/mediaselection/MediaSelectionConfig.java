package editor.mediaselection;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\bJ\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, mo26107d2 = {"Leditor/mediaselection/MediaSelectionConfig;", "Landroid/os/Parcelable;", "selectionCountLimit", "", "selectedItemIds", "", "", "exitOnFirstSelection", "", "(ILjava/util/List;Z)V", "getExitOnFirstSelection", "()Z", "getSelectedItemIds", "()Ljava/util/List;", "getSelectionCountLimit", "()I", "canSelectMoreItems", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionConfig.kt */
public final class MediaSelectionConfig implements Parcelable {
    public static final Parcelable.Creator<MediaSelectionConfig> CREATOR = new Creator();
    private final boolean exitOnFirstSelection;
    private final List<String> selectedItemIds;
    private final int selectionCountLimit;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MediaSelectionConfig> {
        public final MediaSelectionConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MediaSelectionConfig(parcel.readInt(), parcel.createStringArrayList(), parcel.readInt() != 0);
        }

        public final MediaSelectionConfig[] newArray(int i) {
            return new MediaSelectionConfig[i];
        }
    }

    public MediaSelectionConfig() {
        this(0, (List) null, false, 7, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.selectionCountLimit);
        parcel.writeStringList(this.selectedItemIds);
        parcel.writeInt(this.exitOnFirstSelection ? 1 : 0);
    }

    public MediaSelectionConfig(int i, List<String> list, boolean z) {
        this.selectionCountLimit = i;
        this.selectedItemIds = list;
        this.exitOnFirstSelection = z;
    }

    public final int getSelectionCountLimit() {
        return this.selectionCountLimit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaSelectionConfig(int i, List list, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 12 : i, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? false : z);
    }

    public final List<String> getSelectedItemIds() {
        return this.selectedItemIds;
    }

    public final boolean getExitOnFirstSelection() {
        return this.exitOnFirstSelection;
    }

    public final boolean canSelectMoreItems() {
        return this.selectionCountLimit > 0;
    }
}
