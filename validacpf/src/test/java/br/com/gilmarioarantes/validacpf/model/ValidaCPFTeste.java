package br.com.gilmarioarantes.validacpf.model;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidaCPFTeste {
    private ValidaCPF validador;

    @BeforeTest
    public void setUp() {
        validador = new ValidaCPF();
    }

    @Test
    public void testCPFValido() {
        assertTrue(validador.isCPF("12345678909"));
    }

    @Test
    public void testCPFInvalido() {
        assertFalse(validador.isCPF("12345678900"));
    }

    @Test
    public void testCPFComCaracteresNaoNumericos() {
        assertFalse(validador.isCPF("12345x7890z"));
    }

    @Test
    public void testCPFMuitoLongo() {
        assertFalse(validador.isCPF("1234567890123"));
    }

    @Test
    public void testCPFMuitoCurto() {
        assertFalse(validador.isCPF("12345"));
    }

    @Test
    public void testCPFComTodosDigitosIguais() {
        assertFalse(validador.isCPF("11111111111"));
    }

    @Test
    public void testCPFComMenosDeTresDigitos() {
        assertFalse(validador.isCPF("12"));
        assertFalse(validador.isCPF(""));
        assertFalse(validador.isCPF("9"));
    }

    @Test
    public void testCPFNulo() {
        assertFalse(validador.isCPF(null));
    }

}
