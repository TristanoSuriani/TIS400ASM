package nl.suriani.tis400asm.runtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    void dontLoadProgram() {
        var node = new Node();
        var snapshot = node.step();
    }

}