package TP3.PART1;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);
        long userId = 1L;
        User expectedUser = new User(userId, "John Doe");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.getUserById(userId);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userRepository).findUserById(userId);
    }
}
