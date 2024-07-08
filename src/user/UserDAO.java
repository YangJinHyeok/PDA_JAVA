import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> userMap = new HashMap<>();

    public boolean register(User user) {
        if (userMap.containsKey(user.getId())) {
            return false;
        }
        userMap.put(user.getId(), user);
        return true;
    }

    public User login(String id, String pw) {
        User user = userMap.get(id);
        if (user != null && user.getPw().equals(pw)) {
            return user;
        }
        return null;
    }

    public boolean update(User user, String newId, String newPw, String newName) {
        if (userMap.containsKey(user.getId())) {
            userMap.remove(user.getId());
            user.setId(newId);
            user.setPw(newPw);
            user.setName(newName);
            userMap.put(newId, user);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        if (userMap.containsKey(id)) {
            userMap.remove(id);
            return true;
        }
        return false;
    }
}
