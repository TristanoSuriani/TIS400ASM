package nl.suriani.tis400asm.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static nl.suriani.tis400asm.lexer.TokenType.*;
import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    private final Lexer lexer = new Lexer();

    @Test
    void nullText() {
        assertThrows(NoTextException.class, () -> lexer.lex(null));
    }

    @Test
    void emptyText() {
        var result = lexer.lex("");
        assertTrue(result.isEmpty());
    }

    @Test
    void onlyNeg() {
        var result = lexer.lex("NEG");
        thenTokenStreamLooksLikeThis(result, List.of(NEG));
    }

    @Test
    void NegSpaceNeg() {
        var result = lexer.lex("NEG NEG");
        thenTokenStreamLooksLikeThis(result, List.of(NEG, NEG));
    }

    @Test
    void NegSpaceSpaceNeg() {
        var result = lexer.lex("NEG  NEG");
        thenTokenStreamLooksLikeThis(result, List.of(NEG, NEG));
    }

    @Test
    void onlyNegp() {
        var result = lexer.lex("NEGP");
        thenTokenStreamLooksLikeThis(result, List.of(ID));
    }

    @Test
    void NegEOLMov1Up() {
        var text = """
                NEG
                MOV 1 UP""";
        var result = lexer.lex(text);
        thenTokenStreamLooksLikeThis(result, List.of(NEG, MOV, NUMBER, UP));

        var firstLineTokens = List.of(result.get(0));
        var secondLineTokens = List.of(result.get(1), result.get(2), result.get(3));

        firstLineTokens.forEach(token ->
                assertEquals(1, token.line().number().intValue()));

        secondLineTokens.forEach(token ->
                assertEquals(2, token.line().number().intValue()));
    }

    void thenTokenStreamLooksLikeThis(List<Token> list1, List<TokenType> list2) {
        Objects.requireNonNull(list1);
        Objects.requireNonNull(list2);
        var expected = list1.stream()
                                .map(Token::type)
                                .toArray();

        var actual = list2.stream()
                .toArray();
        assertArrayEquals(actual, expected);
    }
}