package com.giphy.sdk.core.models.enums;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/enums/LangType;", "", "lang", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "english", "spanish", "portuguese", "indonesian", "french", "arabic", "turkish", "thai", "vietnamese", "german", "italian", "japanese", "chineseSimplified", "chineseTraditional", "russian", "korean", "polish", "dutch", "romanian", "hungarian", "swedish", "czech", "hindi", "bengali", "danish", "farsi", "filipino", "finnish", "hebrew", "malay", "norwegian", "ukrainian", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: LangType.kt */
public enum LangType {
    english("en"),
    spanish("es"),
    portuguese("pt"),
    indonesian("id"),
    french("fr"),
    arabic("ar"),
    turkish("tr"),
    thai("th"),
    vietnamese("vi"),
    german("de"),
    italian("it"),
    japanese("ja"),
    chineseSimplified("zh-CN"),
    chineseTraditional("zh-TW"),
    russian("ru"),
    korean("ko"),
    polish("pl"),
    dutch("nl"),
    romanian("ro"),
    hungarian("hu"),
    swedish("sv"),
    czech("cs"),
    hindi("hi"),
    bengali("bn"),
    danish("da"),
    farsi("fa"),
    filipino("tl"),
    finnish("fi"),
    hebrew("iw"),
    malay("ms"),
    norwegian("no"),
    ukrainian("uk");
    
    private final String lang;

    private LangType(String str) {
        this.lang = str;
    }

    public String toString() {
        return this.lang;
    }
}
