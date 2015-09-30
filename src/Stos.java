
/** Stos zaimplementowany na tablicy. Przechowuje zmienne typu double oraz klasy String.
 * Stos klasy String reprezentuje tablica ONP[], natomiast stos typu double tablica Values[].
 * @param peek zmienna typu int, przechowuje index do elementu znajduj¹cego siê na szczycie stosu 
 * @author Mateusz Bryzik
 */
public class Stos 
{
	//deklaracja zmiennych indeksowych tablic ONP oraz Values
	private int peek = -1;
	
		//tablice przechowywuj¹ce elementy stosu dla zmiennych typu String oraz double
		String[] ONP = new String[200];
		double[] Values = new double[200];
	
	/**Funkcja odpowiadaj¹ca za dodanie elementu do stosu z wartoœciami String
	 * @param s zmienna klasy String, dodawana na szczyt stosu
	 */
	public void pushS(String s)
	{
		//sprawdzamy czy stos nie jest przepe³niony
		if(peek < 200) 
		{
			peek++;
			ONP[peek] = s;
		}
		else
		{
			System.out.println("Stos przepe³niony");
		}
	}
	
	/**Funkcja zdejmuj¹ca ze stosu z wartoœciami String 1 element
	 * @return Zwraca element klasy String znajduj¹cy siê na szczycie stosu i usuwa go ze stosu
	 */
	public String popS()
	{
				return ONP[peek--];
	}
	
	/**Funkcja umo¿liwiaj¹ca sprawdzenie jaki element jest aktualnie na szczycie stosu
	 * @return Zwraca element znajduj¹cy siê na szczycie stosu bez usuwania go
	 */
	public String peek()
	{
		return ONP[peek];
	}
	
	/**Funkcja sprawdzaj¹ca czy stos jest pusty
	 * @return zwraca wartoœæ true albo false
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
	
	/**Funkcja dodaj¹ca do stosu element typu double
	 * @param d typ double, liczba dodawana do stosu
	 */
	public void pushD(double d)
	{
		//sprawdzenie czy stos nie jest przepe³niony
		if(peek < 200) 
		{
				peek++;
				Values[peek] = d;
		}
		else
		{
				System.out.println("Stos przepe³niony");
		}
	}
	
	/**Funkcja zwracaj¹ca wartoœæ elementu znajduj¹cego siê na szczycie stosu
	 * @return zwraca element znajduj¹cy siê na szczycie stosu
	 */
	public double popD()
	{
			return Values[peek--];
	}
}
