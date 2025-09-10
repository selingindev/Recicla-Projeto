package util;

import reciclabackend.util.api.CosmoApi;

public class TesteApiCosmo {
      public static void main(String[] args) {

        CosmoApi cosmo = new CosmoApi();

        cosmo.gtinData("78912359");
        System.out.println(cosmo.gtinData("78912359"));

    }

}
