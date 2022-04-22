package com.memes.network.util.zipgson;

import com.google.gson.Gson;
import com.memes.network.util.zipgson.list.ZippedList;
import com.memes.network.util.zipgson.object.ZippedObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/network/util/zipgson/ZipGsonTest;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "testZippedList", "", "testZippedObject", "Monkey", "User", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ZipGsonTest.kt */
public final class ZipGsonTest {
    private final Lazy gson$delegate = LazyKt.lazy(ZipGsonTest$gson$2.INSTANCE);

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/util/zipgson/ZipGsonTest$User;", "", "name", "", "email", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ZipGsonTest.kt */
    private static final class User {
        private final String email;
        private final String name;

        public static /* synthetic */ User copy$default(User user, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = user.name;
            }
            if ((i & 2) != 0) {
                str2 = user.email;
            }
            return user.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.email;
        }

        public final User copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "email");
            return new User(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) user.name) && Intrinsics.areEqual((Object) this.email, (Object) user.email);
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.email;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "User(name=" + this.name + ", email=" + this.email + ")";
        }

        public User(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "email");
            this.name = str;
            this.email = str2;
        }

        public final String getName() {
            return this.name;
        }

        public final String getEmail() {
            return this.email;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/network/util/zipgson/ZipGsonTest$Monkey;", "", "color", "", "(Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ZipGsonTest.kt */
    private static final class Monkey {
        private final String color;

        public static /* synthetic */ Monkey copy$default(Monkey monkey, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = monkey.color;
            }
            return monkey.copy(str);
        }

        public final String component1() {
            return this.color;
        }

        public final Monkey copy(String str) {
            Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_COLOR);
            return new Monkey(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Monkey) && Intrinsics.areEqual((Object) this.color, (Object) ((Monkey) obj).color);
            }
            return true;
        }

        public int hashCode() {
            String str = this.color;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Monkey(color=" + this.color + ")";
        }

        public Monkey(String str) {
            Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_COLOR);
            this.color = str;
        }

        public final String getColor() {
            return this.color;
        }
    }

    public final void testZippedObject() {
        String json = getGson().toJson((Object) new ZippedObject(new User("john.doe", "john.doe@mail.com"), new Monkey("blue")), new ZipGsonTest$testZippedObject$json$1().getType());
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(\n\t\t\tzippedOb… Monkey?>?>() {}.type\n\t\t)");
        System.out.println(json);
    }

    public final void testZippedList() {
        String json = getGson().toJson((Object) new ZippedList(CollectionsKt.listOf(new User("john.doe", "john.doe@mail.com")), CollectionsKt.listOf(new Monkey("blue"), new Monkey("red"))), new ZipGsonTest$testZippedList$json$1().getType());
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(\n\t\t\tzippedLi… Monkey?>?>() {}.type\n\t\t)");
        System.out.println(json);
    }
}
