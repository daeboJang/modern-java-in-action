package book.real_world_software.ch_06;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

/**
 * 전송메세지
 */
@Getter
@ToString
public class Twoot {
    private final String id;
    private final String senderId;
    private final String content;
    private final Position position;

    public Twoot(String id, String senderId, String content, Position position) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(senderId, "senderId");
        Objects.requireNonNull(content, "content");
        Objects.requireNonNull(position, "position");

        this.id = id;
        this.senderId = senderId;
        this.content = content;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Twoot twoot = (Twoot) o;

        return id.equals(twoot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
