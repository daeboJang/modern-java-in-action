package book.real_world_software.ch_06;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private final String id;
    private final byte[] password;
    private final byte[] salt;
    private final Set<User> followers = new HashSet<>();
    private final Set<User> following = new HashSet<>();

    private Position lastSeenPosition;
    private ReceiverEndPoint receiverEndPoint;

    public User(String id, byte[] password, byte[] salt, Position lastSeenPosition) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(password, "password");

        this.id = id;
        this.password = password;
        this.salt = salt;
        this.lastSeenPosition = lastSeenPosition;
    }
}
