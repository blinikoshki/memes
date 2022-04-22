package com.memes.commons.mediaviewer.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/types/MediaViewerItem;", "", "()V", "Photo", "Lcom/memes/commons/mediaviewer/types/MediaViewerItem$Photo;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaViewerItem.kt */
public abstract class MediaViewerItem {
    private MediaViewerItem() {
    }

    public /* synthetic */ MediaViewerItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/types/MediaViewerItem$Photo;", "Lcom/memes/commons/mediaviewer/types/MediaViewerItem;", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaViewerItem.kt */
    public static final class Photo extends MediaViewerItem {
        private final String path;

        public static /* synthetic */ Photo copy$default(Photo photo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = photo.path;
            }
            return photo.copy(str);
        }

        public final String component1() {
            return this.path;
        }

        public final Photo copy(String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            return new Photo(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Photo) && Intrinsics.areEqual((Object) this.path, (Object) ((Photo) obj).path);
            }
            return true;
        }

        public int hashCode() {
            String str = this.path;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Photo(path=" + this.path + ")";
        }

        public final String getPath() {
            return this.path;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Photo(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "path");
            this.path = str;
        }
    }
}
