package nl.suriani.tis400asm.runtime;

import java.util.Objects;

public record Data(Integer value) {
    public Data {
        Objects.requireNonNull(value);
        if (value < -999 || value > 999) {
            throw new IllegalArgumentException("Value out of range: " + value);
        }
    }

    public Data() {
        this(0);
    }
}
