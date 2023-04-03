package lab_work_tenth;

public class VisualArray {

	private int[] arr = null;
	private int[] stepArr = null;
	
	public VisualArray(String str) {
		String[] strArr = str.split(",");
		arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		stepArr = arr.clone();
	}

	public String displaySourceArr() {
		return intArrToString(arr);
	}

	public String displaySortArr() {
		int[] tempArr = arr.clone();
		sortBubble(tempArr);
		return intArrToString(tempArr);
	}

	public String displayStepByStepSort() {
		sortBubble(stepArr);
		return intArrToString(stepArr);
	}

	private void sortBubble(int[] tempArr) {
		boolean arr_or_stepArr = tempArr == stepArr;
		boolean isSorted = false;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i < tempArr.length - 1; i++) {
				if(tempArr[i] > tempArr[i+1]) {
					swap(tempArr,i,i+1);
					isSorted = false;
					if(arr_or_stepArr)
						return;
				}
			}
		}
	}

	private String intArrToString(int[] tempArr) {
		StringBuilder strBuilder = new StringBuilder();
		for(int elem : tempArr)
			strBuilder.append(elem + " ");
		return strBuilder.toString();
	}

	private void swap(int[] tempArr,int a, int b) {
		int temp = tempArr[a];
		tempArr[a] = tempArr[b];
		tempArr[b] = temp;
	}
}