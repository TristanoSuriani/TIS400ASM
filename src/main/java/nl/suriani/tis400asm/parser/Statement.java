package nl.suriani.tis400asm.parser;

import java.util.List;
import java.util.Objects;

public record Statement(Instruction instruction, List<Parameter> parameters) {
    public Statement {
        Objects.requireNonNull(instruction);
        Objects.requireNonNull(parameters);

        if (parameters.size() > 2) {
            throw new IllegalArgumentException("Too many parameters, maximum is 2, given " + parameters().size());
        }
    }
}
