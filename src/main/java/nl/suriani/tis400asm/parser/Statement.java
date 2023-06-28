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
        // TODO add constraint check on n. of characters.
        // n. of characters: length of instruction + length of all parameters + (n. of parameters - 1) (representing amount of spaces)
    }
}
