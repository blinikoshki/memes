package com.getstream.sdk.chat;

import android.content.Context;
import android.widget.TextView;
import p015io.noties.markwon.Markwon;
import p015io.noties.markwon.core.CorePlugin;
import p015io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import p015io.noties.markwon.image.ImagesPlugin;
import p015io.noties.markwon.linkify.LinkifyPlugin;

class ChatMarkdownImpl implements ChatMarkdown {
    private final Markwon markwon;

    public ChatMarkdownImpl(Context context) {
        this.markwon = Markwon.builder(context).usePlugin(CorePlugin.create()).usePlugin(LinkifyPlugin.create()).usePlugin(ImagesPlugin.create()).usePlugin(StrikethroughPlugin.create()).build();
    }

    public void setText(TextView textView, String str) {
        this.markwon.setMarkdown(textView, str);
    }
}
