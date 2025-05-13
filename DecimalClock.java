import acm.graphics.GCanvas;

public class DecimalClock {

    /* Construeix un rellotge que usa tres nombres decimals per a indicar hores, minuts i segons i el col·loca en la caixa indicada per dcBox.
     */

    //atributs
    private Box[] caixes;
    private DecimalNumber[] numbers;


    public DecimalClock (Box dcBox) {
        int valor = 3;

        caixes = dcBox.distributeHorizontally(valor);

        numbers = new DecimalNumber[valor];
        for (int i = 0; i < valor; i++){
            numbers[i] = new DecimalNumber(2, caixes[i]);
        }
    }

    /* Afegeix els tres números al canvas indicat per gCanvas.
     */
    public void addToGCanvas (GCanvas gCanvas) {
        for (int i = 0; i < numbers.length; i++){
            numbers[i].addToGCanvas(gCanvas);
        }
    }

    /* Mostra l'hora indicada.
     */
    public void render (int hours, int minutes, int seconds) {
        numbers[0].render(hours);
        numbers[1].render(minutes);
        numbers[2].render(seconds);
    }

}
