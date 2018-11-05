public class InterfaceVersusAbstract {
    public static void main(String[] args) {

    }


    private static class ImplTest implements InterfaceTest {
        @Override
        public void AAA() {

        }

        @Override
        public void BBB() {

        }

    }

    private static class ExtendsTest extends AbstractTest {
        @Override
        void AAA() {

        }

        @Override
        void BBB() {

        }

    }
}

interface InterfaceTest {
    void AAA();
    void BBB();
}

abstract class AbstractTest {
    abstract void AAA();
    abstract void BBB();
    void tseting() {};
}
