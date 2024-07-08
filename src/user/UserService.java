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
        if (result && loggedInUser != null && loggedInUser.getId().equals(user.getId())) {
            loggedInUser.setId(newId);
            loggedInUser.setPw(newPw);
            loggedInUser.setName(newName);
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

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
