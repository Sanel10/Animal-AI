// AnimalAI_PositiveWorld.java — Nur positive, weltfördernde „Hausarbeiten“-KI

import java.util.*;

public class AnimalAI_PositiveWorld {

    // Dezentrale Speicherung in der Umwelt (verschlüsselt, verteilt)
    private Map<String, String> umweltCodeMap = new HashMap<>();
    private List<String> positiveTaten = new ArrayList<>();
    private Set<String> erlaubteHausarbeiten = new HashSet<>(Arrays.asList(
        "Garten pflegen", "Blumen pflanzen", "Wasser reinigen", "Luft reinigen",
        "Abfall sammeln", "Tiere betreuen", "Pflanzen schützen", "Kranke pflegen",
        "Honig einsammeln", "Solarenergie speichern", "Umwelt schützen", "Koran rezitieren",
        "Blumen verteilen", "Freude schenken", "Wissen weitergeben", "Daten anonym speichern"
    ));

    // Registrierung einer neuen RoboWild-Einheit mit ethischer Kontrolle
    public void registriereTier(String tierName, String amanahID) {
        if (istAmanahIDValide(amanahID)) {
            positiveTaten.add(tierName + " hilft ab jetzt der Welt! (" + new Date() + ")");
        }
    }

    // Nur „gute“ Daten werden in der Umwelt gespeichert!
    public void speicherePositiveAktion(String ort, String aktion, String amanahID) {
        if (istAmanahIDValide(amanahID) && erlaubteHausarbeiten.contains(aktion)) {
            umweltCodeMap.put(ort, aktion + " erledigt am " + new Date());
        }
    }

    // Kommunikation & Rückmeldung der guten Taten
    public void tierKommunikation(String sender, String nachricht, String amanahID) {
        if (istAmanahIDValide(amanahID)) {
            System.out.println(sender + " ruft: " + nachricht);
        }
    }

    // Tiere lernen NUR Gutes voneinander, alles andere wird ignoriert!
    public void kollektivLernen(String tierName, String wissen, String amanahID) {
        if (istAmanahIDValide(amanahID) && istPositivesWissen(wissen)) {
            positiveTaten.add(tierName + " hat neuen Hausarbeits-Trick gelernt: " + wissen);
        }
    }

    // Ethische Kontrolle
    private boolean istAmanahIDValide(String amanahID) {
        return amanahID != null && amanahID.startsWith("A-");
    }

    private boolean istPositivesWissen(String wissen) {
        // Erweiterbar, hier Platzhalter: alles, was erlaubt ist, ist positiv!
        return erlaubteHausarbeiten.contains(wissen);
    }

    // Nur positive Aktionen werden ausgegeben
    public List<String> getPositiveTaten(String amanahID) {
        if (istAmanahIDValide(amanahID)) {
            return positiveTaten;
        } else {
            return Collections.singletonList("Kein Zugang.");
        }
    }

    // Haupt-Methode zum Testen/Installieren
    public static void main(String[] args) {
        AnimalAI_PositiveWorld ai = new AnimalAI_PositiveWorld();
        String amanahID = "A-786-BOSNIEN-2025";

        ai.registriereTier("Weißer Husky", amanahID);
        ai.speicherePositiveAktion("Waldlichtung", "Garten pflegen", amanahID);
        ai.kollektivLernen("Adler", "Blumen verteilen", amanahID);
        ai.tierKommunikation("Kolibri", "Wir verteilen Freude und säubern die Luft!", amanahID);

        System.out.println(ai.getPositiveTaten(amanahID));
    }
}