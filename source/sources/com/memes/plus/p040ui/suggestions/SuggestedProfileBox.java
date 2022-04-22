package com.memes.plus.p040ui.suggestions;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/suggestions/SuggestedProfileBox;", "", "profiles", "", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "(Ljava/util/List;)V", "getProfiles", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.suggestions.SuggestedProfileBox */
/* compiled from: SuggestedProfileBox.kt */
public final class SuggestedProfileBox {
    private final List<SuggestedProfile> profiles;

    public static /* synthetic */ SuggestedProfileBox copy$default(SuggestedProfileBox suggestedProfileBox, List<SuggestedProfile> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = suggestedProfileBox.profiles;
        }
        return suggestedProfileBox.copy(list);
    }

    public final List<SuggestedProfile> component1() {
        return this.profiles;
    }

    public final SuggestedProfileBox copy(List<SuggestedProfile> list) {
        Intrinsics.checkNotNullParameter(list, "profiles");
        return new SuggestedProfileBox(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SuggestedProfileBox) && Intrinsics.areEqual((Object) this.profiles, (Object) ((SuggestedProfileBox) obj).profiles);
        }
        return true;
    }

    public int hashCode() {
        List<SuggestedProfile> list = this.profiles;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SuggestedProfileBox(profiles=" + this.profiles + ")";
    }

    public SuggestedProfileBox(List<SuggestedProfile> list) {
        Intrinsics.checkNotNullParameter(list, "profiles");
        this.profiles = list;
    }

    public final List<SuggestedProfile> getProfiles() {
        return this.profiles;
    }
}
