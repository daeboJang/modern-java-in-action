package book.real_world_software.ch_05;

@FunctionalInterface
public interface Rule {
    void perform(Facts facts);
}
