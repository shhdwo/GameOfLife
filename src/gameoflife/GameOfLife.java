package gameoflife;

public class GameOfLife implements GameOfLifeEngine {
	
	private int[][] todayState;
	private int[][] tommorowState;
	private int stage = 0;
	
	//stworzenie planszy i stanu poczatkowego z tablicy dwuwymiarowej, gdzie kazdy element jest oznaczony jako 0-martwy lub 1-zywy
	public void initiateLife(int[][] divineTouch) {
		todayState = Helpers.cloneMatrix(divineTouch);
		tommorowState = Helpers.cloneMatrix(divineTouch);
	}
	
	//symulacja kolejnego kroku
	public void nextGeneration() {
		for (int i = 0; i < todayState.length; i++) {
			for (int j = 0; j < todayState[i].length; j++) {
				if (willLive(i,j)) tommorowState[i][j] = 1;
				else tommorowState[i][j] = 0;
			}
		}
		todayState = Helpers.cloneMatrix(tommorowState);
		stage++;
	}
	
	//sprawdzenie czy komorka zyje
	public boolean isAlive(int x, int y) {
		if (todayState[x][y] == 1) return true;
		else return false;
	}
	
	//sprawdzenie czy komorka ma zyc w nastepnej generacji
	public boolean willLive(int x, int y) {

		int neighbors = 0; //licznik zywych sasiadow
		neighbors = isAlive(x,y) ? -1 : 0; //odejmujemy 1 z licznika sasiadow w przypadku gdy aktualna 
										   //komorka jest zywa (poniewaz w petli jest ona tez liczona)
		
		for (int i = -1; i <= 1; i++) { //petla zliczajaca sasiadow
			for (int j = -1; j <= 1; j++) {
				int posX = x+i;
				int posY = y+j;
				if (posX >= 0 && posY >= 0 && posX < todayState.length && posY < todayState[x].length) {
					if (isAlive(posX, posY)) neighbors++;
				}
			}
		}
		
		if (isAlive(x,y) && (neighbors >= 2 && neighbors <= 3)) { //warunek przezycia dla zywej komorki
			return true;
		}
		else if (!isAlive(x,y) && (neighbors == 3)) { //warunek przezycia dla martwej komorki
			return true;
		}
		else return false;
	}
	
	//drukuje aktualny stan pola
	public void showState() {
		System.out.println("\nKrok: " + stage + "\n");
		for (int[] e : todayState) {
			for (int f : e) {
				System.out.printf("%3d", f);
			}
			System.out.println();
		}
	}
	
	public int[][] getTodayState() {
		return todayState;
	};

}
