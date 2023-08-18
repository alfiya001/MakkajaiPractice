import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
	public static void main(String[] args) {
		Map<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
		int[] arr = {1,5,6,3,14,7,23,11,4,2,19};
		for(int i=0;i<arr.length;i++)
			mp.put( arr[i], true);
		
		for(int i=0;i<arr.length;i++) {
			if(mp.containsKey(arr[i]-1)==true)
				mp.put( arr[i], false);
		}
		
		int count = 1;
		for(int i=0;i<arr.length;i++) {
			if(mp.get(arr[i])==true) {
				int val = arr[i];
				int len = 1;
				while(mp.containsKey(val+1)) {
					len++;
					val++;
				}
				count = Math.max(count, len);
			}
		}
		System.out.println(count);
	}
}
