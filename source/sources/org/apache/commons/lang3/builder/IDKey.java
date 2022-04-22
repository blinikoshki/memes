package org.apache.commons.lang3.builder;

final class IDKey {

    /* renamed from: id */
    private final int f467id;
    private final Object value;

    public IDKey(Object obj) {
        this.f467id = System.identityHashCode(obj);
        this.value = obj;
    }

    public int hashCode() {
        return this.f467id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.f467id == iDKey.f467id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }
}
