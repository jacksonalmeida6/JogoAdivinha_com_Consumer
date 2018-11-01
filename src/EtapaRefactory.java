import java.util.function.Consumer;

class EtapaRefactory {

    static Consumer<Jogo>  iniciar() {
        return jogo -> {
            jogo.resetarAnimais();
            System.out.println("pensei em um animal");
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {

            }
            jogo.executarEtapa(perguntarCaracteristica());
        };
    }

    private static Consumer<Jogo>  perguntarCaracteristica() {
        return jogo -> {
            if (jogo.chegouAoFim()) {
                Animal animal = jogo.proximoAnimal();
                String resposta = Mensageiro.pergunta("O animal que vc pensou  " + animal.getCaracteristicas() + "?");
                if ("s".equals(resposta)) {
                    jogo.executarEtapa(tentarAdivinhar(animal));
                } else {
                    jogo.executarEtapa(perguntarCaracteristica());
                }

            } else {
                jogo.executarEtapa(desistir());
            }
        };
    }
    private static Consumer<Jogo>  tentarAdivinhar(Animal animal) {
        return jogo -> {
            String resposta = Mensageiro.pergunta("O animal que vc pensou é um " + animal.getNome() + "?");
            if ("s".equals(resposta)) {
                System.out.println("Sou fera!!!");
                jogo.executarEtapa(encerrarJogo());
            } else {
               jogo.executarEtapa( perguntarCaracteristica());

            }
        };
    }
    private static Consumer<Jogo>  encerrarJogo() {
        return jogo -> {
            String resposta = Mensageiro.pergunta("Vamos jogar novamente? ");
            if ("s".equals(resposta)) {
                jogo.executarEtapa(iniciar());
            } else {
                System.out.println("Então ta :( ");
            }
        };
    }
    private static Consumer<Jogo>  desistir() {
        return jogo -> {
            String nome = Mensageiro.pergunta("Desisto. Qual animal voçê pensou? ");
            String caracteristica = Mensageiro.pergunta("me diga uma caracteristica desse animal?");
            jogo.addAnimal(new Animal(nome, caracteristica));
            jogo.executarEtapa(encerrarJogo());

        };
    }

}

