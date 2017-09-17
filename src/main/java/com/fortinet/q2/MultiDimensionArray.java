package com.fortinet.q2;

public class MultiDimensionArray {

	private Object mArrObj; // a multi-dimension array;
	
	public MultiDimensionArray(Object mArrObj) {
		this.mArrObj = mArrObj;
	}
	
	public Object getMArrObj() {
		return mArrObj;
	}

	public static Long getValue(int... indexOfDimension) {
		return 0l;
    }
	
	public static Long sum(Object mArray, int[] lengthOfDeminsion, int idx) {
		long sum = 0l;
		if (mArray.getClass().isArray()) {
			Object[] arr = (Object[])mArray;
		    if (idx<lengthOfDeminsion.length && lengthOfDeminsion[idx]==arr.length) {
			    if (!arr[0].getClass().isArray()){
                    for (int i=0; i<lengthOfDeminsion[idx]; i++) {
                    	sum +=(long)arr[i];
                    }
			    	return sum;
		        }
			    for (int i=0; i<lengthOfDeminsion[idx]; i++) {
				    sum += sum(arr[i], lengthOfDeminsion, idx+1);
			    }
			}
		}
		return sum;
	}
	
	/*
	 * Actually (int[] lengthOfDeminsion, int idx) are not required, the unit tests code should be changed
	 */
	public static Long sum(Object mArray) {
		long sum = 0l;
		if (mArray.getClass().isArray()) {
			Object[] arr = (Object[])mArray;
            int len = arr.length;
		    if (!arr[0].getClass().isArray()){
                for (int i=0; i<len; i++) {
                	sum +=(long)arr[i];
                }
		    	return sum;
	        }
		    for (int i=0; i<len; i++) {
			    sum += sum(arr[i]);
		    }
		}
		return sum;
	}
	
	
	
	/*
	 * Time Complexity O(n)  n=the product of each element in array lengthOfDeminsion
	 * Sapce Complexity O(n) When n is larger enough, ignore the size of array lengthOfDeminsion)
	 * 
	 */
	
	public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {
		
		if (mArray==null || lengthOfDeminsion==null) {
			return 0l;
		}
		Object mArr = mArray.getMArrObj();
		if (mArr==null) {
			return 0l;
		}
		
		return sum(mArr, lengthOfDeminsion, 0);
		//return sum(mArr);  //lengthOfDeminsion and idx are not required
		
	}
    
}
