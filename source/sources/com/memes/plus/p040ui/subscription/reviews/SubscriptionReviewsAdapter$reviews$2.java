package com.memes.plus.p040ui.subscription.reviews;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lcom/memes/plus/ui/subscription/reviews/SubscriptionReview;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.reviews.SubscriptionReviewsAdapter$reviews$2 */
/* compiled from: SubscriptionReviewsAdapter.kt */
final class SubscriptionReviewsAdapter$reviews$2 extends Lambda implements Function0<List<? extends SubscriptionReview>> {
    public static final SubscriptionReviewsAdapter$reviews$2 INSTANCE = new SubscriptionReviewsAdapter$reviews$2();

    SubscriptionReviewsAdapter$reviews$2() {
        super(0);
    }

    public final List<SubscriptionReview> invoke() {
        return SubscriptionReviewsProvider.INSTANCE.reviews();
    }
}
