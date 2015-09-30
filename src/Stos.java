
/** Stos zaimplementowany na tablicy. Przechowuje zmienne typu double oraz klasy String.
 * Stos klasy String reprezentuje tablica ONP[], natomiast stos typu double tablica Values[].
 * @param peek zmienna typu int, przechowuje index do elementu znajduj�cego si� na szczycie stosu 
 * @author Mateusz Bryzik
 */
public class Stos 
{
	//deklaracja zmiennych indeksowych tablic ONP oraz Values
	private int peek = -1;
	
		//tablice przechowywuj�ce elementy stosu dla zmiennych typu String oraz double
		String[] ONP = new String[200];
		double[] Values = new double[200];
	
	/**Funkcja odpowiadaj�ca za dodanie elementu do stosu z warto�ciami String
	 * @param s zmienna klasy String, dodawana na szczyt stosu
	 */
	public void pushS(String s)
	{
		//sprawdzamy czy stos nie jest przepe�niony
		if(peek < 200) 
		{
			peek++;
			ONP[peek] = s;
		}
		else
		{
			System.out.println("Stos przepe�niony");
		}
	}
	
	/**Funkcja zdejmuj�ca ze stosu z warto�ciami String 1 element
	 * @return Zwraca element klasy String znajduj�cy si� na szczycie stosu i usuwa go ze stosu
	 */
	public String popS()
	{
				return ONP[peek--];
	}
	
	/**Funkcja umo�liwiaj�ca sprawdzenie jaki element jest aktualnie na szczycie stosu
	 * @return Zwraca element znajduj�cy si� na szczycie stosu bez usuwania go
	 */
	public String peek()
	{
		return ONP[peek];
	}
	
	/**Funkcja sprawdzaj�ca czy stos jest pusty
	 * @return zwraca warto�� true albo false
	 */
	public boolean isEmpty()
	{
		if(peek == -1)
		{
				return true;
		}
		else
		{
				return false;
		}
	}
	
/*************************************************/	
	
	/**Funkcja dodaj�ca do stosu element typu double
	 * @param d typ double, liczba dodawana do stosu
	 */
	public void pushD(double d)
	{
		//sprawdzenie czy stos nie jest przepe�niony
		if(peek < 200) 
		{
				peek++;
				Values[peek] = d;
		}
		else
		{
				System.out.println("Stos przepe�niony");
		}
	}
	
	/**Funkcja zwracaj�ca warto�� elementu znajduj�cego si� na szczycie stosu
	 * @return zwraca element znajduj�cy si� na szczycie stosu
	 */
	public double popD()
	{
			return Values[peek--];
	}
}
