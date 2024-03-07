package pt.gladlyGivenApi.GladlyGiven.Models;

public class FiscalIdentity {
    public static boolean validarNIF(String nif) {
        // Verifica se o NIF tem 9 dígitos
        if (nif == null || !nif.matches("\\d{9}")) {
            return false;
        }

        // Calcula o dígito de controlo
        int[] digitos = new int[9];
        for (int i = 0; i < 9; i++) {
            digitos[i] = Integer.parseInt(nif.substring(i, i + 1));
        }

        int soma = 0;
        for (int i = 0; i < 8; i++) {
            soma += digitos[i] * (9 - i);
        }

        int resto = soma % 11;
        int digitoControlo = resto <= 1 ? 0 : 11 - resto;

        // Verifica se o dígito de controlo coincide com o último dígito do NIF
        return digitoControlo == digitos[8];
    }
}
