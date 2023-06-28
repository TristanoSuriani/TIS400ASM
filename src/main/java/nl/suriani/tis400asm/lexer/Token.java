package nl.suriani.tis400asm.lexer;

import java.util.Objects;

public record Token(TokenType type, String value, Line line) {
    public Token {
        Objects.requireNonNull(type);
        Objects.requireNonNull(value);
        Objects.requireNonNull(line);
    }
}
