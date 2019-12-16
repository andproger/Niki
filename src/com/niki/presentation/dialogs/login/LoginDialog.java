package com.niki.presentation.dialogs.login;

import com.niki.data.services.ConnectionServiceImpl;
import com.niki.domain.interactors.login.LoginInteractorImpl;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginDialog extends JDialog implements LoginView {
    private ResultType result;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPasswordField passwordField;
    private JTextField serverField;
    private JTextField loginField;

    private LoginPresenter presenter;

    public LoginDialog() {
        setContentPane(contentPane);
        setModal(true);

        presenter = new LoginPresenterImpl(this,
                new LoginInteractorImpl(new ConnectionServiceImpl(new ConnectionSettingsJsonFileRepository())),
                new ConnectionSettingsJsonFileRepository()
        );
        initViews();

        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        presenter.onViewReady();
    }

    @Override
    public void renderServerText(String host) {
        serverField.setText(host);
    }

    @Override
    public void onSuccessLogin() {
        result = ResultType.SUCCESS_LOGIN;
        dispose();
    }

    @Override
    public void onWrongLogin() {
        showLoginError();
    }

    @Override
    public void onWrongConnection() {
        JOptionPane.showMessageDialog(this,
                "Не удалось подключится к серверу базы данных", "Ошибка подключения", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showProgress(boolean show) {
        passwordField.setEnabled(!show);
        serverField.setEnabled(!show);
        loginField.setEnabled(!show);
        buttonOK.setEnabled(!show);
    }

    private void showLoginError() {
        JOptionPane.showMessageDialog(this,
                "Не удалось войти. Проверьте имя пользователя и пароль", "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    private void initViews() {
        buttonOK.addActionListener(e -> presenter.onOkClicked(serverField.getText(), loginField.getText(), new String(passwordField.getPassword())));
        buttonCancel.addActionListener(e -> onCancel());
    }

    private void onCancel() {
        result = ResultType.CANCEL;
        dispose();
    }

    public ResultType getResult() {
        return result;
    }

    public enum ResultType {
        SUCCESS_LOGIN,
        CANCEL
    }
}
