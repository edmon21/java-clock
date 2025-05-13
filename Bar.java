import acm.graphics.GCanvas;

public class Bar {

    /* Construeix una barra en la caixa indicada per barBox, formada per size leds de la mateixa mida col·locats horitzontalment.
     */

    //atributs
    private Box[] leds;             //caixes on s'afegiran els leds
    private Led[] ledObjects;       //objectes Led que es dibuixen a les caixes

    public Bar (int size, Box barBox) {

        //dividim la caixa gran en tantes subcaixes horitzonatals com indica size
        leds = barBox.distributeHorizontally(size);

        //creem un led per a cada caixa
        ledObjects = new Led[size];
        for(int i = 0; i < size; i++){
            ledObjects[i] = new Led(leds[i]);
        }
    }

    /* Afegeix tots els leds que formen la barra al canvas gCanvas.
     */
    public void addToGCanvas (GCanvas gCanvas) {

        //afegim cada objecte Led al canvas grafic
        for(int i = 0; i < ledObjects.length; i++){
            ledObjects[i].addToGCanvas(gCanvas);
        }
    }

    /* Il·lumina el led indicat per value en la barra​, comptant des de 0 de dreta a esquerra.
     */
    public void render (int value) {

        //em d'iluiminar el led corresponent a value, comptant des de dreta a esquerra
        for(int i = 0; i < ledObjects.length; i++){

            //per encednre els leds de dreta a esquerra es necessari aquest caclul
            if(i == ledObjects.length - 1 - value){
                //engegar el led corresponent
                ledObjects[i].on();
            } else {
                //apagar la resta de leds
                ledObjects[i].off();
            }
        }
    }

}