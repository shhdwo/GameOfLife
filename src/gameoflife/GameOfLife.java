package gameoflife;

public class GameOfLife implements GameOfLifeEngine {
	
	int[][] todayState;
	int[][] tommorowState;
	int stage = 0;
	
	//stworzenie planszy i stanu poczatkowego z tablicy dwuwymiarowej, gdzie kazdy element jest oznaczony jako 0-martwy lub 1-zywy
	public void initiateLife(int[][] divineTouch) {
		//todayState = divineTouch.clone();
		//tommorowState = divineTouch.clone();
		todayState = helpers.cloneMatrix(divineTouch);
		tommorowState = helpers.cloneMatrix(divineTouch);
	}
	
	
	//symulacja kolejnego kroku
	public void nextGeneration() {
		for (int i = 0; i < todayState.length; i++) {
			for (int j = 0; j < todayState[i].length; j++) {
				if (willLive(i,j)) tommorowState[i][j] = 1;
				else tommorowState[i][j] = 0;
			}
		}
		//todayState = tommorowState.clone();
		todayState = helpers.cloneMatrix(tommorowState);
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
		neighbors = isAlive(x,y) ? -1 : 0; //odejmujemy 1 z licznika sasiadow w przypadku gdy aktualna komorka jest zywa (poniewaz w petli jest liczona)
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				try {
					if (isAlive(x+i,y+j)) neighbors++;
				}
				catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		
		if (isAlive(x,y) && (neighbors >= 2 && neighbors <= 3)) {
			return true;
		}
		else if (!isAlive(x,y) && (neighbors == 3)) {
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

}
