package cn.maxiaot.build;

public class Pazz {

    private String taste;

    private String topping;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pazz{" +
                "taste='" + taste + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
