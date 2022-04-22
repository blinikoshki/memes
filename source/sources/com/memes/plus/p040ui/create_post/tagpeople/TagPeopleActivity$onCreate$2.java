package com.memes.plus.p040ui.create_post.tagpeople;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.gson.Gson;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.tagpeople.TagPeopleActivity$onCreate$2 */
/* compiled from: TagPeopleActivity.kt */
final class TagPeopleActivity$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ TagPeopleActivity this$0;

    TagPeopleActivity$onCreate$2(TagPeopleActivity tagPeopleActivity) {
        this.this$0 = tagPeopleActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.getTaggedPeopleAdapter().getItems().isEmpty()) {
            ExtensionsKt.toast((Context) this.this$0, "No people were tagged.");
            this.this$0.setResult(-1, new Intent());
            this.this$0.finish();
            return;
        }
        String json = new Gson().toJson((Object) this.this$0.getTaggedPeopleAdapter().getItems());
        Timber.m300d("taggedPeopleJson -> " + json, new Object[0]);
        Intent intent = new Intent();
        intent.putExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE, json);
        intent.putExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE_COUNT, this.this$0.getTaggedPeopleAdapter().getItemCount());
        if (this.this$0.getTaggedPeopleAdapter().getItemCount() == 1) {
            intent.putExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE_NAME, ((TaggedPerson) this.this$0.getTaggedPeopleAdapter().getItems().get(0)).getUserName());
        }
        this.this$0.setResult(-1, intent);
        this.this$0.supportFinishAfterTransition();
    }
}
