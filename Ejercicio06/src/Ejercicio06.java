import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio06 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Bienvenido al ejercicio 6 - Grupo 3 \nIngrese un texto:");
		String texto = s.nextLine();
		mensaje(texto,s);
	}
	public static void mensaje (String texto,Scanner s) {
		System.out.println("Ud. ingreso el siguiente texto: "+texto+"\n\n");
		System.out.println("1) La cantidad de caracteres que posee el texto es:"+cantCaracteres(quitarEspaciosEnBlanco(texto)));
		System.out.println("2) La cantidad de operadores de puntuación es:"+cantOperadoresDePuntuacion(texto));
		int[] vocalesYConsonantes =  cantVocalesYConsonantes(texto);
		System.out.println("3) La cantidad de vocales es:"+ vocalesYConsonantes[0] + " y la cantidad de consonantes es: "+ vocalesYConsonantes[1]);
		System.out.println("4) La frecuencia de aparición de cada letra es:");
		mostrarLetrasContabilizadas(frecuenciaLetras(texto));
		String[] charsMayoresYMenores = letrasMasFrecuentesYMenosFrecuentes(frecuenciaLetras(texto));
		System.out.println("5)\n	Las dos letras con más frecuencias son: "+ charsMayoresYMenores[0] +" y "+ charsMayoresYMenores[1]);
		System.out.println("	Las dos letras con menos frecuencias son: "+ charsMayoresYMenores[2] +" y "+ charsMayoresYMenores[3]);
		System.out.println("6) El texto sin espacios en blanco es: "+ quitarEspaciosEnBlanco(texto));
		System.out.println("7) Acontinuacion se le solicitara un caracter y se imprimira un * en su reemplazo:");
		System.out.print("Ingrese un caracter: ");
		char caracter = s.next().charAt(0);
		s.close();
		buscarCaracterEnCadena(texto, caracter);
		System.out.println("8) Las palabras repetidas son:" ); buscarPalabrasRepetidas(texto);
		String[]palabraMasLargaYMasCorta=buscarPalabraMasLargaYMasCorta(texto);
		System.out.println("9)\n	La palabra mas corta es: "+palabraMasLargaYMasCorta[0]);
		System.out.println("	La palabra mas larga es: "+palabraMasLargaYMasCorta[1]);
	}
	
	//1
	public static int cantCaracteres(String texto){
		return texto.length();
	}
	//2
	public static int cantOperadoresDePuntuacion(String texto){
		return texto.split("[;.:!,?¿]").length - 1;
	}
	//3
	public static int[] cantVocalesYConsonantes(String texto) {
		int[] vocalesYConsonantes= new int[2];
		vocalesYConsonantes[0] = texto.split("[aeiouAEIOU]").length-1;
		vocalesYConsonantes[1] = texto.split("[bcdfghjklmnñpqrstvwxyzBCDFGHJKLMNÑPQRSTVWXYZ]").length;
		return vocalesYConsonantes;//retorna un array que contiene tanto el valor del cociente como el del decimal
	}
	//4
	public static boolean ASC = true;
	public static Map<String, Long> frecuenciaLetras(String texto) {
		HashMap<String, Long> ocurrencias = new HashMap<String, Long>();
		ocurrencias= contabiliza(quitarNoLetras(texto));
        return sortByComparator(ocurrencias, ASC);
	}
	public static HashMap<String, Long> contabiliza(String linea) {
		HashMap<String, Long> ocurrencias = new HashMap<String, Long>();
        for(int i=0;i<linea.length();i++) {
            if(null == ocurrencias.get(""+linea.charAt(i))) {
                ocurrencias.put(""+linea.charAt(i),1L);
            }else {
                Long valor = (Long) ocurrencias.get(""+linea.charAt(i));
                valor++;
                ocurrencias.put(""+linea.charAt(i),valor);
            }
        }
        return ocurrencias;
    }
	private static Map<String, Long> sortByComparator(Map<String, Long> unsortMap, final boolean order)
    {
        List<Entry<String, Long>> list = new LinkedList<Entry<String, Long>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Long>>()
        {
            public int compare(Entry<String, Long> o1,
                    Entry<String, Long> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Entry<String, Long> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	private static void mostrarLetrasContabilizadas(Map<String, Long> map)
    {
		map.forEach((key, value) -> 
        System.out.println("	Letra : " + key + " Frecuencia: " + value));
    }
	//5
	public static String quitarNoLetras(String texto) {
		return texto.replaceAll("[^dA-Za-z]", "");
	}
	public static String[] letrasMasFrecuentesYMenosFrecuentes(Map<String, Long> map) {
		String[] charMasFrecuentesYMenosFrecuentes = new String[4];
		List<String> listaDeClaves = new ArrayList<String>(map.keySet());
		List<Long> listaDeValores = new ArrayList<Long>(map.values());
		ArrayList<String> listaConcatenada = new ArrayList<String>(); // Make a new list
		for (int i = 0; i < listaDeClaves.size(); i++) { // Loop through every name/phone number combo
			listaConcatenada.add(listaDeClaves.get(i) + " " + listaDeValores.get(i)); // Concat the two, and add it
		}
		charMasFrecuentesYMenosFrecuentes[0] = listaConcatenada.get(1);//Primero
		charMasFrecuentesYMenosFrecuentes[1] = listaConcatenada.get(2);//Segundo
		charMasFrecuentesYMenosFrecuentes[2] = listaConcatenada.get(listaConcatenada.size()-2);//Penultimo
		charMasFrecuentesYMenosFrecuentes[3] = listaConcatenada.get(listaConcatenada.size()-1);//Ultimo				
		return charMasFrecuentesYMenosFrecuentes;
	}
	//6
	public static String quitarEspaciosEnBlanco(String texto) {
		String textoSinCaracter ="";
		for(int x=0; x<texto.length(); x++) {		
			if(texto.charAt(x)!= ' ') {
				textoSinCaracter += texto.charAt(x);
			}
		}
		return textoSinCaracter;
	}
	//7
	public static void buscarCaracterEnCadena(String texto, char caracter) {//LOS STRING SON INMUTABLES!!!
		char[] result = texto.toCharArray();
	    for(int i = 0; i < result.length; i++){
	        if(result [i] == caracter){
	            result[i] = '*';
	        }
	    }
		System.out.println(result);
	}
	//8
	public static void buscarPalabrasRepetidas(String texto) {
		List<String> lista = Arrays.asList(texto.split(" "));
		Set<String> palabrasUnicas = new HashSet<String>(lista);
		for (String palabra : palabrasUnicas) {
			if(Collections.frequency(lista, palabra)>1) {				
				System.out.println("	La palabra: "+palabra + " se repite: " + Collections.frequency(lista, palabra) +" veces");
			}
		}
	}
	//9
	public static String[] buscarPalabraMasLargaYMasCorta(String texto) {
		String[] palabraMasLargaYMasCorta = new String[2];
		List<String> words = Arrays.asList(texto.split(" "));
		palabraMasLargaYMasCorta[0] = words.stream().min(Comparator.comparing(word -> word.length())).get();
		palabraMasLargaYMasCorta[1] = words.stream().max(Comparator.comparing(word -> word.length())).get();
		return palabraMasLargaYMasCorta;
		
		//Sin usar la api Stream
		/*
		int longitud=0,posicion=0,mayor=0,posMayor=0;
		for(int i=0;i<texto.charAt(i) && (i+1)<texto.length();i++) {
			while(! Character.isLetter(texto.charAt(i))&& (i+1)<texto.length()) {
				i++;
			}
			posicion=i;
			i++;
			while(Character.isLetter(texto.charAt(i))&& (i+1)<texto.length()) {
				longitud++;
				i++;
			}
			if(longitud>mayor) {
				mayor=longitud;
				posMayor=posicion;
			}
		}
		String palabra="";
		for(int i=0; i<mayor; i++) {
			palabra = palabra.concat(String.valueOf(texto.charAt(posMayor+1)));
		}
		String [] palabras = texto.split(" ");
		int masLargoPos, masCortoPos;
		masLargoPos=(palabras[0]).length();
		masCortoPos = 0;
		for (int i = 1; i < palabras.length;i++) {
			if((palabras[i]).length() < masLargoPos) {
				masLargoPos=(palabras[i]).length();
				masCortoPos=i;
			}
		}
		*/
	}
}
