package Ex_02;

public class Taco_Frango extends Taco {
    @Override
    public void bake() {
        super.bake();
        System.out.println("de Frango");
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("de Frango");
    }

    @Override
    public void box() {
        super.box();
        System.out.println("de Frango");
    }
}
