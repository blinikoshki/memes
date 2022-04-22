package top.defaults.drawabletoolbox;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bí\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\b\b\u0002\u0010,\u001a\u00020\t\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\r\u0012\b\b\u0002\u0010/\u001a\u00020\u0006\u0012\b\b\u0002\u00100\u001a\u00020\u0006\u0012\b\b\u0002\u00101\u001a\u00020\t\u0012\b\b\u0002\u00102\u001a\u00020\t\u0012\b\b\u0002\u00103\u001a\u00020\r\u0012\b\b\u0002\u00104\u001a\u00020\u0006\u0012\b\b\u0002\u00105\u001a\u00020\r\u0012\b\b\u0002\u00106\u001a\u00020\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u00108\u001a\u00020\u0006¢\u0006\u0002\u00109J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\rHÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010LJ\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\tHÆ\u0003J\t\u0010Q\u001a\u00020\rHÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003J\t\u0010T\u001a\u00020\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\rHÆ\u0003J\t\u0010]\u001a\u00020\tHÆ\u0003J\t\u0010^\u001a\u00020\tHÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\t\u0010b\u001a\u00020\u0006HÆ\u0003J\t\u0010c\u001a\u00020\u0006HÆ\u0003J\t\u0010d\u001a\u00020\u0006HÆ\u0003J\t\u0010e\u001a\u00020\tHÆ\u0003J\t\u0010f\u001a\u00020\tHÆ\u0003J\t\u0010g\u001a\u00020\rHÆ\u0003J\t\u0010h\u001a\u00020\u0006HÆ\u0003J\t\u0010i\u001a\u00020\rHÆ\u0003J\t\u0010j\u001a\u00020\u0006HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010l\u001a\u00020\u0006HÆ\u0003J\t\u0010m\u001a\u00020\tHÆ\u0003J\t\u0010n\u001a\u00020\rHÆ\u0003J\t\u0010o\u001a\u00020\u0006HÂ\u0003J\t\u0010p\u001a\u00020\u0006HÆ\u0003J\t\u0010q\u001a\u00020\u0006HÆ\u0003J\u0006\u0010r\u001a\u00020\u0000Jö\u0003\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u00102\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u00020\u00062\b\b\u0002\u00105\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010#2\b\b\u0002\u00108\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010sJ\b\u0010t\u001a\u00020\u0006H\u0016J\u0013\u0010u\u001a\u00020\r2\b\u0010v\u001a\u0004\u0018\u00010wHÖ\u0003J\u0006\u0010x\u001a\u00020yJ\u0006\u0010z\u001a\u00020{J\u0006\u0010|\u001a\u00020}J\t\u0010~\u001a\u00020\u0006HÖ\u0001J\u0007\u0010\u001a\u00030\u0001J\u000b\u0010\u0001\u001a\u00030\u0001HÖ\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0006H\u0016R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010:R\u0012\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0012\u0010(\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/DrawableProperties;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "shape", "", "innerRadius", "innerRadiusRatio", "", "thickness", "thicknessRatio", "useLevelForRing", "", "_cornerRadius", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "useGradient", "type", "angle", "centerX", "centerY", "useCenterColor", "startColor", "centerColor", "endColor", "gradientRadiusType", "gradientRadius", "useLevelForGradient", "width", "height", "solidColor", "solidColorStateList", "Landroid/content/res/ColorStateList;", "strokeWidth", "strokeColor", "strokeColorStateList", "dashWidth", "dashGap", "useRotate", "pivotX", "pivotY", "fromDegrees", "toDegrees", "useScale", "scaleLevel", "scaleGravity", "scaleWidth", "scaleHeight", "useFlip", "orientation", "useRipple", "rippleColor", "rippleColorStateList", "rippleRadius", "(IIFIFZIIIIIZIIFFZILjava/lang/Integer;IIFZIIILandroid/content/res/ColorStateList;IILandroid/content/res/ColorStateList;IIZFFFFZIIFFZIZILandroid/content/res/ColorStateList;I)V", "Ljava/lang/Integer;", "value", "cornerRadius", "getCornerRadius", "()I", "setCornerRadius", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "()Ljava/lang/Integer;", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component5", "component6", "component7", "component8", "component9", "copy", "(IIFIFZIIIIIZIIFFZILjava/lang/Integer;IIFZIIILandroid/content/res/ColorStateList;IILandroid/content/res/ColorStateList;IIZFFFFZIIFFZIZILandroid/content/res/ColorStateList;I)Ltop/defaults/drawabletoolbox/DrawableProperties;", "describeContents", "equals", "other", "", "getColors", "", "getCornerRadii", "", "getOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "hashCode", "materialization", "Landroid/graphics/drawable/Drawable;", "toString", "", "writeToParcel", "", "flags", "Companion", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: DrawableProperties.kt */
public final class DrawableProperties implements Parcelable {
    public static final Parcelable.Creator<DrawableProperties> CREATOR = new DrawableProperties$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RADIUS_TYPE_FRACTION = 1;
    public static final int RADIUS_TYPE_PIXELS = 0;
    private int _cornerRadius;
    public int angle;
    public int bottomLeftRadius;
    public int bottomRightRadius;
    public Integer centerColor;
    public float centerX;
    public float centerY;
    private int cornerRadius;
    public int dashGap;
    public int dashWidth;
    public int endColor;
    public float fromDegrees;
    public float gradientRadius;
    public int gradientRadiusType;
    public int height;
    public int innerRadius;
    public float innerRadiusRatio;
    public int orientation;
    public float pivotX;
    public float pivotY;
    public int rippleColor;
    public ColorStateList rippleColorStateList;
    public int rippleRadius;
    public int scaleGravity;
    public float scaleHeight;
    public int scaleLevel;
    public float scaleWidth;
    public int shape;
    public int solidColor;
    public ColorStateList solidColorStateList;
    public int startColor;
    public int strokeColor;
    public ColorStateList strokeColorStateList;
    public int strokeWidth;
    public int thickness;
    public float thicknessRatio;
    public float toDegrees;
    public int topLeftRadius;
    public int topRightRadius;
    public int type;
    public boolean useCenterColor;
    public boolean useFlip;
    public boolean useGradient;
    public boolean useLevelForGradient;
    public boolean useLevelForRing;
    public boolean useRipple;
    public boolean useRotate;
    public boolean useScale;
    public int width;

