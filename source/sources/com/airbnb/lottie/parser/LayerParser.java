package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.facebook.appevents.UserDataStore;
import editor.ffmpeg.api.FfmpegCommand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

public class LayerParser {
    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PreComp;
        List emptyList2 = Collections.emptyList();
        AnimatableTransform animatableTransform = r4;
        AnimatableTransform animatableTransform2 = new AnimatableTransform();
        return new Layer(emptyList, lottieComposition, "__container", -1, layerType, -1, (String) null, emptyList2, animatableTransform, 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), (AnimatableTextFrame) null, (AnimatableTextProperties) null, Collections.emptyList(), Layer.MatteType.None, (AnimatableFloatValue) null);
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        LottieComposition lottieComposition2 = lottieComposition;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long j = 0;
        long j2 = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c = 0;
                        break;
                    }
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c = 1;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 2;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        c = 8;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 9;
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = 10;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c = 11;
                        break;
                    }
                    break;
                case 3669:
                    if (nextName.equals("sh")) {
                        c = 12;
                        break;
                    }
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c = CharUtils.f463CR;
                        break;
                    }
                    break;
                case 3681:
                    if (nextName.equals(UserDataStore.STATE)) {
                        c = 14;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = 15;
                        break;
                    }
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3712:
                    if (nextName.equals(TtmlNode.TAG_TT)) {
                        c = 17;
                        break;
                    }
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c = 18;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 19;
                        break;
                    }
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c = 21;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    JsonReader jsonReader2 = jsonReader;
                    j2 = (long) jsonReader.nextInt();
                    continue;
                case 1:
                    JsonReader jsonReader3 = jsonReader;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (parse != null) {
                            arrayList4.add(parse);
                        }
                    }
                    jsonReader.endArray();
                    continue;
                case 2:
                    JsonReader jsonReader4 = jsonReader;
                    i5 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    continue;
                case 3:
                    JsonReader jsonReader5 = jsonReader;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals(FfmpegCommand.AUDIO_STREAM)) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!nextName2.equals("d")) {
                            jsonReader.skipValue();
                        } else {
                            animatableTextFrame = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case 4:
                    JsonReader jsonReader6 = jsonReader;
                    i4 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    continue;
                case 5:
                    JsonReader jsonReader7 = jsonReader;
                    str3 = jsonReader.nextString();
                    continue;
                case 6:
                    JsonReader jsonReader8 = jsonReader;
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            nextName3.hashCode();
                            if (!nextName3.equals("nm")) {
                                jsonReader.skipValue();
                            } else {
                                arrayList5.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition2.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    continue;
                case 7:
                    JsonReader jsonReader9 = jsonReader;
                    f = (float) jsonReader.nextDouble();
                    continue;
                case 8:
                    JsonReader jsonReader10 = jsonReader;
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    continue;
                case 9:
                    JsonReader jsonReader11 = jsonReader;
                    str2 = jsonReader.nextString();
                    continue;
                case 10:
                    JsonReader jsonReader12 = jsonReader;
                    f2 = (float) jsonReader.nextDouble();
                    continue;
                case 11:
                    JsonReader jsonReader13 = jsonReader;
                    i3 = Color.parseColor(jsonReader.nextString());
                    continue;
                case 12:
                    JsonReader jsonReader14 = jsonReader;
                    i2 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    continue;
                case 13:
                    JsonReader jsonReader15 = jsonReader;
                    f3 = (float) jsonReader.nextDouble();
                    continue;
                case 14:
                    JsonReader jsonReader16 = jsonReader;
                    f4 = (float) jsonReader.nextDouble();
                    continue;
                case 15:
                    JsonReader jsonReader17 = jsonReader;
                    i = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    continue;
                case 16:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    continue;
                case 17:
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    break;
                case 18:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt >= Layer.LayerType.Unknown.ordinal()) {
                        layerType = Layer.LayerType.Unknown;
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[nextInt];
                        break;
                    }
                case 19:
                    j = (long) jsonReader.nextInt();
                    break;
                case 20:
                    str = jsonReader.nextString();
                    break;
                case 21:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            JsonReader jsonReader18 = jsonReader;
        }
        JsonReader jsonReader19 = jsonReader;
        jsonReader.endObject();
        float f5 = f / f3;
        float f6 = f2 / f3;
        ArrayList arrayList6 = new ArrayList();
        if (f5 > 0.0f) {
            Keyframe keyframe = r0;
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            Keyframe keyframe2 = new Keyframe(lottieComposition, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f5));
            arrayList2.add(keyframe);
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = lottieComposition.getEndFrame();
        }
        LottieComposition lottieComposition3 = lottieComposition;
        arrayList2.add(new Keyframe(lottieComposition3, valueOf, valueOf, (Interpolator) null, f5, Float.valueOf(f6)));
        arrayList2.add(new Keyframe(lottieComposition3, valueOf2, valueOf2, (Interpolator) null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            lottieComposition2.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str2, j, layerType, j2, str, arrayList, animatableTransform, i, i2, i3, f3, f4, i4, i5, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue);
    }
}
