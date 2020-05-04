 
// For example

// Array = [1,3,4,4,5,6,6,7,7,7,7,8]
// Target = 7, 2

// Output = 4, 0
// two binary searches for starting and ending indices
// time complexity O(log n)
// space complexity O(1)

//test case: [0,1,2,7,7,7] target = 7
class Solution{
    public int getCound(int[] nums, int target){
        if (nums == null || nums.length == 0 ){
            return 0; //or throw exception
        }
        if (target < nums[0] || target > nums[nums.length - 1]){
            return 0;
        } 
        int left = 0;
        int right = nums.length - 1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while (left + 1 < right){  //left 0 2   //right 5 3
            int mid = (left + right)/2;  // mid 2 3
            
            if (nums[mid] >= target){  
                right = mid; //    right 3
            }
            else {
                left = mid; //left 2 
            }        
        }
        // left  right 
        start = (target == nums[0]? 0 : right); // start = 3
        
        if (nums[start]!= target){ 
            return 0; //reutnr 0
        }
        
        left = 0;
        right = nums.length - 1;
        
        
        
        
        while (left + 1 < right){ // left   // right 
            int mid = (left + right)/2; // mid 
            
            if (nums[mid] <= target){
                left = mid; //left 2 3 4
            }
            else {
                right = mid;
            }        
        }
        // left 4     right 5
        end = (target == nums[nums.length - 1]? nums.length - 1: left); // end = 5
        
        if (nums[start]!= target || nums[end]!= target){
            return 0;
        }
        return end - start + 1; //5-3+1 = 3
    }
}

// test cases

//[1,2,3,5,5,6,7,7,7,7] 
// target = -1, 8, 7, 1, 4, 5


//[3]
// target = 1,3,5

//[3,3,3,3,3,3,3]
// target = 3

//overflow problem if length of arr > 2^31


// arr is sorted?

//[]

//null



// getCount(target);
// getCount(target1);
// getCount(target2);
// getCount(target3);
// getCount(target4);

// klog(n)
    
    //preprocess the array record the corrance in a hashmap
    // time complexity preprossing O(n) n = arr.length
    // space complexity O(n) 
    // each getCount is O(1) in time
    // k * O(1)
    // O (n + k)  if k >> n
    
    // O (k * log n) if k << n


// test cases










1. Input: a array of digits (0-9) => a decimal number, with the most significant bit on leftmost element (index 0)
  Output: the maximum possible number we can generate from this array by swapping any of the two digits by at most once.
Example: 14572 => 74512
         9876513=> 9876531
         987654321 => 987654321
                 
         7526661 => 7626651
         0555556           
    O(length of string)    
    Space: O(length of string)

class Solution{
    public String swapMax(String str){  //"7526661"
        if (str == null || str.length() <= 1){
            return str    ; //throw expcetion
        }
        char[] c = str.toCharArray();
        int[] index = new int[c.length];
        
        char max = c[c.length - 1]; //max = '1'
        int maxIndex = c.length - 1; //maxIndex = 6
        
        for (int i = index.length - 1; i >= 0; i --){
            if (c[i] > c[maxIndex]) {
                max = c[i];   //max = '6' '7'
                maxIndex = i; //maxIndex = 5  0
            }
            index[i] = maxIndex; // index: 0 5 5 5 5 5 6
        }
        
        for (int i = 0 ; i < c.length ; i ++){
            if (c[i] == c[index[i]]) {
                continue;
            }
            c[i] ^= c[index[i]];
            c[index[i]] ^= c[i];
            c[i] ^= c[index[i]];
            return new String(c);
        }
        return str;
    }
    
}

2. Design and implement a hashmap structure
-- on average O(1) time complexity for looup and insert operations on (key, value) pairs
-- assume we have a good hash function to generate a unique hash code for a given key object


array of length L consisting of LinkedList<key-value pair>

hashcode(Object) % L  key-value pair




class Entry{
    String key;
    String value;
    public Entry(String key, String value){
        this.key = key;
        this.value = value;
    }
}    


class MyHashMap{
    private int size = 50;
    LinkedList<Entry>[] arr = new LinkedList[50];
    
    public int hash(String key){
        int num = key.hashCode();
        while (num < 0){
            num += size;
        }
 
        return num % size;
    }

    public void /*synchronized*/ insert(String key, String value){
        
        if (arr[hash(key)] == null){
            arr[hash(key)] = new LinkdList<>();
        }
        
        for (Entry entry: arr[hash(key)]){
            if (entry.key.compareTo(key) == 0){
                entry.value = value;
                return;
            }        
        }
        
        arr[hash(key)].add(new Entry(key, value));    
    }

}









