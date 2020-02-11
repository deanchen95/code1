import java.util.Scanner;
/**
 * Create an array and modify through a menu
 *
 * @author (Xiaohu Chen)
 * @version (02/05/2020)
 *111111111
 */
public class Arrays
{
    public static void main(String[] args)
    {
        CheckInput check=new CheckInput();
        int[] arrayNum=new int[10];
        populate(check,arrayNum);
        Scanner input=new Scanner(System.in);
        int choice=0;
        
        while(choice!=8){
            displayMenu();
            System.out.print("Your chioce: ");
            choice=check.getIntRange(1,8);
            
            switch(choice){
                case 1: displayArray(arrayNum);
                        System.out.println();
                        break;
                case 2: reversed(arrayNum);
                        System.out.println();
                        break;
                case 3: System.out.println("The sum of the array is "+sum(arrayNum));
                        System.out.println();        
                        break;
                case 4: System.out.println("The maximun value is "+max(arrayNum));
                        System.out.println();
                        break;
                case 5: int value,index;
                        System.out.print("Enter the value you want to search: ");
                        value=check.getInt();
                        index=search(arrayNum, value);
                        if(index==-1)
                            System.out.println("The value is not found.");
                        else
                            System.out.println("The value is at location "+index);
                        System.out.println();
                        break;
                case 6: int index2, value2;
                        System.out.print("Enter a location(1-10), and a new value: ");
                        index2=check.getIntRange(1,10);
                        value2=check.getInt();
                        insert(arrayNum, index2, value2);
                        System.out.println();
                        break;
                case 7: populate(check, arrayNum);
                        System.out.println();
                        break;
                case 8: break;
                default: break;
            }
            
        }
    }
    
    /*
     * ask user to prompt 10 int numbers 
     * @parameter check: CheckInput class
     * @parameter arr: fill the array
     */
    public static void populate(CheckInput check, int[] arr){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        for(int i=0; i<arr.length;i++){
            arr[i]=check.getInt();
        }
    }
    
    /*
     * print the array
     * @parameter arr: the array needs to be desplayed
     */
    public static void displayArray(int [] arr){
        System.out.print("Array: ");
        for(int i=0;i<arr.length-1;i++)
            System.out.print(arr[i]+", ");
        System.out.println(arr[arr.length-1]);
    }
    
    /*
     * reversed the array and print it out
     * @parameter arr: the array need to be reversed
     */
    public static void reversed(int[] arr){
        int size=arr.length;
        int [] temp=new int [size];
        int j=size;
        System.out.print("The reversed array: ");
        for(int i=0;i<size;i++){
            temp[j-1]=arr[i];
            j--;
        }
        for(int i=0;i<size-1;i++)
            System.out.print(temp[i]+", ");
        System.out.println(temp[size-1]);
    }
    
    /*
     * search a value from the array
     * @parameter arr: the array for searching
     * @parameter value: the searching value input by user
     * @return the index to the value or -1 if not found
     */
    public static int search(int[] arr, int value){
        for(int i=0; i<arr.length;i++){
            if(value==arr[i])
                return i+1;
        }
        return -1;
    }
    
    /*
     * insert a value into the array and replace the old value
     * @parameter arr: the array passed in
     * @parameter index: the location user choose
     * @parameter value: the new value user inputs
     */
    public static void insert(int[] arr, int index, int value){
        arr[index-1]=value;
    }
    
    /*
     * find the maximun number from the array
     * @parameter arr: the array
     * @return the max number
     */
    public static int max(int[] arr){
        int max=0;
        for(int x:arr){
            if(x>max)
                max=x;
        }
        return max;
    }
    
    /*
     * find the sum of the array
     * @parqameter arr: the array
     * @return the sum of all value
     */
    public static int sum(int[] arr){
        int sum=0;
        for(int x:arr)
            sum+=x;
        return sum;
    }
    
    /*
     * display the menu
     */
    public static void displayMenu(){
        System.out.println("1. Display Values\n2. Display Reversed\n"
                            +"3. Display Sum\n4. Display Maximun\n"
                            +"5. Search for a Value\n6. Insert new Value"
                            +"\n7. Reset Values\n8. Quit\n");
    }
}
