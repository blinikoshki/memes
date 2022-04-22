package com.memes.plus.p040ui.posts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/memes/plus/ui/posts/PostsLinearAdapter$PostViewHolder$animateLikeHearts$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$animateLikeHearts$1 */
/* compiled from: PostsLinearAdapter.kt */
public final class PostsLinearAdapter$PostViewHolder$animateLikeHearts$1 extends AnimatorListenerAdapter {
    final /* synthetic */ View $view;

    PostsLinearAdapter$PostViewHolder$animateLikeHearts$1(View view) {
        this.$view = view;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.$view.setAlpha(0.3f);
        this.$view.setScaleX(1.0f);
        this.$view.setScaleY(1.0f);
        this.$view.setVisibility(8);
        this.$view.clearAnimation();
    }
}
