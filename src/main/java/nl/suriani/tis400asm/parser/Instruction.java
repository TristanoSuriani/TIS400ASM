package nl.suriani.tis400asm.parser;

import java.util.Objects;

public record Instruction(InstructionType type) {
    public Instruction {
        Objects.requireNonNull(type);
    }
}
