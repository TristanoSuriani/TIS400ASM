package nl.suriani.tis400asm.runtime;

public class Register {
    private Data data;

    public Register() {
        this.data = new Data();
    }

    public Integer data() {
        return data.value();
    }

    public void data(Integer value) {
        this.data = new Data(value);
    }
}
