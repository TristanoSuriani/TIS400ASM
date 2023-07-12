package nl.suriani.tis400asm.parser;

import java.util.Objects;

public record Parameter(ParameterType type, String value) {
    public Parameter {
        Objects.requireNonNull(type);
        Objects.requireNonNull(value);
    }
}
