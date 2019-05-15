package com.niki.presentation.dialogs.login;

import com.niki.domain.interactors.login.LoginInteractorImpl;
import com.niki.presentation.dialogs.main.MainDialog;

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

        presenter = new LoginPresenterImpl(this, new LoginInteractorImpl());
        initViews();

        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    @Override
    public void onSuccessLogin() {
        result = ResultType.SUCCESS_LOGIN;
        dispose();
    }

    @Override
    public void onWrongLogin() {
        //TODO:
    }

    private void openMainDialog() {
        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void initViews() {
        buttonOK.addActionListener(e -> presenter.onOkClicked("server-1", "login-2", "password-3"));
        buttonCancel.addActionListener(e -> onCancel());
    }

    private void onCancel() {
        result = ResultType.CANCEL;
        // add your code here if necessary
        dispose();
    }

    public ResultType getResult() {
        return result;
    }

    public enum ResultType{
        SUCCESS_LOGIN,
        CANCEL
    }
}
