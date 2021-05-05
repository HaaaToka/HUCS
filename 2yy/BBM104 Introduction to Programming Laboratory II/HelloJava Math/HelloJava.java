// OKAN ALAN - - 21526638

import java.util.*;
import java.io.*;

public class HelloJava {
    public static int factorial(int number){ //calculate the factorial
        //This method is finding factorial
        if (number<=1)
            return 1;
        else
            return number*factorial(number-1);
    }
    public static double arcsinh(double number){
        //This method is finding arcsinh's  value
        double answer=0;
        for(int n=0;n<30;n++){
            answer+=((Math.pow(-1, n)*factorial(2*n))/(Math.pow(4, n)*Math.pow(factorial(n), 2)*(2*n+1)))*Math.pow(number, 2*n+1) ;
            //given formula in assingment pdf
        }
        return answer;
    }
    public static double integrateReimann(String fc,double a,double b, int nop){
        //This method is finding Reimann Sum answer
        double result=0,up=(b-a)/nop; //up===> amount of increase
        double midPoint=((a+up)+a)/2;   //x===>midPoint
        if (fc.equals("Func1")){
            //This is finding func3's answer
            for(int i = 1;i<=nop;i++){
                result+=Math.pow(midPoint,2)-midPoint+3;//x^2-x+3
                midPoint+=up;
            }
        }
        else if (fc.equals("Func2")){
            //This is finding func2's answer
            for(int i=1;i<=nop;i++){//for every rectangle
                result+=Math.pow((3*Math.sin(midPoint)-4),2);//(3sin(x)-4)^2
                midPoint+=up;
            }
        }
        else if(fc.equals("Func3")){
            //This is finding func3's answer
            for (int i=1;i<=nop;i++){
                if(midPoint<1 && midPoint>-1){
                        result+=arcsinh(midPoint);
                }
                midPoint+=up;
            }
        }
        return result*up;
    }
    public static void armstrongNumber(int digit){
        //This method is finding the armstrong numbers
        int temp=0,dd,dr,answer;
        for(int i=0;i<Math.pow(10,digit);i++){
            answer=0;
            if(i==0){System.out.print(i+" ");}
            else {
                dd=0;//digits
                dr=0;//last digit in number
                temp=i;
                while (temp != 0) //how many has it digit
                {
                    temp /= 10;//last digit is deleting
                    dd++;
                }
                temp=i;
                while (temp!=0){  //control to is it armstrong number
                    dr=temp%10; //take last digits
                    answer+=Math.pow(dr,dd); //control
                    temp/=10; //delete last digit
                }
                if (answer==i){System.out.print(i+" ");} //i don't know how many special number that why i print every step
            }
        }
    }
    public static void main(String[] args){
        //Application starts here
        try {
            Scanner scanner = new Scanner(new File(args[0]));//take input from file which is input.txt java HelloJava Input.txt
            while(scanner.hasNextLine()){ //when we don't know how many input
                String line = scanner.next();   //first word of line
                if(line.equals("IntegrateReimann")){  //which operation we will use
                    String funcName= scanner.next(); //func name
                    double  a=Double.parseDouble(scanner.next()),b=Double.parseDouble(scanner.next());//take inputs
                    int numberOfPartitions=scanner.nextInt();
                    System.out.print(line+" "+funcName+" "+(int)a+" "+(int)b+" "+numberOfPartitions+" Result : "+integrateReimann(funcName,a,b,numberOfPartitions)+"\n");
                }
                else if (line.equals("Arcsinh")){
                    Double sin=Double.parseDouble(scanner.next()); // input values
                    System.out.print(line+" "+sin+" Result : "+arcsinh(sin)+"\n");//output line
                }
                else if(line.equals("Armstrong")){
                    int asn=scanner.nextInt();
                    System.out.print(line+" "+asn+" Result : "); //results output
                    armstrongNumber(asn);
                    System.out.print("\n");
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) { //catching exception
            System.out.println("No File Found!");
            return;
        }
    }
}

