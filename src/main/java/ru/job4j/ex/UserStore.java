package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = new User();
        for (User value : users) {
            if (login.equals(value.getUsername())) {
                user = value;
                break;
            }
        }
        if (user.getUsername() == null) {
            throw new UserNotFoundException("User could not be found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            System.out.println("User is not valid");
        } catch (UserNotFoundException en) {
            System.out.println("User could not be found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
