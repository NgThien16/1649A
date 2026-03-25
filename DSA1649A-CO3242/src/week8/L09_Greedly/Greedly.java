package week8.L09_Greedly;

public class Greedly {
    public static int getMinCoin(int[] coins, int target){
        // target/ bigMoney
        int totalMoney = 0;
        for (int c : coins) {
            if (target >= c) {
                int count = target / c;
                target %= c;
                totalMoney += count;
                System.out.println("Mệnh gia" + c+ ":"+ count +"tờ");

            }
        }

        if (target > 0) {
            System.out.println("Không thể lấy đủ, còn dư: " + target);
        }
        return totalMoney;

    }
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        getMinCoin(new int[]{500,200,100,50,20,10,5,2,1}, 923);
    }
}