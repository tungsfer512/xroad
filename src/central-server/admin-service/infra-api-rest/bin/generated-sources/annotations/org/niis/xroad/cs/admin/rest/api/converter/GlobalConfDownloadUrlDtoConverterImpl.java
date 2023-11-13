package org.niis.xroad.cs.admin.rest.api.converter;

import javax.annotation.processing.Generated;
import org.niis.xroad.cs.admin.api.dto.GlobalConfDownloadUrl;
import org.niis.xroad.cs.openapi.model.GlobalConfDownloadUrlDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T01:21:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
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
