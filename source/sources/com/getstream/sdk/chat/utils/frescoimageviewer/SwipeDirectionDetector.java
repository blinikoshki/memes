package com.getstream.sdk.chat.utils.frescoimageviewer;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

abstract class SwipeDirectionDetector {
    private boolean isDetected;
    private float startX;
    private float startY;
    private int touchSlop;

    public abstract void onDirectionDetected(Direction direction);

    public SwipeDirectionDetector(Context context) {
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r0 != 3) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 0
            if (r0 == 0) goto L_0x0047
            r2 = 1
            if (r0 == r2) goto L_0x0036
            r3 = 2
            if (r0 == r3) goto L_0x0011
            r5 = 3
            if (r0 == r5) goto L_0x0036
            goto L_0x0053
        L_0x0011:
            boolean r0 = r4.isDetected
            if (r0 != 0) goto L_0x0053
            float r0 = r4.getDistance(r5)
            int r3 = r4.touchSlop
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0053
            r4.isDetected = r2
            float r0 = r5.getX()
            float r5 = r5.getY()
            float r2 = r4.startX
            float r3 = r4.startY
            com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction r5 = r4.getDirection(r2, r3, r0, r5)
            r4.onDirectionDetected(r5)
            goto L_0x0053
        L_0x0036:
            boolean r5 = r4.isDetected
            if (r5 != 0) goto L_0x003f
            com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction r5 = com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.Direction.NOT_DETECTED
            r4.onDirectionDetected(r5)
        L_0x003f:
            r5 = 0
            r4.startY = r5
            r4.startX = r5
            r4.isDetected = r1
            goto L_0x0053
        L_0x0047:
            float r0 = r5.getX()
            r4.startX = r0
            float r5 = r5.getY()
            r4.startY = r5
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public Direction getDirection(float f, float f2, float f3, float f4) {
        return Direction.get(getAngle(f, f2, f3, f4));
    }

    public double getAngle(float f, float f2, float f3, float f4) {
        return ((((Math.atan2((double) (f2 - f4), (double) (f3 - f)) + 3.141592653589793d) * 180.0d) / 3.141592653589793d) + 180.0d) % 360.0d;
    }

    private float getDistance(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - this.startX;
        float y = motionEvent.getY(0) - this.startY;
        return (float) (((double) 0.0f) + Math.sqrt((double) ((x * x) + (y * y))));
    }

    public enum Direction {
        NOT_DETECTED,
        UP,
        DOWN,
        LEFT,
        RIGHT;

        private static boolean inRange(double d, float f, float f2) {
            return d >= ((double) f) && d < ((double) f2);
        }

        public static Direction get(double d) {
            if (inRange(d, 45.0f, 135.0f)) {
                return UP;
            }
            if (inRange(d, 0.0f, 45.0f) || inRange(d, 315.0f, 360.0f)) {
                return RIGHT;
            }
            if (inRange(d, 225.0f, 315.0f)) {
                return DOWN;
            }
            return LEFT;
        }
    }
}
