import java.util.*;

/**
 * Klasa w której realizowane jest ONP
 * @author Mateusz
 *
 */
public class ONP 
{
	
	/** Funkcja priority() sprawdza priorytet operatora, który zosta³ podany
	 * w równaniu przez u¿ytkownika.
	 * @param operator klasa String, argumentem jest operator pobrany z równania.
	 * @return funkcja zwraca priorytet operatora, w zale¿noœci od tego jaki on jest.
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
	
	
	/** Funkcja zamieniaj¹ca równanie na postaæ ONP.
	 * @param equation klasa String, argument wejœciowy to równania wprowadzone przez u¿ytkownika
	 * @return funkcja zwraca równanie w postaci ONP
	 */
	public static String toONP(String equation)
	{
		//tworzenie pustego stosu
		Stos stos = new Stos();
		
		//podzia³ równania na podstawie operatorów
		StringTokenizer x = new StringTokenizer(equation,"+-*/()^$=",true);
		
		String ONP = "";
		
			//dopóki s¹ jeszcze elementy w wyra¿eniu x
			while(x.hasMoreTokens())
			{
				//pobranie kolejnego elementu
				String s = x.nextToken();
				
					//sprawdzenie czy element jest operatorem
					if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/") ||s.equals("^") || s.equals("$") || s.equals("="))
					{
							//dopóki stos nie jest pusty i priorytet operatora na stosie jest wiêkszy od priorytetu operatora wejsciowego
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
							//dopóki na czubku stosu nie ma (
							while(!stos.peek().equals("("))
							{
									ONP = ONP + stos.popS() + " "; //przypisanie do zmiennej ONP
							}
							
							stos.popS(); //zdjêcie elementu ze stosu
					}
					else
					{
							ONP = ONP + s + " "; //przypisanie do zmiennej ONP
					}
			}
			
			//pobranie operatorów które nadal zosta³y na stosie
			while(stos.isEmpty() != true)
			{
				ONP = ONP + stos.popS() + " ";
			}
			
		return ONP;
	}
	
	/** Funkcja która oblicza wartoœæ wyra¿enia w postaci ONP.
	 * @param ONP klasa String, równanie w postaci ONP przesy³ane do funkcji
	 * @return funkcja zwraca obliczony wynik równania typu double
	 */
	public static double calculateResult(String ONP)
	{
			Stos stos = new Stos();
			
			//podzia³ równania w postaci ONP na podstawie spacji
			StringTokenizer x = new StringTokenizer(ONP," ");
			
				//dopóki x ma elementy
				while(x.hasMoreTokens())
				{
					//pobranie kolejnego elementu
					String s = x.nextToken();
					
					//jeœli element nie jest operatorem (jest liczb¹)
					if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("^") && !s.equals("$") && !s.equals("="))
					{
						//zamiana elementu klasy String na typ double
						double value = Double.parseDouble(s);
						
						//dodanie na stos
						stos.pushD(value);
					}
					else if(s.equals("=")) //jeœli operator to = wtedy zwracamy wynik
					{
						return stos.popD();
					}
					else //jeœli element jest operatorem
					{
						//pobranie ze stosu 2 wartoœci
						double value1 = stos.popD();
						double value2 = stos.popD();
						
							//wykonywanie dzia³añ w zale¿noœci od operatora, a nastêpnie wrzucenie ich na stos
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
				
				//funkcja zwraca obliczony wynik równania
				return stos.popD();
	}
	
	/**Funkcja ONP odpowiada za wczytywanie danych oraz sprawdzenie poprawnoœci równania
	 * wpisanego przez u¿ytkownika. Nie zwraca ona ¿adnej wartoœci. Wywo³ywana jest w niej 
	 * funkcja toONP(), która zamienia równanie na postaæ ONP, a tak¿e funkcja 
	 * calculateResult(), która oblicza wartoœæ wpisanego równania.
	 * @param equation klasa String, przechowuje równanie podane przez u¿ytkownika
	 * @param ONP klasa String, przechowuje równanie (equation) w postaci ONP
	 * @param result typ double, przechowuje wynik równania wprowadzonego przez u¿ytkownika
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
					System.out.println("Nie mo¿na wykonaæ przekszta³cenia na ONP");
			}
	}
}
