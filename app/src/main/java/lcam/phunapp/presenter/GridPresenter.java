package lcam.phunapp.presenter;


import java.util.List;

import lcam.phunapp.model.Events;
import lcam.phunapp.services.ServiceGenerator;
import lcam.phunapp.view.MainActivity;

public class GridPresenter {
    private MainActivity view;
    private ServiceGenerator service;

    public GridPresenter(MainActivity view, ServiceGenerator service) {
        this.view = view;
        this.service = service;
    }

    public void loadData() {
        service.loadData();
    }

    public void updateView(List<Events> events) {
        view.updateList(events);
    }

    public void updateViewFailed() {
        view.loadFailed();
    }
}
