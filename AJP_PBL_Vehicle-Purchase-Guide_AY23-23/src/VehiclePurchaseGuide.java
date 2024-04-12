import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VehiclePurchaseGuide extends JFrame implements ActionListener {
    private JComboBox<String> vehicleTypeComboBox;
    private JComboBox<String> carNameComboBox;
    private JTextArea resultTextArea;
    private String[][] carNames = {
        {"Toyota - Sedan, 30 MPG, $25,000", "Honda - Hatchback, 35 MPG, $28,000", "Ford - SUV, 25 MPG, $30,000", "Chevrolet - Sedan, 28 MPG, $27,500", "Nissan - Compact, 32 MPG, $26,500"},
        {"Harley-Davidson - Cruiser, 45 MPG, $15,000", "BMW - Sport, 40 MPG, $18,000", "Ducati - Naked, 50 MPG, $20,000", "Kawasaki - Touring, 35 MPG, $16,500", "Suzuki - Sportbike, 42 MPG, $17,800"},
        {"Ford F-150 - Crew Cab, 20 MPG, $35,000", "Chevrolet Silverado - Extended Cab, 22 MPG, $33,000", "Toyota Tacoma - Double Cab, 25 MPG, $32,000", "RAM 1500 - Quad Cab, 21 MPG, $34,500", "GMC Sierra - Regular Cab, 23 MPG, $31,000"}
    };
    private String[][] carSpecifications = {
        {"Toyota: Sedan, 30 MPG, $25,000", "Honda: Hatchback, 35 MPG, $28,000", "Ford: SUV, 25 MPG, $30,000", "Chevrolet: Sedan, 28 MPG, $27,500", "Nissan: Compact, 32 MPG, $26,500"},
        {"Harley-Davidson: Cruiser, 45 MPG, $15,000", "BMW: Sport, 40 MPG, $18,000", "Ducati: Naked, 50 MPG, $20,000", "Kawasaki: Touring, 35 MPG, $16,500", "Suzuki: Sportbike, 42 MPG, $17,800"},
        {"Ford F-150: Crew Cab, 20 MPG, $35,000", "Chevrolet Silverado: Extended Cab, 22 MPG, $33,000", "Toyota Tacoma: Double Cab, 25 MPG, $32,000", "RAM 1500: Quad Cab, 21 MPG, $34,500", "GMC Sierra: Regular Cab, 23 MPG, $31,000"}
    };

    public VehiclePurchaseGuide() {
        setTitle("Vehicle Purchase Guide");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel vehicleTypeLabel = new JLabel("Select Vehicle Type:");
        String[] vehicleTypes = {"Car", "Motorcycle", "Truck"};
        vehicleTypeComboBox = new JComboBox<>(vehicleTypes);
        vehicleTypeComboBox.addActionListener(this);

        JLabel carNameLabel = new JLabel("Select Car:");
        carNameComboBox = new JComboBox<>();
        carNameComboBox.addActionListener(this);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(vehicleTypeLabel);
        topPanel.add(vehicleTypeComboBox);
        topPanel.add(carNameLabel);
        topPanel.add(carNameComboBox);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vehicleTypeComboBox) {
            String selectedVehicleType = (String) vehicleTypeComboBox.getSelectedItem();
            if (selectedVehicleType != null) {
                int index = vehicleTypeComboBox.getSelectedIndex();
                carNameComboBox.removeAllItems();
                for (String car : carNames[index]) {
                    carNameComboBox.addItem(car.split(" - ")[0]);
                }
                resultTextArea.setText("");
            }
        } else if (e.getSource() == carNameComboBox) {
            String selectedCarName = (String) carNameComboBox.getSelectedItem();
            if (selectedCarName != null) {
                String selectedVehicleType = (String) vehicleTypeComboBox.getSelectedItem();
                int typeIndex = vehicleTypeComboBox.getSelectedIndex();
                for (int i = 0; i < carNames[typeIndex].length; i++) {
                    if (selectedCarName.equals(carNames[typeIndex][i].split(" - ")[0])) {
                        resultTextArea.setText("Details for " + selectedCarName + ":\n" + carSpecifications[typeIndex][i]);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VehiclePurchaseGuide gui = new VehiclePurchaseGuide();
            gui.setVisible(true);
        });
    }
}
