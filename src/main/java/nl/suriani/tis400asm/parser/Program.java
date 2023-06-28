package nl.suriani.tis400asm.parser;

import java.util.List;
import java.util.Objects;

public record Program(List<Statement> statements) {
    public Program {
        Objects.requireNonNull(statements);
        // TODO add constraint check on n. of statements
    }
}
