package beans;

import java.util.List;

public class UserBean {
    List<User> users;

    public UserBean(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
