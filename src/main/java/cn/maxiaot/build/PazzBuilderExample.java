package cn.maxiaot.build;

public class PazzBuilderExample {
    public static void main(String[] args) {
        PazzBuilder pazzBuilder = new DurianPazzBuilder();
        Waiter waiter = new Waiter();
        waiter.setPazzBuilder(pazzBuilder);
        Pazz pazz = waiter.makePazz();
        System.out.println(pazz);
    }
}
