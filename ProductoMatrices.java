import java.io.*;
public class ProductoMatrices {

    public static void main(String[] args) throws IOException {
        // Leer los archivos binarios `a.mat` y `b.mat`
        DataInputStream aFile = new DataInputStream(new FileInputStream("a.mat"));
        DataInputStream bFile = new DataInputStream(new FileInputStream("b.mat"));

        // Leer los números de filas y columnas de las matrices
        int nRowsA = aFile.read();
        int nColsA = aFile.read();
        int nRowsB = bFile.read();
        int nColsB = bFile.read();

        // Crear matrices para almacenar los datos de los archivos
        double[][] a = new double[nRowsA][nColsA];
        double[][] b = new double[nRowsB][nColsB];

        // Leer los datos de las matrices de los archivos


        //Matriz A
        System.out.println("\n Matriz A");
        for (int i = 0; i < nRowsA; i++) {
            for (int j = 0; j < nColsA; j++) {
                a[i][j] = aFile.readDouble();


                System.out.print( a[i][j] + " ");
            }

            System.out.println("");

        }

        //Matriz B
        System.out.println("\nMatriz B");
        for (int i = 0; i < nRowsB; i++) {
            for (int j = 0; j < nColsB; j++) {
                b[i][j] = bFile.readDouble();


                System.out.print( b[i][j] + " ");
            }

            System.out.println();
        }


        // Cerrar los archivos de entrada
        aFile.close();
        bFile.close();

        // Calcular el producto de las matrices
        double[][] c = new double[nRowsA][nColsB];
        for (int i = 0; i < nRowsA; i++) {
            for (int j = 0; j < nColsB; j++) {
                for (int k = 0; k < nColsA; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // Escribir el producto de las matrices en el archivo binario `c.mat`
        DataOutputStream cFile = new DataOutputStream(new FileOutputStream("c.mat"));
        cFile.write(nRowsA);
        cFile.write(nColsB);
        for (int i = 0; i < nRowsA; i++) {
            for (int j = 0; j < nColsB; j++) {
                cFile.writeDouble(c[i][j]);
            }
        }

        // Cerrar el archivo de salida
        cFile.close();



        //Mostrar resultado del producto de matrices
        System.out.println(" \nProducto de las matrices:");
        for (int i = 0; i < nRowsA; i++) {
            for (int j = 0; j < nColsB; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

}
