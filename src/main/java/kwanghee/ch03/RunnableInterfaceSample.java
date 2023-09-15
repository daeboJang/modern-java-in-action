package kwanghee.ch03;

public class RunnableInterfaceSample {
    public static void main(String[] args) {
        // Runnable functional interface
        // () -> void
        Runnable r1 = () -> System.out.println("Hello world 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3!!!"));
    }

    public static void process(Runnable r) {
        r.run();
    }
}