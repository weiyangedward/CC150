import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public
class BooleanEvaluation
{
    int evalCount = 0;
    boolean truth;
    int[][] T;
    int[][] F;

    public
    BooleanEvaluation(String express, boolean truth)
    {
        this.truth = truth;
        int i;

        // init operands and operators
        LinkedList<Boolean> operands = new LinkedList<Boolean>();
        LinkedList<Character> operators = new LinkedList<Character>();
        operands.addLast(boolValue(express.charAt(0)));
        for (i=1; i<express.length();i+=2)
        {
            operators.addLast(express.charAt(i));
            operands.addLast(boolValue(express.charAt(i+1)));
        }

        // init T and F
        int n = operands.size();
        T = new int[n][n];
        F = new int[n][n];
        // init T and F for each operand
        for (i=0; i<n; i++)
        {
            T[i][i] = (operands.get(i) == true) ? 1 : 0;
            F[i][i] = (operands.get(i) == false) ? 1 : 0;
        }


        /**
         * DP: time O(n^3) (3 for-loops), space O(n^2)
         */
        // for each window size
        for (int gap=1; gap<n; gap++)
        {
            // slide window from left to right
            for (int s=0, e=gap; e<n; s++, e++)
            {
                // compute ways to evaluate to T and F in this window
                T[s][e] = F[s][e] = 0;

                // for each place to put a parentheses "()()" in a window
                for (int g=0; g<gap; g++)
                {
                    int k = s + g; // operator k is from 0 to n-1 since gap is at least 1

                    // total T and F at the left or right of parentheses
                    int totalStoK = T[s][k] + F[s][k];
                    int totalKtoE = T[k+1][e] + F[k+1][e];

                    // add num of eval to T and F at this window
                    switch (operators.get(k))
                    {
                        case '&':
                            T[s][e] += T[s][k] * T[k+1][e];
                            F[s][e] += (totalStoK*totalKtoE - T[s][k]*T[k+1][e]);
                            break;
                        case '|':
                            T[s][e] += (totalStoK*totalKtoE - F[s][k]*F[k+1][e]);
                            F[s][e] += F[s][k]*F[k+1][e];
                            break;
                        case '^':
                            T[s][e] += F[s][k]*T[k+1][e] + T[s][k]*F[k+1][e];
                            F[s][e] += T[s][k]*T[k+1][e] + F[s][k]*F[k+1][e];
                            break;
                    }
                }
            }
        }
        evalCount = (truth == true) ? T[0][n-1] : F[0][n-1];
    }

    public
    boolean boolValue(char c)
    {
        boolean bool = (c == '1') ? true : false;
        return bool;
    }

    public
    int getEvalCount()
    {
        return evalCount;
    }

    public static
    void main(String[] args)
    {
        try
        {
            String            express1 = "0&0&0&1^1|0";
            BooleanEvaluation be1      = new BooleanEvaluation(express1, true);
            System.out.format("%s evaluate to true can be parenthesized in %d ways\n", express1, be1.getEvalCount());

            String            express2 = "1^0|0|1";
            BooleanEvaluation be2      = new BooleanEvaluation(express2, false);
            System.out.format("%s evaluate to true can be parenthesized in %d ways\n", express2, be2.getEvalCount());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
