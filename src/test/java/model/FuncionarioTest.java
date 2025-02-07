package model;

import br.com.projetoentrevista.model.Funcionario;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void testAumentoSalarial() {
        Funcionario funcionario = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2000.00"), "Operador");
        funcionario.aumentarSalario(new BigDecimal("0.10"));

        assertEquals(new BigDecimal("2200.00").stripTrailingZeros(), funcionario.getSalario().stripTrailingZeros());
    }


    @Test
    void testGetNome() {
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.of(1995, 5, 10), new BigDecimal("2500.00"), "Gerente");
        assertEquals("Carlos", funcionario.getNome());
    }
}