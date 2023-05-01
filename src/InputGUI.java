import javax.swing.*;

/**
 * This class handles the GUI used to obtain user input
 */
public class InputGUI {

    /**
     * Driver code
     * @param args command line arguments
     */
    public static void main(String args[])
    {
        boolean exit = false;

        // we will loop until user exits the app
        BaseConverter converter = new BaseConverter();
        while (!exit)
        {
            // these text fields obtain input
            JTextField original_value = new JTextField(5);
            JTextField current_base = new JTextField(2);
            JTextField new_base = new JTextField(2);

            // add the input fields to our JPanel
            JPanel input_panel = new JPanel();
            input_panel.add(new JLabel("Enter Value:"));
            input_panel.add(original_value);
            input_panel.add(new JLabel("Enter Current Base:"));
            input_panel.add(current_base);
            input_panel.add(new JLabel("Enter New Base"));
            input_panel.add(new_base);

            int inputs = JOptionPane.showConfirmDialog(null, input_panel,
                    "Base Converter", JOptionPane.OK_CANCEL_OPTION);
            if (inputs == JOptionPane.OK_OPTION) {

                // get inputs
                String current_value_input = original_value.getText();
                String current_base_input = current_base.getText();
                String new_base_input = new_base.getText();

                // convert to new base if something has been entered and has positive integer criteria
                if (current_value_input.length() > 0 && current_base_input.length() > 0 && new_base_input.length() > 0
                && current_value_input.indexOf('-')==-1 && current_value_input.indexOf('.') == -1 &&
                        converter.checkValidity(current_value_input, Integer.parseInt(current_base_input),
                                Integer.parseInt(new_base_input)))
                {
                    String output = converter.convert(current_value_input, Integer.parseInt(current_base_input), Integer.parseInt(new_base_input));

                    // display result in a JOptionPane message dialog
                    JOptionPane.showMessageDialog(null, "The converted value is: " + output,
                            "Converting from base " + current_base_input + " to base "+new_base_input, JOptionPane.INFORMATION_MESSAGE);

                    // ask user if they want to do another conversion
                    if (JOptionPane.showConfirmDialog(null, "Perform another conversion?",
                            "Converter", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
                    {
                        exit = true;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid input. Note: Input must be a positive, valid integer.",
                            "Invalid input", JOptionPane.ERROR_MESSAGE);

                }
            }
            // if user exits
            else
            {
                exit = true;
            }
        }
    }


}
