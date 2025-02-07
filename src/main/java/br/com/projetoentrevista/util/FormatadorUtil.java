package br.com.projetoentrevista.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatadorUtil {
    private static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatarData(LocalDate data) {
        return data.format(formatoData);
    }

    public static String formatarSalario(BigDecimal salario) {
        return String.format("%,.2f", salario).replace(',', 'X').replace('.', ',').replace('X', '.');
    }
}