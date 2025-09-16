package reciclabackend.util.mysql;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToData {

    String format(String dataString) {

        // Defina o formato da string de entrada
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converta a string para LocalDate
        LocalDate data = LocalDate.parse(dataString, formatoEntrada);

        // Formate para o padrão do MySQL
        DateTimeFormatter formatoMySQL = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dataMySQL = data.format(formatoMySQL);

        return dataMySQL;
    }

}
