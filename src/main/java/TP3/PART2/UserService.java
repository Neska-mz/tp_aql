package TP3.PART2;


public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
