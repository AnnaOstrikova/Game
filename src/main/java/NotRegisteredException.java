public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Пользователь не зарегистрирован: " + playerName);
    }
}
