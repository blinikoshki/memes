package timber.log;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public final class Timber {
    private static final List<Tree> FOREST = new ArrayList();
    private static final Tree[] TREE_ARRAY_EMPTY;
    private static final Tree TREE_OF_SOULS = new Tree() {
        /* renamed from: v */
        public void mo36159v(String str, Object... objArr) {
            for (Tree v : Timber.forestAsArray) {
                v.mo36159v(str, objArr);
            }
        }

        /* renamed from: v */
        public void mo36161v(Throwable th, String str, Object... objArr) {
            for (Tree v : Timber.forestAsArray) {
                v.mo36161v(th, str, objArr);
            }
        }

        /* renamed from: v */
        public void mo36160v(Throwable th) {
            for (Tree v : Timber.forestAsArray) {
                v.mo36160v(th);
            }
        }

        /* renamed from: d */
        public void mo36146d(String str, Object... objArr) {
            for (Tree d : Timber.forestAsArray) {
                d.mo36146d(str, objArr);
            }
        }

        /* renamed from: d */
        public void mo36148d(Throwable th, String str, Object... objArr) {
            for (Tree d : Timber.forestAsArray) {
                d.mo36148d(th, str, objArr);
            }
        }

        /* renamed from: d */
        public void mo36147d(Throwable th) {
            for (Tree d : Timber.forestAsArray) {
                d.mo36147d(th);
            }
        }

        /* renamed from: i */
        public void mo36152i(String str, Object... objArr) {
            for (Tree i : Timber.forestAsArray) {
                i.mo36152i(str, objArr);
            }
        }

        /* renamed from: i */
        public void mo36154i(Throwable th, String str, Object... objArr) {
            for (Tree i : Timber.forestAsArray) {
                i.mo36154i(th, str, objArr);
            }
        }

        /* renamed from: i */
        public void mo36153i(Throwable th) {
            for (Tree i : Timber.forestAsArray) {
                i.mo36153i(th);
            }
        }

        /* renamed from: w */
        public void mo36162w(String str, Object... objArr) {
            for (Tree w : Timber.forestAsArray) {
                w.mo36162w(str, objArr);
            }
        }

        /* renamed from: w */
        public void mo36164w(Throwable th, String str, Object... objArr) {
            for (Tree w : Timber.forestAsArray) {
                w.mo36164w(th, str, objArr);
            }
        }

        /* renamed from: w */
        public void mo36163w(Throwable th) {
            for (Tree w : Timber.forestAsArray) {
                w.mo36163w(th);
            }
        }

        /* renamed from: e */
        public void mo36149e(String str, Object... objArr) {
            for (Tree e : Timber.forestAsArray) {
                e.mo36149e(str, objArr);
            }
        }

        /* renamed from: e */
        public void mo36151e(Throwable th, String str, Object... objArr) {
            for (Tree e : Timber.forestAsArray) {
                e.mo36151e(th, str, objArr);
            }
        }

        /* renamed from: e */
        public void mo36150e(Throwable th) {
            for (Tree e : Timber.forestAsArray) {
                e.mo36150e(th);
            }
        }

        public void wtf(String str, Object... objArr) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(str, objArr);
            }
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(th, str, objArr);
            }
        }

        public void wtf(Throwable th) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(th);
            }
        }

        public void log(int i, String str, Object... objArr) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, str, objArr);
            }
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, th, str, objArr);
            }
        }

        public void log(int i, Throwable th) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, th);
            }
        }

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };
    static volatile Tree[] forestAsArray;

    /* renamed from: v */
    public static void m309v(String str, Object... objArr) {
        TREE_OF_SOULS.mo36159v(str, objArr);
    }

    /* renamed from: v */
    public static void m311v(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo36161v(th, str, objArr);
    }

    /* renamed from: v */
    public static void m310v(Throwable th) {
        TREE_OF_SOULS.mo36160v(th);
    }

    /* renamed from: d */
    public static void m300d(String str, Object... objArr) {
        TREE_OF_SOULS.mo36146d(str, objArr);
    }

    /* renamed from: d */
    public static void m302d(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo36148d(th, str, objArr);
    }

    /* renamed from: d */
    public static void m301d(Throwable th) {
        TREE_OF_SOULS.mo36147d(th);
    }

    /* renamed from: i */
    public static void m306i(String str, Object... objArr) {
        TREE_OF_SOULS.mo36152i(str, objArr);
    }

    /* renamed from: i */
    public static void m308i(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo36154i(th, str, objArr);
    }

    /* renamed from: i */
    public static void m307i(Throwable th) {
        TREE_OF_SOULS.mo36153i(th);
    }

    /* renamed from: w */
    public static void m312w(String str, Object... objArr) {
        TREE_OF_SOULS.mo36162w(str, objArr);
    }

    /* renamed from: w */
    public static void m314w(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo36164w(th, str, objArr);
    }

    /* renamed from: w */
    public static void m313w(Throwable th) {
        TREE_OF_SOULS.mo36163w(th);
    }

    /* renamed from: e */
    public static void m303e(String str, Object... objArr) {
        TREE_OF_SOULS.mo36149e(str, objArr);
    }

    /* renamed from: e */
    public static void m305e(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo36151e(th, str, objArr);
    }

    /* renamed from: e */
    public static void m304e(Throwable th) {
        TREE_OF_SOULS.mo36150e(th);
    }

    public static void wtf(String str, Object... objArr) {
        TREE_OF_SOULS.wtf(str, objArr);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.wtf(th, str, objArr);
    }

    public static void wtf(Throwable th) {
        TREE_OF_SOULS.wtf(th);
    }

    public static void log(int i, String str, Object... objArr) {
        TREE_OF_SOULS.log(i, str, objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.log(i, th, str, objArr);
    }

    public static void log(int i, Throwable th) {
        TREE_OF_SOULS.log(i, th);
    }

    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static void plant(Tree tree) {
        Objects.requireNonNull(tree, "tree == null");
        if (tree != TREE_OF_SOULS) {
            List<Tree> list = FOREST;
            synchronized (list) {
                list.add(tree);
                forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    public static void plant(Tree... treeArr) {
        Objects.requireNonNull(treeArr, "trees == null");
        int length = treeArr.length;
        int i = 0;
        while (i < length) {
            Tree tree = treeArr[i];
            Objects.requireNonNull(tree, "trees contains null");
            if (tree != TREE_OF_SOULS) {
                i++;
            } else {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
        }
        List<Tree> list = FOREST;
        synchronized (list) {
            Collections.addAll(list, treeArr);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void uproot(Tree tree) {
        List<Tree> list = FOREST;
        synchronized (list) {
            if (list.remove(tree)) {
                forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
            } else {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
            }
        }
    }

    public static void uprootAll() {
        List<Tree> list = FOREST;
        synchronized (list) {
            list.clear();
            forestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    public static List<Tree> forest() {
        List<Tree> unmodifiableList;
        List<Tree> list = FOREST;
        synchronized (list) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return unmodifiableList;
    }

    public static int treeCount() {
        int size;
        List<Tree> list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    static {
        Tree[] treeArr = new Tree[0];
        TREE_ARRAY_EMPTY = treeArr;
        forestAsArray = treeArr;
    }

    private Timber() {
        throw new AssertionError("No instances.");
    }

    public static abstract class Tree {
        final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        /* access modifiers changed from: protected */
        @Deprecated
        public boolean isLoggable(int i) {
            return true;
        }

        /* access modifiers changed from: protected */
        public abstract void log(int i, String str, String str2, Throwable th);

        /* access modifiers changed from: package-private */
        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* renamed from: v */
        public void mo36159v(String str, Object... objArr) {
            prepareLog(2, (Throwable) null, str, objArr);
        }

        /* renamed from: v */
        public void mo36161v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* renamed from: v */
        public void mo36160v(Throwable th) {
            prepareLog(2, th, (String) null, new Object[0]);
        }

        /* renamed from: d */
        public void mo36146d(String str, Object... objArr) {
            prepareLog(3, (Throwable) null, str, objArr);
        }

        /* renamed from: d */
        public void mo36148d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* renamed from: d */
        public void mo36147d(Throwable th) {
            prepareLog(3, th, (String) null, new Object[0]);
        }

        /* renamed from: i */
        public void mo36152i(String str, Object... objArr) {
            prepareLog(4, (Throwable) null, str, objArr);
        }

        /* renamed from: i */
        public void mo36154i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        /* renamed from: i */
        public void mo36153i(Throwable th) {
            prepareLog(4, th, (String) null, new Object[0]);
        }

        /* renamed from: w */
        public void mo36162w(String str, Object... objArr) {
            prepareLog(5, (Throwable) null, str, objArr);
        }

        /* renamed from: w */
        public void mo36164w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        /* renamed from: w */
        public void mo36163w(Throwable th) {
            prepareLog(5, th, (String) null, new Object[0]);
        }

        /* renamed from: e */
        public void mo36149e(String str, Object... objArr) {
            prepareLog(6, (Throwable) null, str, objArr);
        }

        /* renamed from: e */
        public void mo36151e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        /* renamed from: e */
        public void mo36150e(Throwable th) {
            prepareLog(6, th, (String) null, new Object[0]);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, (Throwable) null, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, (String) null, new Object[0]);
        }

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, (Throwable) null, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, (String) null, new Object[0]);
        }

        /* access modifiers changed from: protected */
        public boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        str = str + StringUtils.f466LF + getStackTraceString(th);
                    }
                } else if (th != null) {
                    str = getStackTraceString(th);
                } else {
                    return;
                }
                log(i, tag, str, th);
            }
        }

        /* access modifiers changed from: protected */
        public String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    public static class DebugTree extends Tree {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        /* access modifiers changed from: protected */
        public String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
        }

        /* access modifiers changed from: package-private */
        public final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return createStackElementTag(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() >= MAX_LOG_LENGTH) {
                int i2 = 0;
                int length = str2.length();
                while (i2 < length) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i2 + MAX_LOG_LENGTH);
                        String substring = str2.substring(i2, min);
                        if (i == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i2 = min;
                    }
                    i2 = min + 1;
                }
            } else if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        }
    }
}
