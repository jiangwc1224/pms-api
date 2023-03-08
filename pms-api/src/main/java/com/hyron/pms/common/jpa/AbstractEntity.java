package com.hyron.pms.common.jpa;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class AbstractEntity<T extends AggregateRoot<T, ?>, ID extends Identifier>
		implements Entity<T, ID>, Persistable<ID> {

	private @Transient boolean isNew = true;

	@CreatedBy
	@JsonIgnore
	private String initialCreateUserCode;

	@CreatedDate
	@JsonIgnore
	private LocalDateTime initialCreateDateAndTime;

	@LastModifiedBy
	@JsonIgnore
	private String lastUpdateUserCode;

	@LastModifiedDate
	@JsonIgnore
	private LocalDateTime lastUpdateDateAndTime;

	@NonNull
	public abstract ID getId();

	/**
	 * Returns whether the entity has the given identifier.
	 * @param id must not be {@literal null}.
	 * @return if {@literal true} the object has id.
	 */
	public boolean hasId(ID id) {
		Assert.notNull(id, "Identifier must not be null!");
		return getId().equals(id);
	}

	@JsonIgnore
	@Override
	public boolean isNew() {
		return this.isNew;
	}

	/**
	 * Marks the entity as not new not make sure we merge entity instances instead of
	 * trying to persist them.
	 */
	@PrePersist
	@PostLoad
	void markNotNew() {
		this.isNew = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !obj.getClass().equals(this.getClass())) {
			return false;
		}
		AbstractEntity<?, ?> that = (AbstractEntity<?, ?>) obj;
		return ObjectUtils.nullSafeEquals(this.getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

}
