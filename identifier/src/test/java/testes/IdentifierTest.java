package testes;

import fontes.Identifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IdentifierTest {

    private Identifier s;

    @BeforeEach
    public void setUp() {
        s = new Identifier();
    }

    @Test
    public void invalidaSenhaNull() throws NullPointerException {
        assertThrows(NullPointerException.class, () ->
                s.validateIdentifier(null));
    }

    @Test
    public void invalidaSenhaMenor1() throws StringIndexOutOfBoundsException {
        assertThrows(StringIndexOutOfBoundsException.class, () ->
                s.validateIdentifier(""));
    }

    @Test
    public void invalidaSenhaMaior6() {
        assertFalse(s.validateIdentifier("S1234567"));
    }

    @Test
    public void validaSenhaIgual1() {
        assertTrue(s.validateIdentifier("S"));
    }

    //Teste falhou. Apesar do documento "senha.txt" explicitar que 1 <= T <= 6, na linha 23 do código temos que a somente senha menores que 6 passam.
    @Test
    public void validaSenhaIgual6() {
        assertTrue(s.validateIdentifier("s23456"));
    }

    @Test
    public void validaSenhaEntre1e6() {

        assertTrue(s.validateIdentifier("s23456"));
    }

    @Test
    public void validaSenhaComecadaComLetra() {
        assertTrue(s.validateIdentifier("s123"));
    }

    @Test
    public void invalidaSenhaComecadaComInteger() {
        assertFalse(s.validateIdentifier("123s"));
    }

    @Test
    public void invalidaSenhaComecadaComSimbolo() {
        assertFalse(s.validateIdentifier("*s123"));
    }

    @Test
    public void validaSenhaContendoLetraENumero() {
        assertTrue(s.validateIdentifier("s123"));
    }

    @Test
    public void invalidaSenhaContendoSimbolo() {
        assertFalse(s.validateIdentifier("S123*"));
    }

}
