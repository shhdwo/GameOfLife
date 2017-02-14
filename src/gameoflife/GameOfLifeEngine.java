package gameoflife;

public interface GameOfLifeEngine {
	
	//stworzenie planszy i stanu poczatkowego z tablicy dwuwymiarowej, gdzie kazdy element jest oznaczony jako 0-martwy lub 1-zywy
	public void initiateLife(int[][] divineTouch);
	
	//symulacja kolejnego kroku
	public void nextGeneration();
	
	//sprawdzenie czy komorka zyje
	public boolean isAlive(int x, int y);
	
	//sprawdzenie czy komorka ma zyc w nastepnej generacji
	public boolean willLive(int x, int y);
	
	//drukuje aktualny stan pola
	public void showState();
	
	//zwraca tablice z aktualnym stanem
	public int[][] getTodayState();
	
}
