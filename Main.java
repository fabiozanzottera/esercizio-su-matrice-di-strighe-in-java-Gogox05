import java.util.Scanner;

public class MatriceStringhe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrice = {
            {"blssd", "brige", "kiid"},
            {"sick luke", "lito", "sad"},
            {"succo", "flatpearl", "ddusi"}
        };

        stampaMatrice(matrice);
        System.out.println("Numero totale di parole: " + contaParole(matrice));
        System.out.println("Lunghezza totale delle stringhe: " + sommaLunghezze(matrice));

        System.out.print("Inserisci una parola da cercare: ");
        String parola = scanner.nextLine();
        System.out.println("Presente nella matrice? " + cercaParola(matrice, parola));

        System.out.print("Inserisci il carattere iniziale: ");
        char iniziale = scanner.nextLine().charAt(0);
        System.out.println("Parole che iniziano con '" + iniziale + "': " + contaInizianoCon(matrice, iniziale));

        System.out.print("Inserisci una lettera da cercare nelle parole: ");
        char lettera = scanner.nextLine().charAt(0);
        System.out.println("Parole che contengono '" + lettera + "': " + contaContengonoLettera(matrice, lettera));

        System.out.println("Numero di parole palindrome: " + contaPalindrome(matrice));
        System.out.println("Parola piu' lunga: " + trovaPiuLunga(matrice));
        System.out.println("Parola piu' corta: " + trovaPiuCorta(matrice));
        System.out.println("Numero totale di vocali: " + contaVocali(matrice));

        System.out.print("Lettera da sostituire: ");
        char da = scanner.nextLine().charAt(0);
        System.out.print("Lettera sostitutiva: ");
        char a = scanner.nextLine().charAt(0);
        String[][] matriceSostituita = sostituisciLettera(matrice, da, a);
        System.out.println("Matrice modificata:");
        stampaMatrice(matriceSostituita);

        scanner.close();
    }

    public static void stampaMatrice(String[][] matrice) {
        for (String[] riga : matrice) {
            for (String parola : riga) {
                System.out.print(parola + "\t");
            }
            System.out.println();
        }
    }

    public static int contaParole(String[][] matrice) {
        return matrice.length * matrice[0].length;
    }

    public static int sommaLunghezze(String[][] matrice) {
        int somma = 0;
        for (String[] riga : matrice)
            for (String parola : riga)
                somma += parola.length();
        return somma;
    }

    public static boolean cercaParola(String[][] matrice, String target) {
        for (String[] riga : matrice)
            for (String parola : riga)
                if (parola.equals(target))
                    return true;
        return false;
    }

    public static int contaInizianoCon(String[][] matrice, char iniziale) {
        int count = 0;
        for (String[] riga : matrice)
            for (String parola : riga)
                if (parola.charAt(0) == iniziale)
                    count++;
        return count;
    }

    public static int contaContengonoLettera(String[][] matrice, char lettera) {
        int count = 0;
        for (String[] riga : matrice)
            for (String parola : riga)
                if (parola.indexOf(lettera) != -1)
                    count++;
        return count;
    }

    public static int contaPalindrome(String[][] matrice) {
        int count = 0;
        for (String[] riga : matrice)
            for (String parola : riga)
                if (isPalindroma(parola))
                    count++;
        return count;
    }

    public static boolean isPalindroma(String parola) {
        int i = 0, j = parola.length() - 1;
        while (i < j) {
            if (parola.charAt(i) != parola.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static String trovaPiuLunga(String[][] matrice) {
        String max = "";
        for (String[] riga : matrice)
            for (String parola : riga)
                if (parola.length() > max.length())
                    max = parola;
        return max;
    }

    public static String trovaPiuCorta(String[][] matrice) {
        String min = matrice[0][0];
        for (String[] riga : matrice)
            for (String parola : riga)
                if (parola.length() < min.length())
                    min = parola;
        return min;
    }

    public static int contaVocali(String[][] matrice) {
        int count = 0;
        String vocali = "aeiouAEIOU";
        for (String[] riga : matrice)
            for (String parola : riga)
                for (char c : parola.toCharArray())
                    if (vocali.indexOf(c) != -1)
                        count++;
        return count;
    }

    public static String[][] sostituisciLettera(String[][] matrice, char da, char a) {
        String[][] nuova = new String[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                nuova[i][j] = matrice[i][j].replace(da, a);
            }
        }
        return nuova;
    }
}


