import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class handles testing the base conversions
 */
public class ConversionTests {
    
    @Test
    public void decimalToBinary()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("1011100111", converter.convert("743", 10, 2));
    }

    @Test
    public void binaryToDecimal()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("743", converter.convert("1011100111", 2, 10));
    }

    @Test
    public void decimalToOctal()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("1364", converter.convert("756", 10, 8));
    }

    @Test
    public void octalToDecimal()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("756", converter.convert("1364", 8, 10));
    }

    @Test
    public void decimalToHex()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("1E0", converter.convert("480", 10, 16));
    }

    @Test
    public void hexToDecimal()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("480", converter.convert("1E0", 16, 10));
    }

    @Test
    public void hexToOctal()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("674", converter.convert("1BC", 16, 8));
    }

    @Test
    public void octalToHex()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("1BC", converter.convert("674", 8, 16));
    }

    @Test
    public void octalToBinary()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("111110", converter.convert("76", 8, 2));
    }

    @Test
    public void binaryToOctal()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("76", converter.convert("111110", 2, 8));
    }

    @Test
    public void binaryToHex()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("45", converter.convert("1000101", 2, 16));
    }

    @Test
    public void hexToBinary()
    {
        BaseConverter converter = new BaseConverter();
        assertEquals("1000101", converter.convert("45", 16, 2));
    }

}
