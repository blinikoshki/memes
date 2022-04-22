package com.memes.plus.p040ui.explore_search.tag_search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "", "()V", "tagName", "", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "totalPostsCount", "getTotalPostsCount", "setTotalPostsCount", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResult */
/* compiled from: TagSearchResult.kt */
public final class TagSearchResult {
    @SerializedName("tagName")
    @Expose
    private String tagName;
    @SerializedName("total")
    @Expose
    private String totalPostsCount;

    public final String getTotalPostsCount() {
        return this.totalPostsCount;
    }

    public final void setTotalPostsCount(String str) {
        this.totalPostsCount = str;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final void setTagName(String str) {
        this.tagName = str;
    }
}
