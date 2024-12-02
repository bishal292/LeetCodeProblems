class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // int first = 0;
        // int last = image.length - 1;
        for(int[] img :image){
            flipAndReverse(img);
        }
        return image;
    }

    public void flipAndReverse(int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        while (left <= right) {
            int temp = arr[left] ^ 1;
            arr[left] = arr[right] ^ 1;
            arr[right] = temp;
            left++;
            right--;
        }
    }
}