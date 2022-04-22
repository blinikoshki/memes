package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.overlayboundary.BoundaryCornerView;
import java.util.Objects;

public final class NBoundaryLayoutBinding implements ViewBinding {
    public final BoundaryCornerView bottomLeftCorner;
    public final BoundaryCornerView bottomRightCorner;
    public final View bottomSide;
    public final FrameLayout container;
    public final View leftSide;
    public final View rightSide;
    private final View rootView;
    public final View rotateHandle;
    public final View rotateSide;
    public final View saveSide;
    public final View saveView;
    public final BoundaryCornerView topLeftCorner;
    public final BoundaryCornerView topRightCorner;
    public final View topSide;

    private NBoundaryLayoutBinding(View view, BoundaryCornerView boundaryCornerView, BoundaryCornerView boundaryCornerView2, View view2, FrameLayout frameLayout, View view3, View view4, View view5, View view6, View view7, View view8, BoundaryCornerView boundaryCornerView3, BoundaryCornerView boundaryCornerView4, View view9) {
        this.rootView = view;
        this.bottomLeftCorner = boundaryCornerView;
        this.bottomRightCorner = boundaryCornerView2;
        this.bottomSide = view2;
        this.container = frameLayout;
        this.leftSide = view3;
        this.rightSide = view4;
        this.rotateHandle = view5;
        this.rotateSide = view6;
        this.saveSide = view7;
        this.saveView = view8;
        this.topLeftCorner = boundaryCornerView3;
        this.topRightCorner = boundaryCornerView4;
        this.topSide = view9;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NBoundaryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4175R.C4181layout.n_boundary_layout, viewGroup);
        return bind(viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r0 = com.memes.editor.C4175R.C4179id.right_side;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r0 = com.memes.editor.C4175R.C4179id.rotate_handle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r0 = com.memes.editor.C4175R.C4179id.rotate_side;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r0 = com.memes.editor.C4175R.C4179id.save_side;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        r0 = com.memes.editor.C4175R.C4179id.save_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        r0 = com.memes.editor.C4175R.C4179id.top_side;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.memes.editor.C4175R.C4179id.bottom_side;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r0 = com.memes.editor.C4175R.C4179id.left_side;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NBoundaryLayoutBinding bind(android.view.View r16) {
        /*
            r1 = r16
            int r0 = com.memes.editor.C4175R.C4179id.bottom_left_corner
            android.view.View r2 = r1.findViewById(r0)
            editor.custom.overlayboundary.BoundaryCornerView r2 = (editor.custom.overlayboundary.BoundaryCornerView) r2
            if (r2 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.bottom_right_corner
            android.view.View r3 = r1.findViewById(r0)
            editor.custom.overlayboundary.BoundaryCornerView r3 = (editor.custom.overlayboundary.BoundaryCornerView) r3
            if (r3 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.bottom_side
            android.view.View r4 = r1.findViewById(r0)
            if (r4 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.container
            android.view.View r5 = r1.findViewById(r0)
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.left_side
            android.view.View r6 = r1.findViewById(r0)
            if (r6 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.right_side
            android.view.View r7 = r1.findViewById(r0)
            if (r7 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.rotate_handle
            android.view.View r8 = r1.findViewById(r0)
            if (r8 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.rotate_side
            android.view.View r9 = r1.findViewById(r0)
            if (r9 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.save_side
            android.view.View r10 = r1.findViewById(r0)
            if (r10 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.save_view
            android.view.View r11 = r1.findViewById(r0)
            if (r11 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.top_left_corner
            android.view.View r12 = r1.findViewById(r0)
            editor.custom.overlayboundary.BoundaryCornerView r12 = (editor.custom.overlayboundary.BoundaryCornerView) r12
            if (r12 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.top_right_corner
            android.view.View r13 = r1.findViewById(r0)
            editor.custom.overlayboundary.BoundaryCornerView r13 = (editor.custom.overlayboundary.BoundaryCornerView) r13
            if (r13 == 0) goto L_0x007d
            int r0 = com.memes.editor.C4175R.C4179id.top_side
            android.view.View r14 = r1.findViewById(r0)
            if (r14 == 0) goto L_0x007d
            com.memes.editor.databinding.NBoundaryLayoutBinding r15 = new com.memes.editor.databinding.NBoundaryLayoutBinding
            r0 = r15
            r1 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x007d:
            android.content.res.Resources r1 = r16.getResources()
            java.lang.String r0 = r1.getResourceName(r0)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NBoundaryLayoutBinding.bind(android.view.View):com.memes.editor.databinding.NBoundaryLayoutBinding");
    }
}
