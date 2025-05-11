package investwise.zakat;

public class ZakatCalculator {
    private static final double ZAKAT_RATE = 0.025;

    public double calculateZakat(double netAssets) {
        return netAssets * ZAKAT_RATE;
    }
}