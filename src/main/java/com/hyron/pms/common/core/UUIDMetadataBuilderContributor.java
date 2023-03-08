package com.hyron.pms.common.core;

import java.util.UUID;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.type.UUIDCharType;

/**
 * Change the default UUID mapping "uuid-binary" to "uuid-char"
 *
 * @author hyron xjiang.weichen
 */
public class UUIDMetadataBuilderContributor implements MetadataBuilderContributor {

	@Override
	public void contribute(MetadataBuilder metadataBuilder) {
		metadataBuilder.applyBasicType(UUIDCharType.INSTANCE, UUID.class.getName());
	}

}
