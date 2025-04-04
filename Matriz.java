import java.util.Scanner;

class Matriz {

    public static double[][] leMatriz(int numLinhas, int numColunas, Scanner sc){
        double [][] M = new double[numLinhas][numColunas];
        for (int i = 0; i < numLinhas; i++){
            for (int j = 0; j < numColunas; j++){
                double valor = sc.nextDouble();
                M[i][j] = valor;
            }
        }
        return M;
    }

    public static void exibeMatriz(double[][] M){
        int numLinhas = M.length;
        int numColunas = M[0].length;
        for (int i = 0; i < numLinhas; i++){
            for (int j = 0; j < numColunas; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] matmult (double[][] A, double[][] B){
        int numLinhas = A.length;
        int numColunas = B[0].length;
        double [][] C = new double[numLinhas][numColunas];
        for (int i = 0; i < numLinhas; i++){
            for (int j = 0; j < numColunas; j++){
                for (int k = 0; k < B.length; k++){
                    C[i][j] += A[i][k]*B[k][j];
                }

            }
        }
        return C;
    }

    public static void main(String[] args) {
        if (args.length < 4){
            System.out.println("Use: java Matriz.java num_linhas_A num_cols_A num_linhas_B num_cols_B");
            return;
        }
        int num_linhas_A = Integer.parseInt(args[0]);
        int num_cols_A = Integer.parseInt(args[1]);
        int num_linhas_B = Integer.parseInt(args[2]);
        int num_cols_B = Integer.parseInt(args[3]);

        Scanner sc = new Scanner(System.in);
        double[][] A = leMatriz(num_linhas_A, num_cols_A, sc);
        System.out.println("Matriz A:");
        exibeMatriz(A);
        double[][] B = leMatriz(num_linhas_B, num_cols_B, sc);
        System.out.println("Matriz B:");
        exibeMatriz(B);
        double [][] C = matmult(A, B);
        System.out.println("Matriz C:");
        exibeMatriz(C);
        

    }
}