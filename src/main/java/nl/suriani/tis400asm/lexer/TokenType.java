package nl.suriani.tis400asm.lexer;

public enum TokenType {
    ACC(TokenSubType.REGISTER),
    NIL(TokenSubType.REGISTER),
    UP(TokenSubType.PORT),
    DOWN(TokenSubType.PORT),
    LEFT(TokenSubType.PORT),
    RIGHT(TokenSubType.PORT),
    ANY(TokenSubType.PSEUDO_PORT),
    LAST(TokenSubType.PSEUDO_PORT),
    COLON(TokenSubType.LABEL),
    NOP(TokenSubType.INSTRUCTION),
    MOV(TokenSubType.INSTRUCTION),
    SWP(TokenSubType.INSTRUCTION),
    SAV(TokenSubType.INSTRUCTION),
    ADD(TokenSubType.INSTRUCTION),
    SUB(TokenSubType.INSTRUCTION),
    NEG(TokenSubType.INSTRUCTION),
    JMP(TokenSubType.INSTRUCTION),
    JEZ(TokenSubType.INSTRUCTION),
    JNZ(TokenSubType.INSTRUCTION),
    JGZ(TokenSubType.INSTRUCTION),
    JLZ(TokenSubType.INSTRUCTION),
    JRO(TokenSubType.INSTRUCTION),
    EXCLAMATION_MARK(TokenSubType.BREAKPOINT),
    HASH(TokenSubType.COMMENT),
    NUMBER(TokenSubType.LITERAL),
    ID(TokenSubType.LITERAL);
    
    private TokenSubType subType;

    TokenType(TokenSubType subType) {
        this.subType = subType;
    }
}
