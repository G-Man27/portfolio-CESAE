package Ex_02;
public class Taco_Vaca extends Taco {
    @Override
    public void bake() {
        super.bake();
        System.out.println("de Vaca");
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("de Vaca");
    }

    @Override
    public void box() {
        super.box();
        System.out.println("de Vaca");
    }
}
