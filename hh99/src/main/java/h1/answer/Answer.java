package h1.answer;

public class Answer {
    private int[] nums;

    public Answer(int length) {
        this.nums = new int[length];
    }

    public void addNum (int index, int value) {
        this.nums[index] = value;
    }

    public int getNumByIndex(int index) {
        if (index < 0 || index >= this.nums.length) return -1;
        return this.nums[index];
    }

    public int getIndexByValue(int value) {
        for (int i =0; i < this.nums.length; i++) {
            if(this.nums[i] == value) return i;
        }
        return -1;
    }
}
