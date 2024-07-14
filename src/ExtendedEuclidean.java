import java.util.Scanner;


public class ExtendedEuclidean {

    public static class Result {
        public int gcd;
        public int x;
        public int y;

        public Result(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    public static Result extendedEuclidean(int a, int b) {
        if (a == 0) {
            return new Result(b, 0, 1);
        }
        Result result = extendedEuclidean(b % a, a);
        int x = result.y - (b / a) * result.x;
        int y = result.x;
        return new Result(result.gcd, x, y);
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int m = input.nextInt();

        int resultado;

        Result result = extendedEuclidean(a, m);
        
        if (result.gcd != 1) {
            a = a/result.gcd;
            b = b/result.gcd;
            m = m/result.gcd;
            result = extendedEuclidean(a, m);
            if (result.gcd != 1) {
                System.out.println("O sistema não tem solução!");
            }
            else{
                resultado = (result.x * b) % m;
                System.out.println(resultado);
            }
        }
        else{
            resultado = (result.x * b) % m;
            System.out.println(resultado);
        }

        //System.out.println(result.x);
    }
}
