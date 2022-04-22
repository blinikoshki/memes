package com.memes.plus.p040ui.posts.suggestions;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/suggestions/SuggestedProfilesOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "()V", "isDirectionHorizontal", "", "isMovingLeft", "prevX", "", "prevY", "enableHorizontalScroll", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "enableVerticalScroll", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onTouchEvent", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.suggestions.SuggestedProfilesOnItemTouchListener */
/* compiled from: SuggestedProfilesOnItemTouchListener.kt */
public final class SuggestedProfilesOnItemTouchListener implements RecyclerView.OnItemTouchListener {
    private boolean isDirectionHorizontal;
    private boolean isMovingLeft;
    private float prevX = -1.0f;
    private float prevY = -1.0f;

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.prevX == -1.0f && this.prevY == -1.0f) {
            this.prevX = x;
            this.prevY = y;
        }
        boolean z = true;
        if (motionEvent.getAction() == 1) {
            recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (motionEvent.getAction() == 0) {
            recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (motionEvent.getAction() == 2) {
            int i = (y > this.prevY ? 1 : (y == this.prevY ? 0 : -1));
            float f = this.prevX;
            boolean z2 = x < f;
            float abs = Math.abs(x - f);
            float abs2 = Math.abs(y - this.prevY);
            int i2 = (abs > abs2 ? 1 : (abs == abs2 ? 0 : -1));
            boolean z3 = i2 > 0;
            if (this.isMovingLeft == z2 || this.isDirectionHorizontal != z3) {
                this.isMovingLeft = z2;
                if (i2 <= 0) {
                    z = false;
                }
                this.isDirectionHorizontal = z;
                if (abs2 > abs) {
                    enableVerticalScroll(recyclerView);
                } else {
                    enableHorizontalScroll(recyclerView);
                }
                this.prevX = x;
                this.prevY = y;
            } else {
                enableHorizontalScroll(recyclerView);
                return false;
            }
        }
        return false;
    }

    private final void enableHorizontalScroll(RecyclerView recyclerView) {
        this.isDirectionHorizontal = true;
        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
    }

    private final void enableVerticalScroll(RecyclerView recyclerView) {
        this.isDirectionHorizontal = false;
        recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
    }
}
