import java.util.Scanner;
public class Ejercicio04 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Bienvenido al programa del ejercicio 4 | \nIngrese un valor entero:");
		int numero = s.nextInt();
		mensaje(numero);
		s.close();
	}

	public static void mensaje (int numero) {
		System.out.println("El numero "+ numero);
		System.out.println(esPrimo(numero, 2)? "1)Es un numero primo": "1)No es un numero primo");
		System.out.println(esPar(numero)? "2)Es un numero par": "2)Es un numero impar");
		System.out.println(esCapicua(numero)? "3)Es un numero capicua": "3)No es un numero capicua");
		System.out.println(esArmstrong(numero)? "4)Es un numero armstrong": "4)No es un numero armstrong");
	}
	
	public static boolean esPrimo(int n, int divisor) {
		if(n/2<divisor) {
			return true;
		}else {
			return (n%divisor==0)? false : esPrimo(n, divisor+1);
		}
	}
	
	public static boolean esPar(int n) {
		return (n/2==0);
	}
	
	public static boolean esCapicua(int n) {
		int aux = n;
		int nInverso = 0, cifra;
        while(aux!=0){
	        cifra = aux%10;
	        nInverso = (nInverso * 10) + cifra; 
	        aux = aux / 10;
        }
		return (n == nInverso);
	}
	
	public static boolean esArmstrong(int n) {
		int aux = n;
		int x = 0, a;
		while(n>0) {
			a=n%10;
			n= n/10;
			x=x+(a*a*a);
		}
		return (aux==x);
	}
	
}
