package service;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.projetoentrevista.model.Funcionario;
import br.com.projetoentrevista.service.FuncionarioService;

class FuncionarioServiceTest {
    private FuncionarioService service;

    @BeforeEach
    void setUp() {
        service = new FuncionarioService();
        service.inserirFuncionarios();
    }

    @Test
    void testRemoverFuncionarioJoao() {
        service.removerFuncionarioJoao();
        List<Funcionario> funcionarios = service.agruparPorFuncao().values().stream().flatMap(List::stream).toList();
        assertFalse(funcionarios.stream().anyMatch(f -> f.getNome().equals("João")));
    }

    @Test
    void testAgruparPorFuncao() {
        Map<String, List<Funcionario>> agrupados = service.agruparPorFuncao();

        assertTrue(agrupados.containsKey("Operador"));
        assertTrue(agrupados.containsKey("Gerente"));
        assertTrue(agrupados.containsKey("Diretor"));
        assertTrue(agrupados.containsKey("Coordenador"));
        assertTrue(agrupados.containsKey("Eletricista"));
        assertTrue(agrupados.containsKey("Recepcionista"));

        assertEquals(3, agrupados.get("Operador").size());
    }

}