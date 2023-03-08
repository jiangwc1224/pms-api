package com.hyron.pms.common.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.server.ResponseStatusException;

import com.hyron.pms.common.jpa.AbstractEntity;

/**
 * Queryサポートクラス
 *
 * @param <E> エンティティ型
 * @author hyron xjiang.weichen
 */
public final class QuerySupport<E extends AbstractEntity<?, ?>> {

	/** エンティティクラス */
	private Class<E> entityClass;

	/** バージョン */
	private int version;

	/** 検索結果clone要否 */
	private boolean isCloned = false;

	/** バージョン取得ファンクション */
	private ToIntFunction<E> getVersionFunc;

	/** エンティティマネージャー */
	private EntityManager entityManager;

	/** 検索結果なしの場合、例外要否 */
	private boolean isNullable = false;

	/** null vo 転換要否 */
	private boolean isConverted = true;

	/**
	 * コンストラクタ
	 */
	private QuerySupport() {
	}

	/**
	 * コンストラクタ
	 * @param entityClass エンティティクラス
	 */
	private QuerySupport(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * QuerySupport作成
	 * @param <E> エンティティ型
	 * @param clazz エンティティクラス
	 * @return querySupport
	 */
	public static <E extends AbstractEntity<?, ?>> QuerySupport<E> forEntity(Class<E> clazz) {
		return new QuerySupport<>(clazz);
	}

	/**
	 * QuerySupport作成
	 * @param <E> エンティティ型
	 * @return querySupport
	 */
	public static <E extends AbstractEntity<?, ?>> QuerySupport<E> forEntitys() {
		return new QuerySupport<>();
	}

	/**
	 * QuerySupport作成
	 * @param <E> エンティティ型
	 * @return querySupport
	 */
	public static <E extends AbstractEntity<?, ?>> QuerySupport<E> forProjection() {
		return new QuerySupport<>();
	}

	/**
	 * 排他チェックチェック要
	 * @param version バージョン
	 * @param getVersionFunc バージョン取得ファンクション
	 * @return querySupport
	 */

	public QuerySupport<E> withVersionCheck(int version, ToIntFunction<E> getVersionFunc) {
		this.version = version;
		this.getVersionFunc = getVersionFunc;
		return this;
	}

	/**
	 * 検索結果なしの場合、例外要否
	 * @return querySupport
	 */
	public QuerySupport<E> nullable() {
		this.isNullable = true;
		return this;
	}

	/**
	 * コピー要
	 * @return querySupport
	 */
	public QuerySupport<E> cloned() {
		this.isCloned = true;
		return this;
	}

	/**
	 * NULL VO転換不要
	 * @return querySupport
	 */
	public QuerySupport<E> notConverted() {
		this.isConverted = false;
		return this;
	}

	/**
	 * 分離要
	 * @param entityManager エンティティマネージャー
	 * @return querySupport
	 */
	public QuerySupport<E> detach(EntityManager entityManager) {
		this.entityManager = entityManager;
		return this;
	}

	/**
	 * 検索処理
	 * @param <T> 検索結果型
	 * @param findSupplier 検索ファンクション
	 * @return 検索結果
	 */
	@SuppressWarnings("unchecked")
	public <T> T find(Supplier<Optional<T>> findSupplier) {

		T result = findSupplier.get().orElse(null);

		if (null == result) {
			if (!this.isNullable) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			else {
				return result;
			}
		}

		// Entityを分離する
		this.detach(result);

		if (result instanceof AbstractEntity<?, ?>) {
			E entityResult = (E) result;

			// 排他チェック
			if (null != this.getVersionFunc && this.getVersionFunc.applyAsInt(entityResult) != this.version) {
				throw new ObjectOptimisticLockingFailureException(this.entityClass, (entityResult).getId());
			}

			result = this.isCloned ? (T) DataCloneUtils.clone(entityResult, this.entityClass) : result;
		}

//		if (this.isConverted) {
//			// VOオブジェクト転換処理
//			TraversalHandler.create(SearchHitSupport.unwrapSearchHits(result))
//					.addProcessor(new NullVOConvertTraversalor()).process();
//		}

		return result;
	}

	/**
	 * JPAエンティティdetach処理
	 * @param target 処理対象
	 */
	private void detach(Object target) {

		if (null == this.entityManager) {
			return;
		}

		if (target instanceof Collection<?>) {
			Collection<?> colObj = (Collection<?>) target;
			Iterator<?> iter = colObj.iterator();

			boolean isEntity = false;
			while (iter.hasNext()) {
				Object obj = iter.next();
				if (isEntity || obj instanceof AbstractEntity<?, ?>) {
					this.entityManager.detach(obj);
					isEntity = true;
				}

				if (!isEntity) {
					break;
				}
			}
		}

		if (target instanceof AbstractEntity<?, ?>) {
			this.entityManager.detach(target);
		}
	}

}
