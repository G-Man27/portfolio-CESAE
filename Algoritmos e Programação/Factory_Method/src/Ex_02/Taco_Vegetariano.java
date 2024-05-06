package Ex_02;

public class Taco_Vegetariano extends Taco {
    @Override
    public void bake() {
        super.bake();
        System.out.println("Vegetariano");
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Vegetariano");
    }

    @Override
    public void box() {
        super.box();
        System.out.println("Vegetariano");
    }
}
