package com.educative;

class FindRange {

    private static int search(int[] arr, int key, boolean findMaxIndex) {
        int keyIndex = -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(key > arr[mid]) {
                start = mid + 1;
            }else if( key < arr[mid]) {
                end = mid - 1;
            }else {
                keyIndex = mid;

                if(findMaxIndex){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return keyIndex;
    }

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        int n = arr.length - 1;
        if(key < arr[0] && key > arr[n])
            return result;
        result[0] = search(arr, key, false);

        if(result[0] != -1)
            result[1] = search(arr, key, true);
        return result;
//        while(start <= end) {
//            int mid = start + (end - start)/2;
//
//            if(arr[mid] == key){
//                int rangeStart = mid;
//                while( rangeStart > 0 && arr[rangeStart] == arr[rangeStart - 1])
//                    rangeStart = rangeStart - 1;
//                int rangeEnd = mid;
//                while( rangeEnd < n  && arr[rangeEnd] == arr[rangeEnd +1])
//                    rangeEnd = rangeEnd + 1;
//                result[0] = rangeStart;
//                result[1] = rangeEnd;
//                break;
//            }else if(key > arr[mid]){
//                start = mid + 1;
//            }else{
//                end = mid - 1;
//            }
//        }

//        return result;
    }



    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}