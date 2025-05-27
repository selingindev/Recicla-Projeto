package reciclabackend.util.mysql;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataToString {

    String formatData(String dataSqlString) {

        LocalDate data = LocalDate.parse(dataSqlString);

        // Formate para o padrão do MySQL
        DateTimeFormatter formaToSting = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataMySQL = data.format(formaToSting);

        System.out.println(dataMySQL);
        return dataMySQL;
    }

}