    public DrawableProperties() {
        this(0, 0, 0.0f, 0, 0.0f, false, 0, 0, 0, 0, 0, false, 0, 0, 0.0f, 0.0f, false, 0, (Integer) null, 0, 0, 0.0f, false, 0, 0, 0, (ColorStateList) null, 0, 0, (ColorStateList) null, 0, 0, false, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, false, 0, false, 0, (ColorStateList) null, 0, -1, 65535, (DefaultConstructorMarker) null);
    }

    private final int component7() {
        return this._cornerRadius;
    }

    public static /* bridge */ /* synthetic */ DrawableProperties copy$default(DrawableProperties drawableProperties, int i, int i2, float f, int i3, float f2, boolean z, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, int i10, float f3, float f4, boolean z3, int i11, Integer num, int i12, int i13, float f5, boolean z4, int i14, int i15, int i16, ColorStateList colorStateList, int i17, int i18, ColorStateList colorStateList2, int i19, int i20, boolean z5, float f6, float f7, float f8, float f9, boolean z6, int i21, int i22, float f10, float f11, boolean z7, int i23, boolean z8, int i24, ColorStateList colorStateList3, int i25, int i26, int i27, Object obj) {
        DrawableProperties drawableProperties2 = drawableProperties;
        int i28 = i26;
        int i29 = i27;
        return drawableProperties.copy((i28 & 1) != 0 ? drawableProperties2.shape : i, (i28 & 2) != 0 ? drawableProperties2.innerRadius : i2, (i28 & 4) != 0 ? drawableProperties2.innerRadiusRatio : f, (i28 & 8) != 0 ? drawableProperties2.thickness : i3, (i28 & 16) != 0 ? drawableProperties2.thicknessRatio : f2, (i28 & 32) != 0 ? drawableProperties2.useLevelForRing : z, (i28 & 64) != 0 ? drawableProperties2._cornerRadius : i4, (i28 & 128) != 0 ? drawableProperties2.topLeftRadius : i5, (i28 & 256) != 0 ? drawableProperties2.topRightRadius : i6, (i28 & 512) != 0 ? drawableProperties2.bottomRightRadius : i7, (i28 & 1024) != 0 ? drawableProperties2.bottomLeftRadius : i8, (i28 & 2048) != 0 ? drawableProperties2.useGradient : z2, (i28 & 4096) != 0 ? drawableProperties2.type : i9, (i28 & 8192) != 0 ? drawableProperties2.angle : i10, (i28 & 16384) != 0 ? drawableProperties2.centerX : f3, (i28 & 32768) != 0 ? drawableProperties2.centerY : f4, (i28 & 65536) != 0 ? drawableProperties2.useCenterColor : z3, (i28 & 131072) != 0 ? drawableProperties2.startColor : i11, (i28 & 262144) != 0 ? drawableProperties2.centerColor : num, (i28 & 524288) != 0 ? drawableProperties2.endColor : i12, (i28 & 1048576) != 0 ? drawableProperties2.gradientRadiusType : i13, (i28 & 2097152) != 0 ? drawableProperties2.gradientRadius : f5, (i28 & 4194304) != 0 ? drawableProperties2.useLevelForGradient : z4, (i28 & 8388608) != 0 ? drawableProperties2.width : i14, (i28 & 16777216) != 0 ? drawableProperties2.height : i15, (i28 & 33554432) != 0 ? drawableProperties2.solidColor : i16, (i28 & 67108864) != 0 ? drawableProperties2.solidColorStateList : colorStateList, (i28 & 134217728) != 0 ? drawableProperties2.strokeWidth : i17, (i28 & 268435456) != 0 ? drawableProperties2.strokeColor : i18, (i28 & 536870912) != 0 ? drawableProperties2.strokeColorStateList : colorStateList2, (i28 & 1073741824) != 0 ? drawableProperties2.dashWidth : i19, (i28 & Integer.MIN_VALUE) != 0 ? drawableProperties2.dashGap : i20, (i29 & 1) != 0 ? drawableProperties2.useRotate : z5, (i29 & 2) != 0 ? drawableProperties2.pivotX : f6, (i29 & 4) != 0 ? drawableProperties2.pivotY : f7, (i29 & 8) != 0 ? drawableProperties2.fromDegrees : f8, (i29 & 16) != 0 ? drawableProperties2.toDegrees : f9, (i29 & 32) != 0 ? drawableProperties2.useScale : z6, (i29 & 64) != 0 ? drawableProperties2.scaleLevel : i21, (i29 & 128) != 0 ? drawableProperties2.scaleGravity : i22, (i29 & 256) != 0 ? drawableProperties2.scaleWidth : f10, (i29 & 512) != 0 ? drawableProperties2.scaleHeight : f11, (i29 & 1024) != 0 ? drawableProperties2.useFlip : z7, (i29 & 2048) != 0 ? drawableProperties2.orientation : i23, (i29 & 4096) != 0 ? drawableProperties2.useRipple : z8, (i29 & 8192) != 0 ? drawableProperties2.rippleColor : i24, (i29 & 16384) != 0 ? drawableProperties2.rippleColorStateList : colorStateList3, (i29 & 32768) != 0 ? drawableProperties2.rippleRadius : i25);
    }

    public final int component1() {
        return this.shape;
    }

    public final int component10() {
        return this.bottomRightRadius;
    }

    public final int component11() {
        return this.bottomLeftRadius;
    }

