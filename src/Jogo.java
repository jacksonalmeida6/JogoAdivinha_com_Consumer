

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Consumer;

public class Jogo {


    private final ListIterator<Animal>animais;

    private Jogo(ListIterator<Animal> animais) {
        this.animais = animais;
    }


    public static void main(String[] args) throws InterruptedException {
        Jogo jogo = novo();
        jogo.executarEtapa(EtapaRefactory.iniciar());

    }
    public void executarEtapa(Consumer<Jogo>jogo) {
        jogo.accept(this);
    }


    public static Jogo novo(){
        List<Animal> animais = new ArrayList();
        animais .add(new Animal("Golfinho","sabe nadar" ));
        animais .add(new Animal("Macaco","come banana"  ));

        return new  Jogo(animais .listIterator());
    }



     void resetarAnimais() {
        while (animais.hasPrevious()){
            animais.previous();
        }

    }


    boolean chegouAoFim() {
        return (animais.hasNext());
    }

    Animal proximoAnimal() {
        return animais.next();
    }

    void addAnimal(Animal animal) {
        this.animais.add(animal);
    }
}
