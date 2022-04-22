package p015io.noties.markwon.core.factory;

import kotlin.text.Typography;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.CoreProps;
import p015io.noties.markwon.core.spans.BulletListItemSpan;
import p015io.noties.markwon.core.spans.OrderedListItemSpan;

/* renamed from: io.noties.markwon.core.factory.ListItemSpanFactory */
public class ListItemSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        if (CoreProps.ListItemType.BULLET == CoreProps.LIST_ITEM_TYPE.require(renderProps)) {
            return new BulletListItemSpan(markwonConfiguration.theme(), CoreProps.BULLET_LIST_ITEM_LEVEL.require(renderProps).intValue());
        }
        return new OrderedListItemSpan(markwonConfiguration.theme(), String.valueOf(CoreProps.ORDERED_LIST_ITEM_NUMBER.require(renderProps)) + "." + Typography.nbsp);
    }
}
