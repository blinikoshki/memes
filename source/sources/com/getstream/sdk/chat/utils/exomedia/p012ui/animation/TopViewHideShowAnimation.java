package com.getstream.sdk.chat.utils.exomedia.p012ui.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.animation.TopViewHideShowAnimation */
public class TopViewHideShowAnimation extends AnimationSet {
    /* access modifiers changed from: private */
    public View animationView;
    /* access modifiers changed from: private */
    public boolean toVisible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopViewHideShowAnimation(View view, boolean z, long j) {
        super(false);
        int i = 0;
        this.toVisible = z;
        this.animationView = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? 0.0f : 1.0f, !z ? 0.0f : 1.0f);
        alphaAnimation.setDuration(j);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (z ? -view.getHeight() : 0), (float) (!z ? -view.getHeight() : i));
        translateAnimation.setInterpolator(z ? new LinearOutSlowInInterpolator() : new FastOutLinearInInterpolator());
        translateAnimation.setDuration(j);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new Listener());
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.animation.TopViewHideShowAnimation$Listener */
    private class Listener implements Animation.AnimationListener {
        public void onAnimationRepeat(Animation animation) {
        }

        private Listener() {
        }

        public void onAnimationStart(Animation animation) {
            TopViewHideShowAnimation.this.animationView.setVisibility(0);
        }

        public void onAnimationEnd(Animation animation) {
            TopViewHideShowAnimation.this.animationView.setVisibility(TopViewHideShowAnimation.this.toVisible ? 0 : 8);
        }
    }
}
