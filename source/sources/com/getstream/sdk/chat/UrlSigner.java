package com.getstream.sdk.chat;

public interface UrlSigner {

    public static class DefaultUrlSigner implements UrlSigner {
        public String signFileUrl(String str) {
            return str;
        }

        public String signImageUrl(String str) {
            return str;
        }
    }

    String signFileUrl(String str);

    String signImageUrl(String str);
}
