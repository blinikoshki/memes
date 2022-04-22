package editor.optionsui.layerpaint;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import editor.optionsui.layerpaint.LayerPaint;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, mo26107d2 = {"Leditor/optionsui/layerpaint/LayerPaintJsonAdapter;", "Lcom/google/gson/JsonSerializer;", "Leditor/optionsui/layerpaint/LayerPaint;", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayerPaintJsonAdapter.kt */
public final class LayerPaintJsonAdapter implements JsonSerializer<LayerPaint>, JsonDeserializer<LayerPaint> {
    public JsonElement serialize(LayerPaint layerPaint, Type type, JsonSerializationContext jsonSerializationContext) {
        String str;
        if (layerPaint == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        if (layerPaint instanceof LayerPaint.Color) {
            str = new Gson().toJson((Object) layerPaint);
        } else if (layerPaint instanceof LayerPaint.Gradient) {
            str = new Gson().toJson((Object) layerPaint);
        } else if (layerPaint instanceof LayerPaint.Pattern) {
            str = new Gson().toJson((Object) layerPaint);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        JsonElement parseString = JsonParser.parseString(str);
        Intrinsics.checkNotNullExpressionValue(parseString, "JsonParser.parseString(json)");
        return parseString;
    }

    public LayerPaint deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonElement == null) {
            return null;
        }
        if (!(jsonElement instanceof JsonObject)) {
            jsonElement = null;
        }
        JsonObject jsonObject = (JsonObject) jsonElement;
        if (jsonObject == null) {
            return null;
        }
        if (jsonObject.has("startColor")) {
            JsonElement jsonElement2 = jsonObject.get("startColor");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"startColor\")");
            String asString = jsonElement2.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"startColor\").asString");
            JsonElement jsonElement3 = jsonObject.get("centerColor");
            Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject.get(\"centerColor\")");
            String asString2 = jsonElement3.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(\"centerColor\").asString");
            JsonElement jsonElement4 = jsonObject.get("endColor");
            Intrinsics.checkNotNullExpressionValue(jsonElement4, "jsonObject.get(\"endColor\")");
            String asString3 = jsonElement4.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString3, "jsonObject.get(\"endColor\").asString");
            JsonElement jsonElement5 = jsonObject.get("isLinear");
            Intrinsics.checkNotNullExpressionValue(jsonElement5, "jsonObject.get(\"isLinear\")");
            return new LayerPaint.Gradient(asString, asString2, asString3, jsonElement5.getAsBoolean());
        } else if (jsonObject.has("colorHex")) {
            JsonElement jsonElement6 = jsonObject.get("colorHex");
            Intrinsics.checkNotNullExpressionValue(jsonElement6, "jsonObject.get(\"colorHex\")");
            String asString4 = jsonElement6.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString4, "jsonObject.get(\"colorHex\").asString");
            return new LayerPaint.Color(asString4);
        } else if (jsonObject.has("source")) {
            JsonElement jsonElement7 = jsonObject.get("source");
            Intrinsics.checkNotNullExpressionValue(jsonElement7, "jsonObject.get(\"source\")");
            String asString5 = jsonElement7.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString5, "jsonObject.get(\"source\").asString");
            JsonElement jsonElement8 = jsonObject.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            Intrinsics.checkNotNullExpressionValue(jsonElement8, "jsonObject.get(\"width\")");
            int asInt = jsonElement8.getAsInt();
            JsonElement jsonElement9 = jsonObject.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            Intrinsics.checkNotNullExpressionValue(jsonElement9, "jsonObject.get(\"height\")");
            return new LayerPaint.Pattern(asString5, asInt, jsonElement9.getAsInt());
        } else {
            throw new IllegalStateException("Cannot parse " + jsonObject + " in " + getClass().getSimpleName() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
    }
}
