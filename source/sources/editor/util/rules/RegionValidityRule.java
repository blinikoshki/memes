package editor.util.rules;

import editor.editor.export.regions.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Leditor/util/rules/RegionValidityRule;", "Leditor/util/rules/Rule;", "region", "Leditor/editor/export/regions/Region;", "(Leditor/editor/export/regions/Region;)V", "apply", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RegionValidityRule.kt */
public final class RegionValidityRule extends Rule {
    private final Region region;

    public RegionValidityRule(Region region2) {
        Intrinsics.checkNotNullParameter(region2, TtmlNode.TAG_REGION);
        this.region = region2;
    }

    public void apply() {
        if (!this.region.isValid()) {
            throw new RuleFailedException(this, "Unable to find proper output size. Please try re-selecting this media or choose another media.");
        }
    }
}
