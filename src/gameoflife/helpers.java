package gameoflife;

public class helpers {

	public static int[][] cloneMatrix(int[][] toBeCloned) {
	
		int[][] newMatrix = toBeCloned.clone();
		for (int i = 0; i < toBeCloned.length; i++) {
			newMatrix[i] = toBeCloned[i].clone();
		}
		return newMatrix;
	}
	
}
