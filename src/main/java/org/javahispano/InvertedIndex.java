package org.javahispano;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;


public class InvertedIndex {

	private String[] data; //Lo uso para trabajar sin los signos de puntuación
	
	private Hashtable<String,HashSet<Integer>> indice; //Utilizamos una estructura de hash ya que a travez de una funcion de hash podemos
													   //recuperar rapidamente la palabra que estamos buscando lo que lo hace mas eficinete	
	
	public InvertedIndex(String[] data){
		/**Este metodo se encarga de construir el indice invertido a partir de un vector de entrada**/
		
		//Inicializacion de atributos
		this.data=data;
		indice=new Hashtable<String,HashSet<Integer>>();
		
		//Creacion del indice invertido en la estructura de hash
		for(int i=0; i<data.length; i++){
			
			
			//Obtengo todas las palabras separadas del string actual
			String palabras[]=data[i].split(" ");
			
			//Recorro todas las palabras
			for(int j=0; j<palabras.length; j++){
				
				//Elimino los caracteres adicionales de la palabra, ya que por ejemplo "music" <> "music,"
				//Paso toda la palabra a minusculas para que, por ejemplo, "Music" == "music"
				palabras[j]=palabras[j].replace(",","");
				palabras[j]=palabras[j].replace(".","");
				palabras[j]=palabras[j].replace("?","");
				palabras[j]=palabras[j].replace("¿","");
				palabras[j]=palabras[j].replace("!","");
				palabras[j]=palabras[j].replace("¡","");
				palabras[j]=palabras[j].replace("'","");
				palabras[j]=palabras[j].replace((char)34, (char)0);
				palabras[j]=palabras[j].toLowerCase();
				
				//Si la palabra ya existe, agrego el nuevo idex del vector data donde se encuentra la palabra
				if (indice.containsKey(palabras[j])){
					HashSet<Integer> actual=indice.get(palabras[j]);
					actual.add(i);
					indice.put(palabras[j], actual);
				} 
				
				//Si la palabra no existe, agrego la entrada al indice con el idex del vector data donde se encuentra la palabra 
				else {
					HashSet<Integer> referencias= new HashSet<Integer>();
					referencias.add(i);
					indice.put(palabras[j], referencias);
				}
			}
		}
	}
	
	public String[] get(String palabra){
		/**Este metodo obtiene los elementos del vetor data donde se encuentra la palabra**/
		
		//Obtencion del conjunto de ubicaciones de la palabra
		HashSet<Integer> referencias=indice.get(palabra);
		
		//Creacion del vector resultado, cuyo tamaño es igual a la cantidad de indices en el HashSet referencias
		String[] result=new String[referencias.size()];
		
		//Guardar en el resultado los datos originales
		Iterator<?> it=referencias.iterator();
		int contador=0;
		while(it.hasNext()){
			result[contador]=data[(Integer) it.next()];
			contador++;
		}
		
		return result;
	}
	
	
	public void mostrar(){
		/**Muestra la informacion del indice invertido**/
		
		Enumeration<String> e=indice.keys();
		while (e.hasMoreElements()){
			String actual=e.nextElement();
			System.out.print(actual+": ");
			
			HashSet<?> datos= indice.get(actual);
			Iterator<?> it=datos.iterator();
			while(it.hasNext()){
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}

	}
	
}
