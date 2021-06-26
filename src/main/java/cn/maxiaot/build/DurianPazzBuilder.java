package cn.maxiaot.build;

public class DurianPazzBuilder extends PazzBuilder {

    @Override
    public PazzBuilder choiceTaste() {
        super.pazz.setTaste("原味");
        return this;
    }

    @Override
    public PazzBuilder choiceTopping() {
        super.pazz.setTopping("榴莲");
        return this;
    }
}
