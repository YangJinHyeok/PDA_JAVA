public class Main {
    public static void main(String[] args) {
        Person jobs = new Person("잡스");
        Phone apple = new Apple();
        jobs.buyPhone(apple);
        jobs.turnOnPhone();

        Person jaeyong = new Person("재용");
        Phone samsung = new Samsung();
        jaeyong.buyPhone(samsung);
        jaeyong.turnOnPhone();
    }
}
