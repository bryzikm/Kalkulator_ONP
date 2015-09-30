import java.util.*;

/**
 * Klasa w kt�rej realizowane jest ONP
 * @author Mateusz
 *
 */
public class ONP 
{
	
	/** Funkcja priority() sprawdza priorytet operatora, kt�ry zosta� podany
	 * w r�wnaniu przez u�ytkownika.
	 * @param operator klasa String, argumentem jest operator pobrany z r�wnania.
	 * @return funkcja zwraca priorytet operatora, w zale�no�ci od tego jaki on jest.
	 */	
	public static int priority(String operator)
	{
		//sprawdzenie priorytetu operatora
		if(operator.equals("="))
		{
				return 1;
		}
	    else if(operator.equals("+") || operator.equals("-"))
		{
				return 2;
		}
		else if(operator.equals("*") || operator.equals("/"))
		{
				return 3;
		}
		else if(operator.equals("^") || operator.equals("$"))
		{
				return 4;
		}
		else
		{
				return 0;
		}
	}
	
	
	/** Funkcja zamieniaj�ca r�wnanie na posta� ONP.
	 * @param equation klasa String, argument wej�ciowy to r�wnania wprowadzone przez u�ytkownika
	 * @return funkcja zwraca r�wnanie w postaci ONP
	 */
	public static String toONP(String equation)
	{
		//tworzenie pustego stosu
		Stos stos = new Stos();
		
		//podzia� r�wnania na podstawie operator�w
		StringTokenizer x = new StringTokenizer(equation,"+-*/()^$=",true);
		
		String ONP = "";
		
			//dop�ki s� jeszcze elementy w wyra�eniu x
			while(x.hasMoreTokens())
			{
				//pobranie kolejnego elementu
				String s = x.nextToken();
				
					//sprawdzenie czy element jest operatorem
					if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/") ||s.equals("^") || s.equals("$") || s.equals("="))
					{
							//dop�ki stos nie jest pusty i priorytet operatora na stosie jest wi�kszy od priorytetu operatora wejsciowego
							while((stos.isEmpty() != true) && (priority(stos.peek()) >= priority(s)))
							{
									ONP = ONP + stos.popS() + " "; //przypisanie do zmiennej ONP
							}
							
								stos.pushS(s); //dodanie elementu na stos
					}
					else if(s.equals("("))
					{
							stos.pushS(s); //dodanie elementu na stos
					}
					else if(s.equals(")"))
					{
							//dop�ki na czubku stosu nie ma (
							while(!stos.peek().equals("("))
							{
									ONP = ONP + stos.popS() + " "; //przypisanie do zmiennej ONP
							}
							
							stos.popS(); //zdj�cie elementu ze stosu
					}
					else
					{
							ONP = ONP + s + " "; //przypisanie do zmiennej ONP
					}
			}
			
			//pobranie operator�w kt�re nadal zosta�y na stosie
			while(stos.isEmpty() != true)
			{
				ONP = ONP + stos.popS() + " ";
			}
			
		return ONP;
	}
	
	/** Funkcja kt�ra oblicza warto�� wyra�enia w postaci ONP.
	 * @param ONP klasa String, r�wnanie w postaci ONP przesy�ane do funkcji
	 * @return funkcja zwraca obliczony wynik r�wnania typu double
	 */
	public static double calculateResult(String ONP)
	{
			Stos stos = new Stos();
			
			//podzia� r�wnania w postaci ONP na podstawie spacji
			StringTokenizer x = new StringTokenizer(ONP," ");
			
				//dop�ki x ma elementy
				while(x.hasMoreTokens())
				{
					//pobranie kolejnego elementu
					String s = x.nextToken();
					
					//je�li element nie jest operatorem (jest liczb�)
					if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("^") && !s.equals("$") && !s.equals("="))
					{
						//zamiana elementu klasy String na typ double
						double value = Double.parseDouble(s);
						
						//dodanie na stos
						stos.pushD(value);
					}
					else if(s.equals("=")) //je�li operator to = wtedy zwracamy wynik
					{
						return stos.popD();
					}
					else //je�li element jest operatorem
					{
						//pobranie ze stosu 2 warto�ci
						double value1 = stos.popD();
						double value2 = stos.popD();
						
							//wykonywanie dzia�a� w zale�no�ci od operatora, a nast�pnie wrzucenie ich na stos
							switch(s.charAt(0))
							{
								case '+':
								{
									stos.pushD(value2 + value1);
									break;
								}
								case '-':
								{
									stos.pushD(value2 - value1);
									break;
								}
								case '*':
								{
									stos.pushD(value2 * value1);
									break;
								}
								case '/':
								{
									stos.pushD(value2 / value1);
									break;
								}
								case '^':
								{
									stos.pushD(Math.pow(value2, value1));
									break;
								}
								case '=':
								{
									break;
								}
							}
					}
				}
				
				//funkcja zwraca obliczony wynik r�wnania
				return stos.popD();
	}
	
	/**Funkcja ONP odpowiada za wczytywanie danych oraz sprawdzenie poprawno�ci r�wnania
	 * wpisanego przez u�ytkownika. Nie zwraca ona �adnej warto�ci. Wywo�ywana jest w niej 
	 * funkcja toONP(), kt�ra zamienia r�wnanie na posta� ONP, a tak�e funkcja 
	 * calculateResult(), kt�ra oblicza warto�� wpisanego r�wnania.
	 * @param equation klasa String, przechowuje r�wnanie podane przez u�ytkownika
	 * @param ONP klasa String, przechowuje r�wnanie (equation) w postaci ONP
	 * @param result typ double, przechowuje wynik r�wnania wprowadzonego przez u�ytkownika
	 */
	public void equationONP(String equation)
	{
		
		String ONP = "";

			if(equation.endsWith("="))
			{
					ONP = toONP(equation);
					double result = calculateResult(ONP);
					
					System.out.println(ONP);
					System.out.println(result);
			}
			else
			{
					System.out.println("Nie mo�na wykona� przekszta�cenia na ONP");
			}
	}
}