    public final boolean component12() {
        return this.useGradient;
    }

    public final int component13() {
        return this.type;
    }

    public final int component14() {
        return this.angle;
    }

    public final float component15() {
        return this.centerX;
    }

    public final float component16() {
        return this.centerY;
    }

    public final boolean component17() {
        return this.useCenterColor;
    }

    public final int component18() {
        return this.startColor;
    }

    public final Integer component19() {
        return this.centerColor;
    }

    public final int component2() {
        return this.innerRadius;
    }

    public final int component20() {
        return this.endColor;
    }

    public final int component21() {
        return this.gradientRadiusType;
    }

    public final float component22() {
        return this.gradientRadius;
    }

    public final boolean component23() {
        return this.useLevelForGradient;
    }

    public final int component24() {
        return this.width;
    }

    public final int component25() {
        return this.height;
    }

    public final int component26() {
        return this.solidColor;
    }

    public final ColorStateList component27() {
        return this.solidColorStateList;
    }

    public final int component28() {
        return this.strokeWidth;
    }

    public final int component29() {
        return this.strokeColor;
    }

    public final float component3() {
        return this.innerRadiusRatio;
    }

    public final ColorStateList component30() {
        return this.strokeColorStateList;
    }

    public final int component31() {
        return this.dashWidth;
    }

    public final int component32() {
        return this.dashGap;
    }

    public final boolean component33() {
        return this.useRotate;
    }

    public final float component34() {
        return this.pivotX;
    }

    public final float component35() {
        return this.pivotY;
    }

    public final float component36() {
        return this.fromDegrees;
    }

    public final float component37() {
        return this.toDegrees;
    }

    public final boolean component38() {
        return this.useScale;
    }

    public final int component39() {
        return this.scaleLevel;
    }

    public final int component4() {
        return this.thickness;
    }

    public final int component40() {
        return this.scaleGravity;
    }

    public final float component41() {
        return this.scaleWidth;
    }

    public final float component42() {
        return this.scaleHeight;
    }

    public final boolean component43() {
        return this.useFlip;
    }

    public final int component44() {
        return this.orientation;
    }

    public final boolean component45() {
        return this.useRipple;
    }

    public final int component46() {
        return this.rippleColor;
    }

    public final ColorStateList component47() {
        return this.rippleColorStateList;
    }

    public final int component48() {
        return this.rippleRadius;
    }

    public final float component5() {
        return this.thicknessRatio;
    }

    public final boolean component6() {
        return this.useLevelForRing;
    }

    public final int component8() {
        return this.topLeftRadius;
    }

    public final int component9() {
        return this.topRightRadius;
    }

