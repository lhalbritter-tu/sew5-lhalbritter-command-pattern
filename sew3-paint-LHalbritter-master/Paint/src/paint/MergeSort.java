/**
 * Max hats gemacht
 */
package paint;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Eine Klasse zum Sortieren von Listen über MergeSort
 * 
 * @author Leo Halbritter
 * @version 2017-12-19
 */
public class MergeSort<E extends Comparable<E>>{

	private List<E> l;
	
	/**
	 * Konstruktor zum List-Setzen
	 * 
	 * @param l die Liste zum Setzen
	 */
	public MergeSort( List<E> l ){
		this.l = (List<E>) l;
	}
	
	/**
	 * Methode, um die erste(linke) Hälfte einer Liste zu bekommen
	 * 
	 * @param a die Liste, von der die erste Hälfte zurückgegeben wird
	 * @return die erste Hälfte der Liste
	 */
	public List<E> getFirst( List<E> a ){
		int mid = a.size()/2;
		List<E> r = new ArrayList<E>();
		for( int i = 0; i < mid; i++ ){
			r.add(a.get(i));
			//System.out.println(r.toString());
		}
		return r;
	}
	
	/**
	 * Methode, um die zweite(rechte) Hälfte einer Liste zu bekommen
	 * 
	 * @param a die Liste, von der die zweite Hälfte zurückgegeben wird
	 * @return die zweite Hälfte der Liste
	 */
	public List<E> getSecond(List<E> a){
		int mid = a.size()/2;
		List<E> r = new ArrayList<E>();
		for( int i = mid; i < a.size(); i++ ){
			r.add(a.get(i));
			//System.out.println(r.toString());
		}
		return r;
	}
	
	/**
	 * Methode, die über Rekursion mit der Methode merging, die übergebene Liste sortiert
	 * 
	 * @param k die zu sortierende Liste
	 * @return die sortierte Liste
	 */
	public List<E> sort( List<E> k){
		List<E> left, right;
		if( k.size() < 2 ){
			return (List<E>) k;
		}
			left = (List<E>) this.getFirst( (List<E>) k );
			right = (List<E>) this.getSecond((List<E>) k);
			//System.out.println(left.toString());
			//System.out.println(right.toString());
			left = sort(left);
			right = sort(right);
			return (List<E>) this.merging((List<E>) k, left, right);
	}
	
	/**
	 * Fügt die Listen "left" und "right" in die Liste "a" ein und gibt "a" zurück
	 * 
	 * @param a Die Liste in die "left" und "right" eingefügt werden soll
	 * @param left Die erste Liste die in "a" eingefügt werden soll
	 * @param right Die zweite Liste die in "a" eingefügt werden soll
	 * @return Die zusammengefügte Liste
	 */
	public List<E> merging( List<E> a, List<E> left, List<E> right ){
		int n = 0;
		if( a.size() < 2 ) return a;
		int mid = n/2;
		int n1 = left.size();
		int n2 = right.size();
		int i = 0;
		int j = 0;
		List<E> r = new ArrayList<E>();
		while( i < n1 && j < n2 ){
			if( left.get(i).compareTo(right.get(j)) <= 0){
				try{
					a.set( n, left.get(i));
				}catch(IndexOutOfBoundsException e){
					System.out.println( "Fehler0" );
				}
				i++;
			}else{
				try{
					a.set( n, right.get(j));
				}catch(IndexOutOfBoundsException e){
					System.out.println( "Fehler1" );
				}
				j++;
			}
			n++;
		}
		//Konsolenausgaben zum Testen
		/**System.out.println( a.toString()+", "+left.toString()+", "+right.toString() );
		System.out.println( left.size()+", "+ i+", "+n1 );
		System.out.println( n );*/
		while(i < n1){
			if( n == a.size() ){
				a.add(left.get(i));
				break;
			}
			try{
				a.set(n, left.get(i));
			}catch(IndexOutOfBoundsException e){
				System.out.println( "Fehler2" );
			}
			i++;
			n++;
		}
		while(j < n2){
			try{
				a.set(n, right.get(j));
			}catch(IndexOutOfBoundsException e){
				System.out.println( "Fehler3" );
			}
			j++;
			n++;
		}
		//a.addAll(r);
		//System.out.println(a.toString());
		return a;
	}
	
	/**
	 * Methode zum Starten des Algorithmus
	 * 
	 * @return die sortierte Liste
	 */
	public List<E> start(){
		List<E> l=sort( this.l);
		return l;
	}
}
