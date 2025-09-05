package reciclabackend.util.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import reciclabackend.model.bean.CodigoBarras;
import reciclabackend.util.CodigoBarraApiBasico;

public class CosmoApi implements CodigoBarraApiBasico {

    public String gtinData(String gtin) {
        StringBuilder result = new StringBuilder();
        try {

            String urlStr = "https://api.cosmos.bluesoft.com.br/gtins/" + gtin + ".json";
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(10000);
            conn.setDoInput(true);

            conn.setRequestProperty("X-Cosmos-Token", "kqGmDBD1L5tiXQG38QZkdQ");

            // Conecta e obtém resposta
            conn.connect();

            // Lendo a resposta corretamente
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = reader.readLine();

            result.append(line);
            // Fecha o leitor
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Exibe o resultado
        return result.toString();
    }

}
