import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldWinnerForOne() {
        Player player1 = new Player(1, "Оля", 50);
        Player player2 = new Player(6, "Аня", 30);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Оля", "Аня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinnerForTow() {
        Player player1 = new Player(1, "Оля", 30);
        Player player2 = new Player(6, "Аня", 50);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Оля", "Аня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldForcesAreEqual() {
        Player player1 = new Player(1, "Оля", 30);
        Player player2 = new Player(6, "Аня", 30);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Оля", "Аня");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinnerForUnregisteredOne() {
        Player player1 = new Player(1, "Оля", 30);
        Player player2 = new Player(6, "Аня", 50);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Оля", "Коля")
        );
    }

    @Test
    public void shouldWinnerForUnregisteredTwo() {
        Player player1 = new Player(1, "Оля", 30);
        Player player2 = new Player(6, "Аня", 50);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Поля", "Аня")
        );
    }
}
