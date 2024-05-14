package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.GlobalConfDownloadUrl;
import org.niis.xroad.cs.openapi.model.GlobalConfDownloadUrlDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:25:50+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class GlobalConfDownloadUrlDtoConverterImpl implements GlobalConfDownloadUrlDtoConverter {

    @Override
    public GlobalConfDownloadUrlDto convert(GlobalConfDownloadUrl globalConfDownloadUrl) {
        if ( globalConfDownloadUrl == null ) {
            return null;
        }

        GlobalConfDownloadUrlDto globalConfDownloadUrlDto = new GlobalConfDownloadUrlDto();

        globalConfDownloadUrlDto.url( globalConfDownloadUrl.getUrl() );

        return globalConfDownloadUrlDto;
    }
}
