package com.getstream.sdk.chat.style;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/ChatFontsImpl;", "Lcom/getstream/sdk/chat/style/ChatFonts;", "style", "Lcom/getstream/sdk/chat/style/ChatStyle;", "context", "Landroid/content/Context;", "(Lcom/getstream/sdk/chat/style/ChatStyle;Landroid/content/Context;)V", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "pathMap", "", "", "Landroid/graphics/Typeface;", "resourceMap", "Landroid/util/SparseArray;", "getFont", "textStyle", "Lcom/getstream/sdk/chat/style/TextStyle;", "fontRes", "", "fontPath", "safeLoadTypeface", "setDefaultFont", "", "textView", "Landroid/widget/TextView;", "setFont", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatFontsImpl.kt */
public final class ChatFontsImpl implements ChatFonts {
    private final Context context;
    private final TaggedLogger logger;
    private final Map<String, Typeface> pathMap = new HashMap();
    private final SparseArray<Typeface> resourceMap = new SparseArray<>();
    private final ChatStyle style;

    public ChatFontsImpl(ChatStyle chatStyle, Context context2) {
        Intrinsics.checkNotNullParameter(chatStyle, "style");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.style = chatStyle;
        this.context = context2;
        ChatLogger.Companion companion = ChatLogger.Companion;
        String simpleName = ChatFonts.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ChatFonts::class.java.simpleName");
        this.logger = companion.get(simpleName);
    }

    public void setFont(TextStyle textStyle, TextView textView) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (textStyle.getFont() != null) {
            textView.setTypeface(textStyle.getFont(), textStyle.getStyle());
        } else {
            setDefaultFont(textView, textStyle.getStyle());
        }
    }

    public Typeface getFont(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        if (textStyle.getFontResource() != -1) {
            return getFont(textStyle.getFontResource());
        }
        CharSequence fontAssetsPath = textStyle.getFontAssetsPath();
        if (fontAssetsPath == null || fontAssetsPath.length() == 0) {
            return null;
        }
        String fontAssetsPath2 = textStyle.getFontAssetsPath();
        Intrinsics.checkNotNull(fontAssetsPath2);
        return getFont(fontAssetsPath2);
    }

    private final Typeface getFont(String str) {
        if (this.pathMap.containsKey(str)) {
            return this.pathMap.get(str);
        }
        Typeface safeLoadTypeface = safeLoadTypeface(str);
        if (safeLoadTypeface == null) {
            return null;
        }
        this.pathMap.put(str, safeLoadTypeface);
        return safeLoadTypeface;
    }

    private final Typeface getFont(int i) {
        if (this.resourceMap.indexOfKey(i) >= 0) {
            return this.resourceMap.get(i);
        }
        Typeface safeLoadTypeface = safeLoadTypeface(i);
        if (safeLoadTypeface == null) {
            return null;
        }
        this.resourceMap.put(i, safeLoadTypeface);
        return safeLoadTypeface;
    }

    private final void setDefaultFont(TextView textView, int i) {
        if (this.style.hasDefaultFont()) {
            textView.setTypeface(getFont(this.style.getDefaultTextStyle()), i);
        } else {
            textView.setTypeface(Typeface.DEFAULT, i);
        }
    }

    private final Typeface safeLoadTypeface(int i) {
        try {
            return ResourcesCompat.getFont(this.context, i);
        } catch (Throwable th) {
            this.logger.logE(th);
            return null;
        }
    }

    private final Typeface safeLoadTypeface(String str) {
        try {
            return Typeface.createFromAsset(this.context.getAssets(), str);
        } catch (Throwable th) {
            this.logger.logE(th);
            return null;
        }
    }
}
