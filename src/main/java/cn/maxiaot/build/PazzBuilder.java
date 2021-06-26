package cn.maxiaot.build;

public abstract class PazzBuilder {

    protected Pazz pazz;

    public PazzBuilder makePazz() {
        pazz = new Pazz();
        return this;
    }

    // 选择口味
    public abstract PazzBuilder choiceTaste();

    public abstract PazzBuilder choiceTopping();

    public Pazz build() {
        return this.pazz;
    }
}
