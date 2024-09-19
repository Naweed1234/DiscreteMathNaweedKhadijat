import java.util.Random;

/**
 * @author Xunhua Wang, Oluwasanmi Khadijat, Yarzada Naweed. All rights
 *         reserved.
 * @date 09/19/2024; revised on 09/27/2018; further refined on 09/20/2019,
 *       09/29/2020, 10/07/2022, 03/13/2023; 09/14/2024
 * 
 */

public class OluwasanmiKhadijatYarzadaNaweedRSA {
	public int gcd (int inE, int inZ) {
		while( inZ != 0) {
			int eachnum = inZ;
			inZ = inE % inZ; did it workl
			inE = eachnum;
		}
		return inE;
		// TO BE FINISHED
		// Must implement Euclid's algorithm
		// NO brute-forcing; violation will lead to zero points
		// NO recursion; violation will lead to zero points
	}

	public void testGcd() {
		int r = gcd(48, 180);
		int re = gcd(84, 132);
		int result1 = gcd(29, 288);
		int result2 = gcd(30, 288);
		int result3 = gcd(149, 288);
		int result4 = gcd(2, 4);

		System.out.println("GCD (48, 180) = 0x" + Integer.toString(r, 16));
		System.out.println("GCD (84, 132) = 0x" + Integer.toString(re, 16));
		System.out.println("GCD (29, 288) = 0x" + Integer.toString(result1, 16));
		System.out.println("GCD (30, 288) = 0x" + Integer.toString(result2, 16));
		System.out.println("GCD (149, 288) = 0x" + Integer.toString(result3, 16));
		System.out.println("GCD (2, 4) = 0x" + Integer.toString(result4, 16));
	}

	//
	// We assume that inE < inZ
	// This implementation follows our slides
	// Return:
	// -1: no inverse
	// inverse of inE mod inZ
	// TO BE FINISHED
	// Must implement the extended Euclidean algorithm
	// NO brute-forcing; violation will lead to zero points
	// NO recursion; violation will lead to zero points
	public int xgcd(int inE, int inZ) {
		int number1 = inE; // e
		int number2 = inZ;// z

		int t = 0;
		int t1 = 1;
		int s = 1;
		int s1 = 0;

		while (number2 != 0) {
			int divide = number1 / number2;
			int mod = number1 % number2;
			number1 = number2;
			number2 = mod;

			int temporary_ints = s - divide * s1;
			s = s1;
			s1 = temporary_ints;

			int temporary_intt = t - divide * t1;
			t = t1;
			t1 = temporary_intt;
		}
		if (number1 != 1) {
			return -1;
		}
		if (s < 0) {
			s += number2;
		}
		return s;
	}

	public void testXgcd() {
		int r = xgcd(120, 23);
		int result1 = xgcd(29, 288);
		int result2 = xgcd(30, 288);
		int result3 = xgcd(149, 288);
		int result4 = xgcd(2, 4);

		System.out.println("120^-1 mod 23 = 0x" + Integer.toString(result1, 16));
		System.out.println("29^-1 mod 288 = 0x" + Integer.toString(result1, 16));
		System.out.println("30^-1 mod 288 = 0x" + Integer.toString(result2, 16));
		System.out.println("149^-1 mod 288 = 0x" + Integer.toString(result3, 16));
		System.out.println("2^-1 mod 4 = 0x" + Integer.toString(result4, 16));
	}

	public int[] keygen(int inP, int inQ, int inE) {
		return null;
	}

	//
	// The following method will return an integer array, with [e, N, d] in this
	// order
	//
	public void testKeygen() {
		int[] keypair = keygen(17, 19, 29);

		System.out.println("e = 0x" + Integer.toString(keypair[0], 16));
		System.out.println("N = 0x" + Integer.toString(keypair[1], 16));
		System.out.println("d = 0x" + Integer.toString(keypair[2], 16));
	}

	//
	// Calculate c = a^b mod n, with the square-and-multiply algorithm
	//
	// The following method implements the square-and-multiply algorithm, with Java
	// primitive types
	//
	// Note that even with primitive types, a^b may well exceed the range of Java
	// int
	// For example, 5^20 is too big to be held by a Java primitive integer
	//
	public int modExp(int a, int b, int n) {
		return n;
		// TO BE FINISHED
	}

	public int encrypt(int message, int inE, int inN) {
		return inN;
		// TO BE FINISHED
	}

	public int decrypt(int ciphertext, int inD, int inN) {
		return inN;
		// TO BE FINISHED
	}

	public void testRSA() {
		int[] keypair = keygen(17, 19, 29);

		int m1 = 131;
		int c1 = encrypt(m1, keypair[0], keypair[1]);
		System.out
				.println("The encryption of (m1=0x" + Integer.toString(m1, 16) + ") is 0x" + Integer.toString(c1, 16));
		int cleartext1 = decrypt(c1, keypair[2], keypair[1]);
		System.out.println(
				"The decryption of (c=0x" + Integer.toString(c1, 16) + ") is 0x" + Integer.toString(cleartext1, 16));

		int m2 = 254;
		int c2 = encrypt(m2, keypair[0], keypair[1]);
		System.out
				.println("The encryption of (m2=0x" + Integer.toString(m2, 16) + ") is 0x" + Integer.toString(c2, 16));
		int cleartext2 = decrypt(c2, keypair[2], keypair[1]);
		System.out.println(
				"The decryption of (c2=0x" + Integer.toString(c2, 16) + ") is 0x" + Integer.toString(cleartext2, 16));
	}

	public static void main(String[] args) {
		OluwasanmiKhadijatYarzadaNaweedRSA okznrsa = new OluwasanmiKhadijatYarzadaNaweedRSA();

		System.out.println("********** Small RSA Project output begins ********** ");

		okznrsa.testGcd();
		okznrsa.testXgcd();
		okznrsa.testKeygen();
		okznrsa.testRSA();
	}
}