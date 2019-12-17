package com.niki.presentation.dialogs.simpleView;

import com.niki.data.cache.database.datastores.*;
import com.niki.data.repository.*;
import com.niki.domain.interactors.simpleView.admin.AdminInteractorImpl;
import com.niki.domain.interactors.simpleView.brand.BusBrandInteractorImpl;
import com.niki.domain.interactors.simpleView.bus.BusInteractorImpl;
import com.niki.domain.interactors.simpleView.color.BusColorInteractorImpl;
import com.niki.domain.interactors.simpleView.driver.DriverInteractorImpl;
import com.niki.domain.interactors.simpleView.flight.FlightInteractorImpl;
import com.niki.domain.interactors.simpleView.model.BusModelModelInteractorImpl;
import com.niki.domain.interactors.simpleView.person.PersonInteractorImpl;
import com.niki.domain.interactors.simpleView.route.RouteInteractorImpl;
import com.niki.domain.interactors.simpleView.station.StationInteractorImpl;
import com.niki.presentation.dialogs.simpleView.impl.admin.AdminPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.brand.BusBrandPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.bus.BusPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.color.BusColorPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.driver.DriverPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.flight.FlightPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.model.BusModelPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.person.PersonPresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.route.RoutePresenterImpl;
import com.niki.presentation.dialogs.simpleView.impl.station.StationPresenterImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CatalogDialog extends JDialog implements CatalogView {
    private JPanel contentPane;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JTable table1;

    private CatalogPresenter presenter;

    public CatalogDialog(CatalogType type) {
        setContentPane(contentPane);
        setModal(true);

        getRootPane().setDefaultButton(buttonSave);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        setupPresenter(type);
        initViews();

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initViews() {
        buttonCancel.addActionListener(e -> onCancel());

        buttonSave.addActionListener(e -> presenter.onSaveClicked());
        buttonAdd.addActionListener(e -> presenter.onAddClicked());
        buttonDelete.addActionListener(e -> {
            var viewRows = table1.getSelectedRows();
            var rows = new int[viewRows.length];

            for (int i = 0; i < viewRows.length; i++)
                rows[i] = table1.convertRowIndexToModel(viewRows[i]);

            presenter.onDeleteClicked(rows);
        });

        table1.setAutoCreateRowSorter(true);
    }

    private void onCancel() {
        dispose();
    }

    @Override
    public void setTableModel(AbstractTableModel tableModel) {
        table1.setModel(tableModel);
    }

    @Override
    public void setTableCellEditor(Class aClass, TableCellEditor cellEditor) {
        table1.setDefaultEditor(aClass, cellEditor);
    }

    @Override
    public void setTableCellRenderer(Class aClass, TableCellRenderer cellRenderer) {
        table1.setDefaultRenderer(aClass, cellRenderer);
    }

    @Override
    public void setControlsVisible(boolean isVisible) {
        buttonSave.setVisible(isVisible);
        buttonAdd.setVisible(isVisible);
        buttonDelete.setVisible(isVisible);
    }

    private void setupPresenter(CatalogType type) {
        switch (type) {
            case ADMIN:
                presenter = new AdminPresenterImpl(this, new AdminInteractorImpl(
                        new AdminRepositorySql(new SqlAdminDataStore()),
                        new PersonRepositorySql(new SqlPersonDataStore())
                ));
                break;
            case BUS:
                presenter = new BusPresenterImpl(this, new BusInteractorImpl(
                        new BusRepositorySql(new SqlBusDataStore()),
                        new BusColorRepositorySql(new SqlBusColorDataStore()),
                        new BusModelRepositorySql(new SqlBusModelDataStore())
                ));
                break;
            case PERSON:
                presenter = new PersonPresenterImpl(this, new PersonInteractorImpl(
                        new PersonRepositorySql(new SqlPersonDataStore())
                ));
                break;
            case BRAND:
                presenter= new BusBrandPresenterImpl(this, new BusBrandInteractorImpl(
                        new BusBrandRepositorySql(new SqlBusBrandDataStore())
                ));
                break;
            case COLOR:
                presenter = new BusColorPresenterImpl(this, new BusColorInteractorImpl(
                        new BusColorRepositorySql(new SqlBusColorDataStore())
                ));
                break;
            case MODEL:
                presenter = new BusModelPresenterImpl(this, new BusModelModelInteractorImpl(
                        new BusModelRepositorySql(new SqlBusModelDataStore()),
                        new BusBrandRepositorySql(new SqlBusBrandDataStore())
                ));
                break;
            case DRIVER:
                presenter = new DriverPresenterImpl(this, new DriverInteractorImpl(
                        new DriverRepositorySql(new SqlDriverDataStore()),
                        new PersonRepositorySql(new SqlPersonDataStore())
                ));
                break;
            case STATION:
                presenter = new StationPresenterImpl(this, new StationInteractorImpl(
                        new StationRepositorySql(new SqlStationDataStore())
                ));
                break;
            case ROUTE:
                presenter = new RoutePresenterImpl(this, new RouteInteractorImpl(
                        new RouteRepositorySql(new SqlRouteDataStore()),
                        new StationRepositorySql(new SqlStationDataStore())
                ));
                break;
            case FLIGHT:
                presenter = new FlightPresenterImpl(this, new FlightInteractorImpl(
                        new FlightRepositorySql(new SqlFlightDataStore()),
                        new RouteRepositorySql(new SqlRouteDataStore()),
                        new FlightDriverRepositorySql(new SqlFlightDriverDataStore()),
                        new DriverRepositorySql(new SqlDriverDataStore()),
                        new BusRepositorySql(new SqlBusDataStore())
                ));
                break;


            default:
                throw new IllegalStateException();
        }
    }

    public enum CatalogType {
        ADMIN,
        BRAND,
        BUS,
        PERSON,
        COLOR,
        MODEL,
        DRIVER,
        STATION,
        ROUTE,
        FLIGHT,
    }
}
