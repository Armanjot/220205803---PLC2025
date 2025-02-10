import java.util.Scanner;
import java.util.EnumSet;

public class ErrorsEnum
{
    enum Error { FP_ROUNDING, FP_OVERFLOW, FP_UNDERFLOW, INT_OVERFLOW }

    enum Result { A_BIT_DIFFERENT, INFINITY, ZERO, VERY_DIFFERENT }
    
    private static <E extends Enum<E>> E getEnumElement(String elementTypeName, Class<E> elementType)
    {
        boolean haveError = false;
        E result = null;
        Scanner stdin = new Scanner(System.in);
        
        while ( ! haveError )
        {
            System.out.print("Input " + elementTypeName + ": ");
            try
            {
                error = Enum.valueOf(elementType, stdin.next().toUpperCase());
                haveError = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid " + elementTypeName + ".");
                stdin.nextLine(); // skip the invalid input
            }
        }
        
        stdin.close();
        return result;
    }
  
    private static Result error2Result(Error e)
    {
        Result result = null;
        
        switch (e) {
        case FP_ROUNDING:
            result = Result.A_BIT_DIFFERENT;
            break;
        case FP_OVERFLOW:
            result = Result.INFINITY;
            break;
        case FP_UNDERFLOW:
            result = Result.ZERO;
            break;
        case INT_OVERFLOW:
            result = Result.VERY_DIFFERENT;
            break;
        }
        
        return result;
    }

    private static Error result2Error(Result s)
    {
        Error error = null;
        
        switch (s) {
        case A_BIT_DIFFERENT:
            error = error.FP_ROUNDING;
            break;
        case INFINITY:
            error = error.FP_OVERFLOW;
            break;
        case ZERO:
            error = error.FP_UNDERFLOW;
            break;
        case VERY_DIFFERENT:
            error = error.INT_OVERFLOW;
            break;
        }
        
        return error;
    }

    public static void main(String[] args)
    {
        System.out.print("Known results = ");
        for (Result s : EnumSet.allOf(Result.class)) 
        {
            System.out.print(s + " ");
        }
        System.out.println();
        
        Result s = getEnumElement("Result", Result.class);
        System.out.println(s + " Errors in: " + result2Error(s));
    }
}
