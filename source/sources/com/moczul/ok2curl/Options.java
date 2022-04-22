package com.moczul.ok2curl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Options {
    public static final Options EMPTY = new Options(Collections.emptyList());
    private final List<String> options;

    public static Builder builder() {
        return new Builder();
    }

    private Options(Collection<String> collection) {
        this.options = new ArrayList(collection);
    }

    public List<String> list() {
        return this.options;
    }

    public static class Builder {
        private final Set<String> options = new HashSet();

        public Builder insecure() {
            this.options.add("--insecure");
            return this;
        }

        public Builder maxTime(int i) {
            this.options.add(String.format(Locale.getDefault(), "--max-time %d", new Object[]{Integer.valueOf(i)}));
            return this;
        }

        public Builder connectTimeout(int i) {
            this.options.add(String.format(Locale.getDefault(), "--connect-timeout %d", new Object[]{Integer.valueOf(i)}));
            return this;
        }

        public Builder retry(int i) {
            this.options.add(String.format(Locale.getDefault(), "--retry %d", new Object[]{Integer.valueOf(i)}));
            return this;
        }

        public Builder compressed() {
            this.options.add("--compressed");
            return this;
        }

        public Builder location() {
            this.options.add("--location");
            return this;
        }

        public Options build() {
            return new Options(this.options);
        }
    }
}
