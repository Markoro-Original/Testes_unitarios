package br.com.gilmario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrianguloTest {

    Triangulo t;

    @BeforeEach
    public void setup() {
        t = new Triangulo();
    }

    @Test
    public void validaCMenorAB() throws TrianguloException {
        assertTrue(t.validaTriangulo(2, 2, 2));
    }

    @Test
    public void invalidaCMaiorAB() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(2,2,5));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void validaBMenorAC() throws TrianguloException {
        assertTrue(t.validaTriangulo(3, 4, 5));
    }

    @Test
    public void invalidaBMaiorAC() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(2,4,1));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void validaAMenorBC() throws TrianguloException {
        assertTrue(t.validaTriangulo(5, 5, 6));
    }

    @Test
    public void invalidaAMaiorBC() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(10,2,5));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void invalidaLado0() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(0, 1, 2));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void invalidaLadoNegativo() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(-1, 1, 2));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void invalidaAIqualBC() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(3, 1, 2));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void invalida3Lados0() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(0, 0, 0));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void obtemTipoEquilatero() {
        assertEquals(" O triangulo é equilatero ", t.obtemTipoTriangulo(2,2 , 2));
    }

    @Test
    public void obtemTipoIsosceles1() {
        assertEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(3, 3, 4));
    }

    @Test
    public void obtemTipoIsosceles2() {
        assertEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(3, 4, 3));
    }

    @Test
    public void obtemTipoIsosceles3() {
        assertEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(4, 3, 3));
    }

    @Test
    public void obtemTipoNaoIsosceles1() {
        assertNotEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(3, 3, 3));
    }

    @Test
    public void obtemTipoNaoIsosceles2() {
        assertNotEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(2, 3, 4));
    }

    @Test
    public void obtemTipoEscaleno1() {
        assertEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(3, 4, 5));
    }

    @Test
    public void obtemTipoEscaleno2() {
        assertEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(5, 3, 4));
    }

    @Test
    public void obtemTipoEscaleno3() {
        assertEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(4, 5, 3));
    }

    @Test
    public void obtemTipoNaoEscaleno1() {
        assertNotEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(3, 3, 3));
    }

    @Test
    public void obtemTipoNaoEscaleno2() {
        assertNotEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(3, 3, 4));
    }

    //Teste não chega a compilar devido ao tamanho do número C
    /*
    @Test
    public void invalidaMaxint() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(1431655765, 1431655765, 2147483648));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }
    */

    //Teste não chega a compilar devido ao parâmetro não integer
    /*
    @Test
    public void invalidaNaoInteger() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(a, 2, 3));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }
    */

    //Teste não chega a compilar devido a falta de parâmetros suficiente
    /*
    @Test
    public void invalida2Parametros() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(1, 2));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }
    */

    //Teste não chega a compilar devido ao excesso de parâmetros
    /*
    @Test
    public void invalida4Parametros() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(1, 2, 3, 4));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }
    */
}
