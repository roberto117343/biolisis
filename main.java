/*
 * «Copyright 2017 Roberto Reinosa»
 * 
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		
		InputStreamReader entradaCadena = new InputStreamReader(System.in);
		
		boolean centinela_Principal = true;
		
		String cadena;
		String cadena_Salida;
		int seleccion;
		String seleccion_Cadena;
		char cadena_Caracteres[];
		
		while(centinela_Principal){
			
			System.out.println("¿Que tipo de secuencia desea analizar?\n");
			System.out.println("1. ADN");
			System.out.println("2. ARN");
			System.out.println("3. Proteínas");
			
			BufferedReader selector = new BufferedReader(entradaCadena);
			
			try{
				
				seleccion_Cadena = selector.readLine();
				seleccion = Integer.parseInt(seleccion_Cadena);
				
				if(seleccion > 3 || seleccion <1){
					
					System.out.println("Fallo al realizar la selección");
					continue;
					
				}
				
				
			}catch(Exception e){
				
				System.out.println("Fallo al realizar la selección");
				continue;
				
			};
			
			System.out.println("Introduce la secuencia a alanizar:");
			
			BufferedReader buff = new BufferedReader(entradaCadena);
			try{
				
				cadena = buff.readLine();
				cadena_Caracteres = cadena.toCharArray();
				
				if(seleccion == 1){
					
					lector_Nucleotidos(1, cadena_Caracteres);
					
				}else if(seleccion == 2){
					
					lector_Nucleotidos(2, cadena_Caracteres);
					
				}else if(seleccion == 3){
					
					lector_Proteinas(cadena_Caracteres);
					
				}else{
					
					System.out.println("Fallo al leer el tipo de secuencia");
					
				}
		
			}catch(Exception e){
				
				System.out.println("Error al leer la cadena");
				continue;
				
			};
			
			System.out.println("¿Desea analizar otra secuencia? s/n");
			
			BufferedReader salida = new BufferedReader(entradaCadena);
			
			try{
				
				cadena_Salida = salida.readLine();
				
				if(cadena_Salida.equals("S") || cadena_Salida.equals("s")){
					
					continue;
					
				}else{
					
					centinela_Principal = false;
				}
				
			}catch(Exception e){System.out.println("Fallo al leer la sálida");};
			
			
		}
		
	}
	public static void lector_Nucleotidos(int diferenciador, char cadena[]){//Calcula el tamaño y proporción de secuencias de nucleótidos
		
		char nucleotido_Problema1;
		char nucleotido_Problema2;
		String Nucl_Problema;
		
		int contador_A = 0;
		int contador_C = 0;
		int contador_G = 0;
		int contador_Problema = 0;
		int contador_Anomalias = 0;
		
		
		if(diferenciador == 1){
			
			nucleotido_Problema1 = 'T';
			nucleotido_Problema2 = 't';
			Nucl_Problema = "TIMINA";
			
		}else{
			
			nucleotido_Problema1 = 'U';
			nucleotido_Problema2 = 'u';
			Nucl_Problema = "URACILO";
			
		}
		
		for(int i = 0; i<cadena.length; i++){
			
			if(cadena[i] == 'a' || cadena[i] == 'A'){
				
				contador_A++;
				
			}else if(cadena[i] == 'c' || cadena[i] == 'C'){
				
				contador_C++;
				
			}else if(cadena[i] == 'g' || cadena[i] == 'G'){
				
				contador_G++;
				
			}else if(cadena[i] == nucleotido_Problema1 || cadena[i] == nucleotido_Problema2){
				
				contador_Problema++;
				
			}else{
				
				contador_Anomalias++;
				
			}
			
		}
		
		System.out.println("RESULTADOS:\n");
		
		System.out.println("Tamaño de la secuencia: " + cadena.length + " pb\n");
		
		System.out.println("PROPORCIONES\n");
		
		System.out.println("Proporción de ADENINA: " + calculo_regla(contador_A, cadena.length) + " %");
		System.out.println("Proporción de CITOSINA: " + calculo_regla(contador_C, cadena.length) + " %");
		System.out.println("Proporción de GUANINA: " + calculo_regla(contador_G, cadena.length) + " %");
		System.out.println("Proporción de " + Nucl_Problema + ": "  + calculo_regla(contador_Problema, cadena.length) + " %");
		System.out.println("Proporción de DATOS ANÓMALOS: " + calculo_regla(contador_Anomalias, cadena.length) + " %\n");
		
		
	}
	public static void lector_Proteinas(char cadena[]){//Calcula la proporción y tamaño de las secuencias de aminoácidos
		
		int contador_A = 0, contador_R = 0, contador_N = 0, contador_D = 0, contador_C = 0, contador_Q = 0, contador_E = 0, contador_G = 0, contador_H = 0,
				contador_I = 0, contador_L = 0, contador_K = 0, contador_M = 0, contador_F = 0, contador_P = 0, contador_S = 0, contador_T = 0,
				contador_W = 0, contador_Y = 0, contador_V = 0, contador_Anomalos = 0;
		
		for(int i = 0; i<cadena.length; i++){
			
			switch(cadena[i]){
				
				case 'A':
				case 'a':
					
					contador_A++;
					break;
					
				case 'R':
				case 'r':
					
					contador_R++;
					break;
				
				case 'N':
				case 'n':
					
					contador_N++;
					break;
					
				case 'D':
				case 'd':
					
					contador_D++;
					break;
				
				case 'C':
				case 'c':
					
					contador_C++;
					break;
				
				case 'Q':
				case 'q':
					
					contador_Q++;
					break;
					
				case 'E':
				case 'e':
					
					contador_E++;
					break;
				
				case 'G':
				case 'g':
					
					contador_G++;
					break;
					
				case 'H':
				case 'h':
					
					contador_H++;
					break;
					
				case 'I':
				case 'i':
					
					contador_I++;
					break;
					
				case 'L':
				case 'l':
					
					contador_L++;
					break;
					
				case 'K':
				case 'k':
					
					contador_K++;
					break;
					
				case 'M':
				case 'm':
					
					contador_M++;
					break;
					
				case 'F':
				case 'f':
					
					contador_F++;
					break;
					
				case 'P':
				case 'p':
					
					contador_P++;
					break;
					
				case 'S':
				case 's':
					
					contador_S++;
					break;
					
				case 'T':
				case 't':
					
					contador_T++;
					break;
					
				case 'W':
				case 'w':
					
					contador_W++;
					break;
					
				case 'Y':
				case 'y':
					
					contador_Y++;
					break;
					
				case 'V':
				case 'v':
					
					contador_V++;
					break;
					
			
			default:
				
				contador_Anomalos++;
					
			}
			
		}
		System.out.println("RESULTADOS:\n");
		System.out.println("Tamaño de la secuencia: " + cadena.length + " aa\n");
		System.out.println("PROPORCIONES\n");
		System.out.println("A = " + calculo_regla(contador_A, cadena.length) + " % R = " + calculo_regla(contador_R, cadena.length) + " % N = " + calculo_regla(contador_N, cadena.length) + " % D = " + calculo_regla(contador_D, cadena.length) + " % C = "+ calculo_regla(contador_C, cadena.length ) + " %\n" +
		"Q = " + calculo_regla(contador_Q, cadena.length) + " % E = " + calculo_regla(contador_E, cadena.length) + " % G = " + calculo_regla(contador_G, cadena.length) + " % H = " + calculo_regla(contador_H, cadena.length) + " % I = " + calculo_regla(contador_I,cadena.length) + " %\n" + 
				"L = " + calculo_regla(contador_L, cadena.length) + " % K = " + calculo_regla(contador_K, cadena.length) + " % M = " + calculo_regla(contador_M, cadena.length) + " % F = " + calculo_regla(contador_F, cadena.length) + " % P = " + calculo_regla(contador_P, cadena.length) + " %\n" + 
		"S = " + calculo_regla(contador_S, cadena.length) + " % T = " + calculo_regla(contador_T, cadena.length) + " % W = " + calculo_regla(contador_W, cadena.length) + " % Y = " + calculo_regla(contador_Y, cadena.length) + " % V = " + calculo_regla(contador_V, cadena.length) + " %\n");
		System.out.println("DATOS ANÓMALOS: " + calculo_regla(contador_Anomalos, cadena.length) + " %\n");
		
	}
	public static double calculo_regla(int sec, int longitud){
		
		return (double)(sec * 100)/(double)longitud;
		
	}

}
