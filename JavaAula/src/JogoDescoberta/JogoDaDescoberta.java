package JogoDescoberta;

import java.util.*;

public class JogoDaDescoberta {
	
   public static void main(String[] args) {
	   
       Scanner scanner = new Scanner(System.in);
       
       // Vetor de palavras predefinidas
       String[] palavras = {"java", "computador", "cavalo", "viagem", "brasil", "ventilador"};
       Random random = new Random();
       
       // Seleciona uma palavra aleatória
       String palavraOriginal = palavras[random.nextInt(palavras.length)];
       String palavraEmbaralhada = embaralharPalavra(palavraOriginal);
       System.out.println("Bem-vindo ao Jogo da Descoberta!");
       System.out.println("Tente adivinhar a palavra embaralhada");
       System.out.println("Digite 'dica' para uma dica, ou 'desistir' para sair");
       System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
       
       while (true) {
           System.out.print("Sua tentativa: ");
           // Guarda a mensagem do scanner e a reescreve em letras minusculas
           String tentativa = scanner.nextLine().toLowerCase();
           
           if (tentativa.equals("desistir")) {
               System.out.println("Você desistiu! A palavra era: " + palavraOriginal);
               break;
               
           } else if (tentativa.equals("dica")) {
               System.out.println("Dica: a primeira letra é '" + palavraOriginal.charAt(0) + "' e a última é '" + palavraOriginal.charAt(palavraOriginal.length() - 1) + "'");
           } else if (tentativa.equals(palavraOriginal)) {
               System.out.println("Parabéns! Você acertou a palavra: " + palavraOriginal);
               break;
               
           } else {
               System.out.println("Errado! Tente novamente");
           }
       }
       scanner.close();
       
   }
   // Método para embaralhar a palavra
   public static String embaralharPalavra(String palavra) {
       // Converte a palavra em um array de caracteres
       char[] letras = new char[palavra.length()];
       for (int i = 0; i < palavra.length(); i++) {
           letras[i] = palavra.charAt(i);
       }
       
       // Embaralha a palavra
       for (int i = letras.length - 1; i > 0; i--) {
           int j = (int) (Math.random() * (i + 1)); // número aleatório entre 0 e i
           // Troca letras[i] com letras[j]
           char temp = letras[i];
           letras[i] = letras[j];
           letras[j] = temp;
       }
       
       // Converte o array de volta para uma string
       String palavraEmbaralhada = "";
       for (int i = 0; i < letras.length; i++) {
           palavraEmbaralhada += letras[i];
       }
       return palavraEmbaralhada;   
   }
}
