//Ismael Cutanda Fernández
package PaqGroupName;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainFrame {
    private JTextField idTextField;
    private JTextField weightTextField;
    private JPanel mainPanel;
    private JLabel idNumLabel;
    private JLabel weightLabel;
    private JLabel descLabel;
    private JTextArea descTextArea;
    private JLabel remCompLabel;
    private JTextField remCompTextField;
    private JLabel recCompLabel;
    private JTextField recCompTextField;
    private JButton pileButton;
    private JButton unpileButton;
    private JLabel operationsLabel;
    private JButton showDescButton;
    private JTextArea contDescTextArea;
    private JButton numContButton;
    private JComboBox<String> fromCountryComboBox;
    private JLabel countryLabel;
    private JLabel priorityLabel;
    private JLabel stateLabel;
    private JLabel customInspLabel;
    private JComboBox<String> countryComboBox;
    private JLabel companylogoLabel;
    private JRadioButton a1RadioButton;
    private JTextArea stateTextArea;
    private JCheckBox customInspCheckBox;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JTextField unpileFromTextField;
    private JTextField fromCountryCountText;
    private JTextArea textArea1;
    private JRadioButton hub1RadioButton;
    private JRadioButton hub2RadioButton;
    private JRadioButton hub3RadioButton;
    private JLabel imageLabel;
    Port port = new Port();
    int k = 1;
    public MainFrame() {
        ImageIcon imageIcon = new ImageIcon("unnamed.png");
        imageLabel = new JLabel(imageIcon);
        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container cont = new Container();
                try {
                    cont.setID(Integer.parseInt(idTextField.getText()));
                    cont.setWeight(Integer.parseInt(weightTextField.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter valid integer values for ID and weight.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int which = 1;
                cont.setID(Integer.parseInt(idTextField.getText()));
                cont.setWeight(Integer.parseInt(weightTextField.getText()));
                cont.setSender(remCompTextField.getText());
                cont.setReceiver(recCompTextField.getText());
                if (a1RadioButton.isSelected()){
                    cont.setPriority(1);
                }
                if (a2RadioButton.isSelected()){
                    cont.setPriority(2);
                }
                if (a3RadioButton.isSelected()){
                    cont.setPriority(3);
                }
                cont.setDescription(descTextArea.getText());
                cont.setCountry((String) countryComboBox.getSelectedItem());
                cont.setInspected(customInspCheckBox.isSelected());
                k = 1;
                if (port.hub1.stackCont(cont) == -1){
                    which+=1;
                    k = 2;
                    if (port.hub2.stackCont(cont)==-1){
                        which+=1;
                        k = 3;
                        if (port.hub3.stackCont(cont)==-1){
                            which+=1;
                            descTextArea.setText("Columns are full");
                        }
                    }
                }
                if (which == 1){
                    stateTextArea.setText("HUB 1\n"+port.hub1.hubToString());
                }
                if (which == 2){
                    stateTextArea.setText("HUB 2\n"+port.hub2.hubToString());
                }
                if (which == 3){
                    stateTextArea.setText("HUB 3\n"+port.hub3.hubToString());
                }
                idTextField.setText(""+(cont.ID+1));
            }
        });
        showDescButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!port.hub1.dataContID(Integer.parseInt(textArea1.getText())).equals("Not found")){
                    contDescTextArea.setText(port.hub1.dataContID(Integer.parseInt(textArea1.getText())));
                }
                if (!port.hub2.dataContID(Integer.parseInt(textArea1.getText())).equals("Not found")){
                    contDescTextArea.setText(port.hub2.dataContID(Integer.parseInt(textArea1.getText())));
                }
                if (!port.hub3.dataContID(Integer.parseInt(textArea1.getText())).equals("Not found")){
                    contDescTextArea.setText(port.hub3.dataContID(Integer.parseInt(textArea1.getText())));
                }
            }
        });
        unpileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (k == 1){
                    port.hub1.removeContFrom(Integer.parseInt(unpileFromTextField.getText()));
                    stateTextArea.setText("HUB 1\n"+port.hub1.hubToString());
                }
                if (k == 2){
                    port.hub2.removeContFrom(Integer.parseInt(unpileFromTextField.getText()));
                    stateTextArea.setText("HUB 2\n"+port.hub2.hubToString());
                }
                if (k == 3){
                    port.hub3.removeContFrom(Integer.parseInt(unpileFromTextField.getText()));
                    stateTextArea.setText("HUB 3\n"+port.hub3.hubToString());
                }
            }
        });
        numContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sum = 0;
                sum += port.hub1.howManyFrom((String) fromCountryComboBox.getSelectedItem());
                sum += port.hub2.howManyFrom((String) fromCountryComboBox.getSelectedItem());
                sum += port.hub3.howManyFrom((String) fromCountryComboBox.getSelectedItem());
                String setup = ""+sum;
                fromCountryCountText.setText(setup);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub1RadioButton.isSelected()){
                    k = 1;
                    stateTextArea.setText("HUB 1\n"+port.hub1.hubToString());
                }
                if (hub2RadioButton.isSelected()){
                    k = 2;
                    stateTextArea.setText("HUB 2\n"+port.hub2.hubToString());
                }
                if (hub3RadioButton.isSelected()){
                    k = 3;
                    stateTextArea.setText("HUB 3\n"+port.hub3.hubToString());
                }
            }
        };
        hub1RadioButton.addActionListener(listener);
        hub2RadioButton.addActionListener(listener);
        hub3RadioButton.addActionListener(listener);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }}