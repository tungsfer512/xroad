package org.niis.xroad.cs.admin.rest.api.converter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.AlertInfo;
import org.niis.xroad.cs.admin.rest.api.dto.AlertData;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:50+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class NotificationAlertConverterImpl implements NotificationAlertConverter {

    @Override
    public AlertData toTarget(AlertInfo arg0) {
        if ( arg0 == null ) {
            return null;
        }

        AlertData alertData = new AlertData();

        alertData.setErrorCode( arg0.getErrorCode() );
        List<Object> list = arg0.getMetadata();
        if ( list != null ) {
            alertData.setMetadata( new ArrayList<Object>( list ) );
        }

        return alertData;
    }
}
