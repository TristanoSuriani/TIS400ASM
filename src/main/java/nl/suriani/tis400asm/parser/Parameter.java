package nl.suriani.tis400asm.parser;

import java.util.Objects;

public record Parameter(ParameterType type) {
    public Parameter {
        Objects.requireNonNull(type);
    }
}
