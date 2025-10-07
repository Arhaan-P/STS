import java.util.Scanner;

public
class EulerPhiAlgorithm
{

    // Function to calculate Euler's Totient function φ(n)
public
    static int phi(int n)
    {
        int result = n;

        // Check for all prime factors up to √n
        for (int p = 2; p * p <= n; p++)
        {
            if (n % p == 0)
            {
                // Remove all occurrences of p from n
                while (n % p == 0)
                {
                    n /= p;
                }
                // Apply Euler's formula
                result -= result / p;
            }
        }

        // If n has a prime factor greater than √n
        if (n > 1)
        {
            result -= result / n;
        }

        return result;
    }

    // Main method
public
    static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int phiValue = phi(n);
        System.out.println("φ(" + n + ") = " + phiValue);

        sc.close();
    }
}
