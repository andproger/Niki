package com.niki.presentation.dialogs.intake;

import com.niki.data.cache.datastores.SqlProviderDataStore;
import com.niki.data.repository.ProviderRepositorySql;
import com.niki.domain.entities.Provider;

import javax.swing.*;
import java.util.ArrayList;

public class NewIntakeDialog extends JDialog implements NewIntakeView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;

    private NewIntakePresenter presenter;
    private ResultType resultType;
    private int providerId;

    public NewIntakeDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        presenter = new NewIntakePresenterImpl(this, new ProviderRepositorySql(new SqlProviderDataStore()));
    }

    public int getProviderId() {
        return providerId;
    }

    public ResultType getResultType() {
        return resultType;
    }

    @Override
    public void initViews(ArrayList<Provider> providers) {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        for (var provider : providers)
            comboBox1.addItem(provider);
    }

    private void onOK() {
        resultType = ResultType.OK;
        providerId = ((Provider) comboBox1.getSelectedItem()).getId();
        dispose();
    }

    private void onCancel() {
        resultType = ResultType.CANCEL;
        dispose();
    }

    public enum ResultType {
        OK,
        CANCEL
    }
}
