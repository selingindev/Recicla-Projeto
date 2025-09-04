package reciclabackend.util.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepApi {

    public String getCep(String cep) {
        if (cep == null || cep.isEmpty()) {
            System.out.println("CEP inválido!");
            return null;
        }
        StringBuilder result = new StringBuilder();
        try {

            String urlStr = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(10000);
            conn.setDoInput(true);

            // Conecta e obtém resposta
            conn.connect();

            // Lendo a resposta corretamente
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            for (int i = 0; i < 8; i++) {

                line = reader.readLine();
                
                result.append("\n" + line);

            }

            // Fecha o leitor
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Exibe o resultado
        String retorno = result.toString();
        return retorno;
    }
}
