package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a=\u0010\t\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u000b\u001a\u00020\u00072\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\r\"\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0002\u0010\u000e\u001a\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0019\u001a\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001e\u001a\u0016\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001e\u001a\u0016\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\"\u001a\u0016\u0010#\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010$\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u001e\u001a\u0016\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001e\u001a\u0016\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001e\u001a\u0016\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010+\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u001b\u001a\u0016\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020-\"\u0012\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"gradientState", "Ljava/lang/Class;", "rotateState", "resolveField", "Ljava/lang/reflect/Field;", "source", "fieldName", "", "resolveGradientState", "resolveMethod", "Ljava/lang/reflect/Method;", "methodName", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "resolveRotateState", "setColors", "", "drawable", "Landroid/graphics/drawable/GradientDrawable;", "value", "", "setDrawable", "rotateDrawable", "Landroid/graphics/drawable/RotateDrawable;", "Landroid/graphics/drawable/Drawable;", "setFromDegrees", "", "setGradientRadius", "setGradientRadiusType", "", "setInnerRadius", "setInnerRadiusRatio", "setOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "setPivotX", "setPivotY", "setRadius", "rippleDrawable", "Landroid/graphics/drawable/RippleDrawable;", "setStrokeColor", "setThickness", "setThicknessRatio", "setToDegrees", "setUseLevelForShape", "", "drawabletoolbox_release"}, mo26108k = 2, mo26109mv = {1, 1, 11})
/* compiled from: Compatible.kt */
public final class CompatibleKt {
    private static final Class<?> gradientState = resolveGradientState();
    private static final Class<?> rotateState = resolveRotateState();

    private static final Class<?> resolveGradientState() {
        for (Class<?> cls : GradientDrawable.class.getDeclaredClasses()) {
            Intrinsics.checkExpressionValueIsNotNull(cls, "singleClass");
            if (Intrinsics.areEqual((Object) cls.getSimpleName(), (Object) "GradientState")) {
                return cls;
            }
        }
        throw new RuntimeException("GradientState could not be found in current GradientDrawable implementation");
    }

    private static final Class<?> resolveRotateState() {
        for (Class<?> cls : RotateDrawable.class.getDeclaredClasses()) {
            Intrinsics.checkExpressionValueIsNotNull(cls, "singleClass");
            if (Intrinsics.areEqual((Object) cls.getSimpleName(), (Object) "RotateState")) {
                return cls;
            }
        }
        throw new RuntimeException("RotateState could not be found in current RotateDrawable implementation");
    }

    private static final Field resolveField(Class<?> cls, String str) throws SecurityException, NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        Intrinsics.checkExpressionValueIsNotNull(declaredField, QuerySort.KEY_FIELD_NAME);
        declaredField.setAccessible(true);
        return declaredField;
    }

    private static final Method resolveMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException, NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        Intrinsics.checkExpressionValueIsNotNull(declaredMethod, FirebaseAnalytics.Param.METHOD);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public static final void setInnerRadius(GradientDrawable gradientDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mInnerRadius").setInt(gradientDrawable.getConstantState(), i);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setInnerRadiusRatio(GradientDrawable gradientDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mInnerRadiusRatio").setFloat(gradientDrawable.getConstantState(), f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setThickness(GradientDrawable gradientDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mThickness").setInt(gradientDrawable.getConstantState(), i);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setThicknessRatio(GradientDrawable gradientDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mThicknessRatio").setFloat(gradientDrawable.getConstantState(), f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setUseLevelForShape(GradientDrawable gradientDrawable, boolean z) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mUseLevelForShape").setBoolean(gradientDrawable.getConstantState(), z);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setOrientation(GradientDrawable gradientDrawable, GradientDrawable.Orientation orientation) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        Intrinsics.checkParameterIsNotNull(orientation, "value");
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(orientation);
            return;
        }
        try {
            resolveField(gradientState, "mOrientation").set(gradientDrawable.getConstantState(), orientation);
            resolveField(GradientDrawable.class, "mRectIsDirty").setBoolean(gradientDrawable, true);
            gradientDrawable.invalidateSelf();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setColors(GradientDrawable gradientDrawable, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        Intrinsics.checkParameterIsNotNull(iArr, "value");
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(iArr);
            return;
        }
        try {
            resolveField(gradientState, "mColors").set(gradientDrawable.getConstantState(), iArr);
            gradientDrawable.invalidateSelf();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setGradientRadiusType(GradientDrawable gradientDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mGradientRadiusType").setInt(gradientDrawable.getConstantState(), i);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setGradientRadius(GradientDrawable gradientDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mGradientRadius").setFloat(gradientDrawable.getConstantState(), f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setStrokeColor(GradientDrawable gradientDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "drawable");
        try {
            resolveField(gradientState, "mStrokeColor").setInt(gradientDrawable.getConstantState(), i);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setDrawable(RotateDrawable rotateDrawable, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(rotateDrawable, "rotateDrawable");
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        if (Build.VERSION.SDK_INT >= 21) {
            rotateDrawable.setDrawable(drawable);
            return;
        }
        try {
            resolveField(rotateState, "mDrawable").set(resolveField(RotateDrawable.class, "mState").get(rotateDrawable), drawable);
            drawable.setCallback(rotateDrawable);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setPivotX(RotateDrawable rotateDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(rotateDrawable, "rotateDrawable");
        if (Build.VERSION.SDK_INT >= 21) {
            rotateDrawable.setPivotX(f);
            return;
        }
        try {
            Class<?> cls = rotateState;
            resolveField(cls, "mPivotX").setFloat(rotateDrawable.getConstantState(), f);
            resolveField(cls, "mPivotXRel").setBoolean(rotateDrawable.getConstantState(), true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setPivotY(RotateDrawable rotateDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(rotateDrawable, "rotateDrawable");
        if (Build.VERSION.SDK_INT >= 21) {
            rotateDrawable.setPivotY(f);
            return;
        }
        try {
            Class<?> cls = rotateState;
            resolveField(cls, "mPivotY").setFloat(rotateDrawable.getConstantState(), f);
            resolveField(cls, "mPivotYRel").setBoolean(rotateDrawable.getConstantState(), true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setFromDegrees(RotateDrawable rotateDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(rotateDrawable, "rotateDrawable");
        if (Build.VERSION.SDK_INT >= 21) {
            rotateDrawable.setFromDegrees(f);
            return;
        }
        try {
            resolveField(rotateState, "mFromDegrees").setFloat(rotateDrawable.getConstantState(), f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setToDegrees(RotateDrawable rotateDrawable, float f) {
        Intrinsics.checkParameterIsNotNull(rotateDrawable, "rotateDrawable");
        if (Build.VERSION.SDK_INT >= 21) {
            rotateDrawable.setToDegrees(f);
            return;
        }
        try {
            resolveField(rotateState, "mToDegrees").setFloat(rotateDrawable.getConstantState(), f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final void setRadius(RippleDrawable rippleDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(rippleDrawable, "rippleDrawable");
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i);
            return;
        }
        Class<RippleDrawable> cls = RippleDrawable.class;
        try {
            resolveMethod(cls, "setMaxRadius", Integer.TYPE).invoke(rippleDrawable, new Object[]{Integer.valueOf(i)});
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }
}
