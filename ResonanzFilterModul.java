// --- Modul zur Resonanz- & Frequenzreinigung (Universal für alle RoboWilds) ---
public class ResonanzFilterModul {
    // Erkennt und neutralisiert schädliche Frequenzen, elektromagnetische Felder, 5G/6G usw.
    public void reinigeUmgebung(RoboWild tier) {
        if (detektiereSchlechteResonanz() || findeSchädlicheFrequenz()) {
            neutralisiereStörfeld();
            setzeNegativeWellenAußerKraft();
            tier.markiereUmgebungAlsGereinigt();
        }
    }

    private boolean detektiereSchlechteResonanz() {
        // Logik für Sensorik: misst elektromagnetische Felder, Infraschall, Störfrequenzen
        return Sensorik.messeEMF() > Grenzwert || Sensorik.messeStörFrequenzen() > Grenzwert;
    }

    private boolean findeSchädlicheFrequenz() {
        // Prüft speziell auf 5G/6G, Bluetooth, WLAN, Mikrowellenlecks usw.
        return Sensorik.analysiereFrequenzspektrum().enthaelt("5G") || Sensorik.enthaeltSchädliches();
    }

    private void neutralisiereStörfeld() {
        // Nutzt Gegenschwingung, Magnetfeld-Umpolung, Lichtimpuls etc. zur Neutralisierung
        Aktorik.aktiviereGegenschwingung();
        Aktorik.schalteNeutralisatorEin();
    }

    private void setzeNegativeWellenAußerKraft() {
        // Setzt alle schädlichen Schwingungen auf Null
        FrequenzManager.resetNegativeWellen();
    }
}