    public final DrawableProperties copy(int i, int i2, float f, int i3, float f2, boolean z, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, int i10, float f3, float f4, boolean z3, int i11, Integer num, int i12, int i13, float f5, boolean z4, int i14, int i15, int i16, ColorStateList colorStateList, int i17, int i18, ColorStateList colorStateList2, int i19, int i20, boolean z5, float f6, float f7, float f8, float f9, boolean z6, int i21, int i22, float f10, float f11, boolean z7, int i23, boolean z8, int i24, ColorStateList colorStateList3, int i25) {
        return new DrawableProperties(i, i2, f, i3, f2, z, i4, i5, i6, i7, i8, z2, i9, i10, f3, f4, z3, i11, num, i12, i13, f5, z4, i14, i15, i16, colorStateList, i17, i18, colorStateList2, i19, i20, z5, f6, f7, f8, f9, z6, i21, i22, f10, f11, z7, i23, z8, i24, colorStateList3, i25);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DrawableProperties) {
                DrawableProperties drawableProperties = (DrawableProperties) obj;
                if (this.shape == drawableProperties.shape) {
                    if ((this.innerRadius == drawableProperties.innerRadius) && Float.compare(this.innerRadiusRatio, drawableProperties.innerRadiusRatio) == 0) {
                        if ((this.thickness == drawableProperties.thickness) && Float.compare(this.thicknessRatio, drawableProperties.thicknessRatio) == 0) {
                            if (this.useLevelForRing == drawableProperties.useLevelForRing) {
                                if (this._cornerRadius == drawableProperties._cornerRadius) {
                                    if (this.topLeftRadius == drawableProperties.topLeftRadius) {
                                        if (this.topRightRadius == drawableProperties.topRightRadius) {
                                            if (this.bottomRightRadius == drawableProperties.bottomRightRadius) {
                                                if (this.bottomLeftRadius == drawableProperties.bottomLeftRadius) {
                                                    if (this.useGradient == drawableProperties.useGradient) {
                                                        if (this.type == drawableProperties.type) {
                                                            if ((this.angle == drawableProperties.angle) && Float.compare(this.centerX, drawableProperties.centerX) == 0 && Float.compare(this.centerY, drawableProperties.centerY) == 0) {
                                                                if (this.useCenterColor == drawableProperties.useCenterColor) {
                                                                    if ((this.startColor == drawableProperties.startColor) && Intrinsics.areEqual((Object) this.centerColor, (Object) drawableProperties.centerColor)) {
                                                                        if (this.endColor == drawableProperties.endColor) {
                                                                            if ((this.gradientRadiusType == drawableProperties.gradientRadiusType) && Float.compare(this.gradientRadius, drawableProperties.gradientRadius) == 0) {
                                                                                if (this.useLevelForGradient == drawableProperties.useLevelForGradient) {
                                                                                    if (this.width == drawableProperties.width) {
                                                                                        if (this.height == drawableProperties.height) {
                                                                                            if ((this.solidColor == drawableProperties.solidColor) && Intrinsics.areEqual((Object) this.solidColorStateList, (Object) drawableProperties.solidColorStateList)) {
                                                                                                if (this.strokeWidth == drawableProperties.strokeWidth) {
                                                                                                    if ((this.strokeColor == drawableProperties.strokeColor) && Intrinsics.areEqual((Object) this.strokeColorStateList, (Object) drawableProperties.strokeColorStateList)) {
                                                                                                        if (this.dashWidth == drawableProperties.dashWidth) {
                                                                                                            if (this.dashGap == drawableProperties.dashGap) {
                                                                                                                if ((this.useRotate == drawableProperties.useRotate) && Float.compare(this.pivotX, drawableProperties.pivotX) == 0 && Float.compare(this.pivotY, drawableProperties.pivotY) == 0 && Float.compare(this.fromDegrees, drawableProperties.fromDegrees) == 0 && Float.compare(this.toDegrees, drawableProperties.toDegrees) == 0) {
                                                                                                                    if (this.useScale == drawableProperties.useScale) {
                                                                                                                        if (this.scaleLevel == drawableProperties.scaleLevel) {
                                                                                                                            if ((this.scaleGravity == drawableProperties.scaleGravity) && Float.compare(this.scaleWidth, drawableProperties.scaleWidth) == 0 && Float.compare(this.scaleHeight, drawableProperties.scaleHeight) == 0) {
                                                                                                                                if (this.useFlip == drawableProperties.useFlip) {
                                                                                                                                    if (this.orientation == drawableProperties.orientation) {
                                                                                                                                        if (this.useRipple == drawableProperties.useRipple) {
                                                                                                                                            if ((this.rippleColor == drawableProperties.rippleColor) && Intrinsics.areEqual((Object) this.rippleColorStateList, (Object) drawableProperties.rippleColorStateList)) {
                                                                                                                                                if (this.rippleRadius == drawableProperties.rippleRadius) {
                                                                                                                                                    return true;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int floatToIntBits = ((((((((this.shape * 31) + this.innerRadius) * 31) + Float.floatToIntBits(this.innerRadiusRatio)) * 31) + this.thickness) * 31) + Float.floatToIntBits(this.thicknessRatio)) * 31;
        boolean z = this.useLevelForRing;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (((((((((((floatToIntBits + (z ? 1 : 0)) * 31) + this._cornerRadius) * 31) + this.topLeftRadius) * 31) + this.topRightRadius) * 31) + this.bottomRightRadius) * 31) + this.bottomLeftRadius) * 31;
        boolean z3 = this.useGradient;
        if (z3) {
            z3 = true;
        }
        int floatToIntBits2 = (((((((((i + (z3 ? 1 : 0)) * 31) + this.type) * 31) + this.angle) * 31) + Float.floatToIntBits(this.centerX)) * 31) + Float.floatToIntBits(this.centerY)) * 31;
        boolean z4 = this.useCenterColor;
        if (z4) {
            z4 = true;
        }
        int i2 = (((floatToIntBits2 + (z4 ? 1 : 0)) * 31) + this.startColor) * 31;
        Integer num = this.centerColor;
        int i3 = 0;
        int hashCode = (((((((i2 + (num != null ? num.hashCode() : 0)) * 31) + this.endColor) * 31) + this.gradientRadiusType) * 31) + Float.floatToIntBits(this.gradientRadius)) * 31;
        boolean z5 = this.useLevelForGradient;
        if (z5) {
            z5 = true;
        }
        int i4 = (((((((hashCode + (z5 ? 1 : 0)) * 31) + this.width) * 31) + this.height) * 31) + this.solidColor) * 31;
        ColorStateList colorStateList = this.solidColorStateList;
        int hashCode2 = (((((i4 + (colorStateList != null ? colorStateList.hashCode() : 0)) * 31) + this.strokeWidth) * 31) + this.strokeColor) * 31;
        ColorStateList colorStateList2 = this.strokeColorStateList;
        int hashCode3 = (((((hashCode2 + (colorStateList2 != null ? colorStateList2.hashCode() : 0)) * 31) + this.dashWidth) * 31) + this.dashGap) * 31;
        boolean z6 = this.useRotate;
        if (z6) {
            z6 = true;
        }
        int floatToIntBits3 = (((((((((hashCode3 + (z6 ? 1 : 0)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31) + Float.floatToIntBits(this.fromDegrees)) * 31) + Float.floatToIntBits(this.toDegrees)) * 31;
        boolean z7 = this.useScale;
        if (z7) {
            z7 = true;
        }
        int floatToIntBits4 = (((((((((floatToIntBits3 + (z7 ? 1 : 0)) * 31) + this.scaleLevel) * 31) + this.scaleGravity) * 31) + Float.floatToIntBits(this.scaleWidth)) * 31) + Float.floatToIntBits(this.scaleHeight)) * 31;
        boolean z8 = this.useFlip;
        if (z8) {
            z8 = true;
        }
        int i5 = (((floatToIntBits4 + (z8 ? 1 : 0)) * 31) + this.orientation) * 31;
        boolean z9 = this.useRipple;
        if (!z9) {
            z2 = z9;
        }
        int i6 = (((i5 + (z2 ? 1 : 0)) * 31) + this.rippleColor) * 31;
        ColorStateList colorStateList3 = this.rippleColorStateList;
        if (colorStateList3 != null) {
            i3 = colorStateList3.hashCode();
        }
        return ((i6 + i3) * 31) + this.rippleRadius;
    }

    public String toString() {
        return "DrawableProperties(shape=" + this.shape + ", innerRadius=" + this.innerRadius + ", innerRadiusRatio=" + this.innerRadiusRatio + ", thickness=" + this.thickness + ", thicknessRatio=" + this.thicknessRatio + ", useLevelForRing=" + this.useLevelForRing + ", _cornerRadius=" + this._cornerRadius + ", topLeftRadius=" + this.topLeftRadius + ", topRightRadius=" + this.topRightRadius + ", bottomRightRadius=" + this.bottomRightRadius + ", bottomLeftRadius=" + this.bottomLeftRadius + ", useGradient=" + this.useGradient + ", type=" + this.type + ", angle=" + this.angle + ", centerX=" + this.centerX + ", centerY=" + this.centerY + ", useCenterColor=" + this.useCenterColor + ", startColor=" + this.startColor + ", centerColor=" + this.centerColor + ", endColor=" + this.endColor + ", gradientRadiusType=" + this.gradientRadiusType + ", gradientRadius=" + this.gradientRadius + ", useLevelForGradient=" + this.useLevelForGradient + ", width=" + this.width + ", height=" + this.height + ", solidColor=" + this.solidColor + ", solidColorStateList=" + this.solidColorStateList + ", strokeWidth=" + this.strokeWidth + ", strokeColor=" + this.strokeColor + ", strokeColorStateList=" + this.strokeColorStateList + ", dashWidth=" + this.dashWidth + ", dashGap=" + this.dashGap + ", useRotate=" + this.useRotate + ", pivotX=" + this.pivotX + ", pivotY=" + this.pivotY + ", fromDegrees=" + this.fromDegrees + ", toDegrees=" + this.toDegrees + ", useScale=" + this.useScale + ", scaleLevel=" + this.scaleLevel + ", scaleGravity=" + this.scaleGravity + ", scaleWidth=" + this.scaleWidth + ", scaleHeight=" + this.scaleHeight + ", useFlip=" + this.useFlip + ", orientation=" + this.orientation + ", useRipple=" + this.useRipple + ", rippleColor=" + this.rippleColor + ", rippleColorStateList=" + this.rippleColorStateList + ", rippleRadius=" + this.rippleRadius + ")";
    }

    public DrawableProperties(int i, int i2, float f, int i3, float f2, boolean z, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, int i10, float f3, float f4, boolean z3, int i11, Integer num, int i12, int i13, float f5, boolean z4, int i14, int i15, int i16, ColorStateList colorStateList, int i17, int i18, ColorStateList colorStateList2, int i19, int i20, boolean z5, float f6, float f7, float f8, float f9, boolean z6, int i21, int i22, float f10, float f11, boolean z7, int i23, boolean z8, int i24, ColorStateList colorStateList3, int i25) {
        int i26 = i4;
        this.shape = i;
        this.innerRadius = i2;
        this.innerRadiusRatio = f;
        this.thickness = i3;
        this.thicknessRatio = f2;
        this.useLevelForRing = z;
        this._cornerRadius = i26;
        this.topLeftRadius = i5;
        this.topRightRadius = i6;
        this.bottomRightRadius = i7;
        this.bottomLeftRadius = i8;
        this.useGradient = z2;
        this.type = i9;
        this.angle = i10;
        this.centerX = f3;
        this.centerY = f4;
        this.useCenterColor = z3;
        this.startColor = i11;
        this.centerColor = num;
        this.endColor = i12;
        this.gradientRadiusType = i13;
        this.gradientRadius = f5;
        this.useLevelForGradient = z4;
        this.width = i14;
        this.height = i15;
        this.solidColor = i16;
        this.solidColorStateList = colorStateList;
        this.strokeWidth = i17;
        this.strokeColor = i18;
        this.strokeColorStateList = colorStateList2;
        this.dashWidth = i19;
        this.dashGap = i20;
        this.useRotate = z5;
        this.pivotX = f6;
        this.pivotY = f7;
        this.fromDegrees = f8;
        this.toDegrees = f9;
        this.useScale = z6;
        this.scaleLevel = i21;
        this.scaleGravity = i22;
        this.scaleWidth = f10;
        this.scaleHeight = f11;
        this.useFlip = z7;
        this.orientation = i23;
        this.useRipple = z8;
        this.rippleColor = i24;
        this.rippleColorStateList = colorStateList3;
        this.rippleRadius = i25;
        this.cornerRadius = i26;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DrawableProperties(int r49, int r50, float r51, int r52, float r53, boolean r54, int r55, int r56, int r57, int r58, int r59, boolean r60, int r61, int r62, float r63, float r64, boolean r65, int r66, java.lang.Integer r67, int r68, int r69, float r70, boolean r71, int r72, int r73, int r74, android.content.res.ColorStateList r75, int r76, int r77, android.content.res.ColorStateList r78, int r79, int r80, boolean r81, float r82, float r83, float r84, float r85, boolean r86, int r87, int r88, float r89, float r90, boolean r91, int r92, boolean r93, int r94, android.content.res.ColorStateList r95, int r96, int r97, int r98, kotlin.jvm.internal.DefaultConstructorMarker r99) {
        /*
            r48 = this;
            r0 = r97
            r1 = r98
            r2 = r0 & 1
            if (r2 == 0) goto L_0x000a
            r2 = 0
            goto L_0x000c
        L_0x000a:
            r2 = r49
        L_0x000c:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0012
            r4 = -1
            goto L_0x0014
        L_0x0012:
            r4 = r50
        L_0x0014:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001b
            r6 = 1091567616(0x41100000, float:9.0)
            goto L_0x001d
        L_0x001b:
            r6 = r51
        L_0x001d:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0023
            r7 = -1
            goto L_0x0025
        L_0x0023:
            r7 = r52
        L_0x0025:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002c
            r8 = 1077936128(0x40400000, float:3.0)
            goto L_0x002e
        L_0x002c:
            r8 = r53
        L_0x002e:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0034
            r9 = 0
            goto L_0x0036
        L_0x0034:
            r9 = r54
        L_0x0036:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003c
            r10 = 0
            goto L_0x003e
        L_0x003c:
            r10 = r55
        L_0x003e:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0044
            r11 = 0
            goto L_0x0046
        L_0x0044:
            r11 = r56
        L_0x0046:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004c
            r12 = 0
            goto L_0x004e
        L_0x004c:
            r12 = r57
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0054
            r13 = 0
            goto L_0x0056
        L_0x0054:
            r13 = r58
        L_0x0056:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005c
            r14 = 0
            goto L_0x005e
        L_0x005c:
            r14 = r59
        L_0x005e:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0064
            r15 = 0
            goto L_0x0066
        L_0x0064:
            r15 = r60
        L_0x0066:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            r16 = 1
            if (r3 == 0) goto L_0x006e
            r3 = 1
            goto L_0x0070
        L_0x006e:
            r3 = r61
        L_0x0070:
            r5 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x0076
            r5 = 0
            goto L_0x0078
        L_0x0076:
            r5 = r62
        L_0x0078:
            r17 = r5
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            r18 = 1056964608(0x3f000000, float:0.5)
            if (r5 == 0) goto L_0x0083
            r5 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0085
        L_0x0083:
            r5 = r63
        L_0x0085:
            r19 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r19
            if (r20 == 0) goto L_0x008f
            r20 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0091
        L_0x008f:
            r20 = r64
        L_0x0091:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x009a
            r21 = 0
            goto L_0x009c
        L_0x009a:
            r21 = r65
        L_0x009c:
            r22 = 131072(0x20000, float:1.83671E-40)
            r22 = r0 & r22
            r23 = -4560696(0xffffffffffba68c8, float:NaN)
            if (r22 == 0) goto L_0x00a9
            r22 = -4560696(0xffffffffffba68c8, float:NaN)
            goto L_0x00ab
        L_0x00a9:
            r22 = r66
        L_0x00ab:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            r25 = 0
            if (r24 == 0) goto L_0x00b8
            r24 = r25
            java.lang.Integer r24 = (java.lang.Integer) r24
            goto L_0x00ba
        L_0x00b8:
            r24 = r67
        L_0x00ba:
            r26 = 524288(0x80000, float:7.34684E-40)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00c4
            r26 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x00c6
        L_0x00c4:
            r26 = r68
        L_0x00c6:
            r27 = 1048576(0x100000, float:1.469368E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00cd
            goto L_0x00cf
        L_0x00cd:
            r16 = r69
        L_0x00cf:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00d8
            r27 = 1056964608(0x3f000000, float:0.5)
            goto L_0x00da
        L_0x00d8:
            r27 = r70
        L_0x00da:
            r28 = 4194304(0x400000, float:5.877472E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00e3
            r28 = 0
            goto L_0x00e5
        L_0x00e3:
            r28 = r71
        L_0x00e5:
            r29 = 8388608(0x800000, float:1.17549435E-38)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00ee
            r29 = -1
            goto L_0x00f0
        L_0x00ee:
            r29 = r72
        L_0x00f0:
            r30 = 16777216(0x1000000, float:2.3509887E-38)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00f9
            r30 = -1
            goto L_0x00fb
        L_0x00f9:
            r30 = r73
        L_0x00fb:
            r31 = 33554432(0x2000000, float:9.403955E-38)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0104
            r31 = 0
            goto L_0x0106
        L_0x0104:
            r31 = r74
        L_0x0106:
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x0111
            r32 = r25
            android.content.res.ColorStateList r32 = (android.content.res.ColorStateList) r32
            goto L_0x0113
        L_0x0111:
            r32 = r75
        L_0x0113:
            r33 = 134217728(0x8000000, float:3.85186E-34)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x011c
            r33 = 0
            goto L_0x011e
        L_0x011c:
            r33 = r76
        L_0x011e:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x0128
            r34 = -12303292(0xffffffffff444444, float:-2.6088314E38)
            goto L_0x012a
        L_0x0128:
            r34 = r77
        L_0x012a:
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            r35 = r0 & r35
            if (r35 == 0) goto L_0x0135
            r35 = r25
            android.content.res.ColorStateList r35 = (android.content.res.ColorStateList) r35
            goto L_0x0137
        L_0x0135:
            r35 = r78
        L_0x0137:
            r36 = 1073741824(0x40000000, float:2.0)
            r36 = r0 & r36
            if (r36 == 0) goto L_0x0140
            r36 = 0
            goto L_0x0142
        L_0x0140:
            r36 = r79
        L_0x0142:
            r37 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r37
            if (r0 == 0) goto L_0x014a
            r0 = 0
            goto L_0x014c
        L_0x014a:
            r0 = r80
        L_0x014c:
            r37 = r1 & 1
            if (r37 == 0) goto L_0x0153
            r37 = 0
            goto L_0x0155
        L_0x0153:
            r37 = r81
        L_0x0155:
            r38 = r1 & 2
            if (r38 == 0) goto L_0x015c
            r38 = 1056964608(0x3f000000, float:0.5)
            goto L_0x015e
        L_0x015c:
            r38 = r82
        L_0x015e:
            r39 = r1 & 4
            if (r39 == 0) goto L_0x0163
            goto L_0x0165
        L_0x0163:
            r18 = r83
        L_0x0165:
            r39 = r1 & 8
            r40 = 0
            if (r39 == 0) goto L_0x016e
            r39 = 0
            goto L_0x0170
        L_0x016e:
            r39 = r84
        L_0x0170:
            r41 = r1 & 16
            if (r41 == 0) goto L_0x0177
            r41 = 0
            goto L_0x0179
        L_0x0177:
            r41 = r85
        L_0x0179:
            r42 = r1 & 32
            if (r42 == 0) goto L_0x0180
            r42 = 0
            goto L_0x0182
        L_0x0180:
            r42 = r86
        L_0x0182:
            r43 = r1 & 64
            if (r43 == 0) goto L_0x0189
            r43 = 10000(0x2710, float:1.4013E-41)
            goto L_0x018b
        L_0x0189:
            r43 = r87
        L_0x018b:
            r97 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0194
            r0 = 17
            goto L_0x0196
        L_0x0194:
            r0 = r88
        L_0x0196:
            r44 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x019e
            r0 = 0
            goto L_0x01a0
        L_0x019e:
            r0 = r89
        L_0x01a0:
            r45 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a7
            goto L_0x01a9
        L_0x01a7:
            r40 = r90
        L_0x01a9:
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01af
            r0 = 0
            goto L_0x01b1
        L_0x01af:
            r0 = r91
        L_0x01b1:
            r46 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b9
            r0 = 0
            goto L_0x01bb
        L_0x01b9:
            r0 = r92
        L_0x01bb:
            r47 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01c3
            r0 = 0
            goto L_0x01c5
        L_0x01c3:
            r0 = r93
        L_0x01c5:
            r99 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01cc
            goto L_0x01ce
        L_0x01cc:
            r23 = r94
        L_0x01ce:
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01d7
            r0 = r25
            android.content.res.ColorStateList r0 = (android.content.res.ColorStateList) r0
            goto L_0x01d9
        L_0x01d7:
            r0 = r95
        L_0x01d9:
            r1 = r1 & r19
            if (r1 == 0) goto L_0x01df
            r1 = -1
            goto L_0x01e1
        L_0x01df:
            r1 = r96
        L_0x01e1:
            r49 = r48
            r50 = r2
            r51 = r4
            r52 = r6
            r53 = r7
            r54 = r8
            r55 = r9
            r56 = r10
            r57 = r11
            r58 = r12
            r59 = r13
            r60 = r14
            r61 = r15
            r62 = r3
            r63 = r17
            r64 = r5
            r65 = r20
            r66 = r21
            r67 = r22
            r68 = r24
            r69 = r26
            r70 = r16
            r71 = r27
            r72 = r28
            r73 = r29
            r74 = r30
            r75 = r31
            r76 = r32
            r77 = r33
            r78 = r34
            r79 = r35
            r80 = r36
            r81 = r97
            r82 = r37
            r83 = r38
            r84 = r18
            r85 = r39
            r86 = r41
            r87 = r42
            r88 = r43
            r89 = r44
            r90 = r45
            r91 = r40
            r92 = r46
            r93 = r47
            r94 = r99
            r95 = r23
            r96 = r0
            r97 = r1
            r49.<init>(r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: top.defaults.drawabletoolbox.DrawableProperties.<init>(int, int, float, int, float, boolean, int, int, int, int, int, boolean, int, int, float, float, boolean, int, java.lang.Integer, int, int, float, boolean, int, int, int, android.content.res.ColorStateList, int, int, android.content.res.ColorStateList, int, int, boolean, float, float, float, float, boolean, int, int, float, float, boolean, int, boolean, int, android.content.res.ColorStateList, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/DrawableProperties$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Ltop/defaults/drawabletoolbox/DrawableProperties;", "RADIUS_TYPE_FRACTION", "", "RADIUS_TYPE_PIXELS", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
    /* compiled from: DrawableProperties.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(int i) {
        this._cornerRadius = i;
        this.topLeftRadius = i;
        this.topRightRadius = i;
        this.bottomRightRadius = i;
        this.bottomLeftRadius = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DrawableProperties(android.os.Parcel r55) {
        /*
            r54 = this;
            r0 = r55
            java.lang.String r1 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            int r3 = r55.readInt()
            int r4 = r55.readInt()
            float r5 = r55.readFloat()
            int r6 = r55.readInt()
            float r7 = r55.readFloat()
            byte r1 = r55.readByte()
            r2 = 0
            byte r8 = (byte) r2
            if (r1 == r8) goto L_0x0025
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            int r10 = r55.readInt()
            int r11 = r55.readInt()
            int r12 = r55.readInt()
            int r13 = r55.readInt()
            int r14 = r55.readInt()
            byte r15 = r55.readByte()
            if (r15 == r8) goto L_0x0042
            r15 = 1
            goto L_0x0043
        L_0x0042:
            r15 = 0
        L_0x0043:
            int r16 = r55.readInt()
            int r17 = r55.readInt()
            float r18 = r55.readFloat()
            float r19 = r55.readFloat()
            byte r2 = r55.readByte()
            if (r2 == r8) goto L_0x005c
            r21 = 1
            goto L_0x005e
        L_0x005c:
            r21 = 0
        L_0x005e:
            int r22 = r55.readInt()
            java.lang.Class r2 = java.lang.Integer.TYPE
            java.lang.ClassLoader r2 = r2.getClassLoader()
            java.lang.Object r2 = r0.readValue(r2)
            boolean r9 = r2 instanceof java.lang.Integer
            if (r9 != 0) goto L_0x0071
            r2 = 0
        L_0x0071:
            r24 = r2
            java.lang.Integer r24 = (java.lang.Integer) r24
            int r25 = r55.readInt()
            int r26 = r55.readInt()
            float r27 = r55.readFloat()
            byte r2 = r55.readByte()
            if (r2 == r8) goto L_0x008a
            r28 = 1
            goto L_0x008c
        L_0x008a:
            r28 = 0
        L_0x008c:
            int r29 = r55.readInt()
            int r30 = r55.readInt()
            int r31 = r55.readInt()
            java.lang.Class<android.content.res.ColorStateList> r2 = android.content.res.ColorStateList.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r32 = r2
            android.content.res.ColorStateList r32 = (android.content.res.ColorStateList) r32
            int r33 = r55.readInt()
            int r34 = r55.readInt()
            java.lang.Class<android.content.res.ColorStateList> r2 = android.content.res.ColorStateList.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r35 = r2
            android.content.res.ColorStateList r35 = (android.content.res.ColorStateList) r35
            int r36 = r55.readInt()
            int r37 = r55.readInt()
            byte r2 = r55.readByte()
            if (r2 == r8) goto L_0x00cd
            r38 = 1
            goto L_0x00cf
        L_0x00cd:
            r38 = 0
        L_0x00cf:
            float r39 = r55.readFloat()
            float r40 = r55.readFloat()
            float r41 = r55.readFloat()
            float r42 = r55.readFloat()
            byte r2 = r55.readByte()
            if (r2 == r8) goto L_0x00e8
            r43 = 1
            goto L_0x00ea
        L_0x00e8:
            r43 = 0
        L_0x00ea:
            int r44 = r55.readInt()
            int r45 = r55.readInt()
            float r46 = r55.readFloat()
            float r47 = r55.readFloat()
            byte r2 = r55.readByte()
            if (r2 == r8) goto L_0x0103
            r51 = 1
            goto L_0x0105
        L_0x0103:
            r51 = 0
        L_0x0105:
            int r52 = r55.readInt()
            byte r2 = r55.readByte()
            if (r2 == r8) goto L_0x0112
            r53 = 1
            goto L_0x0114
        L_0x0112:
            r53 = 0
        L_0x0114:
            int r48 = r55.readInt()
            java.lang.Class<android.content.res.ColorStateList> r2 = android.content.res.ColorStateList.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r49 = r2
            android.content.res.ColorStateList r49 = (android.content.res.ColorStateList) r49
            int r50 = r55.readInt()
            r2 = r54
            r8 = r1
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r21
            r20 = r22
            r21 = r24
            r22 = r25
            r23 = r26
            r24 = r27
            r25 = r28
            r26 = r29
            r27 = r30
            r28 = r31
            r29 = r32
            r30 = r33
            r31 = r34
            r32 = r35
            r33 = r36
            r34 = r37
            r35 = r38
            r36 = r39
            r37 = r40
            r38 = r41
            r39 = r42
            r40 = r43
            r41 = r44
            r42 = r45
            r43 = r46
            r44 = r47
            r45 = r51
            r46 = r52
            r47 = r53
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: top.defaults.drawabletoolbox.DrawableProperties.<init>(android.os.Parcel):void");
    }

    public final DrawableProperties copy() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkExpressionValueIsNotNull(obtain, "parcel");
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        DrawableProperties createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        Intrinsics.checkExpressionValueIsNotNull(createFromParcel, "properties");
        return createFromParcel;
    }

    public final float[] getCornerRadii() {
        int i = this.topLeftRadius;
        int i2 = this.topRightRadius;
        int i3 = this.bottomRightRadius;
        int i4 = this.bottomLeftRadius;
        return new float[]{(float) i, (float) i, (float) i2, (float) i2, (float) i3, (float) i3, (float) i4, (float) i4};
    }

    public final GradientDrawable.Orientation getOrientation() {
        int i = this.angle % 360;
        if (i == 0) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if (i == 45) {
            return GradientDrawable.Orientation.BL_TR;
        }
        if (i == 90) {
            return GradientDrawable.Orientation.BOTTOM_TOP;
        }
        if (i == 135) {
            return GradientDrawable.Orientation.BR_TL;
        }
        if (i == 180) {
            return GradientDrawable.Orientation.RIGHT_LEFT;
        }
        if (i == 225) {
            return GradientDrawable.Orientation.TR_BL;
        }
        if (i == 270) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if (i == 315) {
            return GradientDrawable.Orientation.TL_BR;
        }
        throw new IllegalArgumentException("Unsupported angle: " + i);
    }

    public final int[] getColors() {
        Integer num;
        if (!this.useCenterColor || (num = this.centerColor) == null) {
            return new int[]{this.startColor, this.endColor};
        }
        int[] iArr = new int[3];
        iArr[0] = this.startColor;
        if (num == null) {
            Intrinsics.throwNpe();
        }
        iArr[1] = num.intValue();
        iArr[2] = this.endColor;
        return iArr;
    }

    public final Drawable materialization() {
        return new DrawableBuilder().batch(this).build();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.shape);
        parcel.writeInt(this.innerRadius);
        parcel.writeFloat(this.innerRadiusRatio);
        parcel.writeInt(this.thickness);
        parcel.writeFloat(this.thicknessRatio);
        parcel.writeByte(this.useLevelForRing ? (byte) 1 : 0);
        parcel.writeInt(this._cornerRadius);
        parcel.writeInt(this.topLeftRadius);
        parcel.writeInt(this.topRightRadius);
        parcel.writeInt(this.bottomRightRadius);
        parcel.writeInt(this.bottomLeftRadius);
        parcel.writeByte(this.useGradient ? (byte) 1 : 0);
        parcel.writeInt(this.type);
        parcel.writeInt(this.angle);
        parcel.writeFloat(this.centerX);
        parcel.writeFloat(this.centerY);
        parcel.writeByte(this.useCenterColor ? (byte) 1 : 0);
        parcel.writeInt(this.startColor);
        parcel.writeValue(this.centerColor);
        parcel.writeInt(this.endColor);
        parcel.writeInt(this.gradientRadiusType);
        parcel.writeFloat(this.gradientRadius);
        parcel.writeByte(this.useLevelForGradient ? (byte) 1 : 0);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.solidColor);
        parcel.writeParcelable(this.solidColorStateList, i);
        parcel.writeInt(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeParcelable(this.strokeColorStateList, i);
        parcel.writeInt(this.dashWidth);
        parcel.writeInt(this.dashGap);
        parcel.writeByte(this.useRotate ? (byte) 1 : 0);
        parcel.writeFloat(this.pivotX);
        parcel.writeFloat(this.pivotY);
        parcel.writeFloat(this.fromDegrees);
        parcel.writeFloat(this.toDegrees);
        parcel.writeByte(this.useScale ? (byte) 1 : 0);
        parcel.writeInt(this.scaleLevel);
        parcel.writeInt(this.scaleGravity);
        parcel.writeFloat(this.scaleWidth);
        parcel.writeFloat(this.scaleHeight);
        parcel.writeByte(this.useFlip ? (byte) 1 : 0);
        parcel.writeInt(this.orientation);
        parcel.writeByte(this.useRipple ? (byte) 1 : 0);
        parcel.writeInt(this.rippleColor);
        parcel.writeParcelable(this.rippleColorStateList, i);
        parcel.writeInt(this.rippleRadius);
    }
}
