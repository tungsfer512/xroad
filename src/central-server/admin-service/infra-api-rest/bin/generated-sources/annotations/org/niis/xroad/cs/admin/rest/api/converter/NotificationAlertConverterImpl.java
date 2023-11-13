package org.niis.xroad.cs.admin.rest.api.converter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.AlertInfo;
import org.niis.xroad.cs.admin.rest.api.dto.AlertData;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:36+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
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
