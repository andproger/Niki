package com.niki.presentation.dialogs.catalog;

import com.niki.presentation.dialogs.catalog.impl.*;

import javax.swing.*;
import java.awt.event.*;

public class CatalogDialog extends JDialog implements CatalogView {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonAdd;
    private JButton deleteButton;
    private JTable table1;

    private CatalogPresenter presenter;

    public CatalogDialog(CatalogType type) {
        setContentPane(contentPane);
        setModal(true);

        setupPresenter(type);
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

    private void initViews() {
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
    }

    private void onOK() {
        // buttonAdd your code here
        dispose();
    }

    private void onCancel() {
        // buttonAdd your code here if necessary
        dispose();
    }

    private void setupPresenter(CatalogType type) {
        switch (type) {
            case USERS:
                presenter = new UsersPresenterImpl(this);
                break;

            case DRUGS:
                presenter = new DrugsPresenterImpl(this);
                break;

            case STARAGES:
                presenter = new StaragesPresenterImpl(this);
                break;

            case COUNTRIES:
                presenter = new CountriesPresenterImpl(this);
                break;

            case NEW_SALES:
                presenter = new NewSalesPresenterImpl(this);
                break;

            case POSITIONS:
                presenter = new PositionsPresenterImpl(this);
                break;

            case PROVIDERS:
                presenter = new ProvidersPresenterImpl(this);
                break;

            case DRUG_CLASS:
                presenter = new DrugClassPresenterImpl(this);
                break;

            case DRUG_FORMS:
                presenter = new DrugFormsPresenterImpl(this);
                break;

            case NEW_INTAKES:
                presenter = new NewIntakesPresenterImpl(this);
                break;

            case MANUFACTURES:
                presenter = new ManufacturesPresenterImpl(this);
                break;

            default:
                throw new IllegalStateException();
        }
    }

    public enum CatalogType {
        USERS,
        POSITIONS,
        COUNTRIES,
        MANUFACTURES,
        DRUGS,
        DRUG_FORMS,
        DRUG_CLASS,
        NEW_SALES,
        NEW_INTAKES,
        STARAGES,
        PROVIDERS
    }
}
