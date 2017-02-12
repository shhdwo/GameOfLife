package gameoflife;

public class launch {

	public static void main(String[] args) {
		
		GameOfLife gra = new GameOfLife();
		int[][] divineTouch = {{1,0,1,1},{1,1,1,0},{1,0,1,0},{1,1,1,1}}; //tutaj podajemy tablice wejsciowa, 1-zywa komorka, 0-martwa
		gra.initiateLife(divineTouch);
		
		
		//symulacja
		gra.showState();
		
		int n = 10; //liczba krokow
		for (int i = 0; i < n; i++) {
			gra.nextGeneration();
			gra.showState();
		}
	}

}
