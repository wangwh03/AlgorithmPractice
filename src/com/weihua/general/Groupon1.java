package com.weihua.general;

/*
 * A groupon interview question
 * Give a map and a path, a starting point, find the ending point
 */
public class Groupon1 {

	public static void main(String[] args) {
		Groupon1 test = new Groupon1();
		Position newPosition = test.getPosition(new Position(5, 5), 10, 10, new char[]{'N','S','E','E','N','N','N'});
		System.out.println(newPosition);
	}

	public Position getPosition(Position current, int width, int height, char[] path) {
		if (!isValid(current, width, height)) {
			throw new IllegalArgumentException("current position is invalid!");
		}

		for (int i = 0; i < path.length; i++) {
			Position newPosition;
			switch(path[i]) {
			case 'N':
				newPosition = new Position(current.x, current.y + 1);
				break;
			case 'S':
				newPosition = new Position(current.x, current.y - 1);
				break;
			case 'E':
				newPosition = new Position(current.x + 1, current.y);
				break;
			case 'W':
				newPosition = new Position(current.x - 1, current.y);
				break;
			default:
				throw new IllegalArgumentException("invalid path");
			}
			if (isValid(newPosition, width, height)) {
				current = newPosition;
			}
		}
		
		return current;
	}

	private boolean isValid(Position position, int width, int height) {
		if (position == null) {
			return false;
		}
		if (position.x >= 0 && position.x < width
				&& position.y >= 0 && position.y < height) {
			return true;
		} else {
			return false;
		}
	}

	public static class Position {
		private int x;
		private int y;

		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		public String toString() {
			return "x:" + x + " y: " + y;
		}
	}
}
