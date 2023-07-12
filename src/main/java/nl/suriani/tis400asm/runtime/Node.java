package nl.suriani.tis400asm.runtime;

import nl.suriani.tis400asm.parser.Parameter;
import nl.suriani.tis400asm.parser.Program;
import nl.suriani.tis400asm.parser.Statement;

import java.util.Optional;

public class Node {
    final private Port up;
    final private Port down;
    final private Port left;
    final private Port right;
    private Port any;
    private Port last;
    final private Register acc;
    final private Register bak;
    final private Register pc;
    final private NodeStatus status;
    final private Program program;

    public Node() {
        up = new Port();
        down = new Port();
        left = new Port();
        right = new Port();
        acc = new Register();
        bak = new Register();
        pc = new Register();
        status = NodeStatus.READY;
        program = new Program();
    }

    public void loadProgram(Program program) {
        this.program.statements().clear();
        this.program.statements().addAll(program.statements());
    }

    public NodeSnapshot step() {
        return new NodeSnapshot(acc, bak, pc, status);
    }

    private void handleStatement(Statement statement) {
        final var parameters = statement.parameters();
        final var maybeParameter1 = parameters.stream()
                .limit(1)
                .findFirst();

        final var maybeParameter2 = parameters.stream()
                .limit(2)
                .skip(1)
                .findFirst();

        switch (statement.instruction().type()) {
            case NOP -> { break; }
            case MOV -> mov(maybeParameter1.get(), maybeParameter2.get());
            case SWP -> { break; }
            case SAV -> { break; }
            case ADD -> { break; }
            case SUB -> { break; }
            case NEG -> { break; }
            case JMP -> { break; }
            case JEZ -> { break; }
            case JNZ -> { break; }
            case JGZ -> { break; }
            case JLZ -> { break; }
            case JRO -> { break; }
        }
    }

    private void up() {

    }

    private void down() {

    }

    private void left() {

    }

    private void right() {

    }

    private void any() {

    }

    private void last() {

    }

    private void mov(Parameter from, Parameter to) {

    }

    private void add() {

    }

    private void sub() {

    }

    private void neg() {

    }

    private void nop() {

    }

    private void sav() {

    }

    private void swp() {

    }

    private void jmp() {

    }

    private void jez() {

    }
    private void jlz() {

    }
    private void jgz() {

    }
    private void jnz() {

    }
    private void jro() {

    }
}
