package src;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static final int MAX = 1000; // Limite para fatoriais calculados
    public static BigInteger[] fatoriais = new BigInteger[MAX];

    public void precalcularFatoriais() {
        fatoriais[0] = BigInteger.ONE;
        for (int i = 1; i < MAX; i++) {
            fatoriais[i] = calcularFatorial(i);
        }
    }

    public void salvarFatoriaisEmArquivo(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (int i = 0; i < MAX; i++) {
                writer.write(i + "! = " + fatoriais[i] + "\n");
            }
            System.out.println("Fatoriais salvos em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar fatoriais: " + e.getMessage());
        }
    }
    
    // Função para calcular fatorial
    public BigInteger calcularFatorial(int n) {
        if (fatoriais[n] != null) {
            return fatoriais[n];
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            if (fatoriais[i] == null) {
                fatoriais[i] = fatoriais[i - 1].multiply(BigInteger.valueOf(i));
            }
            result = fatoriais[i];
        }
        return result;
    }
}
