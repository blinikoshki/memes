package com.kaopiz.kprogresshud;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

public class KProgressHUD {
    /* access modifiers changed from: private */
    public int mAnimateSpeed;
    private Context mContext;
    /* access modifiers changed from: private */
    public float mCornerRadius;
    /* access modifiers changed from: private */
    public float mDimAmount = 0.0f;
    /* access modifiers changed from: private */
    public boolean mFinished;
    private int mGraceTimeMs;
    private Handler mGraceTimer;
    /* access modifiers changed from: private */
    public boolean mIsAutoDismiss;
    /* access modifiers changed from: private */
    public int mMaxProgress;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressDialog;
    /* access modifiers changed from: private */
    public int mWindowColor;

    public enum Style {
        SPIN_INDETERMINATE,
        PIE_DETERMINATE,
        ANNULAR_DETERMINATE,
        BAR_DETERMINATE
    }

    public KProgressHUD(Context context) {
        this.mContext = context;
        this.mProgressDialog = new ProgressDialog(context);
        this.mWindowColor = context.getResources().getColor(C4019R.C4020color.kprogresshud_default_color);
        this.mAnimateSpeed = 1;
        this.mCornerRadius = 10.0f;
        this.mIsAutoDismiss = true;
        this.mGraceTimeMs = 0;
        this.mFinished = false;
        setStyle(Style.SPIN_INDETERMINATE);
    }

    public static KProgressHUD create(Context context) {
        return new KProgressHUD(context);
    }

    public static KProgressHUD create(Context context, Style style) {
        return new KProgressHUD(context).setStyle(style);
    }

