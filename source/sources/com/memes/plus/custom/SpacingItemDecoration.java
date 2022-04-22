package com.memes.plus.custom;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int horizontalSpacing;
    private int verticalSpacing;

    public SpacingItemDecoration(int i, int i2) {
        this.horizontalSpacing = i;
        this.verticalSpacing = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.horizontalSpacing / 2;
        rect.right = this.horizontalSpacing / 2;
        rect.top = this.verticalSpacing / 2;
        rect.bottom = this.verticalSpacing / 2;
    }
}
