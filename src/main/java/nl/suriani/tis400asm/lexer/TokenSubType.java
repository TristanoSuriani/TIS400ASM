package nl.suriani.tis400asm.lexer;

public enum TokenSubType {
    REGISTER,
    LABEL,
    INSTRUCTION,
    PORT,
    PSEUDO_PORT,
    COMMENT,
    BREAKPOINT,
    LITERAL
}
