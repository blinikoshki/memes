package editor.signature.utils;

import com.memes.eventtracker.util.Util;

class SvgPoint {

    /* renamed from: x */
    final Integer f1438x;

    /* renamed from: y */
    final Integer f1439y;

    public SvgPoint(TimedPoint timedPoint) {
        this.f1438x = Integer.valueOf(Math.round(timedPoint.f1440x));
        this.f1439y = Integer.valueOf(Math.round(timedPoint.f1441y));
    }

    public SvgPoint(int i, int i2) {
        this.f1438x = Integer.valueOf(i);
        this.f1439y = Integer.valueOf(i2);
    }

    public String toAbsoluteCoordinates() {
        return this.f1438x + Util.EVENT_ID_SEPARATOR + this.f1439y;
    }

    public String toRelativeCoordinates(SvgPoint svgPoint) {
        return new SvgPoint(this.f1438x.intValue() - svgPoint.f1438x.intValue(), this.f1439y.intValue() - svgPoint.f1439y.intValue()).toString();
    }

    public String toString() {
        return toAbsoluteCoordinates();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SvgPoint svgPoint = (SvgPoint) obj;
        if (!this.f1438x.equals(svgPoint.f1438x)) {
            return false;
        }
        return this.f1439y.equals(svgPoint.f1439y);
    }

    public int hashCode() {
        return (this.f1438x.hashCode() * 31) + this.f1439y.hashCode();
    }
}
