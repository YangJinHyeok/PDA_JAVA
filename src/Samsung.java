public class Samsung implements Phone {
    private final String brand;

    public Samsung() {
        this.brand = "삼송폰";
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void turnOn() {
        System.out.println("*** 폰 켜지는 중 ***");
    }
}
