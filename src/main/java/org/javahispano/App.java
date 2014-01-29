package org.javahispano;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String[] data = new String[]{
    			"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
    			"Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
    			"Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
    			"This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
    			"Another book with music related content"
    		};
    	
    	//Creacion del indice invertido
    	InvertedIndex indice= new InvertedIndex(data);
    	
    	//Consulta
    	String[] result = indice.get("music");
    	
    	//Resultado de la consulta
    	System.out.println(result.length);
    	System.out.println(Arrays.toString(result));
    }
}
