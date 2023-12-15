package book.real_world_software.ch_05;

@FunctionalInterface
public interface Action {
    void execute(Facts facts);
}
