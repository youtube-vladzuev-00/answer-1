import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public final class Runner {
    public static void main(final String... args)
            throws Exception {
        final EvenNumberGenerator generator = new EvenNumberGenerator();
        new Thread(generator::generate).start();
        MILLISECONDS.sleep(100);

        //на момент вызова метода EvenNumberGenerator::getValue поток, который вызывает метод generate,
        //успеет выполнить только первый 'this.value++' внутри метода generate,
        //поэтому здесь мы получим -1, а не 0, как ожидаем от генератора четных чисел
        out.println(generator.getValue());
    }
}