package p015io.noties.markwon;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.noties.markwon.RenderPropsImpl */
class RenderPropsImpl implements RenderProps {
    private final Map<Prop, Object> values = new HashMap(3);

    RenderPropsImpl() {
    }

    public <T> T get(Prop<T> prop) {
        return this.values.get(prop);
    }

    public <T> T get(Prop<T> prop, T t) {
        T t2 = this.values.get(prop);
        return t2 != null ? t2 : t;
    }

    public <T> void set(Prop<T> prop, T t) {
        if (t == null) {
            this.values.remove(prop);
        } else {
            this.values.put(prop, t);
        }
    }

    public <T> void clear(Prop<T> prop) {
        this.values.remove(prop);
    }

    public void clearAll() {
        this.values.clear();
    }
}
