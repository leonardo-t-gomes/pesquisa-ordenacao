import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Util {

    public static boolean carregarArquivoEmLista(String nomeArquivo, ArrayList<Integer> lista) {
        try {
            FileReader procurador;
            procurador = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(procurador);
            String linha;
            do {
                linha = leitor.readLine();
                if (linha != null) {
                    lista.add(Integer.parseInt(linha));
                }                
            } while (linha != null);
            leitor.close();
            return true;
        } catch (Exception e) {
            //System.out.println("Erro " + e.getMessage());
            return false;
        }
    }

    public static void exibirLista(ArrayList<Integer> lista) {
        for (Integer item : lista) {
            System.out.println(item);
        }
    }

    public static void GerarNumeros() {

        Random random = new Random();

        try (PrintWriter arquivo =
                     new PrintWriter(new FileWriter("numeros.txt"))) {

            for (int i = 0; i < 100000; i++) {
                arquivo.println(random.nextInt(1000000));
            }

            System.out.println("Arquivo numeros.txt criado!");
            System.out.println("Quantidade de números: 100000");

        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    
    }
}
