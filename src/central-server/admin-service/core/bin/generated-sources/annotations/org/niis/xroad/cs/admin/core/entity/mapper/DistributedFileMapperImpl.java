package org.niis.xroad.cs.admin.core.entity.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.domain.DistributedFile;
import org.niis.xroad.cs.admin.core.entity.DistributedFileEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class DistributedFileMapperImpl implements DistributedFileMapper {

    @Override
    public DistributedFile toTarget(DistributedFileEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DistributedFile distributedFile = new DistributedFile();

        distributedFile.setContentIdentifier( arg0.getContentIdentifier() );
        byte[] fileData = arg0.getFileData();
        if ( fileData != null ) {
            distributedFile.setFileData( Arrays.copyOf( fileData, fileData.length ) );
        }
        distributedFile.setFileName( arg0.getFileName() );
        distributedFile.setFileUpdatedAt( arg0.getFileUpdatedAt() );
        distributedFile.setHaNodeName( arg0.getHaNodeName() );
        distributedFile.setId( arg0.getId() );
        distributedFile.setVersion( arg0.getVersion() );

        return distributedFile;
    }
}
