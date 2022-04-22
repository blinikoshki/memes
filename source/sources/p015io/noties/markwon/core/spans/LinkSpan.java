package p015io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import p015io.noties.markwon.LinkResolver;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.core.spans.LinkSpan */
public class LinkSpan extends URLSpan {
    private final String link;
    private final LinkResolver resolver;
    private final MarkwonTheme theme;

    public LinkSpan(MarkwonTheme markwonTheme, String str, LinkResolver linkResolver) {
        super(str);
        this.theme = markwonTheme;
        this.link = str;
        this.resolver = linkResolver;
    }

    public void onClick(View view) {
        this.resolver.resolve(view, this.link);
    }

    public void updateDrawState(TextPaint textPaint) {
        this.theme.applyLinkStyle(textPaint);
    }

    public String getLink() {
        return this.link;
    }
}
