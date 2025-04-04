import java.util.Scanner;

class matrizOO {
    int numLinhas;
    int numColunas;
    double [][] valores;
    static Scanner sc = new Scanner(System.in);

    public matrizOO (int linhas , int colunas){
        numColunas = colunas;
        numLinhas = linhas;
        valores = new double[numLinhas][numColunas];
    }    
    public void leValores(){
        for (int i = 0; i < numLinhas; i++){
            for (int j = 0; j < numColunas; j++){
                double valor = sc.nextDouble();
                valores[i][j] = valor;
            }
    
        }
    }
    public void exibeMatriz(){
        for (int i = 0; i < numLinhas; i++){
            for (int j = 0; j < numColunas; j++){
                System.out.print(valores[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static matrizOO matmult(matrizOO A, matrizOO B){
        matrizOO C = new matrizOO(A.numLinhas, B.numColunas);
        for (int i = 0; i < A.numLinhas; i++){
            for (int j = 0; j < B.numColunas; j++){
                for (int k = 0; k < B.numLinhas; k++){
                    C.valores[i][j] += A.valores[i][k]*B.valores[k][j];
                }

            }
        }
        return C;
    }

    public static void main (String[] args){
        matrizOO A = new matrizOO(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        A.leValores();
        matrizOO B = new matrizOO(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        B.leValores();
        
        System.out.println("Matriz A:");
        A.exibeMatriz();
        System.out.println("Matriz B:");
        B.exibeMatriz();
        matrizOO C = matmult(A, B);
        System.out.println("Matriz C:");
        C.exibeMatriz();
    }
}
