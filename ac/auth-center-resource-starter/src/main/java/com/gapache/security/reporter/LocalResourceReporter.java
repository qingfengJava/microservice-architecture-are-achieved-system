package com.gapache.security.reporter;

import com.gapache.security.interfaces.ResourceReporter;
import com.gapache.security.interfaces.ResourceReceiver;
import com.gapache.security.model.ResourceReportDTO;

public class LocalResourceReporter implements ResourceReporter {

    private final ResourceReceiver resourceReceiver;

    public LocalResourceReporter(ResourceReceiver resourceReceiver) {
        this.resourceReceiver = resourceReceiver;
    }

    @Override
    public boolean reporting(ResourceReportDTO resourceReportDTO) {
        return resourceReceiver.receiveReportData(resourceReportDTO);
    }
}
