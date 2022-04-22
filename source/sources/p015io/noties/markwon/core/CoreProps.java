package p015io.noties.markwon.core;

import p015io.noties.markwon.Prop;

/* renamed from: io.noties.markwon.core.CoreProps */
public abstract class CoreProps {
    public static final Prop<Integer> BULLET_LIST_ITEM_LEVEL = Prop.m157of("bullet-list-item-level");
    public static final Prop<String> CODE_BLOCK_INFO = Prop.m157of("code-block-info");
    public static final Prop<Integer> HEADING_LEVEL = Prop.m157of("heading-level");
    public static final Prop<String> LINK_DESTINATION = Prop.m157of("link-destination");
    public static final Prop<ListItemType> LIST_ITEM_TYPE = Prop.m157of("list-item-type");
    public static final Prop<Integer> ORDERED_LIST_ITEM_NUMBER = Prop.m157of("ordered-list-item-number");
    public static final Prop<Boolean> PARAGRAPH_IS_IN_TIGHT_LIST = Prop.m157of("paragraph-is-in-tight-list");

    /* renamed from: io.noties.markwon.core.CoreProps$ListItemType */
    public enum ListItemType {
        BULLET,
        ORDERED
    }

    private CoreProps() {
    }
}
