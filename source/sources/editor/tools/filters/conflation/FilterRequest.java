package editor.tools.filters.conflation;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.commons.media.MediaContent;
import editor.tools.filters.MediaFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, mo26107d2 = {"Leditor/tools/filters/conflation/FilterRequest;", "Landroid/os/Parcelable;", "identifier", "", "content", "Lcom/memes/commons/media/MediaContent;", "filter", "Leditor/tools/filters/MediaFilter;", "filterTab", "Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "(Ljava/lang/String;Lcom/memes/commons/media/MediaContent;Leditor/tools/filters/MediaFilter;Leditor/tools/filters/conflation/FilterRequest$FilterTab;)V", "getContent", "()Lcom/memes/commons/media/MediaContent;", "getFilter", "()Leditor/tools/filters/MediaFilter;", "getFilterTab", "()Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "getIdentifier", "()Ljava/lang/String;", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "FilterTab", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FilterRequest.kt */
public final class FilterRequest implements Parcelable {
    public static final Parcelable.Creator<FilterRequest> CREATOR = new Creator();
    private final MediaContent content;
    private final MediaFilter filter;
    private final FilterTab filterTab;
    private final String identifier;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FilterRequest> {
        public final FilterRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FilterRequest(parcel.readString(), (MediaContent) parcel.readParcelable(FilterRequest.class.getClassLoader()), MediaFilter.CREATOR.createFromParcel(parcel), (FilterTab) Enum.valueOf(FilterTab.class, parcel.readString()));
        }

        public final FilterRequest[] newArray(int i) {
            return new FilterRequest[i];
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "", "(Ljava/lang/String;I)V", "ENHANCE", "FILTERS", "DEEP_FRY", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FilterRequest.kt */
    public enum FilterTab {
        ENHANCE,
        FILTERS,
        DEEP_FRY
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.identifier);
        parcel.writeParcelable(this.content, i);
        this.filter.writeToParcel(parcel, 0);
        parcel.writeString(this.filterTab.name());
    }

    public FilterRequest(String str, MediaContent mediaContent, MediaFilter mediaFilter, FilterTab filterTab2) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        Intrinsics.checkNotNullParameter(mediaFilter, "filter");
        Intrinsics.checkNotNullParameter(filterTab2, "filterTab");
        this.identifier = str;
        this.content = mediaContent;
        this.filter = mediaFilter;
        this.filterTab = filterTab2;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final MediaContent getContent() {
        return this.content;
    }

    public final MediaFilter getFilter() {
        return this.filter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterRequest(String str, MediaContent mediaContent, MediaFilter mediaFilter, FilterTab filterTab2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, mediaContent, mediaFilter, (i & 8) != 0 ? FilterTab.ENHANCE : filterTab2);
    }

    public final FilterTab getFilterTab() {
        return this.filterTab;
    }

    public String toString() {
        return "FilterRequest(identifier='" + this.identifier + "', content=" + this.content + ", filter=" + this.filter + ", filterTab=" + this.filterTab + ')';
    }
}
