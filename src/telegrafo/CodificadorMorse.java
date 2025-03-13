package telegrafo;

import java.util.HashMap;
import java.util.Map;

public class CodificadorMorse {
    private static final String[] english = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?", "!", ":", "@", "=", "-", "+", "\"", "/", "&",
            "'", "(", ")", " "
    };

    private static final String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--..", "-.-.--", "---...", ".--.-.",
            "-...-", "-....-", ".-.-.", ".-..-.", "-..-.", ".-...", ".----.",
            "-.--.", "-.--.-", " "
    };

    private static final Map<String, String> EN_TO_MORSE = new HashMap<>();
    private static final Map<String, String> MORSE_TO_EN = new HashMap<>();

    public CodificadorMorse() {
        for (int i = 0; i < english.length; i++) {
            EN_TO_MORSE.put(english[i], morse[i]);
            MORSE_TO_EN.put(morse[i], english[i]);
        }
    }

    private static final String divisorCaracteres = "/";

    public String codificar(String mensaje) {
        String mensajeCodificado = "";

        for (char caracter : mensaje.toLowerCase().toCharArray()) {
            String equivalente = EN_TO_MORSE.get(String.valueOf(caracter));
            mensajeCodificado += equivalente;
            mensajeCodificado += divisorCaracteres;
        }
        System.out.println("LOG: mensaje codificado: " + mensajeCodificado);
        return mensajeCodificado;
    }

    public String decodificar(String mensajeCodificado) {
        String mensajeDecodificado = "";

        String[] caracteres = mensajeCodificado.split(divisorCaracteres);
        for (String caracter : caracteres) {
            String equivalente = MORSE_TO_EN.get(caracter);
            mensajeDecodificado += equivalente;
        }

        System.out.println("LOG: mensaje decodificado: " + mensajeDecodificado);
        return mensajeDecodificado;
    }
}
