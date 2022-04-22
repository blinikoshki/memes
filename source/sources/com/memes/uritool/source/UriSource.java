package com.memes.uritool.source;

import com.memes.uritool.resolve.UriResolveResult;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/uritool/source/UriSource;", "", "isSupportedUri", "", "resolve", "Lcom/memes/uritool/resolve/UriResolveResult;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UriSource.kt */
public interface UriSource {
    boolean isSupportedUri();

    UriResolveResult resolve();
}
