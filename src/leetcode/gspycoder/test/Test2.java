package leetcode.gspycoder.test;

public class Test2 {
    static void paranthesisRecursive(char str[], int index, int n, int open, int close)
    {
        if(close == n)
        {
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[index] = ')';
                paranthesisRecursive(str, index+1, n, open, close+1);
            }
            if(open < n) {
                str[index] = '(';
                paranthesisRecursive(str, index+1, n, open+1, close);
            }
        }
    }
    public static void main (String[] args)
    {
        int n = 3;
        char[] str = new char[2 * n];
        if(n > 0){
            paranthesisRecursive(str, 0, n, 0, 0);
        }
    }
}
