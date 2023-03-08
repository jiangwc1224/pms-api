package com.hyron.pms.common.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

@MappedSuperclass
public abstract class AbstractAggregateRoot<A extends AbstractAggregateRoot<A, ID>, ID extends Identifier>
		extends AbstractEntity<A, ID> implements AggregateRoot<A, ID> {

	@Transient
	private final transient List<Object> domainEvents = new ArrayList<>();

	/**
	 * Registers the given event object for publication on a call to a Spring Data
	 * repository's save methods.
	 * @param event must not be {@literal null}.
	 * @param <T> the type of event.
	 * @return the event that has been added.
	 * @see #andEvent(Object)
	 */
	protected <T> T registerEvent(T event) {
		Assert.notNull(event, "Domain event must not be null!");
		this.domainEvents.add(event);
		return event;
	}

	/**
	 * Clears all domain events currently held. Usually invoked by the infrastructure in
	 * place in Spring Data repositories.
	 */
	@AfterDomainEventPublication
	protected void clearDomainEvents() {
		this.domainEvents.clear();
	}

	/**
	 * All domain events currently captured by the aggregate.
	 * @return domain events.
	 */
	@DomainEvents
	protected Collection<Object> domainEvents() {
		return Collections.unmodifiableList(this.domainEvents);
	}

	/**
	 * Adds all events contained in the given aggregate to the current one.
	 * @param aggregate must not be {@literal null}.
	 * @return the aggregate
	 */
	@SuppressWarnings("unchecked")
	protected final A andEventsFrom(A aggregate) {
		Assert.notNull(aggregate, "Aggregate must not be null!");
		this.domainEvents.addAll(aggregate.domainEvents());
		return (A) this;
	}

	/**
	 * Adds the given event to the aggregate for later publication when calling a Spring
	 * Data repository's save-method. Does the same as {@link #registerEvent(Object)} but
	 * returns the aggregate instead of the event.
	 * @param event must not be {@literal null}.
	 * @return the aggregate
	 * @see #registerEvent(Object)
	 */
	@SuppressWarnings("unchecked")
	protected final A andEvent(Object event) {
		registerEvent(event);
		return (A) this;
	}

}
