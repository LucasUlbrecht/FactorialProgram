

import org.junit.Test;

import src.Main;

import java.math.BigInteger;
import static org.junit.Assert.assertEquals;

public class Testes {

    @Test
    public void testarCalculoFatorial() {
        Main main = new Main();

        // Verifica se o fatorial de 0 é 1
        assertEquals(BigInteger.ONE, main.calcularFatorial(0));

        // Verifica se o fatorial de 1 é 1
        assertEquals(BigInteger.ONE, main.calcularFatorial(1));

        // Verifica se o fatorial de 2 é 2
        assertEquals(BigInteger.valueOf(2), main.calcularFatorial(2));

        // Verifica se o fatorial de 3 é 6
        assertEquals(BigInteger.valueOf(6), main.calcularFatorial(3));

        // Verifica se o fatorial de 4 é 24
        assertEquals(BigInteger.valueOf(24), main.calcularFatorial(4));

        // Adicione mais testes conforme necessário
        String numberString = "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000";
        assertEquals(new BigInteger(numberString), main.calcularFatorial(100));
    }
}
