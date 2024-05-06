package Ex_02;

public interface Taco_interface {
    default void bake(){
        System.out.print("A cozinhar taco ");
    };
    default void prepare(){
        System.out.print("A preparar taco ");
    };
    default void box(){
        System.out.print("A embalar taco ");
    };

}
