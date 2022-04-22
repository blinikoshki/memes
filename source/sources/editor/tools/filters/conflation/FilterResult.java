package editor.tools.filters.conflation;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.commons.media.MediaContent;
import editor.tools.filters.MediaFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo26107d2 = {"Leditor/tools/filters/conflation/FilterResult;", "Landroid/os/Parcelable;", "identifier", "", "content", "Lcom/memes/commons/media/MediaContent;", "filter", "Leditor/tools/filters/MediaFilter;", "(Ljava/lang/String;Lcom/memes/commons/media/MediaContent;Leditor/tools/filters/MediaFilter;)V", "getContent", "()Lcom/memes/commons/media/MediaContent;", "getFilter", "()Leditor/tools/filters/MediaFilter;", "getIdentifier", "()Ljava/lang/String;", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FilterResult.kt */
public final class FilterResult implements Parcelable {
    public static final Parcelable.Creator<FilterResult> CREATOR = new Creator();
    private final MediaContent content;
    private final MediaFilter filter;
    private final String identifier;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FilterResult> {
        public final FilterResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FilterResult(parcel.readString(), (MediaContent) parcel.readParcelable(FilterResult.class.getClassLoader()), MediaFilter.CREATOR.createFromParcel(parcel));
        }

        public final FilterResult[] newArray(int i) {
            return new FilterResult[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.identifier);
        parcel.writeParcelable(this.content, i);
        this.filter.writeToParcel(parcel, 0);
    }

    public FilterResult(String str, MediaContent mediaContent, MediaFilter mediaFilter) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        Intrinsics.checkNotNullParameter(mediaFilter, "filter");
        this.identifier = str;
        this.content = mediaContent;
        this.filter = mediaFilter;
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

    public String toString() {
        return "FilterResult(identifier='" + this.identifier + "', content=" + this.content + ", filter=" + this.filter + ')';
    }
}
