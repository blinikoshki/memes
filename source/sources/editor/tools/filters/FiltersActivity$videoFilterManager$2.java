package editor.tools.filters;

import editor.tools.filters.helpers.MediaVideoFilterManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/tools/filters/helpers/MediaVideoFilterManager;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FiltersActivity.kt */
final class FiltersActivity$videoFilterManager$2 extends Lambda implements Function0<MediaVideoFilterManager> {
    public static final FiltersActivity$videoFilterManager$2 INSTANCE = new FiltersActivity$videoFilterManager$2();

    FiltersActivity$videoFilterManager$2() {
        super(0);
    }

    public final MediaVideoFilterManager invoke() {
        return new MediaVideoFilterManager();
    }
}
