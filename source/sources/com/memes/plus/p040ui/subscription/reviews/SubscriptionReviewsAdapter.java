package com.memes.plus.p040ui.subscription.reviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.plus.C4199R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/reviews/SubscriptionReviewsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/memes/plus/ui/subscription/reviews/SubscriptionReviewsAdapter$ReviewsViewHolder;", "()V", "reviews", "", "Lcom/memes/plus/ui/subscription/reviews/SubscriptionReview;", "getReviews", "()Ljava/util/List;", "reviews$delegate", "Lkotlin/Lazy;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ReviewsViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.reviews.SubscriptionReviewsAdapter */
/* compiled from: SubscriptionReviewsAdapter.kt */
public final class SubscriptionReviewsAdapter extends RecyclerView.Adapter<ReviewsViewHolder> {
    private final Lazy reviews$delegate = LazyKt.lazy(SubscriptionReviewsAdapter$reviews$2.INSTANCE);

    private final List<SubscriptionReview> getReviews() {
        return (List) this.reviews$delegate.getValue();
    }

    public ReviewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C4199R.C4205layout.subscription_review_list_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…list_item, parent, false)");
        return new ReviewsViewHolder(this, inflate);
    }

    public int getItemCount() {
        return getReviews().size();
    }

    public void onBindViewHolder(ReviewsViewHolder reviewsViewHolder, int i) {
        Intrinsics.checkNotNullParameter(reviewsViewHolder, "holder");
        SubscriptionReview subscriptionReview = getReviews().get(i);
        reviewsViewHolder.getUserNameTextView().setText(subscriptionReview.getName());
        reviewsViewHolder.getReviewTextView().setText(subscriptionReview.getReview());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/reviews/SubscriptionReviewsAdapter$ReviewsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/memes/plus/ui/subscription/reviews/SubscriptionReviewsAdapter;Landroid/view/View;)V", "reviewTextView", "Landroid/widget/TextView;", "getReviewTextView", "()Landroid/widget/TextView;", "userNameTextView", "getUserNameTextView", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.subscription.reviews.SubscriptionReviewsAdapter$ReviewsViewHolder */
    /* compiled from: SubscriptionReviewsAdapter.kt */
    public final class ReviewsViewHolder extends RecyclerView.ViewHolder {
        private final TextView reviewTextView;
        final /* synthetic */ SubscriptionReviewsAdapter this$0;
        private final TextView userNameTextView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReviewsViewHolder(SubscriptionReviewsAdapter subscriptionReviewsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = subscriptionReviewsAdapter;
            View findViewById = view.findViewById(C4199R.C4203id.user_name_text_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.user_name_text_view)");
            this.userNameTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C4199R.C4203id.review_text_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.review_text_view)");
            this.reviewTextView = (TextView) findViewById2;
        }

        public final TextView getUserNameTextView() {
            return this.userNameTextView;
        }

        public final TextView getReviewTextView() {
            return this.reviewTextView;
        }
    }
}
