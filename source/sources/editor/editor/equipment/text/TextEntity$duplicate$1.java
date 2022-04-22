package editor.editor.equipment.text;

import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.property.NicoProperty;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextEntity.kt */
final class TextEntity$duplicate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextEntity $newEntity;
    final /* synthetic */ TextEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextEntity$duplicate$1(TextEntity textEntity, TextEntity textEntity2) {
        super(0);
        this.this$0 = textEntity;
        this.$newEntity = textEntity2;
    }

    public final void invoke() {
        float f = (float) 20;
        this.$newEntity.applyProperty(new NicoProperty.Translate(((TextLayer) this.this$0.getLayer()).getX() + f, ((TextLayer) this.this$0.getLayer()).getY() + f));
        CoreEntity.show$default(this.$newEntity, false, 1, (Object) null);
    }
}
