import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio05 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Bienvenido al ejercicio 5 - Grupo 3 \nIngrese el primer valor:");
		int numero1 = s.nextInt();
		System.out.print("Ingrese el segundo valor: ");
		int numero2 = s.nextInt();
		mensaje(numero1, numero2);
		s.close();
	}

	public static void mensaje (int numero1, int numero2) {
		System.out.println("Ingreso "+numero1+ " y "+ numero2);
		System.out.println("1) La suma entre ambos es:"+suma(numero1, numero2));
		System.out.println("2) La resta entre ambos es:"+resta(numero1, numero2));
		Integer[] cocrest = cocienteYResto(numero1,numero2);
		System.out.println("3) Division\n	a) El decimal de la division entre ambos es:"+decimal(numero1, numero2));
		System.out.println("	b) El cociente de la division entre ambos es: "+ cocrest[0]+" y el resto es: "+ cocrest[1]);
		System.out.println("4) La mulplicacion entre ambos es:"+multiplicacion(numero1, numero2));
		System.out.println("5) Tabla de multiplicar\n	a) La tabla de multiplicar del primer valor es: "+ Arrays.toString(tablaDeMultiplicar(numero1)));
		System.out.println("	b) La tabla de multiplicar del segundo valor es: "+ Arrays.toString(tablaDeMultiplicar(numero2)));
		System.out.println("6) Factorial\n	a) El factorial del primer valor es: "+ factorial(numero1));
		System.out.println("	a) El factorial del segundo valor es: "+ factorial(numero2));
		System.out.println("7) Potencia\n	a) La potencia del primer valor con respecto al segundo es: "+ potencia(numero1,numero2));
		System.out.println("	b) La potencia del segundo valor con respecto al primer es: "+ potencia(numero2,numero1));
		System.out.println("8) Serie Fibonacci\n	a) La serie Fibonacci del primer valor es: "+ (fibonacciRecursivo(numero1)));
		System.out.println("	b) La serie Fibonacci del segundo valor es: "+ (fibonacciRecursivo(numero2)));
	}
	//1
	public static int suma(int n1, int n2) {
		return n1+n2;
	}
	//2
	public static int resta(int n1, int n2) {
		return n1-n2;
	}
	//3 a)
	public static double decimal(int dividendo, int divisor) { 
		return (double)dividendo/divisor; //retorna el decimal
	}
	//3 b)
	public static Integer[] cocienteYResto(int dividendo, int divisor) {
		Integer[] cteydec = new Integer[2];
		cteydec[0]= dividendo/divisor; //cociente
		cteydec[1]=  dividendo%divisor; //resto
		return cteydec;//retorna un array que contiene tanto el valor del cociente como el del decimal
	}
	//4
	public static int multiplicacion(int n1, int n2) {
		return n1 * n2;
	}
	//5
	public static Integer[] tablaDeMultiplicar(int n) {
		Integer[] tabla = new Integer[10];
		int pos;
		for(pos = 1;pos<=10; pos++) {
			tabla[pos-1]= n*pos;
		}
		return tabla;
	}
	//6
	public static int factorial(int n) {
		return (n==0)? 1: n * factorial(n-1);
	}
	//7
	public static int potencia(int n1, int n2) {
		return (int) Math.pow(n1, n2);
	}
	//8
	public static int fibonacciRecursivo(int n) {
		if(n==0) {	
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
		}
	}
}