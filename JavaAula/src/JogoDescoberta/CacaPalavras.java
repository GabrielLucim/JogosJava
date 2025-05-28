package JogoDescoberta;

import java.util.*;

public class CacaPalavras {
	
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String[] palavras = {"computador", "cavalo", "viagem", "brasil", "java", "ventilador"};
       Random random = new Random();
       String palavraEscolhida = palavras[random.nextInt(palavras.length)];
       int tamanho = 10; // Tamanho do tabuleiro (10x10)
       char[][] tabuleiro = new char[tamanho][tamanho];
       
       
       // Preencher com letras aleatórias
       for (int i = 0; i < tamanho; i++) {
           for (int j = 0; j < tamanho; j++) {
               tabuleiro[i][j] = (char) ('a' + random.nextInt(26)); // letras minúsculas de 'a' a 'z'
           }
       }
       
       // Esconder a palavra em uma linha aleatória, posição aleatória horizontalmente
       int linha = random.nextInt(tamanho);
       int colunaInicio = random.nextInt(tamanho - palavraEscolhida.length());
       
       for (int i = 0; i < palavraEscolhida.length(); i++) {
           tabuleiro[linha][colunaInicio + i] = palavraEscolhida.charAt(i);
       }
       
       System.out.println("Bem-vindo ao Caça-Palavras!");
       System.out.println("Tente adivinhar a palavra escondida no tabuleiro");
       System.out.println("Digite 'dica' para uma dica ou 'desistir' para sair");
       System.out.println();
       
       // Mostra o tabuleiro
       for (int i = 0; i < tamanho; i++) {
           for (int j = 0; j < tamanho; j++) {
               System.out.print(tabuleiro[i][j] + " ");
           }
           
           System.out.println();
           
       }
       
       while (true) {
           System.out.print("\nSua tentativa: ");
           String tentativa = scanner.nextLine().toLowerCase();
           if (tentativa.equals("desistir")) {
               System.out.println("Você desistiu! A palavra era: " + palavraEscolhida);
               break;
               
           } else if (tentativa.equals("dica")) {
               System.out.println("Dica: a palavra começa com '" + palavraEscolhida.charAt(0) + "' e termina com '" +
                       palavraEscolhida.charAt(palavraEscolhida.length() - 1) + "'");
           } else if (tentativa.equals(palavraEscolhida)) {
               System.out.println("Parabéns! Você encontrou a palavra: " + palavraEscolhida);
               break;
               
           } else {
               System.out.println("Errado! Tente novamente");
           }
       }
       
       scanner.close();
   }
}
