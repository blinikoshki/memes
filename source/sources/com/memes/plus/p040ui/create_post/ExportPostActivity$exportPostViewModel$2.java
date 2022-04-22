package com.memes.plus.p040ui.create_post;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.media.MediaScannerUtility;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/create_post/ExportPostViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$exportPostViewModel$2 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$exportPostViewModel$2 extends Lambda implements Function0<ExportPostViewModel> {
    final /* synthetic */ ExportPostActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExportPostActivity$exportPostViewModel$2(ExportPostActivity exportPostActivity) {
        super(0);
        this.this$0 = exportPostActivity;
    }

    public final ExportPostViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ExportPostViewModel>(this) {
            final /* synthetic */ ExportPostActivity$exportPostViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ExportPostViewModel invoke() {
                MemesRepository memesRepository = RepositoryInjection.INSTANCE.memesRepository();
                OutputTargetGenerator fromMemesDirectory = OutputTargetGenerator.Companion.fromMemesDirectory();
                Context applicationContext = this.this$0.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                MediaScannerUtility mediaScannerUtility = new MediaScannerUtility(applicationContext);
                RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
                Context applicationContext2 = this.this$0.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                return new ExportPostViewModel(memesRepository, fromMemesDirectory, mediaScannerUtility, repositoryInjection.storageRepository(applicationContext2));
            }
        })).get(ExportPostViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (ExportPostViewModel) viewModel;
    }
}
