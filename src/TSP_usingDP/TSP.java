package TSP_usingDP;

public class TSP {
    static int N = 4; // this is the size of the dp array.

    static int[][] dp = new int[16][4];//creating the dp array of size of [2powN][N]
    // creating the distance array.
    static int[][] distance = {{0, 20, 42, 25},
            {20, 0, 30, 34},
            {42, 30, 0, 10},
            {25, 34, 10, 0}
    };

    //if all the cities have been visited
    static int VISITED_ALL = (1 << N) - 1;

    // mask--> the set of cities which have been visited so far, so from
    //         mask we come to know that which cities have not been visited
    // pos---> the position of the current cities or from which city I am going
    //         to the next city.

    // taking the function which has the parameter "mask" and "position".
    static int Tsp(int mask, int pos) {
        // Base condition
        if (mask == VISITED_ALL) {
            return distance[pos][0];
        }


        // condition: if all the position in the Dp array get visited
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }
        // Assumption: take a variable "Ans" which contains the Integer Max Value.
        int Ans = Integer.MAX_VALUE;

        // traversing to the city which are not visited.
        for (int city = 0; city < N; city++) {

            // we consider the "mask" and "city" in the binary form
            // if mask=1--->00000001 and and city = 2
            // (1 << 2)---> 1 = 00000001,left shift the binary form of 1 by 2
            //         00000001  = 1
            //       & 00000100  = 4        |
            //        ----------
            //         00000000  = 0
            if ((mask & (1 << city)) == 0) { // checking that the binary form of the
                // code is double equals  to 0 or not.

                int newAns = distance[pos][city] + Tsp(mask | (1 << city), city);
                // taking a new variable--> "newAns"
                // newAns assign the "sum of the distance[pos][city] + Tsp(mask | (1 << city), city)"
                // Tsp(mask | (1 << city), city)---> is the recursive function that is going
                // to call for each different "mask" and "city"
                // let's take "mask"=1 and "city"=2 then
                // 1 = 00000001 and (1<<2)--> 00000100 = 4
                //       00000001  = 1
                //    |  00000100  = 4
                //      ----------
                //       00000101  = 5

                // updating the "Ans" by taking--> min{Ans , newAns}
                Ans = Math.min(Ans, newAns);
            }
        }
        // after the Loop end return the dp[mask][pos] to the-->Tsp(int mask, int pos)
        return dp[mask][pos] = Ans;
    }

    public static void main (String[]args){
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1; // initially I am assigning having value -1 to all
            }
        }
        System.out.println();
        System.out.println("minimum weight hamiltonian path costs: " + Tsp(1, 0));
        // Tsp(1, 0) ---> initially this value is assigning to mask=1 , pos=0
        // and calling the same---> Tsp(int mask, int pos) function.
        // 1--->denotes the initial "mask" = 0001
        // pos--> denotes the 0th city have been visited initially.

    }

}
