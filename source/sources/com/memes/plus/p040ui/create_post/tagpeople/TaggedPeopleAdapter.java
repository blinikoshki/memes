package com.memes.plus.p040ui.create_post.tagpeople;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.TaggedPeopleItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/tagpeople/TaggedPeopleAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/create_post/tagpeople/TaggedPerson;", "Lcom/memes/plus/ui/create_post/tagpeople/TaggedPeopleAdapter$TaggedPeopleViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "TaggedPeopleViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.tagpeople.TaggedPeopleAdapter */
/* compiled from: TaggedPeopleAdapter.kt */
public final class TaggedPeopleAdapter extends BaseRecyclerAdapter<TaggedPerson, TaggedPeopleViewHolder> {
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaggedPeopleAdapter(Context context2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public TaggedPeopleViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        TaggedPeopleItemBinding inflate = TaggedPeopleItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "TaggedPeopleItemBinding.…(inflater, parent, false)");
        return new TaggedPeopleViewHolder(this, inflate);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/tagpeople/TaggedPeopleAdapter$TaggedPeopleViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/create_post/tagpeople/TaggedPerson;", "binding", "Lcom/memes/plus/databinding/TaggedPeopleItemBinding;", "(Lcom/memes/plus/ui/create_post/tagpeople/TaggedPeopleAdapter;Lcom/memes/plus/databinding/TaggedPeopleItemBinding;)V", "taggedPerson", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.tagpeople.TaggedPeopleAdapter$TaggedPeopleViewHolder */
    /* compiled from: TaggedPeopleAdapter.kt */
    public final class TaggedPeopleViewHolder extends BaseViewHolder<TaggedPerson> {
        private final TaggedPeopleItemBinding binding;
        private TaggedPerson taggedPerson;
        final /* synthetic */ TaggedPeopleAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TaggedPeopleViewHolder(com.memes.plus.p040ui.create_post.tagpeople.TaggedPeopleAdapter r2, com.memes.plus.databinding.TaggedPeopleItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.FrameLayout r2 = r3.deleteItemView
                com.memes.plus.ui.create_post.tagpeople.TaggedPeopleAdapter$TaggedPeopleViewHolder$1 r3 = new com.memes.plus.ui.create_post.tagpeople.TaggedPeopleAdapter$TaggedPeopleViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.create_post.tagpeople.TaggedPeopleAdapter.TaggedPeopleViewHolder.<init>(com.memes.plus.ui.create_post.tagpeople.TaggedPeopleAdapter, com.memes.plus.databinding.TaggedPeopleItemBinding):void");
        }

        public void setItem(TaggedPerson taggedPerson2) {
            Intrinsics.checkNotNullParameter(taggedPerson2, "item");
            this.taggedPerson = taggedPerson2;
            TextView textView = this.binding.nameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.nameTextView");
            TaggedPerson taggedPerson3 = this.taggedPerson;
            if (taggedPerson3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taggedPerson");
            }
            textView.setText(taggedPerson3.getName());
            TextView textView2 = this.binding.usernameTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.usernameTextView");
            TaggedPerson taggedPerson4 = this.taggedPerson;
            if (taggedPerson4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taggedPerson");
            }
            textView2.setText(taggedPerson4.getUserName());
            this.binding.profilePicImageView.setProUser(taggedPerson2.isProUser());
            UserAvatarView userAvatarView = this.binding.profilePicImageView;
            TaggedPerson taggedPerson5 = this.taggedPerson;
            if (taggedPerson5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taggedPerson");
            }
            UserAvatarView.loadUrl$default(userAvatarView, taggedPerson5.getProfilePicUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }
    }
}
