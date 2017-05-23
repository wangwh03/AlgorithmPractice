package com.weihua.general;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * give a integer array, find triplet that sums up to the given sum a+b+c=0
 * convert this problem into the two sum problem by a+b=-c
 * loop through all c, find all (a,b) pairs that sum up to -c
 * store the triplets results in a set, to avoid duplicates
 * 
 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		System.out.println(test.getTriplets(new int[] {1, 2, -3, -1, 0, -2}));
	}
	
	public Set<Triplet> getTriplets(int[] input) {
		Set<Triplet> results = new HashSet<ThreeSum.Triplet>();
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			int sum = -input[i];
			int left = 0;
			int right = input.length - 1;
			while (left < right) {
				if (input[left] + input[right] < sum) {
					left++;
				} else if (input[left] + input[right] > sum) {
					right--;
				} else {
					if (left != i && right != i) {
						Triplet result = new Triplet(input[i], input[left], input[right]);
						results.add(result);
					}
					left++;
				}
			}
		}
			
		return results;
	}
		
	public static class Triplet {
		Set<Integer> triplet = new HashSet<Integer>();
		
		public Triplet(int first, int second, int third) {
			triplet.add(first);
			triplet.add(second);
			triplet.add(third);
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (Integer number : triplet) {
				sb.append(number + " ");
			}
			return sb.toString();
		}
		
		@Override
		public int hashCode() {
			return triplet.hashCode();
		}
		
		@Override
		public boolean equals(Object o2) {
			Triplet that = (Triplet) o2;
			if (!(o2 instanceof Triplet)) {
				return false;
			} 
			return this.triplet.equals(that.triplet);
		}
	}

}
