package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.tools.videotrim.rangeseekbar.RangeSeekBarView;
import editor.tools.videotrim.timeline.BitmapTimeLineView;

public final class NVideoTrimmerActivityBinding implements ViewBinding {
    public final Button cancelButton;
    public final Button cancelTrimButton;
    public final LinearLayout controlsContainer;
    public final NVideoTrimmerUpgradePopupBinding includedTrimDurationUpgradeLayout;
    public final LinearLayout playbackInfoContainer;
    public final LinearLayout playbackProgressContainer;
    public final TextView playbackProgressTextView;
    public final TextView playbackSelectedRangeTextView;
    public final TextView playbackSizeTextView;
    public final ImageView playbackStateToggleView;
    private final LinearLayout rootView;
    public final Button selectVideoButton;
    public final LinearLayout selectionControlsBar;
    public final FrameLayout timelineContainer;
    public final ProgressBar timelinePlaceholderProgressBar;
    public final RangeSeekBarView timelineSeekBarView;
    public final BitmapTimeLineView timelineView;
    public final LinearLayout trimControlsBar;
    public final Button trimOptionsButton;
    public final Button trimVideoButton;
    public final FrameLayout videoContainer;
    public final VideoView videoView;

    private NVideoTrimmerActivityBinding(LinearLayout linearLayout, Button button, Button button2, LinearLayout linearLayout2, NVideoTrimmerUpgradePopupBinding nVideoTrimmerUpgradePopupBinding, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, ImageView imageView, Button button3, LinearLayout linearLayout5, FrameLayout frameLayout, ProgressBar progressBar, RangeSeekBarView rangeSeekBarView, BitmapTimeLineView bitmapTimeLineView, LinearLayout linearLayout6, Button button4, Button button5, FrameLayout frameLayout2, VideoView videoView2) {
        this.rootView = linearLayout;
        this.cancelButton = button;
        this.cancelTrimButton = button2;
        this.controlsContainer = linearLayout2;
        this.includedTrimDurationUpgradeLayout = nVideoTrimmerUpgradePopupBinding;
        this.playbackInfoContainer = linearLayout3;
        this.playbackProgressContainer = linearLayout4;
        this.playbackProgressTextView = textView;
        this.playbackSelectedRangeTextView = textView2;
        this.playbackSizeTextView = textView3;
        this.playbackStateToggleView = imageView;
        this.selectVideoButton = button3;
        this.selectionControlsBar = linearLayout5;
        this.timelineContainer = frameLayout;
        this.timelinePlaceholderProgressBar = progressBar;
        this.timelineSeekBarView = rangeSeekBarView;
        this.timelineView = bitmapTimeLineView;
        this.trimControlsBar = linearLayout6;
        this.trimOptionsButton = button4;
        this.trimVideoButton = button5;
        this.videoContainer = frameLayout2;
        this.videoView = videoView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NVideoTrimmerActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NVideoTrimmerActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_video_trimmer_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.memes.editor.C4175R.C4179id.included_trim_duration_upgrade_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NVideoTrimmerActivityBinding bind(android.view.View r26) {
        /*
            r0 = r26
            int r1 = com.memes.editor.C4175R.C4179id.cancel_button
            android.view.View r2 = r0.findViewById(r1)
            r5 = r2
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.cancel_trim_button
            android.view.View r2 = r0.findViewById(r1)
            r6 = r2
            android.widget.Button r6 = (android.widget.Button) r6
            if (r6 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.controls_container
            android.view.View r2 = r0.findViewById(r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.included_trim_duration_upgrade_layout
            android.view.View r2 = r0.findViewById(r1)
            if (r2 == 0) goto L_0x00fe
            com.memes.editor.databinding.NVideoTrimmerUpgradePopupBinding r8 = com.memes.editor.databinding.NVideoTrimmerUpgradePopupBinding.bind(r2)
            int r1 = com.memes.editor.C4175R.C4179id.playback_info_container
            android.view.View r2 = r0.findViewById(r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.playback_progress_container
            android.view.View r2 = r0.findViewById(r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.playback_progress_text_view
            android.view.View r2 = r0.findViewById(r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.playback_selected_range_text_view
            android.view.View r2 = r0.findViewById(r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.playback_size_text_view
            android.view.View r2 = r0.findViewById(r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.playback_state_toggle_view
            android.view.View r2 = r0.findViewById(r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.select_video_button
            android.view.View r2 = r0.findViewById(r1)
            r15 = r2
            android.widget.Button r15 = (android.widget.Button) r15
            if (r15 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.selection_controls_bar
            android.view.View r2 = r0.findViewById(r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.timeline_container
            android.view.View r2 = r0.findViewById(r1)
            r17 = r2
            android.widget.FrameLayout r17 = (android.widget.FrameLayout) r17
            if (r17 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.timeline_placeholder_progress_bar
            android.view.View r2 = r0.findViewById(r1)
            r18 = r2
            android.widget.ProgressBar r18 = (android.widget.ProgressBar) r18
            if (r18 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.timeline_seek_bar_view
            android.view.View r2 = r0.findViewById(r1)
            r19 = r2
            editor.tools.videotrim.rangeseekbar.RangeSeekBarView r19 = (editor.tools.videotrim.rangeseekbar.RangeSeekBarView) r19
            if (r19 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.timeline_view
            android.view.View r2 = r0.findViewById(r1)
            r20 = r2
            editor.tools.videotrim.timeline.BitmapTimeLineView r20 = (editor.tools.videotrim.timeline.BitmapTimeLineView) r20
            if (r20 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.trim_controls_bar
            android.view.View r2 = r0.findViewById(r1)
            r21 = r2
            android.widget.LinearLayout r21 = (android.widget.LinearLayout) r21
            if (r21 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.trim_options_button
            android.view.View r2 = r0.findViewById(r1)
            r22 = r2
            android.widget.Button r22 = (android.widget.Button) r22
            if (r22 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.trim_video_button
            android.view.View r2 = r0.findViewById(r1)
            r23 = r2
            android.widget.Button r23 = (android.widget.Button) r23
            if (r23 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.video_container
            android.view.View r2 = r0.findViewById(r1)
            r24 = r2
            android.widget.FrameLayout r24 = (android.widget.FrameLayout) r24
            if (r24 == 0) goto L_0x00fe
            int r1 = com.memes.editor.C4175R.C4179id.video_view
            android.view.View r2 = r0.findViewById(r1)
            r25 = r2
            android.widget.VideoView r25 = (android.widget.VideoView) r25
            if (r25 == 0) goto L_0x00fe
            com.memes.editor.databinding.NVideoTrimmerActivityBinding r1 = new com.memes.editor.databinding.NVideoTrimmerActivityBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        L_0x00fe:
            android.content.res.Resources r0 = r26.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NVideoTrimmerActivityBinding.bind(android.view.View):com.memes.editor.databinding.NVideoTrimmerActivityBinding");
    }
}
