public class Apple implements Phone {
    private final String brand;

    public Apple() {
        this.brand = "애플폰";
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void turnOn() {
        System.out.println("@@@ 폰 켜지는 중 @@@");
    }
}
