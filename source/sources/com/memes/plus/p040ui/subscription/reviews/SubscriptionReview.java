package com.memes.plus.p040ui.subscription.reviews;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/reviews/SubscriptionReview;", "", "name", "", "review", "imageResId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getImageResId", "()I", "getName", "()Ljava/lang/String;", "getReview", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.reviews.SubscriptionReview */
/* compiled from: SubscriptionReview.kt */
public final class SubscriptionReview {
    private final int imageResId;
    private final String name;
    private final String review;

    public static /* synthetic */ SubscriptionReview copy$default(SubscriptionReview subscriptionReview, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subscriptionReview.name;
        }
        if ((i2 & 2) != 0) {
            str2 = subscriptionReview.review;
        }
        if ((i2 & 4) != 0) {
            i = subscriptionReview.imageResId;
        }
        return subscriptionReview.copy(str, str2, i);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.review;
    }

    public final int component3() {
        return this.imageResId;
    }

    public final SubscriptionReview copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "review");
        return new SubscriptionReview(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionReview)) {
            return false;
        }
        SubscriptionReview subscriptionReview = (SubscriptionReview) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) subscriptionReview.name) && Intrinsics.areEqual((Object) this.review, (Object) subscriptionReview.review) && this.imageResId == subscriptionReview.imageResId;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.review;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.imageResId;
    }

    public String toString() {
        return "SubscriptionReview(name=" + this.name + ", review=" + this.review + ", imageResId=" + this.imageResId + ")";
    }

    public SubscriptionReview(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "review");
        this.name = str;
        this.review = str2;
        this.imageResId = i;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReview() {
        return this.review;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionReview(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getImageResId() {
        return this.imageResId;
    }
}
