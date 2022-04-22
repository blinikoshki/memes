package com.memes.commons.enhancedtext.socialtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.memes.commons.C4144R;
import com.memes.commons.enhancedtext.readmore.ReadMoreTextView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class SocialTextView extends ReadMoreTextView {
    public static final int EMAIL = 16;
    public static final int HASHTAG = 1;
    public static final int MENTION = 2;
    public static final int PHONE = 4;
    public static final int URL = 8;
    private static Pattern patternHashtag;
    private static Pattern patternMention;
    private int emailColor;
    private int flags;
    private int hashtagColor;
    /* access modifiers changed from: private */
    public OnLinkClickListener linkClickListener;
    private int mentionColor;
    private int phoneColor;
    private int selectedColor;
    private boolean underlineEnabled;
    private int urlColor;

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkOptions {
    }

    public interface OnLinkClickListener {
        void onLinkClicked(int i, String str);
    }

    public SocialTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SocialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SocialTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMovementMethod(AccurateMovementMethod.getInstance());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4144R.styleable.SocialTextView);
        this.flags = obtainStyledAttributes.getInt(C4144R.styleable.SocialTextView_linkModes, -1);
        this.hashtagColor = obtainStyledAttributes.getColor(C4144R.styleable.SocialTextView_hashtagColor, SupportMenu.CATEGORY_MASK);
        this.mentionColor = obtainStyledAttributes.getColor(C4144R.styleable.SocialTextView_mentionColor, SupportMenu.CATEGORY_MASK);
        this.phoneColor = obtainStyledAttributes.getColor(C4144R.styleable.SocialTextView_phoneColor, SupportMenu.CATEGORY_MASK);
        this.emailColor = obtainStyledAttributes.getColor(C4144R.styleable.SocialTextView_emailColor, SupportMenu.CATEGORY_MASK);
        this.urlColor = obtainStyledAttributes.getColor(C4144R.styleable.SocialTextView_urlColor, SupportMenu.CATEGORY_MASK);
        this.selectedColor = obtainStyledAttributes.getColor(C4144R.styleable.SocialTextView_selectedColor, -3355444);
        this.underlineEnabled = obtainStyledAttributes.getBoolean(C4144R.styleable.SocialTextView_underlineEnabled, false);
        if (obtainStyledAttributes.hasValue(C4144R.styleable.SocialTextView_android_text)) {
            setLinkText(obtainStyledAttributes.getString(C4144R.styleable.SocialTextView_android_text));
        }
        if (obtainStyledAttributes.hasValue(C4144R.styleable.SocialTextView_android_hint)) {
            setLinkHint(obtainStyledAttributes.getString(C4144R.styleable.SocialTextView_android_hint));
        }
        obtainStyledAttributes.recycle();
    }

    public void setHighlightColor(int i) {
        super.setHighlightColor(0);
    }

    public void setLinkText(String str) {
        setText(createSocialMediaSpan(str));
    }

    public SpannableString createSpansFor(String str) {
        return createSocialMediaSpan(str);
    }

    public void appendLinkText(String str) {
        append(createSocialMediaSpan(str));
    }

    public void setLinkHint(String str) {
        setHint(createSocialMediaSpan(str));
    }

    public void setOnLinkClickListener(OnLinkClickListener onLinkClickListener) {
        this.linkClickListener = onLinkClickListener;
    }

    private SpannableString createSocialMediaSpan(String str) {
        Set<LinkItem> collectLinkItemsFromText = collectLinkItemsFromText(str);
        SpannableString spannableString = new SpannableString(str);
        for (LinkItem next : collectLinkItemsFromText) {
            final LinkItem linkItem = next;
            spannableString.setSpan(new TouchableSpan(getColorByMode(next.mode), this.selectedColor, this.underlineEnabled) {
                public void onClick(View view) {
                    if (SocialTextView.this.linkClickListener != null) {
                        boolean unused = SocialTextView.this.isClickConsumedBySpan = true;
                        SocialTextView.this.linkClickListener.onLinkClicked(linkItem.mode, linkItem.matched);
                    }
                }
            }, next.start, next.end, 33);
        }
        return spannableString;
    }

    private Set<LinkItem> collectLinkItemsFromText(String str) {
        HashSet hashSet = new HashSet();
        if ((this.flags & 1) == 1) {
            collectLinkItems(1, hashSet, getHashtagPattern().matcher(str));
        }
        if ((this.flags & 2) == 2) {
            collectLinkItems(2, hashSet, getMentionPattern().matcher(str));
        }
        if ((this.flags & 4) == 4) {
            collectLinkItems(4, hashSet, Patterns.PHONE.matcher(str));
        }
        if ((this.flags & 8) == 8) {
            collectLinkItems(8, hashSet, Patterns.WEB_URL.matcher(str));
        }
        if ((this.flags & 16) == 16) {
            collectLinkItems(16, hashSet, Patterns.EMAIL_ADDRESS.matcher(str));
        }
        return hashSet;
    }

    private void collectLinkItems(int i, Collection<LinkItem> collection, Matcher matcher) {
        while (matcher.find()) {
            int start = matcher.start();
            String group = matcher.group();
            if (group.startsWith(StringUtils.SPACE)) {
                start++;
                group = group.substring(1);
            }
            collection.add(new LinkItem(group, start, matcher.end(), i));
        }
    }

    private int getColorByMode(int i) {
        if (i == 1) {
            return this.hashtagColor;
        }
        if (i == 2) {
            return this.mentionColor;
        }
        if (i == 4) {
            return this.phoneColor;
        }
        if (i == 8) {
            return this.urlColor;
        }
        if (i == 16) {
            return this.emailColor;
        }
        throw new IllegalArgumentException("Invalid mode!");
    }

    private static Pattern getHashtagPattern() {
        if (patternHashtag == null) {
            patternHashtag = Pattern.compile("(?:^|\\s|$)#[\\p{L}0-9_]*");
        }
        return patternHashtag;
    }

    private static Pattern getMentionPattern() {
        if (patternMention == null) {
            patternMention = Pattern.compile("(?:^|\\s|$|[.])@[\\p{L}0-9_]*");
        }
        return patternMention;
    }

    private final class LinkItem {
        /* access modifiers changed from: private */
        public final int end;
        /* access modifiers changed from: private */
        public final String matched;
        /* access modifiers changed from: private */
        public final int mode;
        /* access modifiers changed from: private */
        public final int start;

        private LinkItem(String str, int i, int i2, int i3) {
            this.matched = str;
            this.start = i;
            this.end = i2;
            this.mode = i3;
        }
    }
}
