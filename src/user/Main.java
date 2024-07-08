package user;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        User loggedInUser = null;
        while (true) {
            System.out.println("1: 회원가입 / 2: 로그인 / 3: 회원정보 수정 / 4: 탈퇴 / 5: 로그아웃 / 0: 종료");
            System.out.print("입력: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("아이디를 입력하세요");
                    String id = sc.next();
                    System.out.println("비밀번호를 입력하세요");
                    String pw = sc.next();
                    System.out.println("닉네임을 입력하세요");
                    String name = sc.next();

                    User newUser = new User(id, pw, name);
                    if (userService.register(newUser)) {
                        System.out.println(name + "님 가입을 환영합니다.");
                    } else {
                        System.out.println("이미 존재하는 아이디입니다.");
                    }
                    break;

                case 2:
                    if (loggedInUser != null) {
                        System.out.println("이미 로그인 상태입니다.");
                        break;
                    }
                    System.out.println("아이디를 입력하세요.");
                    id = sc.next();
                    System.out.println("비밀번호를 입력하세요.");
                    pw = sc.next();
                    loggedInUser = userService.login(id, pw);
                    if (loggedInUser != null) {
                        System.out.println(loggedInUser.getName() + "님 환영합니다.");
                    } else {
                        System.out.println("로그인 실패");
                    }
                    break;

                case 3:
                    if (loggedInUser == null) {
                        System.out.println("로그인 상태가 아닙니다.");
                        break;
                    }

                    System.out.println("변경할 아이디를 입력하세요");
                    id = sc.next();
                    System.out.println("변경할 비밀번호를 입력하세요");
                    pw = sc.next();
                    System.out.println("변경할 닉네임을 입력하세요");
                    name = sc.next();
                    if (userService.update(loggedInUser, id, pw, name)) {
                        System.out.println("회원정보가 수정되었습니다. 다시 로그인해주세요");
                        userService.logout();
                        loggedInUser = null;
                    } else {
                        System.out.println("회원정보 수정에 실패했습니다.");
                    }
                    break;

                case 4:
                    if (loggedInUser == null) {
                        System.out.println("로그인 상태가 아닙니다.");
                        break;
                    }

                    System.out.println("정말로 탈퇴하시겠습니까? (y/n)");
                    String out = sc.next();

                    if (out.equalsIgnoreCase("y")) {
                        if (userService.delete(loggedInUser.getId())) {
                            System.out.println("회원탈퇴가 완료되었습니다.");
                            loggedInUser = null; // 로그아웃 처리
                        } else {
                            System.out.println("회원탈퇴에 실패했습니다.");
                        }
                    }
                    break;

                case 5:
                    if (loggedInUser == null) {
                        System.out.println("로그인 상태가 아닙니다.");
                        break;
                    }
                    userService.logout();
                    loggedInUser = null;
                    System.out.println("로그아웃 되었습니다.");
                    break;

                case 0: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
