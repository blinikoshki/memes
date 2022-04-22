package com.memes.plus.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000  2\u00020\u0001:\u0002 !B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tJ(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\tJ\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\u000fR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcom/memes/plus/util/CustomTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPieces", "", "Lcom/memes/plus/util/CustomTextView$Piece;", "addPiece", "", "aPiece", "location", "applySpannablesTo", "finalString", "Landroid/text/SpannableString;", "start", "end", "changeTextColor", "textColor", "display", "getPiece", "init", "removePiece", "replacePieceAt", "newPiece", "reset", "Companion", "Piece", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CustomTextView.kt */
public final class CustomTextView extends AppCompatTextView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int DEFAULT_ABSOLUTE_TEXT_SIZE;
    /* access modifiers changed from: private */
    public static float DEFAULT_RELATIVE_TEXT_SIZE = 1.0f;
    private List<Piece> mPieces;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/util/CustomTextView$Companion;", "", "()V", "DEFAULT_ABSOLUTE_TEXT_SIZE", "", "DEFAULT_RELATIVE_TEXT_SIZE", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CustomTextView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        init();
    }

    private final void init() {
        this.mPieces = new ArrayList();
        DEFAULT_ABSOLUTE_TEXT_SIZE = (int) getTextSize();
    }

    public final void addPiece(Piece piece) {
        Intrinsics.checkNotNullParameter(piece, "aPiece");
        List<Piece> list = this.mPieces;
        Intrinsics.checkNotNull(list);
        list.add(piece);
    }

    public final void addPiece(Piece piece, int i) {
        Intrinsics.checkNotNullParameter(piece, "aPiece");
        List<Piece> list = this.mPieces;
        Intrinsics.checkNotNull(list);
        list.add(i, piece);
    }

    public final void replacePieceAt(int i, Piece piece) {
        Intrinsics.checkNotNullParameter(piece, "newPiece");
        List<Piece> list = this.mPieces;
        Intrinsics.checkNotNull(list);
        list.set(i, piece);
    }

    public final void removePiece(int i) {
        List<Piece> list = this.mPieces;
        Intrinsics.checkNotNull(list);
        list.remove(i);
    }

    public final Piece getPiece(int i) {
        if (i >= 0) {
            List<Piece> list = this.mPieces;
            Intrinsics.checkNotNull(list);
            if (i < list.size()) {
                List<Piece> list2 = this.mPieces;
                Intrinsics.checkNotNull(list2);
                return list2.get(i);
            }
        }
        return null;
    }

    public final void display() {
        StringBuilder sb = new StringBuilder();
        List<Piece> list = this.mPieces;
        Intrinsics.checkNotNull(list);
        for (Piece text : list) {
            sb.append(text.getText());
        }
        int i = 0;
        SpannableString spannableString = new SpannableString(sb.toString());
        List<Piece> list2 = this.mPieces;
        Intrinsics.checkNotNull(list2);
        for (Piece next : list2) {
            String text2 = next.getText();
            Intrinsics.checkNotNull(text2);
            applySpannablesTo(next, spannableString, i, text2.length() + i);
            String text3 = next.getText();
            Intrinsics.checkNotNull(text3);
            i += text3.length();
        }
        setText(spannableString);
    }

    private final void applySpannablesTo(Piece piece, SpannableString spannableString, int i, int i2) {
        if (piece.getSubscript()) {
            spannableString.setSpan(new SubscriptSpan(), i, i2, 33);
        }
        if (piece.getSuperscript()) {
            spannableString.setSpan(new SuperscriptSpan(), i, i2, 33);
        }
        if (piece.getStrike()) {
            spannableString.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (piece.getUnderline()) {
            spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        spannableString.setSpan(new StyleSpan(piece.getStyle()), i, i2, 33);
        String text = piece.getText();
        Intrinsics.checkNotNull(text);
        spannableString.setSpan(new CustomTypefaceSpan(text, piece.getTypeFace()), i, i2, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(piece.getTextSize()), i, i2, 33);
        spannableString.setSpan(new RelativeSizeSpan(piece.getTextSizeRelative()), i, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(piece.getTextColor()), i, i2, 33);
        if (piece.getBackgroundColor() != -1) {
            spannableString.setSpan(new BackgroundColorSpan(piece.getBackgroundColor()), i, i2, 33);
        }
    }

    public final void reset() {
        this.mPieces = new ArrayList();
        setText("");
    }

    public final void changeTextColor(int i) {
        List<Piece> list = this.mPieces;
        Intrinsics.checkNotNull(list);
        for (Piece textColorr : list) {
            textColorr.setTextColorr(i);
        }
        display();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010+\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\f¨\u0006-"}, mo26107d2 = {"Lcom/memes/plus/util/CustomTextView$Piece;", "", "builder", "Lcom/memes/plus/util/CustomTextView$Piece$Builder;", "(Lcom/memes/plus/util/CustomTextView$Piece$Builder;)V", "backgroundColor", "", "getBackgroundColor", "()I", "strike", "", "getStrike", "()Z", "style", "getStyle", "subscript", "getSubscript", "superscript", "getSuperscript", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "(I)V", "textSize", "getTextSize", "textSizeRelative", "", "getTextSizeRelative", "()F", "typeFace", "Landroid/graphics/Typeface;", "getTypeFace", "()Landroid/graphics/Typeface;", "underline", "getUnderline", "setSpanText", "", "setTextColorr", "Builder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CustomTextView.kt */
    public static final class Piece {
        private final int backgroundColor;
        private final boolean strike;
        private final int style;
        private final boolean subscript;
        private final boolean superscript;
        private String text;
        private int textColor;
        private final int textSize;
        private final float textSizeRelative;
        private final Typeface typeFace;
        private final boolean underline;

        public Piece(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.text = builder.getText();
            this.textSize = builder.getTextSize();
            this.textColor = builder.getTextColor();
            this.backgroundColor = builder.getBackgroundColor();
            this.textSizeRelative = builder.getTextSizeRelative();
            this.style = builder.getStyle();
            this.underline = builder.getUnderline();
            this.superscript = builder.getSuperscript();
            this.subscript = builder.getSubscript();
            this.strike = builder.getStrike();
            this.typeFace = builder.getTypeFace();
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final void setTextColor(int i) {
            this.textColor = i;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        public final float getTextSizeRelative() {
            return this.textSizeRelative;
        }

        public final int getStyle() {
            return this.style;
        }

        public final boolean getUnderline() {
            return this.underline;
        }

        public final boolean getSuperscript() {
            return this.superscript;
        }

        public final boolean getStrike() {
            return this.strike;
        }

        public final boolean getSubscript() {
            return this.subscript;
        }

        public final Typeface getTypeFace() {
            return this.typeFace;
        }

        public final void setSpanText(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public final void setTextColorr(int i) {
            this.textColor = i;
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u00101\u001a\u000202J\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0000J\u0006\u0010\u0017\u001a\u00020\u0000J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u0006\u0010.\u001a\u00020\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010¨\u00063"}, mo26107d2 = {"Lcom/memes/plus/util/CustomTextView$Piece$Builder;", "", "text", "", "(Ljava/lang/String;)V", "backgroundColor", "", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "strike", "", "getStrike", "()Z", "setStrike", "(Z)V", "style", "getStyle", "setStyle", "subscript", "getSubscript", "setSubscript", "superscript", "getSuperscript", "setSuperscript", "getText", "()Ljava/lang/String;", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "textSizeRelative", "", "getTextSizeRelative", "()F", "setTextSizeRelative", "(F)V", "typeFace", "Landroid/graphics/Typeface;", "getTypeFace", "()Landroid/graphics/Typeface;", "setTypeFace", "(Landroid/graphics/Typeface;)V", "underline", "getUnderline", "setUnderline", "build", "Lcom/memes/plus/util/CustomTextView$Piece;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CustomTextView.kt */
        public static final class Builder {
            private int backgroundColor = -1;
            private boolean strike;
            private int style;
            private boolean subscript;
            private boolean superscript;
            private final String text;
            private int textColor = -16777216;
            private int textSize = CustomTextView.DEFAULT_ABSOLUTE_TEXT_SIZE;
            private float textSizeRelative = CustomTextView.DEFAULT_RELATIVE_TEXT_SIZE;
            private Typeface typeFace;
            private boolean underline;

            public Builder(String str) {
                Intrinsics.checkNotNullParameter(str, "text");
                this.text = str;
                Typeface typeface = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "Typeface.DEFAULT");
                this.typeFace = typeface;
            }

            public final String getText() {
                return this.text;
            }

            public final int getTextSize() {
                return this.textSize;
            }

            public final void setTextSize(int i) {
                this.textSize = i;
            }

            public final int getTextColor() {
                return this.textColor;
            }

            public final void setTextColor(int i) {
                this.textColor = i;
            }

            public final int getBackgroundColor() {
                return this.backgroundColor;
            }

            public final void setBackgroundColor(int i) {
                this.backgroundColor = i;
            }

            public final float getTextSizeRelative() {
                return this.textSizeRelative;
            }

            public final void setTextSizeRelative(float f) {
                this.textSizeRelative = f;
            }

            public final int getStyle() {
                return this.style;
            }

            public final void setStyle(int i) {
                this.style = i;
            }

            public final boolean getUnderline() {
                return this.underline;
            }

            public final void setUnderline(boolean z) {
                this.underline = z;
            }

            public final boolean getStrike() {
                return this.strike;
            }

            public final void setStrike(boolean z) {
                this.strike = z;
            }

            public final boolean getSuperscript() {
                return this.superscript;
            }

            public final void setSuperscript(boolean z) {
                this.superscript = z;
            }

            public final boolean getSubscript() {
                return this.subscript;
            }

            public final void setSubscript(boolean z) {
                this.subscript = z;
            }

            public final Typeface getTypeFace() {
                return this.typeFace;
            }

            public final void setTypeFace(Typeface typeface) {
                Intrinsics.checkNotNullParameter(typeface, "<set-?>");
                this.typeFace = typeface;
            }

            public final Builder textSize(int i) {
                this.textSize = i;
                return this;
            }

            public final Builder textColor(int i) {
                this.textColor = i;
                return this;
            }

            public final Builder backgroundColor(int i) {
                this.backgroundColor = i;
                return this;
            }

            public final Builder textSizeRelative(float f) {
                this.textSizeRelative = f;
                return this;
            }

            public final Builder style(int i) {
                this.style = i;
                return this;
            }

            public final Builder underline() {
                this.underline = true;
                return this;
            }

            public final Builder strike() {
                this.strike = true;
                return this;
            }

            public final Builder superscript() {
                this.superscript = true;
                return this;
            }

            public final Builder subscript() {
                this.subscript = true;
                return this;
            }

            public final Builder typeFace(Typeface typeface) {
                Intrinsics.checkNotNullParameter(typeface, "typeFace");
                this.typeFace = typeface;
                return this;
            }

            public final Piece build() {
                return new Piece(this);
            }
        }
    }
}
