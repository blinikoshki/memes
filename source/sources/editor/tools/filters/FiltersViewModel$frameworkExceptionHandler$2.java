package editor.tools.filters;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FiltersViewModel.kt */
final class FiltersViewModel$frameworkExceptionHandler$2 extends Lambda implements Function0<CoroutineExceptionHandler> {
    final /* synthetic */ FiltersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiltersViewModel$frameworkExceptionHandler$2(FiltersViewModel filtersViewModel) {
        super(0);
        this.this$0 = filtersViewModel;
    }

    public final CoroutineExceptionHandler invoke() {
        return new C4920x76ffc87a(CoroutineExceptionHandler.Key, this);
    }
}
