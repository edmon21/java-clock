import acm.graphics.GCanvas;

public class Group {

    /*
    Construeix un grup en la caixa indicada per groupBox,
    formada per tantes barres com elements tingui la taula sizes.
    La taula sizes conté el nombre de leds que tenen cadascuna de les barres.
    Les barres estan disposades, una damunt de l'altra, verticalment.
    L'ordre dels sizes es correspon a les mides de les barres de dalt cap avall.
    */

    //atributs
    private Box[] leds;             //caixes on s'afegiran els leds
    private Bar[] ledObjects;       //objectes Led que es dibuixen a les caixes

    public Group (int[] sizes, Box groupBox) {

        //dividim la caixa gran en tantes subcaixes verticals com elements tingui el vector sizes
        leds = groupBox.distributeVertically(sizes.length);

        //creem una barra (Bar) per a cada subcaixa del grup
        ledObjects = new Bar[sizes.length];
        for(int i = 0; i < sizes.length; i++){
            ledObjects[i] = new Bar(sizes[i], leds[i]);
        }
    }

    /* Afegeix totes les barres que formen el grup al canvas gCanvas.
     */
    public void addToGCanvas (GCanvas gCanvas) {

        //afegim cada objecte Led al canvas
        for(int i = 0; i < ledObjects.length; i++){
            ledObjects[i].addToGCanvas(gCanvas);
        }
    }

    /*
    Mostra, en cadascuna de les barres del grup, el valor corresponent de la taula values.
    L'ordre dels elements a la taula values és de baix cap amunt.
    D'aquesta manera, si voleu mostrar el valor d'un número a partir de les seves xifres, la xifra corresponent a les unitats estarà en la posició 0 del vector values.
    */

    public void render (int[] values) {

        //mostra en cadascuna de les barres del grup el valor corresponent de la taula values
        for (int i = 0; i < ledObjects.length; i++) {
            ledObjects[i].render(values[values.length - 1 - i]);
        }
    }

}
