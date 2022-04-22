package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.text.webvtt.-$$Lambda$WebvttCueParser$Element$VyiDJ7qRfxCLGd6CXvAWYb7Vhxg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WebvttCueParser$Element$VyiDJ7qRfxCLGd6CXvAWYb7Vhxg implements Comparator {
    public static final /* synthetic */ $$Lambda$WebvttCueParser$Element$VyiDJ7qRfxCLGd6CXvAWYb7Vhxg INSTANCE = new $$Lambda$WebvttCueParser$Element$VyiDJ7qRfxCLGd6CXvAWYb7Vhxg();

    private /* synthetic */ $$Lambda$WebvttCueParser$Element$VyiDJ7qRfxCLGd6CXvAWYb7Vhxg() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((WebvttCueParser.Element) obj).startTag.position, ((WebvttCueParser.Element) obj2).startTag.position);
    }
}
