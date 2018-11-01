import java.util.Scanner;

public  class Mensageiro {

    private final static Scanner scanner = new Scanner(System.in);

    private Mensageiro(){

    }

    public  static String pergunta(String pergunta) {
        System.out.println(pergunta);
        String resposta = scanner.nextLine();
        while ("".equals(resposta)) {
            resposta = scanner.nextLine();
        }
        return resposta;
    }
}