    /* renamed from: com.kaopiz.kprogresshud.KProgressHUD$2 */
    static /* synthetic */ class C40182 {
        static final /* synthetic */ int[] $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.kaopiz.kprogresshud.KProgressHUD$Style[] r0 = com.kaopiz.kprogresshud.KProgressHUD.Style.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style = r0
                com.kaopiz.kprogresshud.KProgressHUD$Style r1 = com.kaopiz.kprogresshud.KProgressHUD.Style.SPIN_INDETERMINATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kaopiz.kprogresshud.KProgressHUD$Style r1 = com.kaopiz.kprogresshud.KProgressHUD.Style.PIE_DETERMINATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kaopiz.kprogresshud.KProgressHUD$Style r1 = com.kaopiz.kprogresshud.KProgressHUD.Style.ANNULAR_DETERMINATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kaopiz.kprogresshud.KProgressHUD$Style r1 = com.kaopiz.kprogresshud.KProgressHUD.Style.BAR_DETERMINATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kaopiz.kprogresshud.KProgressHUD.C40182.<clinit>():void");
        }
    }

    public KProgressHUD setStyle(Style style) {
        View view;
        int i = C40182.$SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style[style.ordinal()];
        if (i == 1) {
            view = new SpinView(this.mContext);
        } else if (i == 2) {
            view = new PieView(this.mContext);
        } else if (i != 3) {
            view = i != 4 ? null : new BarView(this.mContext);
        } else {
            view = new AnnularView(this.mContext);
        }
        this.mProgressDialog.setView(view);
        return this;
    }

    public KProgressHUD setDimAmount(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.mDimAmount = f;
        }
        return this;
    }

    public KProgressHUD setSize(int i, int i2) {
        this.mProgressDialog.setSize(i, i2);
        return this;
    }

    @Deprecated
    public KProgressHUD setWindowColor(int i) {
        this.mWindowColor = i;
        return this;
    }

    public KProgressHUD setBackgroundColor(int i) {
        this.mWindowColor = i;
        return this;
    }

    public KProgressHUD setCornerRadius(float f) {
        this.mCornerRadius = f;
        return this;
    }

    public KProgressHUD setAnimationSpeed(int i) {
        this.mAnimateSpeed = i;
        return this;
    }

    public KProgressHUD setLabel(String str) {
        this.mProgressDialog.setLabel(str);
        return this;
    }

    public KProgressHUD setLabel(String str, int i) {
        this.mProgressDialog.setLabel(str, i);
        return this;
    }

    public KProgressHUD setDetailsLabel(String str) {
        this.mProgressDialog.setDetailsLabel(str);
        return this;
    }

    public KProgressHUD setDetailsLabel(String str, int i) {
        this.mProgressDialog.setDetailsLabel(str, i);
        return this;
    }

    public KProgressHUD setMaxProgress(int i) {
        this.mMaxProgress = i;
        return this;
    }

    public void setProgress(int i) {
        this.mProgressDialog.setProgress(i);
    }

    public KProgressHUD setCustomView(View view) {
        if (view != null) {
            this.mProgressDialog.setView(view);
            return this;
        }
        throw new RuntimeException("Custom view must not be null!");
    }

    public KProgressHUD setCancellable(boolean z) {
        this.mProgressDialog.setCancelable(z);
        this.mProgressDialog.setOnCancelListener((DialogInterface.OnCancelListener) null);
        return this;
    }

    public KProgressHUD setCancellable(DialogInterface.OnCancelListener onCancelListener) {
        this.mProgressDialog.setCancelable(onCancelListener != null);
        this.mProgressDialog.setOnCancelListener(onCancelListener);
        return this;
    }

    public KProgressHUD setAutoDismiss(boolean z) {
        this.mIsAutoDismiss = z;
        return this;
    }

    public KProgressHUD setGraceTime(int i) {
        this.mGraceTimeMs = i;
        return this;
    }

    public KProgressHUD show() {
        if (!isShowing()) {
            this.mFinished = false;
            if (this.mGraceTimeMs == 0) {
                this.mProgressDialog.show();
            } else {
                Handler handler = new Handler();
                this.mGraceTimer = handler;
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (KProgressHUD.this.mProgressDialog != null && !KProgressHUD.this.mFinished) {
                            KProgressHUD.this.mProgressDialog.show();
                        }
                    }
                }, (long) this.mGraceTimeMs);
            }
        }
        return this;
    }

    public boolean isShowing() {
        ProgressDialog progressDialog = this.mProgressDialog;
        return progressDialog != null && progressDialog.isShowing();
    }

    public void dismiss() {
        ProgressDialog progressDialog;
        this.mFinished = true;
        Context context = this.mContext;
        if (context != null && !((Activity) context).isFinishing() && (progressDialog = this.mProgressDialog) != null && progressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        Handler handler = this.mGraceTimer;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mGraceTimer = null;
        }
    }

    private class ProgressDialog extends Dialog {
        private BackgroundLayout mBackgroundLayout;
        private FrameLayout mCustomViewContainer;
        private int mDetailColor = -1;
        private String mDetailsLabel;
        private TextView mDetailsText;
        private Determinate mDeterminateView;
        private int mHeight;
        private Indeterminate mIndeterminateView;
        private String mLabel;
        private int mLabelColor = -1;
        private TextView mLabelText;
        private View mView;
        private int mWidth;

        public ProgressDialog(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(C4019R.C4023layout.kprogresshud_hud);
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = KProgressHUD.this.mDimAmount;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            setCanceledOnTouchOutside(false);
            initViews();
        }

        private void initViews() {
            BackgroundLayout backgroundLayout = (BackgroundLayout) findViewById(C4019R.C4022id.background);
            this.mBackgroundLayout = backgroundLayout;
            backgroundLayout.setBaseColor(KProgressHUD.this.mWindowColor);
            this.mBackgroundLayout.setCornerRadius(KProgressHUD.this.mCornerRadius);
            if (this.mWidth != 0) {
                updateBackgroundSize();
            }
            this.mCustomViewContainer = (FrameLayout) findViewById(C4019R.C4022id.container);
            addViewToFrame(this.mView);
            Determinate determinate = this.mDeterminateView;
            if (determinate != null) {
                determinate.setMax(KProgressHUD.this.mMaxProgress);
            }
            Indeterminate indeterminate = this.mIndeterminateView;
            if (indeterminate != null) {
                indeterminate.setAnimationSpeed((float) KProgressHUD.this.mAnimateSpeed);
            }
            this.mLabelText = (TextView) findViewById(C4019R.C4022id.label);
            setLabel(this.mLabel, this.mLabelColor);
            this.mDetailsText = (TextView) findViewById(C4019R.C4022id.details_label);
            setDetailsLabel(this.mDetailsLabel, this.mDetailColor);
        }

        private void addViewToFrame(View view) {
            if (view != null) {
                this.mCustomViewContainer.addView(view, new ViewGroup.LayoutParams(-2, -2));
            }
        }

        private void updateBackgroundSize() {
            ViewGroup.LayoutParams layoutParams = this.mBackgroundLayout.getLayoutParams();
            layoutParams.width = Helper.dpToPixel((float) this.mWidth, getContext());
            layoutParams.height = Helper.dpToPixel((float) this.mHeight, getContext());
            this.mBackgroundLayout.setLayoutParams(layoutParams);
        }

        public void setProgress(int i) {
            Determinate determinate = this.mDeterminateView;
            if (determinate != null) {
                determinate.setProgress(i);
                if (KProgressHUD.this.mIsAutoDismiss && i >= KProgressHUD.this.mMaxProgress) {
                    dismiss();
                }
            }
        }

        public void setView(View view) {
            if (view != null) {
                if (view instanceof Determinate) {
                    this.mDeterminateView = (Determinate) view;
                }
                if (view instanceof Indeterminate) {
                    this.mIndeterminateView = (Indeterminate) view;
                }
                this.mView = view;
                if (isShowing()) {
                    this.mCustomViewContainer.removeAllViews();
                    addViewToFrame(view);
                }
            }
        }

        public void setLabel(String str) {
            this.mLabel = str;
            TextView textView = this.mLabelText;
            if (textView == null) {
                return;
            }
            if (str != null) {
                textView.setText(str);
                this.mLabelText.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }

        public void setDetailsLabel(String str) {
            this.mDetailsLabel = str;
            TextView textView = this.mDetailsText;
            if (textView == null) {
                return;
            }
            if (str != null) {
                textView.setText(str);
                this.mDetailsText.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }

        public void setLabel(String str, int i) {
            this.mLabel = str;
            this.mLabelColor = i;
            TextView textView = this.mLabelText;
            if (textView == null) {
                return;
            }
            if (str != null) {
                textView.setText(str);
                this.mLabelText.setTextColor(i);
                this.mLabelText.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }

        public void setDetailsLabel(String str, int i) {
            this.mDetailsLabel = str;
            this.mDetailColor = i;
            TextView textView = this.mDetailsText;
            if (textView == null) {
                return;
            }
            if (str != null) {
                textView.setText(str);
                this.mDetailsText.setTextColor(i);
                this.mDetailsText.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }

        public void setSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            if (this.mBackgroundLayout != null) {
                updateBackgroundSize();
            }
        }
    }
}
