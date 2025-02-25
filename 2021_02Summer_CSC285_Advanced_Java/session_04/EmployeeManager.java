//package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class EmployeeManager extends JFrame {
    private static Logger log = Logger.getLogger(EmployeeManager.class.getName());
    // private static Logger log = Logger.getLogger("InfoLogging");

    private EmployeeDAO employeeDAO;

    private JTextField idField;
    private JTextField nameField;
    private JTextField positionField;
    private JTextField addressField;
    private JTextField phoneNumberField;
    private JTextField hoursField;
    private JTextField rateField;
    private JTextField sexField;
    private JTextField ageField;
    private JTextField activeField;
    private JTextField ssnField;
    private JTextField grossPayField;
    private JTextField stateTaxField;
    private JTextField federalTaxField;
    private JTextField netPayField;

    private JList employeeList;
    private DefaultListModel employeeListModel;

    private JButton saveButton;

    private ArrayList<JTextField> editableTextFields;
    private ArrayList<JTextField> allTextFields;

    public EmployeeManager() {
        super("Employee Manager");
        System.out.println(EmployeeManager.class.getName());


        try {
            employeeDAO = new EmployeeDAO();
        } catch (Exception e) {
            handleFatalException(e);
        }

        editableTextFields = new ArrayList<JTextField>();
        allTextFields = new ArrayList<JTextField>();

        //center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(14, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        //the ID field does not get shown, but it gets used by this class
        idField = new JTextField("-1");                         //   YOU DO NOT DISPLAY THE idField
        nameField = addLabelAndTextField("Name", 100, true, centerPanel);
        positionField = addLabelAndTextField("Position", 100, true, centerPanel);
        addressField = addLabelAndTextField("Address", 100, true, centerPanel);
        phoneNumberField = addLabelAndTextField("Phone", 12, true, centerPanel);
        hoursField = addLabelAndTextField("Hours", 10, true, centerPanel);
        rateField = addLabelAndTextField("Rate", 10, true, centerPanel);
        sexField = addLabelAndTextField("Sex", 10, true, centerPanel);
        ageField = addLabelAndTextField("Age", 10, true, centerPanel);
        activeField = addLabelAndTextField("Active", 10, true, centerPanel);
        ssnField = addLabelAndTextField("SSN", 20, true, centerPanel);
        grossPayField = addLabelAndTextField("Gross Pay", 100, false, centerPanel);
        stateTaxField = addLabelAndTextField("State Tax", 100, false, centerPanel);
        federalTaxField = addLabelAndTextField("Federal Tax", 100, false, centerPanel);
        netPayField = addLabelAndTextField("Net Pay", 100, false, centerPanel);

        add(centerPanel, BorderLayout.CENTER);

        //east panel
        JPanel eastPanel = new JPanel(new GridLayout(2, 1));

        employeeListModel = new DefaultListModel();
        employeeList = new JList(employeeListModel);
        employeeList.setLayoutOrientation(JList.VERTICAL_WRAP);
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            refreshEmployeeList();
        } catch (Exception e) {
            handleFatalException(e);
        }
        eastPanel.add(employeeList);

        JPanel eastPanelBottom = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        JButton viewButton = new JButton("View");
        viewButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        viewEmployee();
                    }
                }
        );
        eastPanelBottom.add(viewButton, constraints);

        constraints.gridy = 1;
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        editEmployee();
                    }
                }
        );
        eastPanelBottom.add(editButton, constraints);

        constraints.gridy = 2;
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        deleteEmployee();
                    }
                }
        );
        eastPanelBottom.add(deleteButton, constraints);

        eastPanel.add(eastPanelBottom);
        add(eastPanel, BorderLayout.EAST);

        //south panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));

        JButton newButton = new JButton("New");
        newButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        clearTextFields();
                        setFieldsEditable(true);
                        saveButton.setEnabled(true);
                    }
                }
        );
        southPanel.add(newButton);

        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try {
                            saveEmployee();
                        } catch (Exception e) {
                            handleFatalException(e);
                        }
                    }
                }
        );
        southPanel.add(saveButton);

        add(southPanel, BorderLayout.SOUTH);

        //show the UI
        setVisible(true);
    }

    private void deleteEmployee() {
        Employee employee = getSelectedEmployee();
        if (employee != null) {
            int result = JOptionPane.showOptionDialog(this, "Are you sure you want to delete  " + employee + "?", "Confirm Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (result == JOptionPane.YES_OPTION) {
                try {
                    employeeDAO.deleteEmployee(employee);
                    refreshEmployeeList();
                } catch (Exception e) {
                    handleFatalException(e);
                }

                if (Integer.parseInt(idField.getText()) == employee.getId()) {
                    clearTextFields();
                    setFieldsEditable(false);
                    saveButton.setEnabled(false);
                }
            }
        }
    }

    private void editEmployee() {
        Employee employee = getSelectedEmployee();
        if (employee != null) {
            clearTextFields();
            setFieldsEditable(true);
            populateFieldsFromEmployee(employee);
            saveButton.setEnabled(true);
        }
    }

    private void viewEmployee() {
        Employee employee = getSelectedEmployee();
        if (employee != null) {
            clearTextFields();
            setFieldsEditable(false);
            populateFieldsFromEmployee(employee);
            saveButton.setEnabled(false);
        }
    }

    private Employee getSelectedEmployee() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "Please select an employee from the list.", "ERROR", JOptionPane.PLAIN_MESSAGE);
            return null;
        }

        return (Employee) employeeListModel.getElementAt(selectedIndex);
    }

    private void saveEmployee() throws Exception {
        Employee employee = populateEmployeeFromFields();
        if (employee != null) {
            //if the ID is -1, this is a new employee - otherwise it's an update
            if (employee.getId() != -1) {
                employeeDAO.updateEmployee(employee);
            } else {
                employeeDAO.addEmployee(employee);
            }

            clearTextFields();
            setFieldsEditable(false);
            refreshEmployeeList();
            saveButton.setEnabled(false);
        }
    }

    private void refreshEmployeeList() throws Exception {
        List<Employee> employees = employeeDAO.getAllEmployees();

        employeeListModel.clear();

        for (Employee employee : employees) {
            log.fine("Adding employee to list: " + employee);
            employeeListModel.addElement(employee);
        }
    }

    private void setFieldsEditable(boolean b) {
        for (JTextField textField : editableTextFields) {
            textField.setEditable(b);
        }
    }

    protected void clearTextFields() {
        for (JTextField textField : allTextFields) {
            textField.setText("");
        }

        idField.setText("-1");
    }

    private void handleFatalException(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
        System.exit(1);
    }

    private Employee populateEmployeeFromFields() {
        try {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(idField.getText()));
            employee.setName(nameField.getText());
            employee.setPosition(positionField.getText());
            employee.setAddress(addressField.getText());
            employee.setPhoneNumber(phoneNumberField.getText());
            employee.setHours(getDoubleValue(hoursField.getText(), "Hours"));
            employee.setRate(getDoubleValue(rateField.getText(), "Rate"));

            String sex = sexField.getText();
            if (sex.length() > 0) {
                employee.setSex(sex.charAt(0));
            } else {
                employee.setSex(' ');
            }

            employee.setAge((int) getDoubleValue(ageField.getText(), "Age"));
            employee.setActive(Boolean.valueOf(activeField.getText()));
            employee.setSSN(ssnField.getText());


            return employee;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, nfe.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
            return null;
        }
    }

    private void populateFieldsFromEmployee(Employee employee) {
        NumberFormat dollarsFormat = new DecimalFormat("$0.00");
        NumberFormat hoursFormat = new DecimalFormat("0.00");

        idField.setText(String.valueOf(employee.getId()));
        nameField.setText(employee.getName());
        positionField.setText(employee.getPosition());
        addressField.setText(employee.getAddress());
        phoneNumberField.setText(employee.getPhoneNumber());
        hoursField.setText(hoursFormat.format(employee.getHours()));
        rateField.setText(hoursFormat.format(employee.getRate()));
        sexField.setText(String.valueOf(employee.getSex()));
        ageField.setText(String.valueOf(employee.getAge()));
        activeField.setText(String.valueOf(employee.isActive()));
        ssnField.setText(employee.getSSN());
        grossPayField.setText(dollarsFormat.format(employee.calculateGrossPay()));
        federalTaxField.setText(dollarsFormat.format(employee.calculateFederalTax()));
        stateTaxField.setText(dollarsFormat.format(employee.calculateStateTax()));
        netPayField.setText(dollarsFormat.format(employee.calculateNetPay()));
    }

    private double getDoubleValue(String input, String fieldName) {
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " must contain a numeric value!");
        }
    }

    //addLabelAndTextField("Name", 100, true, centerPanel);
    private JTextField addLabelAndTextField(String label, int fieldLength, boolean textFieldIsEditable, JPanel panel) {
        panel.add(new JLabel(label));

        JTextField textField = new JTextField(fieldLength);
        textField.setEditable(false);
        panel.add(textField);

        if (textFieldIsEditable)
            editableTextFields.add(textField);

        allTextFields.add(textField);

        return textField;
    }

    public static void main(String[] args) {
        Level enabledLoggingLevel = Level.FINEST;

        Logger.getLogger("finalproject").setLevel(enabledLoggingLevel);

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setLevel(enabledLoggingLevel);
        }

        new EmployeeManager();
    }
}