package com.moczul.ok2curl.modifier;

import com.moczul.ok2curl.Header;

public interface HeaderModifier {
    boolean matches(Header header);

    Header modify(Header header);
}
