package gameoflife;

import org.junit.Test;
import org.junit.Assert;

public class GameOfLifeTest {
	/**
	 * Zywa komorka zyje w kolejnej generacji jesli ma 2 lub trzech zywych sasiadow
	 * Martwa komorka zyje w kolejnej generacji jesli ma rowno 3 zywych sasiadow
	 */

	
	@Test
	public void shouldReturn_1011_1000_0000_1011whenPut_1011_1110_1010_1111 () {
		//given
		GameOfLife life = new GameOfLife();
		int[][] divineTouch = {{1,0,1,1},
							   {1,1,1,0},
							   {1,0,1,0},
							   {1,1,1,1}}; //tutaj podajemy tablice wejsciowa, 1-zywa komorka, 0-martwa
		life.initiateLife(divineTouch);
		//when
		life.nextGeneration();
		int[][] actual = life.getTodayState();
		int[][] expected = {{1,0,1,1},
						    {1,0,0,0},
						    {0,0,0,0},
						    {1,0,1,1}};
		//then
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn_1001_0000_0000_1001_whenPut_1111_1111_1111_1111 () {
		//given
		GameOfLife life = new GameOfLife();
		int[][] divineTouch = {{1,1,1,1},
							   {1,1,1,1},
							   {1,1,1,1},
							   {1,1,1,1}}; //tutaj podajemy tablice wejsciowa, 1-zywa komorka, 0-martwa
		life.initiateLife(divineTouch);
		//when
		life.nextGeneration();
		int[][] actual = life.getTodayState();
		int[][] expected = {{1,0,0,1},
						    {0,0,0,0},
						    {0,0,0,0},
						    {1,0,0,1}};
		//then
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn_1100_1100_0011_0011_whenPut_1100_1000_0001_0011 () {
		//given
		GameOfLife life = new GameOfLife();
		int[][] divineTouch = {{1,1,0,0},
							   {1,0,0,0},
							   {0,0,0,1},
							   {0,0,1,1}}; //tutaj podajemy tablice wejsciowa, 1-zywa komorka, 0-martwa
		life.initiateLife(divineTouch);
		//when
		life.nextGeneration();
		int[][] actual = life.getTodayState();
		int[][] expected = {{1,1,0,0},
						    {1,1,0,0},
						    {0,0,1,1},
						    {0,0,1,1}};
		//then
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn_11_11_whenPut_11_11 () {
		//given
		GameOfLife life = new GameOfLife();
		int[][] divineTouch = {{1,1},
							   {1,1}}; //tutaj podajemy tablice wejsciowa, 1-zywa komorka, 0-martwa
		life.initiateLife(divineTouch);
		//when
		life.nextGeneration();
		int[][] actual = life.getTodayState();
		int[][] expected = {{1,1},
						    {1,1}};
		//then
		Assert.assertArrayEquals(expected, actual);
	}
}
