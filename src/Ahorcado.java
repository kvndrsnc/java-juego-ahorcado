import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
       // clase scanner que nos permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);
       
       // declaraciones y asignaciones 
       String palabraSecreta = "inteligencia";
       int intentosMaximos = 10;
       int intentos = 0;
       boolean palabraAdivinada = false;

       // arreglos
       char[] letrasAdivinadas = new char[palabraSecreta.length()];

       // estructura de control: iterativa (bucle)
       for (int i = 0; i < letrasAdivinadas.length; i++) {
        letrasAdivinadas[i] = '_';
       }

       // estructura de control: iterativa (bucle)
       while (!palabraAdivinada && intentos < intentosMaximos) {
        /*
         * Esto se usa cuando tenemos una palabra de chars
         * String.valueOf(letrasAdivinadas)
         */
        System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
       
        // usamos la clase scanner para pedir una letra
        System.out.println("Introduce una letra: ");
        char letra = Character.toLowerCase(scanner.next().charAt(0));

        boolean letraCorrecta = false;

        // estructura de control: iterativa (bucle)
        for (int i = 0; i < palabraSecreta.length(); i++) {
            // estructura de control: condicional
            if (palabraSecreta.charAt(i) == letra) {
                letrasAdivinadas[i] = letra;
                letraCorrecta = true;
            }
        }

        if (!letraCorrecta) {
            intentos++;
            System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
        }

        if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
            palabraAdivinada = true;
            System.out.println("¡Felicidades, has adivinado la palabra secreta!");
        }
       }

       if (!palabraAdivinada) {
        System.out.println("¡Te quedaste sin intentos!");
       }

       scanner.close();
    }
}
