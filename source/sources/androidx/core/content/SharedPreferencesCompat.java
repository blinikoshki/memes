package androidx.core.content;

import android.content.SharedPreferences;

@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper = new Helper();

        private static class Helper {
            Helper() {
            }

            public void apply(SharedPreferences.Editor editor2) {
                try {
                    editor2.apply();
                } catch (AbstractMethodError unused) {
                    editor2.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        @Deprecated
        public void apply(SharedPreferences.Editor editor2) {
            this.mHelper.apply(editor2);
        }
    }

    private SharedPreferencesCompat() {
    }
}
