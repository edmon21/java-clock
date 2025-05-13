import acm.graphics.GCanvas;

public class LedsClock {

    /* Construeix un rellotge que usa tres grups de barres de leds per a indicar hores, minuts i segons i el col·loca en la caixa indicada per lcBox.
     */

    //atributs
    private Group hours;
    private Group minutes;
    private Group seconds;
    private Box[] caixes;

    public LedsClock (Box lcBox) {
        int valor = 3;

        caixes = lcBox.distributeVertically(valor);

        hours = new Group(new int[] {3, 10}, caixes[0]);
        minutes = new Group(new int[] {6, 10}, caixes[1]);
        seconds = new Group(new int[] {6, 10}, caixes[2]);
    }

    /* Afegeix els grups de barres de leds al canvas gCanvas.
     */
    public void addToGCanvas (GCanvas gCanvas) {
        hours.addToGCanvas(gCanvas);
        minutes.addToGCanvas(gCanvas);
        seconds.addToGCanvas(gCanvas);
    }

    /* Mostra l'hora indicada.
     */
    public void render(int hours, int minutes, int seconds) {
        this.hours.render(new int[] {hours % 10, hours / 10});
        this.minutes.render(new int[] {minutes % 10, minutes / 10});
        this.seconds.render(new int[] {seconds % 10, seconds / 10});
    }

}