package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Pivot {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    private static final int PIVOT_CENTER = -1;
    private static final int PIVOT_MAX = -2;
    private int axis;
    private int pivotPoint;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    /* renamed from: com.yarolegovich.discretescrollview.transform.Pivot$X */
    public enum C4639X {
        LEFT {
            public Pivot create() {
                return new Pivot(0, 0);
            }
        },
        CENTER {
            public Pivot create() {
                return new Pivot(0, -1);
            }
        },
        RIGHT {
            public Pivot create() {
                return new Pivot(0, -2);
            }
        };

        public abstract Pivot create();
    }

    /* renamed from: com.yarolegovich.discretescrollview.transform.Pivot$Y */
    public enum C4643Y {
        TOP {
            public Pivot create() {
                return new Pivot(1, 0);
            }
        },
        CENTER {
            public Pivot create() {
                return new Pivot(1, -1);
            }
        },
        BOTTOM {
            public Pivot create() {
                return new Pivot(1, -2);
            }
        };

        public abstract Pivot create();
    }

    public Pivot(int i, int i2) {
        this.axis = i;
        this.pivotPoint = i2;
    }

    public void setOn(View view) {
        int i = this.axis;
        if (i == 0) {
            int i2 = this.pivotPoint;
            if (i2 == -2) {
                view.setPivotX((float) view.getWidth());
            } else if (i2 != -1) {
                view.setPivotX((float) i2);
            } else {
                view.setPivotX(((float) view.getWidth()) * 0.5f);
            }
        } else if (i == 1) {
            int i3 = this.pivotPoint;
            if (i3 == -2) {
                view.setPivotY((float) view.getHeight());
            } else if (i3 != -1) {
                view.setPivotY((float) i3);
            } else {
                view.setPivotY(((float) view.getHeight()) * 0.5f);
            }
        }
    }

    public int getAxis() {
        return this.axis;
    }
}
