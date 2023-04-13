/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
*/

import java.util.Random;

public class EstimatePI {
    public static void main(String[] args) {
        int n = 1000000; // número de puntos a generar
        int count = 0; // número de puntos dentro del círculo
        double r = 1.0; // radio del círculo
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            double x = rand.nextDouble() * 2 * r - r; // generar una coordenada x aleatoria
            double y = rand.nextDouble() * 2 * r - r; // generar una coordenada y aleatoria

            if (x * x + y * y <= r * r) {
                count++;
            }
        }

        double pi = 4.0 * count / n; // estimar pi
        System.out.printf("Valor estimado de pi: %.3f", pi);
    }
}
