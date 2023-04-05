package aula2;

import java.util.Scanner;

public class Aula2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            System.out.println("Qual o seu nome?");
            String nome = scan.nextLine();

            System.out.println("Qual a sua idade?");
            int idade = scan.nextInt();

            System.out.println("Qual é o seu peso?");
            float peso = scan.nextFloat();

            System.out.println("Qual é a sua altura?");
            float altura = scan.nextFloat();

            float resultado = peso / (altura * altura);
            String aviso;

            if(resultado < 18.5) {
                aviso = "Abaixo do peso";
            } else if(resultado >= 18.5 && resultado < 25) {
                aviso = "Peso normal";
            } else if(resultado >= 25 && resultado < 30) {
                aviso = "Sobrepeso";
            } else {
                aviso = "Obesidade";
            }

            System.out.println("Nome: " + nome + 
                    "\nIdade: " + idade + " anos." +
                    "\nPeso: " + peso + " kg" +
                    "\nAltura: " + altura + " m" +
                    "\nResultado: " + resultado + " kg/m²" +
                    "\nAviso: " + aviso);
        } catch(Exception erro) {
            System.out.println("Xiiii...deu ruim :/");
        }
    }
    
}
