package com.niki.presentation.dialogs.catalog.impl.user.create;

import com.niki.data.cache.database.datastores.SqlPositionDataStore;
import com.niki.data.repository.PositionRepositorySql;
import com.niki.domain.entities.Contact;
import com.niki.domain.entities.Position;
import com.niki.domain.interactors.catalog.user.UserContract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class CreateUserDialog extends JDialog implements CreateUserView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox positionComboBox;
    private JTextField phoneField;
    private JTextField emailField;

    private UserContract userContract;
    private CreateUserPresenter presenter;

    public CreateUserDialog() {
        setContentPane(contentPane);
        setModal(true);
        presenter = new CreateUserPresenterImpl(this, new PositionRepositorySql(new SqlPositionDataStore()));

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (loginField.getText().isEmpty() || passwordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Не заполненны обязательные поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            userContract = new UserContract(
                    0,
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    (Position) positionComboBox.getSelectedItem(),
                    new Contact(0,
                            phoneField.getText(),
                            emailField.getText(),
                            "",
                            ""
                    )
            );

            dispose();
        }
    }

    private void onCancel() {
        dispose();
    }

    public UserContract getUserContract() {
        return userContract;
    }

    @Override
    public void initViews(List<Position> positions) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        for (var position : positions)
            positionComboBox.addItem(position);
    }
}
