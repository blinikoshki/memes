package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.utils.GifEditText;
import com.getstream.sdk.chat.view.PreviewMessageView;

public final class StreamViewMessageInputBinding implements ViewBinding {
    public final Button btnClose;
    public final CheckBox cbSendAlsoToChannel;
    public final ConstraintLayout clAddFile;
    public final ConstraintLayout clSelectPhoto;
    public final ConstraintLayout clTitle;
    public final ListView fileComposer;
    public final ImageView ivCameraPermission;
    public final ImageView ivMediaPermission;
    public final ImageView ivOpenAttach;
    public final LinearLayout llComposer;
    public final RecyclerView mediaComposer;
    public final GifEditText messageTextInput;
    public final ProgressBar progressBarFileLoader;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMedia;
    public final RecyclerView rvSuggestions;
    public final LinearLayout selectCamera;
    public final LinearLayout selectFile;
    public final LinearLayout selectMedia;
    public final ImageView sendButton;
    public final TextView tvCommand;
    public final TextView tvTitle;
    public final TextView tvUploadCamera;
    public final TextView tvUploadFile;
    public final TextView tvUploadPhotoVideo;
    public final PreviewMessageView vPreviewMessage;

    private StreamViewMessageInputBinding(ConstraintLayout constraintLayout, Button button, CheckBox checkBox, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ListView listView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, RecyclerView recyclerView, GifEditText gifEditText, ProgressBar progressBar, RecyclerView recyclerView2, RecyclerView recyclerView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, PreviewMessageView previewMessageView) {
        this.rootView = constraintLayout;
        this.btnClose = button;
        this.cbSendAlsoToChannel = checkBox;
        this.clAddFile = constraintLayout2;
        this.clSelectPhoto = constraintLayout3;
        this.clTitle = constraintLayout4;
        this.fileComposer = listView;
        this.ivCameraPermission = imageView;
        this.ivMediaPermission = imageView2;
        this.ivOpenAttach = imageView3;
        this.llComposer = linearLayout;
        this.mediaComposer = recyclerView;
        this.messageTextInput = gifEditText;
        this.progressBarFileLoader = progressBar;
        this.rvMedia = recyclerView2;
        this.rvSuggestions = recyclerView3;
        this.selectCamera = linearLayout2;
        this.selectFile = linearLayout3;
        this.selectMedia = linearLayout4;
        this.sendButton = imageView4;
        this.tvCommand = textView;
        this.tvTitle = textView2;
        this.tvUploadCamera = textView3;
        this.tvUploadFile = textView4;
        this.tvUploadPhotoVideo = textView5;
        this.vPreviewMessage = previewMessageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamViewMessageInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamViewMessageInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_view_message_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamViewMessageInputBinding bind(View view) {
        View view2 = view;
        int i = C1673R.C1677id.btn_close;
        Button button = (Button) view2.findViewById(i);
        if (button != null) {
            i = C1673R.C1677id.cbSendAlsoToChannel;
            CheckBox checkBox = (CheckBox) view2.findViewById(i);
            if (checkBox != null) {
                i = C1673R.C1677id.cl_add_file;
                ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(i);
                if (constraintLayout != null) {
                    i = C1673R.C1677id.cl_select_photo;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(i);
                    if (constraintLayout2 != null) {
                        i = C1673R.C1677id.cl_title;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(i);
                        if (constraintLayout3 != null) {
                            i = C1673R.C1677id.file_composer;
                            ListView listView = (ListView) view2.findViewById(i);
                            if (listView != null) {
                                i = C1673R.C1677id.iv_camera_permission;
                                ImageView imageView = (ImageView) view2.findViewById(i);
                                if (imageView != null) {
                                    i = C1673R.C1677id.iv_media_permission;
                                    ImageView imageView2 = (ImageView) view2.findViewById(i);
                                    if (imageView2 != null) {
                                        i = C1673R.C1677id.iv_openAttach;
                                        ImageView imageView3 = (ImageView) view2.findViewById(i);
                                        if (imageView3 != null) {
                                            i = C1673R.C1677id.ll_composer;
                                            LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
                                            if (linearLayout != null) {
                                                i = C1673R.C1677id.media_composer;
                                                RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                                                if (recyclerView != null) {
                                                    i = C1673R.C1677id.message_text_input;
                                                    GifEditText gifEditText = (GifEditText) view2.findViewById(i);
                                                    if (gifEditText != null) {
                                                        i = C1673R.C1677id.progressBar_file_loader;
                                                        ProgressBar progressBar = (ProgressBar) view2.findViewById(i);
                                                        if (progressBar != null) {
                                                            i = C1673R.C1677id.rv_media;
                                                            RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(i);
                                                            if (recyclerView2 != null) {
                                                                i = C1673R.C1677id.rvSuggestions;
                                                                RecyclerView recyclerView3 = (RecyclerView) view2.findViewById(i);
                                                                if (recyclerView3 != null) {
                                                                    i = C1673R.C1677id.select_camera;
                                                                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(i);
                                                                    if (linearLayout2 != null) {
                                                                        i = C1673R.C1677id.select_file;
                                                                        LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                                                        if (linearLayout3 != null) {
                                                                            i = C1673R.C1677id.select_media;
                                                                            LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                                                            if (linearLayout4 != null) {
                                                                                i = C1673R.C1677id.sendButton;
                                                                                ImageView imageView4 = (ImageView) view2.findViewById(i);
                                                                                if (imageView4 != null) {
                                                                                    i = C1673R.C1677id.tv_command;
                                                                                    TextView textView = (TextView) view2.findViewById(i);
                                                                                    if (textView != null) {
                                                                                        i = C1673R.C1677id.tv_title;
                                                                                        TextView textView2 = (TextView) view2.findViewById(i);
                                                                                        if (textView2 != null) {
                                                                                            i = C1673R.C1677id.tv_upload_camera;
                                                                                            TextView textView3 = (TextView) view2.findViewById(i);
                                                                                            if (textView3 != null) {
                                                                                                i = C1673R.C1677id.tv_upload_file;
                                                                                                TextView textView4 = (TextView) view2.findViewById(i);
                                                                                                if (textView4 != null) {
                                                                                                    i = C1673R.C1677id.tv_upload_photo_video;
                                                                                                    TextView textView5 = (TextView) view2.findViewById(i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = C1673R.C1677id.vPreviewMessage;
                                                                                                        PreviewMessageView previewMessageView = (PreviewMessageView) view2.findViewById(i);
                                                                                                        if (previewMessageView != null) {
                                                                                                            return new StreamViewMessageInputBinding((ConstraintLayout) view2, button, checkBox, constraintLayout, constraintLayout2, constraintLayout3, listView, imageView, imageView2, imageView3, linearLayout, recyclerView, gifEditText, progressBar, recyclerView2, recyclerView3, linearLayout2, linearLayout3, linearLayout4, imageView4, textView, textView2, textView3, textView4, textView5, previewMessageView);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
