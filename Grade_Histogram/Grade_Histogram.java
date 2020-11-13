import java.util.Scanner;
/**
 * Grade_Histogram
 */
public class Grade_Histogram {
    static Scanner scan = new Scanner(System.in); //Declares scanner object to read inputs
    static String A, B, C, D, F, error; //Declaring public strings
    public static void main(String[] args) {
        input();

        if(error.equals("NULL")){ //If any of the strings equals "NULL" 
            System.out.println("Invalid Input resulting in Invalid Histogram."); //Display error message
        }else{
            System.out.println(); //Printing the Histogram
            System.out.println("-HISTOGRAM-");
            System.out.println(A);
            System.out.println(B);
            System.out.println(C);
            System.out.println(D);
            System.out.println(F);
            System.out.println();
        }
    }

    public static void input(){
        for (int i = 0; i < 5; i++) { //Runs five times as there are five grades
            System.out.println("Enter grade, return key, then number"); //Prompts user to input + format
            String grade = scan.nextLine(); //Reads the grade-type
            int gradeCount = scan.nextInt(); //Reads how many particular grade-type(from variable above) student has received
            scan.nextLine();//Flushes out any extra characters to avoid skipping grade-type reader
            histogramFrequency(gradeCount, grade); //Calls the histogramFrequency method accepting two parameters 
        }
    }

    public static void histogramFrequency(int gradeCount, String grade){ //Accepts one integer and one string
        String incrementor = "";//Declares and initializes variable incrementor 
        error = ""; //Initializes error variable
        switch (grade) { //Switch statement used for different types of values for variable 'grade'
            case "A": //If the grade is A
                for (int i = 0; i < gradeCount; i++) { //add the same number of '*' symbol to the A grade string as the value of gradeCount
                    incrementor += '*'; //Adds '*' symbol
                }
                A = grade + "|" + incrementor; // Final String for A
                break; //Breaks the statement so it does not fall-through to other cases
            
            case "B": //If the grade is B
                for (int i = 0; i < gradeCount; i++) { //add the same number of '*' symbol to the B grade string as the value of gradeCount
                    incrementor += '*';//Adds '*' symbol
                }
                B = grade + "|" + incrementor; // Final String for B
                break; //Breaks the statement so it does not fall-through to other cases

            case "C": //If the grade is C
                for (int i = 0; i < gradeCount; i++) { //add the same number of '*' symbol to the C grade string as the value of gradeCount
                    incrementor += '*';//Adds '*' symbol
                }
                C = grade + "|" + incrementor; // Final String for C
                break; //Breaks the statement so it does not fall-through to other cases

            case "D": //If the grade is D
                for (int i = 0; i < gradeCount; i++) { //add the same number of '*' symbol to the D grade string as the value of gradeCount
                    incrementor += '*';//Adds '*' symbol
                }
                D = grade + "|" + incrementor; // Final String for D
                break; //Breaks the statement so it does not fall-through to other cases

            case "F": //If the grade is F
                for (int i = 0; i < gradeCount; i++) { //add the same number of '*' symbol to the F grade string as the value of gradeCount
                    incrementor += '*';//Adds '*' symbol
                }
                F = grade + "|" + incrementor; // Final String for F
                break; //Breaks the statement so it does not fall-through to other cases

            default: //When the above cases are not the same as the 'grade' variable
                error = "NULL"; //Makes error equal to null
                break;
        }
    }

    
    

    
}