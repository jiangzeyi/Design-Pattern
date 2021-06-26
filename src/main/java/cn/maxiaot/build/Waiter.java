package cn.maxiaot.build;

public class Waiter {

    private PazzBuilder pazzBuilder;

    public PazzBuilder getPazzBuilder() {
        return pazzBuilder;
    }

    public void setPazzBuilder(PazzBuilder pazzBuilder) {
        this.pazzBuilder = pazzBuilder;
    }

    public  Pazz makePazz() {
        return pazzBuilder.makePazz()
                .choiceTaste().choiceTopping().build();
    }
}
