package nl.suriani.tis400asm.runtime;


public record NodeSnapshot(Register acc, Register bak, Register pc, NodeStatus status) {
    public NodeSnapshot {
        acc = acc.clone();
        bak = bak.clone();
        pc = pc.clone();
        status = NodeStatus.valueOf(status.name());
    }
}
