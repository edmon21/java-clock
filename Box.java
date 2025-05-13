public class Box {

    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public Box (double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Box withPadding (Padding padding) {
        double top    = height * padding.getTop();
        double right  = width  * padding.getRight();
        double bottom = height * padding.getBottom();
        double left   = width  * padding.getLeft();
        return new Box (x + left, y + top,
                width  - left - right, height - top  - bottom);
    }

    public Box[][] distributeBidimensionally (int numRows, int numCols) {
		/*
			partitionedRows no és "exactament" una matriu sinó una taula de
			referències a taules (fixeu-vos en què no he indicat el nombre de
			columnes en declarar la "matriu").
			El nombre de columnes de cada fila de la matriu serà el nombre
			d'elements del vector que sigui referenciat per la fila.
			En aquest cas totes les files tenen el mateix nombre de columnes.
		*/
        Box[][] partitionedRows = new Box[numRows][];
        Box[] rows = distributeVertically (numRows);
        for (int i = 0; i < rows.length; i++) {
            partitionedRows[i] = rows[i].distributeHorizontally (numCols);
        }
        return partitionedRows;
    }

    /*
    Distribueix de manera uniforme l'espai indicat en la caixa (Box)
    de l'objecte receptor en tantes caixes com indiqui numColumns.
    Les caixes resultants estan col·locades horitzontalment de manera contigua.
    Es retorna el vector de referències a aquestes noves caixes.
    */
    public Box[] distributeHorizontally (int numColumns) {
        Box [] caixes = new Box[numColumns];

        //creem els valors comuns per totes les caixes
        double newWidth = this.width / numColumns;
        double newHeight = this.height;
        double newY = this.y;

        for(int i = 0; i < numColumns; i++){

            //caclulem el marge entre cada caixa (nou valor de X)
            double newX = this.x + i * newWidth;

            //creem cada caixa amb les seves noves propietats
            caixes[i] = new Box(newX, newY, newWidth, newHeight);
        }

        return caixes;
    }

    /*
    Distribueix de manera uniforme l'espai indicat en la caixa (Box)
    de l'objecte receptor en tantes caixes com indiqui numRows.
    Les caixes resultants estan col·locades verticalment de manera contigua.
    Es retorna el vector de referències a aquestes noves caixes.
    */
    public Box[] distributeVertically (int numRows) {
        Box [] caixes = new Box[numRows];

        //creem els valors comuns per totes les caixes
        double newWidth = this.width;
        double newX = this.x;
        double newHeight = this.height / numRows;

        for(int i = 0; i < numRows; i++){

            //calculem el marge entre les caixes (nou valor de Y)
            double newY = this.y + i * newHeight;

            //creem cada caixa amb les seves noves propietats
            caixes[i] = new Box(newX, newY, newWidth, newHeight);
        }

        return caixes;
    }

    /*
    Divideix la caixa corresponent a l'objecte receptor en dos, una damunt de l'altra.
    La de damunt es queda amb una altura corresponent al ràtio i la resta serà l'altura de la que queda a sota.
    E.g.: si el ràtio és 0.25, la caixa superior tindrà una quarta part de l'altura total i la inferior tres quartes parts.
    La taula que retorna com a resultat consta de dues referències:
    la de la caixa superior seguida de la de la caixa inferior.
    */
    public Box[] splitTopBottom (double ratio) {
        Box [] caixes = new Box[2];

        double heightTop = this.height * ratio;
        double heightBottom = this.height * (1 - ratio);

        caixes[0] = new Box(this.x, this.y, this.width, heightTop);
        caixes[1] = new Box(this.x, this.y + heightTop, this.width, heightBottom);

        return caixes;
    }

}
