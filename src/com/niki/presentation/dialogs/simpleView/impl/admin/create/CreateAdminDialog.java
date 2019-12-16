package com.niki.presentation.dialogs.simpleView.impl.admin.create;

import com.niki.data.cache.database.datastores.SqlPersonDataStore;
import com.niki.data.repository.PersonRepositorySql;
import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.admin.AdminContract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class CreateAdminDialog extends JDialog implements CreateAdminView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JComboBox positionComboBox;

    private AdminContract adminContract;
    private CreateAdminPresenter presenter;

    public CreateAdminDialog() {
        setContentPane(contentPane);
        setModal(true);
        presenter = new CreateAdminPresenterImpl(this, new PersonRepositorySql(new SqlPersonDataStore()));

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
            adminContract = new AdminContract(
                    0,
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    (Person) positionComboBox.getSelectedItem()
            );

            dispose();
        }
    }

    private void onCancel() {
        dispose();
    }

    public AdminContract getAdminContract() {
        return adminContract;
    }

    @Override
    public void initViews(List<Person> items) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        for (var position : items)
            positionComboBox.addItem(position);
    }
}
