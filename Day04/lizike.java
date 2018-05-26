package cn.ioteck.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day04 {

	public static void main(String[] args) {
		List<int[]> list = new ArrayList<int[]>();
		
		int [] nums = {-1, 0, 1, 3, -1, -4};
		for(int i=0;i < nums.length-2;i++){
			for(int j=i+1;j < nums.length-1;j++){
				for(int z=i+2;z<nums.length;z++){			
					if(nums[i] + nums[j] + nums[z] ==0){	
						int [] arr = new int[3];
						arr[0] = nums[i];
						arr[1] = nums[j];
						arr[2] = nums[z];
						Arrays.sort(arr);
						System.out.print(arr[0]);
						System.out.print(arr[1]);
						System.out.println(arr[2]);
						if(list.isEmpty()){
							list.add(arr);
						}
						for(int n=0;n<list.size();n++){
							if(Arrays.equals(arr, list.get(n))){
								break;
							}else if(n == list.size()-1&&!Arrays.equals(arr, list.get(n))){
							list.add(arr);
							break;
							}
						}
						
					}
					
				}
			}
		}
		
		System.out.println(list.size());

	}

}

