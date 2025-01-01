package com.gildedrose.core.domain;

public class Range {
    private final int min;//inclusive
    private final int max;//exclusive

    private Range(Builder builder) {
        min = builder.min;
        max = builder.max;
    }

    public static Builder from(int min) {
        return Range.Builder.from(min);
    }

    public boolean isInRange(int value){
        return value >= min && value < max;
    }

    public int ensureInRange(int value){
        if(isInRange(value)){
            return value;
        }

        int fixValue = value;
        if(value < min){
            fixValue = min;
        }else if(value >= max){
            fixValue = max - 1;
        }

        return fixValue;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return 0;
    }

    public static final class Builder {
        private final int min;
        private int max = Integer.MAX_VALUE;

        private Builder(int min) {
            this.min = min;
        }

        public static Builder from(int min) {
            return new Builder(min);
        }

        public Builder toExclusive(int max){
            this.max = max;
            return this;
        }

        public Builder toInclusive(int max){
            this.max = max + 1;
            return this;
        }

        public Range build() {
            return new Range(this);
        }
    }
}
