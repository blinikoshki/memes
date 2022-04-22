package p019me.relex.photodraweeview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;

/* renamed from: me.relex.photodraweeview.DefaultOnDoubleTapListener */
public class DefaultOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    private Attacher mAttacher;

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public DefaultOnDoubleTapListener(Attacher attacher) {
        setPhotoDraweeViewAttacher(attacher);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        DraweeView<GenericDraweeHierarchy> draweeView;
        RectF displayRect;
        Attacher attacher = this.mAttacher;
        if (attacher == null || (draweeView = attacher.getDraweeView()) == null) {
            return false;
        }
        if (!(this.mAttacher.getOnPhotoTapListener() == null || (displayRect = this.mAttacher.getDisplayRect()) == null)) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.contains(x, y)) {
                this.mAttacher.getOnPhotoTapListener().onPhotoTap(draweeView, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.mAttacher.getOnViewTapListener() == null) {
            return false;
        }
        this.mAttacher.getOnViewTapListener().onViewTap(draweeView, motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        Attacher attacher = this.mAttacher;
        if (attacher == null) {
            return false;
        }
        try {
            float scale = attacher.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.mAttacher.getMediumScale()) {
                Attacher attacher2 = this.mAttacher;
                attacher2.setScale(attacher2.getMediumScale(), x, y, true);
            } else if (scale < this.mAttacher.getMediumScale() || scale >= this.mAttacher.getMaximumScale()) {
                Attacher attacher3 = this.mAttacher;
                attacher3.setScale(attacher3.getMinimumScale(), x, y, true);
            } else {
                Attacher attacher4 = this.mAttacher;
                attacher4.setScale(attacher4.getMaximumScale(), x, y, true);
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public void setPhotoDraweeViewAttacher(Attacher attacher) {
        this.mAttacher = attacher;
    }
}
