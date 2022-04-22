package p015io.noties.markwon.movement;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.widget.TextView;
import p015io.noties.markwon.AbstractMarkwonPlugin;
import p015io.noties.markwon.MarkwonPlugin;
import p015io.noties.markwon.core.CorePlugin;

/* renamed from: io.noties.markwon.movement.MovementMethodPlugin */
public class MovementMethodPlugin extends AbstractMarkwonPlugin {
    private final MovementMethod movementMethod;

    @Deprecated
    public static MovementMethodPlugin create() {
        return create(LinkMovementMethod.getInstance());
    }

    public static MovementMethodPlugin link() {
        return create(LinkMovementMethod.getInstance());
    }

    public static MovementMethodPlugin none() {
        return new MovementMethodPlugin((MovementMethod) null);
    }

    public static MovementMethodPlugin create(MovementMethod movementMethod2) {
        return new MovementMethodPlugin(movementMethod2);
    }

    MovementMethodPlugin(MovementMethod movementMethod2) {
        this.movementMethod = movementMethod2;
    }

    public void configure(MarkwonPlugin.Registry registry) {
        ((CorePlugin) registry.require(CorePlugin.class)).hasExplicitMovementMethod(true);
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
        MovementMethod movementMethod2 = textView.getMovementMethod();
        MovementMethod movementMethod3 = this.movementMethod;
        if (movementMethod2 != movementMethod3) {
            textView.setMovementMethod(movementMethod3);
        }
    }
}
