package editor.common.choicesbottomsheet.categories;

import editor.common.choicesbottomsheet.Choice;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/common/choicesbottomsheet/categories/CropChoice;", "", "()V", "CURRENT", "", "ORIGINAL", "create", "", "Leditor/common/choicesbottomsheet/Choice;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropChoice.kt */
public final class CropChoice {
    public static final String CURRENT = "998";
    public static final CropChoice INSTANCE = new CropChoice();
    public static final String ORIGINAL = "997";

    private CropChoice() {
    }

    public final List<Choice> create() {
        return CollectionsKt.listOf(Choice.Companion.create$default(Choice.Companion, ORIGINAL, "Crop Original File", false, 4, (Object) null), Choice.Companion.create$default(Choice.Companion, CURRENT, "Crop Current File", false, 4, (Object) null));
    }
}
