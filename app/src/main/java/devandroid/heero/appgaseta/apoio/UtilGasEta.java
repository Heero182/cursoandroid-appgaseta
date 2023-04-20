package devandroid.heero.appgaseta.apoio;

public class UtilGasEta {

    public static String calcularMelhorOpcao(double gasolina, double etanol) {


        return etanol / gasolina > 0.7 ? "Abastecer com Gasolina" : "Abastecer com Etanol";
    }
}
