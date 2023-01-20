//Auf gehts eine Runde BlackJack! Hier ist ein vollständiges Kartendeck.
val kartendeck: List<String> = listOf(
    "Pik Ass", "Pik Koenig", "Pik Dame", "Pik Bube", "Pik 10", "Pik 9",
    "Pik 8", "Pik 7", "Pik 6", "Pik 5", "Pik 4", "Pik 3", "Pik 2",
    "Kreuz Ass", "Kreuz Koenig", "Kreuz Dame", "Kreuz Bube", "Kreuz 10", "Kreuz 9",
    "Kreuz 8", "Kreuz 7", "Kreuz 6", "Kreuz 5", "Kreuz 4", "Kreuz 3", "Kreuz 2",      // Mein Deck
    "Herz Ass", "Herz Koenig", "Herz Dame", "Herz Bube", "Herz 10", "Herz 9",
    "Herz 8", "Herz 7", "Herz 6", "Herz 5", "Herz 4", "Herz 3", "Herz 2",
    "Karo Ass", "Karo Koenig", "Karo Dame", "Karo Bube", "Karo 10", "Karo 9",
    "Karo 8", "Karo 7", "Karo 6", "Karo 5", "Karo 4", "Karo 3", "Karo 2",
)

fun main() {

    /* Die Variable meinDeck ist euer Deck mit dem ihr arbeiten könnt.
    Mit der Funktion mischen() könnt ihr das Deck mischen.
    Mit der Funktion eineKarteZiehen() könnt ihr aus eurem Deck die oberste Karte ziehen.
    Beachtet, dass die Funktion die Karte auch aus eurem Deck entfernt.
    Mit der Funktion kartenWert() bekommst du den Wert einer Karte als Int zurück.
    Unter dem Kommentar siehst du wie du die Funktionen benutzen kannst.
     */
    var meinDeck = kartendeck.toMutableList()

    mischen(meinDeck)
    var karte = eineKarteZiehen(meinDeck)
    var beispielwert = kartenWert(karte)
    // println(beispielwert)
    println( test21(handziehen(meinDeck, true)))

}

fun mischen(deck: MutableList<String>) {
    deck.shuffle()
}

fun eineKarteZiehen(deck: MutableList<String>): String {
    var karte = deck.first()
    deck.remove(deck.first())
    return karte
}

fun kartenWert(karte: String): Int {
    var kartenWert = karte.split(" ")[1]

    return when (kartenWert) {
        "2" -> 2
        "3" -> 3
        "4" -> 4
        "5" -> 5
        "6" -> 6
        "7" -> 7
        "8" -> 8
        "9" -> 9
        in listOf("10", "Koenig", "Dame", "Bube") -> 10
        "Ass" -> 11
        else -> 0
    }

}

fun punktZahl(hand: MutableList<String>): Int {
    var ergebnis = 0
    for (karte in hand) {
        ergebnis += kartenWert(karte)

    }
    return ergebnis


}

fun handziehen(deck: MutableList<String>, istHandSpieler: Boolean): MutableList<String> {
    mischen(deck)
    var hand: MutableList<String> = mutableListOf(eineKarteZiehen(deck), eineKarteZiehen(deck))
    if (istHandSpieler) {
        println("deine Hand ist $hand")

    } else {
        if (kartenWert(hand[0]) > kartenWert(hand[1])) {
            println(hand[0])

        } else {
            println(hand[1])
        }
    }
    return hand
}

fun test21(hand: MutableList<String>):Boolean{
    return punktZahl(hand)>21

}