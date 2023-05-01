import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * This class handles converting between bases
 */
public class BaseConverter {

    /**
     * Constructor
     */
    public BaseConverter()
    {
        // initialize conversion factors
        initConversionValues();
    }

    /**
     * This function converts a value with a given base to a new base
     * @param value initial value
     * @param current_base initial base
     * @param new_base base to convert to
     * @return String representation of converted value
     */
    public String convert(String value, int current_base, int new_base)
    {
        // if we are converting to base we are already in, no conversion necessary
        if (current_base == new_base)
        {
            return value;
        }

        // convert to decimal
        int decimal_value = toDecimal(value, current_base);

        // convert to new base from decimal
        return fromDecimal(decimal_value, new_base);
    }

    /**
     * Converts a given value, base to decimal
     * @param value initial value
     * @param current_base initial base
     * @return decimal form of initial value
     */
    private int toDecimal(String value, int current_base)
    {
        // split string into list of individual characters and reverse
        List<String> number_list = Arrays.asList(value.split(""));
        Collections.reverse(number_list);

        int decimal_value = 0;

        // convert to decimal if not already
        if (current_base != 10)
        {
            // add each decimal digit
            for (int i = 0; i < number_list.size(); i++)
            {
                decimal_value += (base_conversions.get(number_list.get(i)) * Math.pow(current_base, i));
            }
        }
        else
        {
            // if already in decimal we can directly go from string to int
            decimal_value = Integer.parseInt(value);
        }

        return decimal_value;
    }

    /**
     * Converts a decimal value to a new base
     * @param decimal_val decimal value
     * @param new_base base to convert to
     * @return converted value from decimal to new base
     */
    public String fromDecimal(int decimal_val, int new_base)
    {
        String new_value = "";

        // if we are going to decimal, just return the string value of the current number
        if (new_base == 10)
        {
            return String.valueOf(decimal_val);
        }

        int pow = 0;

        // find the max base power that can divide
        while (decimal_val / Math.pow(new_base, pow) >= 1)
        {
            pow+=1;
        }

        // loop for each power of base
        for (int i = pow-1; i >=0 ; i--)
        {
            int power = (int)Math.pow(new_base, i);
            int factor = decimal_val / power;

            // find the base conversion factor
            String key = "";
            for (String k : base_conversions.keySet())
            {
                if (base_conversions.get(k) == factor)
                {
                    key = k;
                    break;
                }
            }
            new_value += key;
            decimal_val = decimal_val % power;
        }
        return new_value;
    }

    /**
     * checks validity of input
     * @param input input value
     * @param base input current base
     * @param new_base input new base
     * @return true if valid, false otherwise
     */
    public boolean checkValidity(String input, int base, int new_base)
    {
        // check that we have valid base
        if (base < 2 || base > 32)
        {
            return false;
        }

        // check that our input is actually possible to achieve with current base
        List<String> digits = Arrays.asList(input.split(""));

        for (String digit : digits)
        {
            // if any of the digits is greater than the base, it is invalid
            if (base_conversions.get(digit) >= base)
            {
                return false;
            }

            // if any of the digits is not in the conversions list, it is invalid
            if (!base_conversions.containsKey(digit))
            {
                return false;
            }
        }

        // if all checks passed return true
        return true;
    }

    /**
     * This function initializes the conversion values for all bases
     */
    private void initConversionValues()
    {
        // initialize the conversion factors
        base_conversions = new HashMap<>();
        base_conversions.put("0", 0);
        base_conversions.put("1", 1);
        base_conversions.put("2", 2);
        base_conversions.put("3", 3);
        base_conversions.put("4", 4);
        base_conversions.put("5", 5);
        base_conversions.put("6", 6);
        base_conversions.put("7", 7);
        base_conversions.put("8", 8);
        base_conversions.put("9", 9);
        base_conversions.put("A", 10);
        base_conversions.put("B", 11);
        base_conversions.put("C", 12);
        base_conversions.put("D", 13);
        base_conversions.put("E", 14);
        base_conversions.put("F", 15);
        base_conversions.put("G", 16);
        base_conversions.put("H", 17);
        base_conversions.put("I", 18);
        base_conversions.put("J", 19);
        base_conversions.put("K", 20);
        base_conversions.put("L", 21);
        base_conversions.put("M", 22);
        base_conversions.put("N", 23);
        base_conversions.put("O", 24);
        base_conversions.put("P", 25);
        base_conversions.put("Q", 26);
        base_conversions.put("R", 27);
        base_conversions.put("S", 28);
        base_conversions.put("T", 29);
        base_conversions.put("U", 30);
        base_conversions.put("V", 31);
    }

    private HashMap<String, Integer> base_conversions;
}
