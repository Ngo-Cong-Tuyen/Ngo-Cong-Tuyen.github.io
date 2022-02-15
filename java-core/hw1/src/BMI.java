import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Your weight:");
        double weight= scanner.nextDouble();
        System.out.println("Your height:");
        double height= scanner.nextDouble();
        double BMI= Caculation.BMI(weight, height);
        System.out.printf("Your Body Mass Index: %.2f", BMI);
        System.out.println();
        if (BMI < 18.5){
            System.out.println("Underweight");
        } else if (BMI>=18.5 && BMI< 25) {
            System.out.println("Normal weight");
        } else if (BMI>= 25 && BMI<30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obesity");
        }
    }


}
