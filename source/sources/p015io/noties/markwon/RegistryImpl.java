package p015io.noties.markwon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p015io.noties.markwon.MarkwonPlugin;
import p015io.noties.markwon.core.CorePlugin;

/* renamed from: io.noties.markwon.RegistryImpl */
class RegistryImpl implements MarkwonPlugin.Registry {
    private final List<MarkwonPlugin> origin;
    private final Set<MarkwonPlugin> pending = new HashSet(3);
    private final List<MarkwonPlugin> plugins;

    RegistryImpl(List<MarkwonPlugin> list) {
        this.origin = list;
        this.plugins = new ArrayList(list.size());
    }

    public <P extends MarkwonPlugin> P require(Class<P> cls) {
        return get(cls);
    }

    public <P extends MarkwonPlugin> void require(Class<P> cls, MarkwonPlugin.Action<? super P> action) {
        action.apply(get(cls));
    }

    /* access modifiers changed from: package-private */
    public List<MarkwonPlugin> process() {
        for (MarkwonPlugin configure : this.origin) {
            configure(configure);
        }
        return this.plugins;
    }

    private void configure(MarkwonPlugin markwonPlugin) {
        if (this.plugins.contains(markwonPlugin)) {
            return;
        }
        if (!this.pending.contains(markwonPlugin)) {
            this.pending.add(markwonPlugin);
            markwonPlugin.configure(this);
            this.pending.remove(markwonPlugin);
            if (this.plugins.contains(markwonPlugin)) {
                return;
            }
            if (CorePlugin.class.isAssignableFrom(markwonPlugin.getClass())) {
                this.plugins.add(0, markwonPlugin);
            } else {
                this.plugins.add(markwonPlugin);
            }
        } else {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.pending);
        }
    }

    private <P extends MarkwonPlugin> P get(Class<P> cls) {
        P find = find(this.plugins, cls);
        if (find == null) {
            find = find(this.origin, cls);
            if (find != null) {
                configure(find);
            } else {
                throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.origin);
            }
        }
        return find;
    }

    private static <P extends MarkwonPlugin> P find(List<MarkwonPlugin> list, Class<P> cls) {
        Iterator<MarkwonPlugin> it = list.iterator();
        while (it.hasNext()) {
            P p = (MarkwonPlugin) it.next();
            if (cls.isAssignableFrom(p.getClass())) {
                return p;
            }
        }
        return null;
    }
}
