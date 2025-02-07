package br.com.projetoentrevista;

import br.com.projetoentrevista.service.FuncionarioService;

public class Main {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        // 3.1 – Inserir todos os funcionários
        service.inserirFuncionarios();

        // 3.2 – Remover o funcionário “João”
        service.removerFuncionarioJoao();

        // 3.3 – Imprimir todos os funcionários com todas as informações
        System.out.println("\nLista de funcionários:");
        service.imprimirFuncionarios();

        // 3.4 – Aumentar salário em 10%
        service.aumentarSalarios();
        System.out.println("\nSalários após aumento de 10%:");
        service.imprimirFuncionarios();

        // 3.5 e 3.6 – Agrupar funcionários por função e imprimir
        System.out.println("\nFuncionários agrupados por função:");
        service.imprimirFuncionariosPorFuncao();

        // 3.8 – Imprimir funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("\nFuncionários que fazem aniversário em outubro e dezembro:");
        service.imprimirAniversariantesOutubroDezembro();

        // 3.9 – Imprimir o funcionário mais velho
        System.out.println("\nFuncionário mais velho:");
        service.imprimirFuncionarioMaisVelho();

        // 3.10 – Imprimir lista ordenada por nome
        System.out.println("\nFuncionários ordenados por nome:");
        service.imprimirFuncionariosOrdenadosNome();

        // 3.11 – Imprimir o total dos salários
        System.out.println("\nTotal dos salários:");
        service.imprimirTotalSalarios();

        // 3.12 – Imprimir quantos salários mínimos cada funcionário ganha
        System.out.println("\nSalários mínimos por funcionário:");
        service.imprimirSalariosMinimos();
    }}