package editor.optionsui.layout.templates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.databinding.NTemplateItemBinding;
import editor.core.NicoRecyclerAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, mo26107d2 = {"Leditor/optionsui/layout/templates/TemplatesAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/layout/templates/Template;", "context", "Landroid/content/Context;", "callback", "Leditor/optionsui/layout/templates/TemplatesAdapter$Callback;", "(Landroid/content/Context;Leditor/optionsui/layout/templates/TemplatesAdapter$Callback;)V", "cornerRadius", "", "getCornerRadius", "()F", "cornerRadius$delegate", "Lkotlin/Lazy;", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "Callback", "TemplateViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TemplatesAdapter.kt */
public final class TemplatesAdapter extends NicoRecyclerAdapter<Template> {
    /* access modifiers changed from: private */
    public final Callback callback;
    private final Lazy cornerRadius$delegate;
    /* access modifiers changed from: private */
    public final RequestManager glideRequestManager;
    private final Lazy layoutInflater$delegate;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/layout/templates/TemplatesAdapter$Callback;", "", "onTemplateTapped", "", "template", "Leditor/optionsui/layout/templates/Template;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TemplatesAdapter.kt */
    public interface Callback {
        void onTemplateTapped(Template template);
    }

    /* access modifiers changed from: private */
    public final float getCornerRadius() {
        return ((Number) this.cornerRadius$delegate.getValue()).floatValue();
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public TemplatesAdapter(Context context, Callback callback2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        RequestManager with = Glide.with(context);
        Intrinsics.checkNotNullExpressionValue(with, "Glide.with(context)");
        this.glideRequestManager = with;
        this.layoutInflater$delegate = LazyKt.lazy(new TemplatesAdapter$layoutInflater$2(context));
        this.cornerRadius$delegate = LazyKt.lazy(new TemplatesAdapter$cornerRadius$2(context));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NTemplateItemBinding inflate = NTemplateItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTemplateItemBinding.inf…tInflater, parent, false)");
        return new TemplateViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof TemplateViewHolder) {
            ((TemplateViewHolder) viewHolder).setItem((Template) getItemAt(i));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/optionsui/layout/templates/TemplatesAdapter$TemplateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NTemplateItemBinding;", "(Leditor/optionsui/layout/templates/TemplatesAdapter;Lcom/memes/editor/databinding/NTemplateItemBinding;)V", "template", "Leditor/optionsui/layout/templates/Template;", "cleanup", "", "setItem", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TemplatesAdapter.kt */
    private final class TemplateViewHolder extends RecyclerView.ViewHolder {
        private final NTemplateItemBinding binding;
        /* access modifiers changed from: private */
        public Template template;
        final /* synthetic */ TemplatesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TemplateViewHolder(TemplatesAdapter templatesAdapter, NTemplateItemBinding nTemplateItemBinding) {
            super(nTemplateItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nTemplateItemBinding, "binding");
            this.this$0 = templatesAdapter;
            this.binding = nTemplateItemBinding;
            nTemplateItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ TemplateViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.callback.onTemplateTapped(TemplateViewHolder.access$getTemplate$p(this.this$0));
                }
            });
            AspectRatioFrameLayout root = nTemplateItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewCornerOutlineProviderKt.roundCorners$default((View) root, templatesAdapter.getCornerRadius(), (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
        }

        public static final /* synthetic */ Template access$getTemplate$p(TemplateViewHolder templateViewHolder) {
            Template template2 = templateViewHolder.template;
            if (template2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
            }
            return template2;
        }

        public final void setItem(Template template2) {
            Intrinsics.checkNotNullParameter(template2, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
            this.template = template2;
            this.binding.aspectRatioFrameLayout.setAspectRatio(template2.aspectRatio());
            ((RequestBuilder) ((RequestBuilder) this.this$0.glideRequestManager.load(template2.getThumbnailPath()).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).into(this.binding.imageView);
        }

        public final void cleanup() {
            this.this$0.glideRequestManager.clear((View) this.binding.imageView);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof TemplateViewHolder) {
            ((TemplateViewHolder) viewHolder).cleanup();
        }
        super.onViewRecycled(viewHolder);
    }
}
