package org.commonmark.parser.block;

import org.commonmark.internal.BlockStartImpl;

public abstract class BlockStart {
    public static BlockStart none() {
        return null;
    }

    public abstract BlockStart atColumn(int i);

    public abstract BlockStart atIndex(int i);

    public abstract BlockStart replaceActiveBlockParser();

    protected BlockStart() {
    }

    /* renamed from: of */
    public static BlockStart m221of(BlockParser... blockParserArr) {
        return new BlockStartImpl(blockParserArr);
    }
}
