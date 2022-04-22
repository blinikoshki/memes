package org.apache.commons.lang3.text;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public abstract class StrLookup<V> {
    private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup((Map) null);

    public abstract String lookup(String str);

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    private static Properties copyProperties(Properties properties) {
        if (properties == null) {
            return null;
        }
        Properties properties2 = new Properties();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            properties2.setProperty(str, properties.getProperty(str));
        }
        return properties2;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        Properties properties;
        try {
            properties = System.getProperties();
        } catch (SecurityException unused) {
            properties = null;
        }
        return new MapStrLookup(copyProperties(properties));
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    protected StrLookup() {
    }

    static class MapStrLookup<V> extends StrLookup<V> {
        private final Map<String, V> map;

        MapStrLookup(Map<String, V> map2) {
            this.map = map2;
        }

        public String lookup(String str) {
            V v;
            Map<String, V> map2 = this.map;
            if (map2 == null || (v = map2.get(str)) == null) {
                return null;
            }
            return v.toString();
        }
    }
}
