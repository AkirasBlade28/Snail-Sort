import java.util.ArrayList;

public class Snail {
	
	private static int length;
	private static int width;
	private static ArrayList<Integer> resultTest;
	
	public static int[] snail(int array[][]) {
		length = array.length;
		width = array[0].length;
		resultTest = new ArrayList<>();
		traverseEnumStates(array);
		
		return resultTest.stream()
                .mapToInt(Integer::intValue)
                .toArray();
	}
	
	private static void traverseEnumStates(int array[][]) { // traverse map and collect integers
		
		int limitWidthlSize = width;
		int limitLengthSize = length;
		int indexForRightTraversal = 0;
		int limitRightTraversal = 0;
		int indexForDownTraversal = 1;
		int indexForLeftTraversal = 0;
		int indexForUpTraversal = 0;
				
		var currentState = TRAVERSE_CLOCKWISE.RIGHT;
		// total number the snake will move/traverse 
		int totalNumberOfClocksRottation = (length>width) ? width+width : (length+length)-1;
		for(int t=0; t<totalNumberOfClocksRottation; ++t) {			
			
			switch (currentState) {
				case RIGHT: {
					for(int i=limitRightTraversal; i<limitWidthlSize; ++i) {
						resultTest.add(array[indexForRightTraversal][i]);
					}
					++indexForRightTraversal;
					--limitWidthlSize;	
				}
				break;
						
				case LEFT: {
					for(int i=limitWidthlSize-1; i>=indexForLeftTraversal; --i) {
						resultTest.add(array[limitLengthSize-1][i]);
					}
					++indexForLeftTraversal;
					--limitLengthSize;
				}
				break;
		
				case UP: {
					for(int i=limitLengthSize-1; i>indexForUpTraversal; --i) {
						resultTest.add(array[i][indexForUpTraversal]);
					}
					++indexForUpTraversal;
					++limitRightTraversal;
				}
				break;
						
				case DOWN: {
					for(int i=indexForDownTraversal; i<limitLengthSize; ++i) {
						resultTest.add(array[i][limitWidthlSize]);
					}
					++indexForDownTraversal;	
				}
				break;
				default: break;
			}
			currentState = currentState.transition();
		} 
	}
	
	private static enum TRAVERSE_CLOCKWISE {
		
		RIGHT{
			@Override
			public TRAVERSE_CLOCKWISE transition() {
				return DOWN;
			}
		},
		
		LEFT {
			@Override
			public TRAVERSE_CLOCKWISE transition() {
				return UP;
			}
		},
		
		DOWN {
			@Override
			public TRAVERSE_CLOCKWISE transition() {
				return LEFT;
			}
		},
		
		UP {
			@Override
			public TRAVERSE_CLOCKWISE transition() {
				return RIGHT;
			}
		};
		
		public abstract TRAVERSE_CLOCKWISE transition();
	}

}
