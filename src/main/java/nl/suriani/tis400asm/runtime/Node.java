package nl.suriani.tis400asm.runtime;

public class Node {
    private Port up;
    private Port down;
    private Port left;
    private Port right;
    private Port any;
    private Port last;
    private Register acc;
    private Register bak;
    private Register pc;
    private NodeStatus status;

    public Node() {
        up = new Port();
        down = new Port();
        left = new Port();
        right = new Port();
        acc = new Register();
        bak = new Register();
        pc = new Register();
    }

    public void up() {

    }

    public void down() {

    }

    public void left() {

    }

    public void right() {

    }

    public void any() {

    }

    public void last() {

    }

    public void add() {

    }

    public void sub() {

    }

    public void neg() {

    }

    public void nop() {

    }

    public void sav() {

    }

    public void swp() {

    }

    public void jmp() {

    }

    public void jez() {

    }
    public void jlz() {

    }
    public void jgz() {

    }
    public void jnz() {

    }
    public void jro() {

    }
}
