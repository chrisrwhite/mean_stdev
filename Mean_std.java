/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mean_std;

/* Import libraries*/
import java.util.Scanner; //keyboard scanner
import java.lang.Math;  // for powers
import java.text.DecimalFormat; // decimal formatting


public class Mean_std {
    // read user input method
    public static double [] read_user_input(double [] array, final int sz) {
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");

        for(int index = 0; index < sz; index++){
            array[index] = kybd.nextDouble();
        }
        
        return array;
    }

    public static double compute_mean(double [] a, final int sz) {
        double sum_x_i = 0;
        int index = 0;
        for (index = 0; index < sz; index++){
            sum_x_i += a[index];
        }
        int len_a = a.length;
        
        double result = sum_x_i/len_a;
        return result;
        
    }

    public static double compute_std(double [] a, final int sz) {
       
        //sum_x_i_sq
        int index = 0;
        double sum_x_i_sq = 0;
        for (index = 0; index < sz; index++){
            sum_x_i_sq += Math.pow(a[index],2)  ;
        }
        
        
        //sum_x_i
        index = 0;
        double sum_x_i = 0;
        for (index = 0; index < sz; index++){
            sum_x_i += a[index];
        }       
        
        int len_a = a.length;
        
        double std = Math.pow((sum_x_i_sq - (Math.pow(sum_x_i,2))/len_a)/(len_a - 1),0.5);
        
        return std;
        
    }    
    
    // Sample run input: 1 2 3 4.5 5.6 6 7 8 9 10
    public static void main(String[] args) {
        //formatting numbers upto 2 decimal places in Java
        DecimalFormat df = new DecimalFormat("#,###,##0.00000");
        
        // initialize a new array
        int input_size = 10;
        double[] input_array = new double[input_size];
        
        double [] input_array_loaded = read_user_input(input_array, input_size);
        
        double mean = compute_mean(input_array_loaded, input_size);
        System.out.println("The mean is: " + mean);
        
        double std = compute_std(input_array_loaded, input_size);
        System.out.println("The standard deviation is: " + df.format(std));
        
    }
}
