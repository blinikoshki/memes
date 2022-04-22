package com.memes.plus.custom;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo26107d2 = {"com/memes/plus/custom/HeightWrappingViewPager$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: HeightWrappingViewPager.kt */
public final class HeightWrappingViewPager$onPageChangeListener$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ HeightWrappingViewPager this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    HeightWrappingViewPager$onPageChangeListener$1(HeightWrappingViewPager heightWrappingViewPager) {
        this.this$0 = heightWrappingViewPager;
    }

    public void onPageSelected(int i) {
        View access$findViewByPosition;
        if (this.this$0.isAttachedToWindow() && (access$findViewByPosition = this.this$0.findViewByPosition(i)) != null) {
            this.this$0.measureView(access$findViewByPosition);
            HeightWrappingViewPager heightWrappingViewPager = this.this$0;
            heightWrappingViewPager.animateContentHeight(access$findViewByPosition, heightWrappingViewPager.getHeight(), access$findViewByPosition.getMeasuredHeight());
        }
    }
}
