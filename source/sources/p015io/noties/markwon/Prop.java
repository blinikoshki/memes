package p015io.noties.markwon;

import java.util.Objects;

/* renamed from: io.noties.markwon.Prop */
public class Prop<T> {
    private final String name;

    /* renamed from: of */
    public static <T> Prop<T> m156of(Class<T> cls, String str) {
        return new Prop<>(str);
    }

    /* renamed from: of */
    public static <T> Prop<T> m157of(String str) {
        return new Prop<>(str);
    }

    Prop(String str) {
        this.name = str;
    }

    public String name() {
        return this.name;
    }

    public T get(RenderProps renderProps) {
        return renderProps.get(this);
    }

    public T get(RenderProps renderProps, T t) {
        return renderProps.get(this, t);
    }

    public T require(RenderProps renderProps) {
        T t = get(renderProps);
        Objects.requireNonNull(t, this.name);
        return t;
    }

    public void set(RenderProps renderProps, T t) {
        renderProps.set(this, t);
    }

    public void clear(RenderProps renderProps) {
        renderProps.clear(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((Prop) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.name + '\'' + '}';
    }
}
