package br.com.projetoentrevista.service;

import br.com.projetoentrevista.model.Funcionario;
import br.com.projetoentrevista.util.FormatadorUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class FuncionarioService {
    private List<Funcionario> funcionarios;

    public FuncionarioService() {
        this.funcionarios = new ArrayList<>();
    }

    // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
    public void inserirFuncionarios() {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    // 3.2 – Remover o funcionário “João” da lista.
    public void removerFuncionarioJoao() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals("João")) {
                funcionarios.remove(i);
                break;
            }
        }
    }

    // Imprimir todos os funcionários com todas suas informações
    public void imprimirFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + FormatadorUtil.formatarData(f.getDataNascimento()) +
                    " - R$ " + FormatadorUtil.formatarSalario(f.getSalario()) + " - " + f.getFuncao());
        }
    }

    // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
    public void aumentarSalarios() {
        for (Funcionario f : funcionarios) {
            f.aumentarSalario(new BigDecimal("0.10"));
        }
    }

    // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
    public Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapa = new HashMap<>();

        for (Funcionario f : funcionarios) {
            if (!mapa.containsKey(f.getFuncao())) {
                mapa.put(f.getFuncao(), new ArrayList<>());
            }
            mapa.get(f.getFuncao()).add(f);
        }

        return mapa;
    }

    // 3.6 – Imprimir os funcionários, agrupados por função.
    public void imprimirFuncionariosPorFuncao() {
        Map<String, List<Funcionario>> mapa = agruparPorFuncao();

        for (String funcao : mapa.keySet()) {
            System.out.println(funcao + ":");

            List<Funcionario> lista = mapa.get(funcao);
            for (Funcionario f : lista) {
                System.out.println("  " + f.getNome());
            }
        }
    }

    // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    public void imprimirAniversariantesOutubroDezembro() {
        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                System.out.println(f.getNome() + " faz aniversário no mês " + mes);
            }
        }
    }

    // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
    public void imprimirFuncionarioMaisVelho() {
        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }

        int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
        System.out.println("Funcionário mais velho: " + maisVelho.getNome() + " - " + idade + " anos");
    }

    // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
    public void imprimirFuncionariosOrdenadosNome() {
        List<Funcionario> listaOrdenada = new ArrayList<>(funcionarios);

        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            for (int j = i + 1; j < listaOrdenada.size(); j++) {
                if (listaOrdenada.get(i).getNome().compareTo(listaOrdenada.get(j).getNome()) > 0) {
                    Funcionario temp = listaOrdenada.get(i);
                    listaOrdenada.set(i, listaOrdenada.get(j));
                    listaOrdenada.set(j, temp);
                }
            }
        }

        for (Funcionario f : listaOrdenada) {
            System.out.println(f.getNome());
        }
    }

    // 3.11 – Imprimir o total dos salários dos funcionários.
    public void imprimirTotalSalarios() {
        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario f : funcionarios) {
            total = total.add(f.getSalario());
        }

        System.out.println("Total dos salários: R$ " + FormatadorUtil.formatarSalario(total));
    }

    // 3.12 –Imprimir quantos salários mínimos ganha cada funcionário.
    public void imprimirSalariosMinimos() {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario f : funcionarios) {
            BigDecimal salarioFuncionario = f.getSalario();
            int contador = 0;

            while (salarioFuncionario.compareTo(salarioMinimo) >= 0) {
                salarioFuncionario = salarioFuncionario.subtract(salarioMinimo);
                contador++;
            }

            System.out.println(f.getNome() + " recebe aproximadamente " + contador + " salários mínimos.");
        }
    }
}