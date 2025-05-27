package reciclabackend.util.mysql;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataToString {
    public static void main(String[] args) {
     
    formatData("2025-09-02");
    }
       static String formatData(String dataSqlString){

        LocalDate data = LocalDate.parse(dataSqlString);

        // Formate para o padrão do MySQL
        DateTimeFormatter formaToSting = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataMySQL = data.format(formaToSting);

       System.out.println(dataMySQL);
        return dataMySQL;
    }   

}
