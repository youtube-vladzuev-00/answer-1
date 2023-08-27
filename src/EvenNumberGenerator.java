import static java.util.concurrent.TimeUnit.SECONDS;

//генератор четных чисел
public final class EvenNumberGenerator {
    private volatile long value = -2;

    public synchronized long generate() {
        try {
            this.value++;
            SECONDS.sleep(1);
            this.value++;
            return this.value;
        } catch (final InterruptedException cause) {
            throw new RuntimeException(cause);
        }
    }

    public long getValue() {
        return this.value;
    }
}