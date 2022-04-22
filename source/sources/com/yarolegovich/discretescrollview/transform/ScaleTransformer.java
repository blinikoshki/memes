package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import com.yarolegovich.discretescrollview.transform.Pivot;

public class ScaleTransformer implements DiscreteScrollItemTransformer {
    /* access modifiers changed from: private */
    public float maxMinDiff = 0.2f;
    /* access modifiers changed from: private */
    public float minScale = 0.8f;
    /* access modifiers changed from: private */
    public Pivot pivotX = Pivot.C4639X.CENTER.create();
    /* access modifiers changed from: private */
    public Pivot pivotY = Pivot.C4643Y.CENTER.create();

    public void transformItem(View view, float f) {
        this.pivotX.setOn(view);
        this.pivotY.setOn(view);
        float abs = this.minScale + (this.maxMinDiff * (1.0f - Math.abs(f)));
        view.setScaleX(abs);
        view.setScaleY(abs);
    }

    public static class Builder {
        private float maxScale = 1.0f;
        private ScaleTransformer transformer = new ScaleTransformer();

        public Builder setMinScale(float f) {
            float unused = this.transformer.minScale = f;
            return this;
        }

        public Builder setMaxScale(float f) {
            this.maxScale = f;
            return this;
        }

        public Builder setPivotX(Pivot.C4639X x) {
            return setPivotX(x.create());
        }

        public Builder setPivotX(Pivot pivot) {
            assertAxis(pivot, 0);
            Pivot unused = this.transformer.pivotX = pivot;
            return this;
        }

        public Builder setPivotY(Pivot.C4643Y y) {
            return setPivotY(y.create());
        }

        public Builder setPivotY(Pivot pivot) {
            assertAxis(pivot, 1);
            Pivot unused = this.transformer.pivotY = pivot;
            return this;
        }

        public ScaleTransformer build() {
            ScaleTransformer scaleTransformer = this.transformer;
            float unused = scaleTransformer.maxMinDiff = this.maxScale - scaleTransformer.minScale;
            return this.transformer;
        }

        private void assertAxis(Pivot pivot, int i) {
            if (pivot.getAxis() != i) {
                throw new IllegalArgumentException("You passed a Pivot for wrong axis.");
            }
        }
    }
}
