package user;

public class UserService {
    private UserDAO dao;
    private User loggedInUser;

    public UserService() {
        this.dao = new UserDAO();
    }

    public boolean register(User user) {
        return dao.register(user);
    }

    public User login(String id, String pw) {
        User user = dao.login(id, pw);
        if (user != null) {
            loggedInUser = user;
        }
        return user;
    }

    public void logout() {
        loggedInUser = null;
    }

    public boolean update(User user, String newId, String newPw, String newName) {
        boolean result = dao.update(user, newId, newPw, newName);
        if (result) {
            loggedInUser = dao.login(newId, newPw); // 수정된 정보를 반영하여 다시 로그인
        }
        return result;
    }

    public boolean delete(String id) {
        if (dao.delete(id)) {
            if (loggedInUser != null && loggedInUser.getId().equals(id)) {
                loggedInUser = null;
            }
            return true;
        }
        return false;
    }
}
