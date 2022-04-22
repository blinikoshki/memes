package editor.signature.utils;

public class TimedPoint {
    public long timestamp;

    /* renamed from: x */
    public float f1440x;

    /* renamed from: y */
    public float f1441y;

    public TimedPoint set(float f, float f2) {
        this.f1440x = f;
        this.f1441y = f2;
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public float velocityFrom(TimedPoint timedPoint) {
        long j = this.timestamp - timedPoint.timestamp;
        if (j <= 0) {
            j = 1;
        }
        float distanceTo = distanceTo(timedPoint) / ((float) j);
        if (Float.isInfinite(distanceTo) || Float.isNaN(distanceTo)) {
            return 0.0f;
        }
        return distanceTo;
    }

    public float distanceTo(TimedPoint timedPoint) {
        return (float) Math.sqrt(Math.pow((double) (timedPoint.f1440x - this.f1440x), 2.0d) + Math.pow((double) (timedPoint.f1441y - this.f1441y), 2.0d));
    }
}
