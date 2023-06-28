package nl.suriani.tis400asm.lexer;

import java.util.Objects;

public record Line(Integer number) {
    public Line {
        Objects.requireNonNull(number);
        if (number < 1 || number > 12) {
            throw new IllegalArgumentException();
        }
    }
}
