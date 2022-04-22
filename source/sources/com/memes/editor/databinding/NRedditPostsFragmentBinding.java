package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.editor.C4175R;

public final class NRedditPostsFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final NSnippetSearchLayoutBinding includedSearchLayout;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView searchQueryResultTextView;
    public final RecyclerView suggestionsRecyclerView;

    private NRedditPostsFragmentBinding(LinearLayout linearLayout, ContentLayout contentLayout2, NSnippetSearchLayoutBinding nSnippetSearchLayoutBinding, RecyclerView recyclerView2, TextView textView, RecyclerView recyclerView3) {
        this.rootView = linearLayout;
        this.contentLayout = contentLayout2;
        this.includedSearchLayout = nSnippetSearchLayoutBinding;
        this.recyclerView = recyclerView2;
        this.searchQueryResultTextView = textView;
        this.suggestionsRecyclerView = recyclerView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NRedditPostsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NRedditPostsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_reddit_posts_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.memes.editor.C4175R.C4179id.included_search_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NRedditPostsFragmentBinding bind(android.view.View r9) {
        /*
            int r0 = com.memes.editor.C4175R.C4179id.content_layout
            android.view.View r1 = r9.findViewById(r0)
            r4 = r1
            com.memes.commons.contentlayout.ContentLayout r4 = (com.memes.commons.contentlayout.ContentLayout) r4
            if (r4 == 0) goto L_0x0042
            int r0 = com.memes.editor.C4175R.C4179id.included_search_layout
            android.view.View r1 = r9.findViewById(r0)
            if (r1 == 0) goto L_0x0042
            com.memes.editor.databinding.NSnippetSearchLayoutBinding r5 = com.memes.editor.databinding.NSnippetSearchLayoutBinding.bind(r1)
            int r0 = com.memes.editor.C4175R.C4179id.recycler_view
            android.view.View r1 = r9.findViewById(r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x0042
            int r0 = com.memes.editor.C4175R.C4179id.search_query_result_text_view
            android.view.View r1 = r9.findViewById(r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0042
            int r0 = com.memes.editor.C4175R.C4179id.suggestions_recycler_view
            android.view.View r1 = r9.findViewById(r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x0042
            com.memes.editor.databinding.NRedditPostsFragmentBinding r0 = new com.memes.editor.databinding.NRedditPostsFragmentBinding
            r3 = r9
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0042:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NRedditPostsFragmentBinding.bind(android.view.View):com.memes.editor.databinding.NRedditPostsFragmentBinding");
    }
}
