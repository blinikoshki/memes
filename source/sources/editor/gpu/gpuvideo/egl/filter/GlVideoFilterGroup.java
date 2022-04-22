package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;
import android.util.Pair;
import editor.gpu.gpuvideo.egl.GlFramebufferObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class GlVideoFilterGroup extends GlVideoFilter {
    private final ArrayList<GlVideoFilter> filters;
    private final ArrayList<Pair<GlVideoFilter, GlFramebufferObject>> list;
    private int prevTexName;

    public GlVideoFilterGroup(GlVideoFilter... glVideoFilterArr) {
        this((Collection<GlVideoFilter>) Arrays.asList(glVideoFilterArr));
    }

    public GlVideoFilterGroup(Collection<GlVideoFilter> collection) {
        ArrayList<GlVideoFilter> arrayList = new ArrayList<>();
        this.filters = arrayList;
        this.list = new ArrayList<>();
        arrayList.addAll(collection);
    }

    public void addFilter(GlVideoFilter glVideoFilter) {
        this.filters.add(glVideoFilter);
    }

    public void setup() {
        super.setup();
        ArrayList<GlVideoFilter> arrayList = this.filters;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            Iterator<GlVideoFilter> it = this.filters.iterator();
            while (it.hasNext()) {
                GlVideoFilter next = it.next();
                next.setup();
                i++;
                this.list.add(Pair.create(next, i < size ? new GlFramebufferObject() : null));
            }
        }
    }

    public void release() {
        Iterator<Pair<GlVideoFilter, GlFramebufferObject>> it = this.list.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (next.first != null) {
                ((GlVideoFilter) next.first).release();
            }
            if (next.second != null) {
                ((GlFramebufferObject) next.second).release();
            }
        }
        this.list.clear();
        super.release();
    }

    public void setFrameSize(int i, int i2) {
        super.setFrameSize(i, i2);
        Iterator<Pair<GlVideoFilter, GlFramebufferObject>> it = this.list.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (next.first != null) {
                ((GlVideoFilter) next.first).setFrameSize(i, i2);
            }
            if (next.second != null) {
                ((GlFramebufferObject) next.second).setup(i, i2);
            }
        }
    }

    public void draw(int i, GlFramebufferObject glFramebufferObject) {
        this.prevTexName = i;
        Iterator<Pair<GlVideoFilter, GlFramebufferObject>> it = this.list.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (next.second != null) {
                if (next.first != null) {
                    ((GlFramebufferObject) next.second).enable();
                    GLES20.glClear(16640);
                    ((GlVideoFilter) next.first).draw(this.prevTexName, (GlFramebufferObject) next.second);
                }
                this.prevTexName = ((GlFramebufferObject) next.second).getTexName();
            } else {
                if (glFramebufferObject != null) {
                    glFramebufferObject.enable();
                } else {
                    GLES20.glBindFramebuffer(36160, 0);
                }
                if (next.first != null) {
                    ((GlVideoFilter) next.first).draw(this.prevTexName, glFramebufferObject);
                }
            }
        }
    }
}
