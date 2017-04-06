package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {

    private List<User> users;

    public FileUserDAO(String filename) throws FileNotFoundException {
        this.users = new ArrayList<>();
        Scanner input = new Scanner(new File(filename));
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            String[] credentials = line.split("\\s+");
            if (credentials.length == 2) {
                users.add(new User(credentials[0], credentials[1]));
            }
        }
    }

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User u : users) {
            if (u.getUsername().equals(name)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

}
