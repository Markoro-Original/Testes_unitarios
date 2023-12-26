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
    public void validaTrianguloAMenorQueBMaisC() throws TrianguloException {
        assertTrue(t.validaTriangulo(8, 5, 5));
    }

    @Test
    public void validaTrianguloBMenorQueAMaisC() throws TrianguloException {
        assertTrue(t.validaTriangulo(8, 5, 5));
    }

    @Test
    public void validaTrianguloAMaiorQueBMaisC() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(20, 5, 6));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }

    @Test
    public void validaTrianguloBMaiorQueAMaisC() throws TrianguloException {

        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(5, 20, 6));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());

    }

    @Test
    public void validaTrianguloCMaiorQueAMaisB() throws TrianguloException {
        Exception exception = assertThrows(TrianguloException.class, () ->
                t.validaTriangulo(5, 5, 20));
        assertEquals("Os valores informados não formam um triangulo!", exception.getMessage());
    }



    @Test
    public void validaTrianguloCMenorQueAMaisB() throws TrianguloException {
        assertTrue(t.validaTriangulo(8, 5, 5));
    }

    @Test
    public void tipoEquilatero() {
        assertEquals(" O triangulo é equilatero ", t.obtemTipoTriangulo(5, 5, 5));
    }

    @Test
    public void naoTipoEquilatero() {
        assertNotEquals(" O triangulo é equilatero ", t.obtemTipoTriangulo(5, 5, 4));
        assertNotEquals(" O triangulo é equilatero ", t.obtemTipoTriangulo(5, 4, 5));
        assertNotEquals(" O triangulo é equilatero ", t.obtemTipoTriangulo(4, 5, 5));
        assertNotEquals(" O triangulo é equilatero ", t.obtemTipoTriangulo(4, 2, 5));
    }

    @Test
    public void tipoIsosceles() {
        assertEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(5, 5, 10));
        assertEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(5, 10, 5));
        assertEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(10, 5, 5));
    }

    @Test
    public void naoTipoIsosceles() {
        assertNotEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(5, 5, 5));
        assertNotEquals(" O triangulo é isoceles ", t.obtemTipoTriangulo(3, 5, 4));
    }

    @Test
    public void tipoEscaleno() {
        assertEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(5, 8, 4));
    }

    @Test
    public void naoTipoEscaleno() {
        assertNotEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(5, 5, 5));
        assertNotEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(5, 5, 4));
        assertNotEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(5, 4, 5));
        assertNotEquals(" O triangulo é escaleno ", t.obtemTipoTriangulo(4, 5, 5));
    }

}
