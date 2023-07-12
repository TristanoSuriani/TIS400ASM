package nl.suriani.tis400asm.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Lexer {

    public List<Token> lex(final String text) {
        if (text == null) {
            throw new NoTextException();
        }

        final var tokens = new ArrayList<Token>();
        final var currentWord = new StringBuilder();
        final var lineNumber = new AtomicInteger(1);

        text.chars()
                .mapToObj(c -> (char) c)
                .forEach(character -> {

                    if (!isDelimiter(character)) {
                        currentWord.append(character);
                        return;
                    }

                    if (pushWordIfNeeded(currentWord.toString(), lineNumber.get(), tokens)) {
                        currentWord.setLength(0);
                    }

                    if (isEndOfLine(character)) {
                        lineNumber.incrementAndGet();
                    }
        });

        pushWordIfNeeded(currentWord.toString(), lineNumber.get(), tokens);
        return tokens;
    }

    private boolean pushWordIfNeeded(String currentWord, int lineNumber, List<Token> tokens) {
        if (currentWord.isEmpty()) {
            return false;
        }

        var maybeToken = getNumberFromWord(currentWord, lineNumber);
        if (maybeToken.isPresent()) {
            pushToken(tokens, maybeToken.get());
            return true;
        }

        var maybeTokenType = getTokenTypeFromWord(currentWord);
        if (maybeTokenType.isPresent()) {
            pushToken(tokens, currentWord, lineNumber, maybeTokenType.get());
            return true;
        }

        pushToken(tokens, currentWord, lineNumber, TokenType.ID);
        return true;
    }

    private Optional<Token> getNumberFromWord(String currentWord, int lineNumber) {
        try {
            int number = Integer.parseInt(currentWord);
            return Optional.of(new Token(TokenType.NUMBER, currentWord, new Line(lineNumber)));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

    private static void pushToken(List<Token> tokens, String currentWord, int lineNumber, TokenType tokenType) {
        var token = new Token(tokenType, currentWord, new Line(lineNumber));
        tokens.add(token);
    }

    private static void pushToken(List<Token> tokens, Token token) {
        tokens.add(token);
    }

    private boolean isEndOfLine(char character) {
        return character == '\n';
    }

    private boolean isDelimiter(char character) {
        return character == ' ' ||
                isEndOfLine(character);
    }

    private Optional<TokenType> getTokenTypeFromWord(String word) {
        return Arrays.stream(TokenType.values())
                .filter(type -> type.name().equals(word))
                .findFirst();
    }
}
