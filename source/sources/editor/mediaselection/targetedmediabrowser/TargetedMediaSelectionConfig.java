package editor.mediaselection.targetedmediabrowser;

import android.os.Parcel;
import android.os.Parcelable;
import editor.mediaselection.MediaSelectionConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, mo26107d2 = {"Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionConfig;", "Landroid/os/Parcelable;", "selectionTarget", "Leditor/mediaselection/targetedmediabrowser/MediaSelectionTarget;", "selectionConfig", "Leditor/mediaselection/MediaSelectionConfig;", "(Leditor/mediaselection/targetedmediabrowser/MediaSelectionTarget;Leditor/mediaselection/MediaSelectionConfig;)V", "getSelectionConfig", "()Leditor/mediaselection/MediaSelectionConfig;", "getSelectionTarget", "()Leditor/mediaselection/targetedmediabrowser/MediaSelectionTarget;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TargetedMediaSelectionConfig.kt */
public final class TargetedMediaSelectionConfig implements Parcelable {
    public static final Parcelable.Creator<TargetedMediaSelectionConfig> CREATOR = new Creator();
    private final MediaSelectionConfig selectionConfig;
    private final MediaSelectionTarget selectionTarget;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TargetedMediaSelectionConfig> {
        public final TargetedMediaSelectionConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TargetedMediaSelectionConfig((MediaSelectionTarget) Enum.valueOf(MediaSelectionTarget.class, parcel.readString()), MediaSelectionConfig.CREATOR.createFromParcel(parcel));
        }

        public final TargetedMediaSelectionConfig[] newArray(int i) {
            return new TargetedMediaSelectionConfig[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.selectionTarget.name());
        this.selectionConfig.writeToParcel(parcel, 0);
    }

    public TargetedMediaSelectionConfig(MediaSelectionTarget mediaSelectionTarget, MediaSelectionConfig mediaSelectionConfig) {
        Intrinsics.checkNotNullParameter(mediaSelectionTarget, "selectionTarget");
        Intrinsics.checkNotNullParameter(mediaSelectionConfig, "selectionConfig");
        this.selectionTarget = mediaSelectionTarget;
        this.selectionConfig = mediaSelectionConfig;
    }

    public final MediaSelectionTarget getSelectionTarget() {
        return this.selectionTarget;
    }

    public final MediaSelectionConfig getSelectionConfig() {
        return this.selectionConfig;
    }
}
