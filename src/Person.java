public class Person {
    private final String name;
    private Phone phone;

    public Person(String name) {
        this.name = name;
    }

    public void buyPhone(Phone phone) {
        this.phone = phone;
        System.out.println(name + "님이 " + phone.getBrand() + "을 구매했습니다.");
    }

    public void turnOnPhone() {
        if (phone != null) {
            System.out.println(name + "님이 " + phone.getBrand() + "을 켰습니다.");
            phone.turnOn();
        }
    }
}
