package editor.signature.view;

import android.os.Build;
import android.view.View;

public class ViewCompat {
    public static boolean isLaidOut(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }
}
