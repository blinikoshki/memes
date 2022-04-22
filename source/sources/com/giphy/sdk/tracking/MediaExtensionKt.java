package com.giphy.sdk.tracking;

import android.util.Log;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.giphy.sdk.core.GiphyCore;
import com.giphy.sdk.core.models.Media;
import editor.editor.equipment.core.CoreConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\u001a\n\u0010&\u001a\u00020'*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\",\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\",\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\",\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019\",\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\",\u0010\"\u001a\u0004\u0018\u00010\u0001*\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010%¨\u0006("}, mo26107d2 = {"EVENT_TYPE_KEY", "", "IS_EMOJI_KEY", "IS_TEXT_KEY", "POSITION_KEY", "RESPONSE_ID_KEY", "adSession", "Lcom/giphy/sdk/tracking/GPHAdSession;", "Lcom/giphy/sdk/core/models/Media;", "getAdSession", "(Lcom/giphy/sdk/core/models/Media;)Lcom/giphy/sdk/tracking/GPHAdSession;", "value", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "eventType", "getEventType", "(Lcom/giphy/sdk/core/models/Media;)Lcom/giphy/sdk/analytics/models/enums/EventType;", "setEventType", "(Lcom/giphy/sdk/core/models/Media;Lcom/giphy/sdk/analytics/models/enums/EventType;)V", "gphSessionId", "getGphSessionId", "(Lcom/giphy/sdk/core/models/Media;)Ljava/lang/String;", "", "isEmoji", "(Lcom/giphy/sdk/core/models/Media;)Ljava/lang/Boolean;", "setEmoji", "(Lcom/giphy/sdk/core/models/Media;Ljava/lang/Boolean;)V", "isText", "setText", "", "position", "getPosition", "(Lcom/giphy/sdk/core/models/Media;)Ljava/lang/Integer;", "setPosition", "(Lcom/giphy/sdk/core/models/Media;Ljava/lang/Integer;)V", "responseId", "getResponseId", "setResponseId", "(Lcom/giphy/sdk/core/models/Media;Ljava/lang/String;)V", "createAdSession", "", "giphy-sdk_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* compiled from: MediaExtension.kt */
public final class MediaExtensionKt {
    private static final String EVENT_TYPE_KEY = "etk";
    private static final String IS_EMOJI_KEY = "iek";
    private static final String IS_TEXT_KEY = "itk";
    private static final String POSITION_KEY = "pk";
    private static final String RESPONSE_ID_KEY = "rk";

    public static final String getResponseId(Media media) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary != null) {
            return userDictionary.get(RESPONSE_ID_KEY);
        }
        return null;
    }

    public static final void setResponseId(Media media, String str) {
        HashMap<String, String> userDictionary;
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary2 = media.getUserDictionary();
        if (userDictionary2 == null) {
            userDictionary2 = new HashMap<>();
        }
        media.setUserDictionary(userDictionary2);
        if (str != null && (userDictionary = media.getUserDictionary()) != null) {
            String put = userDictionary.put(RESPONSE_ID_KEY, str);
        }
    }

    public static final Integer getPosition(Media media) {
        String str;
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null || (str = userDictionary.get(POSITION_KEY)) == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public static final void setPosition(Media media, Integer num) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null) {
            userDictionary = new HashMap<>();
        }
        media.setUserDictionary(userDictionary);
        if (num != null) {
            int intValue = num.intValue();
            HashMap<String, String> userDictionary2 = media.getUserDictionary();
            if (userDictionary2 != null) {
                String put = userDictionary2.put(POSITION_KEY, String.valueOf(intValue));
            }
        }
    }

    public static final Boolean isEmoji(Media media) {
        String str;
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null || (str = userDictionary.get(IS_EMOJI_KEY)) == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public static final void setEmoji(Media media, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null) {
            userDictionary = new HashMap<>();
        }
        media.setUserDictionary(userDictionary);
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            HashMap<String, String> userDictionary2 = media.getUserDictionary();
            if (userDictionary2 != null) {
                String put = userDictionary2.put(IS_EMOJI_KEY, String.valueOf(booleanValue));
            }
        }
    }

    public static final Boolean isText(Media media) {
        String str;
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null || (str = userDictionary.get(IS_TEXT_KEY)) == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public static final void setText(Media media, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null) {
            userDictionary = new HashMap<>();
        }
        media.setUserDictionary(userDictionary);
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            HashMap<String, String> userDictionary2 = media.getUserDictionary();
            if (userDictionary2 != null) {
                String put = userDictionary2.put(IS_TEXT_KEY, String.valueOf(booleanValue));
            }
        }
    }

    public static final EventType getEventType(Media media) {
        String str;
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary = media.getUserDictionary();
        if (userDictionary == null || (str = userDictionary.get(EVENT_TYPE_KEY)) == null) {
            return null;
        }
        return EventType.values()[Integer.parseInt(str)];
    }

    public static final void setEventType(Media media, EventType eventType) {
        HashMap<String, String> userDictionary;
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        HashMap<String, String> userDictionary2 = media.getUserDictionary();
        if (userDictionary2 == null) {
            userDictionary2 = new HashMap<>();
        }
        media.setUserDictionary(userDictionary2);
        if (eventType != null && (userDictionary = media.getUserDictionary()) != null) {
            String put = userDictionary.put(EVENT_TYPE_KEY, String.valueOf(eventType.ordinal()));
        }
    }

    public static final String getGphSessionId(Media media) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        StringBuilder sb = new StringBuilder();
        String responseId = getResponseId(media);
        if (responseId == null) {
            responseId = "";
        }
        sb.append(responseId);
        sb.append(CoreConfig.ENTITY_TOKEN_PREFIX);
        sb.append(media.getId());
        return sb.toString();
    }

    public static final GPHAdSession getAdSession(Media media) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        if (GiphyCore.INSTANCE.getTrackOpenMeasurement()) {
            return OMTracking.INSTANCE.getSession(media);
        }
        return null;
    }

    public static final void createAdSession(Media media) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        if (GiphyCore.INSTANCE.getTrackOpenMeasurement()) {
            String tag = OMTracking.INSTANCE.getTAG();
            Log.d(tag, "[OM] createAdSession " + getGphSessionId(media));
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new MediaExtensionKt$createAdSession$1(media, (Continuation) null), 2, (Object) null);
        }
    }
}
