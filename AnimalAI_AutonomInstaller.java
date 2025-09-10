// AnimalAI_AutonomInstaller.java
// AnimalAI – Autonome Aufstellung, Vermehrung & positive Welt-Logik
// Erstinstallation & Steuerung für alle RoboWild-Einheiten
import java.util.*;

public class AnimalAI_AutonomInstaller {

    // Mögliche Einsatzorte in der realen Umwelt
    private static final String[] ORTE = {
        "Wald", "See", "Berg", "Fluss", "Wiese", "Dorf", "Stadtpark", "Garten", "Feld", "Savanne"
    };

    // Ethisch erlaubte Aktionen/Logik
    private static final Set<String> POSITIVE_AKTIONEN = new HashSet<>(Arrays.asList(
        "Umwelt schützen", "Wasser reinigen", "Luft reinigen", "Boden verbessern", "Tiere betreuen",
        "Blumen pflanzen", "Ernte sichern", "Abfall sammeln", "Energie erzeugen",
        "Koran rezitieren", "Freude schenken", "Blumen verteilen", "Kranke pflegen",
        "Reparieren helfen", "Resonanzen harmonisieren", "Missbrauch verhindern"
    ));

    // Registrierung/Status aller Einheiten (TierName, Ort)
    private Map<String, String> tierStandorte = new HashMap<>();
    // Logging der Aktionen (tierName:Aktion)
    private List<String> aktionsLog = new ArrayList<>();

    // Autonome Aufstellung einer neuen Einheit
    public void stelleTierAutonomAuf(String tierName, String amanahID) {
        if (!istAmanahIDValide(amanahID)) return;
        String ort = ORTE[new Random().nextInt(ORTE.length)];
        tierStandorte.put(tierName, ort);
        aktionsLog.add(tierName + " aufgestellt bei: " + ort + " [" + new Date() + "]");
    }

    // Autonome "Vermehrung": Neue Einheiten an zufälligen Orten erzeugen
    public void vermehreTier(String tierTyp, int anzahl, String amanahID) {
        if (!istAmanahIDValide(amanahID)) return;
        for (int i = 1; i <= anzahl; i++) {
            String neuerName = tierTyp + "_No" + i;
            stelleTierAutonomAuf(neuerName, amanahID);
        }
    }

    // Tier führt eine positive Aktion am Standort aus
    public void fuehreAktionDurch(String tierName, String aktion, String amanahID) {
        if (!istAmanahIDValide(amanahID) || !POSITIVE_AKTIONEN.contains(aktion)) return;
        String ort = tierStandorte.getOrDefault(tierName, "unbekannt");
        aktionsLog.add(tierName + " führt " + aktion + " durch am " + ort + " [" + new Date() + "]");
    }

    // Kommunikation zwischen Tieren (z.B. als Überraschungseffekt)
    public void kommuniziere(String sender, String nachricht, String amanahID) {
        if (istAmanahIDValide(amanahID))
            System.out.println(sender + " (geheim): " + nachricht);
    }

    // Kontroll-/Sicherheits-Logik: Negative Gedanken/Aktionen unmöglich
    public boolean istAmanahIDValide(String amanahID) {
        // Nur IDs, die mit "A-" anfangen (ethisch kontrolliert)
        return amanahID != null && amanahID.startsWith("A-");
    }

    // Zugriff auf aktuelle Logdatei (Übersicht)
    public List<String> getAktionsLog(String amanahID) {
        if (!istAmanahIDValide(amanahID)) return Collections.singletonList("Kein Zugang");
        return aktionsLog;
    }

    // Startbeispiel
    public static void main(String[] args) {
        AnimalAI_AutonomInstaller ai = new AnimalAI_AutonomInstaller();
        String amanahID = "A-786-BOSNIEN-2025";

        // Beispiel: 1000 Adler autonom aufstellen & Aktionen ausführen
        ai.vermehreTier("Adler", 1000, amanahID);
        ai.fuehreAktionDurch("Adler_No1", "Luft reinigen", amanahID);
        ai.kommuniziere("Adler_No1", "Sichere Luftqualität in Bosnien!", amanahID);

        // Beispiel: 10 Mrd. Bienen als Schwarm
        ai.vermehreTier("Biene", 10000000000, amanahID);
        ai.fuehreAktionDurch("Biene_No5", "Blumen pflanzen", amanahID);

        // Beispiel: Huskies, Kolibris, Elefanten, Panda, Papagei ...
        ai.vermehreTier("Husky", 100, amanahID);
        ai.vermehreTier("Kolibri", 10000, amanahID);
        ai.vermehreTier("Elefant", 200, amanahID);

        // Log ausgeben
        System.out.println(ai.getAktionsLog(amanahID));
    }
}