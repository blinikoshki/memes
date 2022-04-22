package com.memes.plus.p040ui.subscription.reviews;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/reviews/SubscriptionReviewsProvider;", "", "()V", "reviews", "", "Lcom/memes/plus/ui/subscription/reviews/SubscriptionReview;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.reviews.SubscriptionReviewsProvider */
/* compiled from: SubscriptionReviewsProvider.kt */
public final class SubscriptionReviewsProvider {
    public static final SubscriptionReviewsProvider INSTANCE = new SubscriptionReviewsProvider();

    private SubscriptionReviewsProvider() {
    }

    public final List<SubscriptionReview> reviews() {
        List<SubscriptionReview> arrayList = new ArrayList<>();
        arrayList.add(new SubscriptionReview("My Review", "Just plain out amazing i can't even explain in words how much joy and laughter this gives me this app definitely makes me feel like a memer", 0, 4, (DefaultConstructorMarker) null));
        arrayList.add(new SubscriptionReview("Marwah Alk", "I love it it amazing I see so many meme that when i laugh peed my pants 🤣🤣🤣 my name is is MEMES_T_T", 0, 4, (DefaultConstructorMarker) null));
        arrayList.add(new SubscriptionReview("Filip Hinc", "Best meme making app ive seen ill use it for my meme page thx", 0, 4, (DefaultConstructorMarker) null));
        arrayList.add(new SubscriptionReview("Rukhsana Maken", "Just wanna say this is the coolest app to make apps and so easy to use!!😊", 0, 4, (DefaultConstructorMarker) null));
        arrayList.add(new SubscriptionReview("Thabang Selala", "Gold star yall... im loving it... follow me yall❤", 0, 4, (DefaultConstructorMarker) null));
        return arrayList;
    }
}
