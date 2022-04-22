package com.getstream.sdk.chat.utils.exomedia.p012ui.animation;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.animation.BottomViewHideShowAnimation */
public class BottomViewHideShowAnimation extends AnimationSet {
    /* access modifiers changed from: private */
    public View animationView;
    /* access modifiers changed from: private */
    public boolean toVisible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomViewHideShowAnimation(View view, boolean z, long j) {
        super(false);
        int i = 0;
        this.toVisible = z;
        this.animationView = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? 0.0f : 1.0f, !z ? 0.0f : 1.0f);
        alphaAnimation.setDuration(j);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (z ? getHideShowDelta(view) : 0), (float) (!z ? getHideShowDelta(view) : i));
        translateAnimation.setInterpolator(z ? new LinearOutSlowInInterpolator() : new FastOutLinearInInterpolator());
        translateAnimation.setDuration(j);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new Listener());
    }

    private int getHideShowDelta(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - view.getTop();
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.animation.BottomViewHideShowAnimation$Listener */
    private class Listener implements Animation.AnimationListener {
        public void onAnimationRepeat(Animation animation) {
        }

        private Listener() {
        }

        public void onAnimationStart(Animation animation) {
            BottomViewHideShowAnimation.this.animationView.setVisibility(0);
        }

        public void onAnimationEnd(Animation animation) {
            BottomViewHideShowAnimation.this.animationView.setVisibility(BottomViewHideShowAnimation.this.toVisible ? 0 : 8);
        }
    }
}
