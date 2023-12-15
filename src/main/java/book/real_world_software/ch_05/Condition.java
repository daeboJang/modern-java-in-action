package book.real_world_software.ch_05;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
