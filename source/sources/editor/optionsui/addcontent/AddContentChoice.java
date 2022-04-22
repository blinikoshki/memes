package editor.optionsui.addcontent;

import editor.common.choicesbottomsheet.Choice;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/optionsui/addcontent/AddContentChoice;", "", "()V", "MEDIA", "", "TEXT", "create", "", "Leditor/common/choicesbottomsheet/Choice;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AddContentChoice.kt */
public final class AddContentChoice {
    public static final AddContentChoice INSTANCE = new AddContentChoice();
    public static final String MEDIA = "992";
    public static final String TEXT = "991";

    private AddContentChoice() {
    }

    public final List<Choice> create() {
        return CollectionsKt.listOf(Choice.Companion.create$default(Choice.Companion, TEXT, "Add Text", false, 4, (Object) null), Choice.Companion.create$default(Choice.Companion, MEDIA, "Add Media", false, 4, (Object) null));
    }
}
