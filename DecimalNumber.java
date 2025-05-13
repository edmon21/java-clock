import acm.graphics.GCanvas;

public class DecimalNumber {

    /* Construeix un número decimal format per numDigits dígits.
    El número ocuparà l'espai indicat per dnBox. Els dígits estan disposats, un al costat de l'altre, de forma horitzontal.
    */

    //atributs
    private Box[] caixes;               //caixes que contindran els digits
    private DecimalDigit[] digits;      //digits que es es mantindran dins les caixes

    public DecimalNumber (int numDigits, Box dnBox) {

        //distribuim les caixes horitzontalment
        caixes = dnBox.distributeHorizontally(numDigits);

        //afegim cada digit a cada caixa
        digits = new DecimalDigit[numDigits];
        for (int i = 0; i < numDigits; i++){
            digits[i] = new DecimalDigit(caixes[i]);
        }
    }

    /* Afegeix els dígits al canvas indicat per gCanvas.
     */
    public void addToGCanvas (GCanvas gCanvas) {

        //afegim cada digit grafic al canvas
        for(int i = 0; i < digits.length; i++){
            digits[i].addToGCanvas(gCanvas);
        }
    }

    /* Mostra el número indicat per number usant els diferents dígits de què consta el número.
     */
    public void render (int number) {
        for (int i = digits.length - 1; i >= 0; i--){

            if(number > 0){
                digits[i].render(number % 10);
                number = number / 10;
            } else {
                digits[i].render(0);
            }
        }
    }

}