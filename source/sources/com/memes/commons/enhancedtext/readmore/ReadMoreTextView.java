package com.memes.commons.enhancedtext.readmore;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.memes.commons.C4144R;

public class ReadMoreTextView extends AppCompatTextView {
    private static final boolean DEFAULT_SHOW_TRIM_EXPANDED_TEXT = true;
    private static final int DEFAULT_TRIM_LENGTH = 240;
    private static final int DEFAULT_TRIM_LINES = 2;
    private static final String ELLIPSIZE = "... ";
    private static final int INVALID_END_INDEX = -1;
    private static final int TRIM_MODE_LENGTH = 1;
    private static final int TRIM_MODE_LINES = 0;
    private TextView.BufferType bufferType;
    /* access modifiers changed from: private */
    public int colorClickableText;
    /* access modifiers changed from: protected */
    public boolean isClickConsumedBySpan;
    private int lineEndIndex;
    private View.OnClickListener onClickListener;
    /* access modifiers changed from: private */
    public boolean readMore;
    private boolean showTrimExpandedText;
    private CharSequence text;
    private CharSequence trimCollapsedText;
    private CharSequence trimExpandedText;
    private int trimLength;
    private int trimLines;
    private int trimMode;
    private ReadMoreClickableSpan viewMoreSpan;

    public ReadMoreTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ReadMoreTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReadMoreTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.readMore = true;
        this.onClickListener = null;
        this.isClickConsumedBySpan = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4144R.styleable.ReadMoreTextView);
        this.trimLength = obtainStyledAttributes.getInt(C4144R.styleable.ReadMoreTextView_trimLength, 240);
        int resourceId = obtainStyledAttributes.getResourceId(C4144R.styleable.ReadMoreTextView_trimCollapsedText, C4144R.string.read_more);
        int resourceId2 = obtainStyledAttributes.getResourceId(C4144R.styleable.ReadMoreTextView_trimExpandedText, C4144R.string.read_less);
        this.trimCollapsedText = getResources().getString(resourceId);
        this.trimExpandedText = getResources().getString(resourceId2);
        this.trimLines = obtainStyledAttributes.getInt(C4144R.styleable.ReadMoreTextView_trimLines, 2);
        this.colorClickableText = obtainStyledAttributes.getColor(C4144R.styleable.ReadMoreTextView_colorClickableText, ContextCompat.getColor(context, 17170443));
        this.showTrimExpandedText = obtainStyledAttributes.getBoolean(C4144R.styleable.ReadMoreTextView_showTrimExpandedText, true);
        this.trimMode = obtainStyledAttributes.getInt(C4144R.styleable.ReadMoreTextView_trimMode, 0);
        obtainStyledAttributes.recycle();
        this.viewMoreSpan = new ReadMoreClickableSpan();
        onGlobalLayoutLineEndIndex();
        setText();
    }

    /* access modifiers changed from: private */
    public void setText() {
        super.setText(getDisplayableText(), this.bufferType);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
    }

    private CharSequence getDisplayableText() {
        return getTrimmedText(this.text);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType2) {
        this.text = charSequence;
        this.bufferType = bufferType2;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence charSequence) {
        if (this.trimMode != 1 || charSequence == null || charSequence.length() <= this.trimLength) {
            if (this.trimMode != 0 || charSequence == null || this.lineEndIndex <= 0) {
                return charSequence;
            }
            if (!this.readMore) {
                return updateExpandedText();
            }
            if (getLayout().getLineCount() > this.trimLines) {
                return updateCollapsedText();
            }
            return charSequence;
        } else if (this.readMore) {
            return updateCollapsedText();
        } else {
            return updateExpandedText();
        }
    }

    private CharSequence updateCollapsedText() {
        int i;
        int length = this.text.length();
        int i2 = this.trimMode;
        if (i2 != 0) {
            if (i2 == 1) {
                i = this.trimLength;
            }
            return addClickableSpan(new SpannableStringBuilder(this.text, 0, length).append(ELLIPSIZE).append(this.trimCollapsedText), this.trimCollapsedText);
        }
        length = this.lineEndIndex - ((4 + this.trimCollapsedText.length()) + 1);
        if (length < 0) {
            i = this.trimLength;
        }
        return addClickableSpan(new SpannableStringBuilder(this.text, 0, length).append(ELLIPSIZE).append(this.trimCollapsedText), this.trimCollapsedText);
        length = i + 1;
        return addClickableSpan(new SpannableStringBuilder(this.text, 0, length).append(ELLIPSIZE).append(this.trimCollapsedText), this.trimCollapsedText);
    }

    private CharSequence updateExpandedText() {
        if (!this.showTrimExpandedText) {
            return this.text;
        }
        CharSequence charSequence = this.text;
        return addClickableSpan(new SpannableStringBuilder(charSequence, 0, charSequence.length()).append(this.trimExpandedText), this.trimExpandedText);
    }

    private CharSequence addClickableSpan(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        spannableStringBuilder.setSpan(this.viewMoreSpan, spannableStringBuilder.length() - charSequence.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public void setTrimLength(int i) {
        this.trimLength = i;
        setText();
    }

    public void setColorClickableText(int i) {
        this.colorClickableText = i;
    }

    public void setTrimCollapsedText(CharSequence charSequence) {
        this.trimCollapsedText = charSequence;
    }

    public void setTrimExpandedText(CharSequence charSequence) {
        this.trimExpandedText = charSequence;
    }

    public void setTrimMode(int i) {
        this.trimMode = i;
    }

    public void setTrimLines(int i) {
        this.trimLines = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
        super.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReadMoreTextView.this.lambda$setOnClickListener$0$ReadMoreTextView(view);
            }
        });
    }

    public /* synthetic */ void lambda$setOnClickListener$0$ReadMoreTextView(View view) {
        if (this.isClickConsumedBySpan) {
            this.isClickConsumedBySpan = false;
        } else {
            this.onClickListener.onClick(view);
        }
    }

    private class ReadMoreClickableSpan extends ClickableSpan {
        private ReadMoreClickableSpan() {
        }

        public void onClick(View view) {
            ReadMoreTextView.this.isClickConsumedBySpan = true;
            ReadMoreTextView readMoreTextView = ReadMoreTextView.this;
            boolean unused = readMoreTextView.readMore = true ^ readMoreTextView.readMore;
            ReadMoreTextView.this.setText();
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ReadMoreTextView.this.colorClickableText);
        }
    }

    private void onGlobalLayoutLineEndIndex() {
        if (this.trimMode == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = ReadMoreTextView.this.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                    ReadMoreTextView.this.refreshLineEndIndex();
                    ReadMoreTextView.this.setText();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void refreshLineEndIndex() {
        try {
            int i = this.trimLines;
            if (i == 0) {
                this.lineEndIndex = getLayout().getLineEnd(0);
            } else if (i <= 0 || getLineCount() < this.trimLines) {
                this.lineEndIndex = -1;
            } else {
                this.lineEndIndex = getLayout().getLineEnd(this.trimLines - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
