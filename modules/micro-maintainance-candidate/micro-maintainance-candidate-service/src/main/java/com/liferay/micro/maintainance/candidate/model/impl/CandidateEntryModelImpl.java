/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.micro.maintainance.candidate.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.model.CandidateEntryModel;
import com.liferay.micro.maintainance.candidate.model.CandidateEntrySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CandidateEntry service. Represents a row in the &quot;Candidate_CandidateEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CandidateEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryImpl
 * @see CandidateEntry
 * @see CandidateEntryModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CandidateEntryModelImpl extends BaseModelImpl<CandidateEntry>
	implements CandidateEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate entry model instance should use the {@link CandidateEntry} interface instead.
	 */
	public static final String TABLE_NAME = "Candidate_CandidateEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "candidateEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "wikiPageId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("candidateEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("wikiPageId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table Candidate_CandidateEntry (uuid_ VARCHAR(75) null,candidateEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,wikiPageId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Candidate_CandidateEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY candidateEntry.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Candidate_CandidateEntry.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.candidate.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.micro.maintainance.candidate.model.CandidateEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.candidate.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.micro.maintainance.candidate.model.CandidateEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.candidate.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.micro.maintainance.candidate.model.CandidateEntry"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long USERID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long WIKIPAGEID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CandidateEntry toModel(CandidateEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CandidateEntry model = new CandidateEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setCandidateEntryId(soapModel.getCandidateEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setWikiPageId(soapModel.getWikiPageId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CandidateEntry> toModels(CandidateEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CandidateEntry> models = new ArrayList<CandidateEntry>(soapModels.length);

		for (CandidateEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.micro.maintainance.candidate.service.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.micro.maintainance.candidate.model.CandidateEntry"));

	public CandidateEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _candidateEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateEntryId", getCandidateEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("wikiPageId", getWikiPageId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateEntryId = (Long)attributes.get("candidateEntryId");

		if (candidateEntryId != null) {
			setCandidateEntryId(candidateEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long wikiPageId = (Long)attributes.get("wikiPageId");

		if (wikiPageId != null) {
			setWikiPageId(wikiPageId);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCandidateEntryId() {
		return _candidateEntryId;
	}

	@Override
	public void setCandidateEntryId(long candidateEntryId) {
		_candidateEntryId = candidateEntryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getWikiPageId() {
		return _wikiPageId;
	}

	@Override
	public void setWikiPageId(long wikiPageId) {
		_columnBitmask |= WIKIPAGEID_COLUMN_BITMASK;

		if (!_setOriginalWikiPageId) {
			_setOriginalWikiPageId = true;

			_originalWikiPageId = _wikiPageId;
		}

		_wikiPageId = wikiPageId;
	}

	public long getOriginalWikiPageId() {
		return _originalWikiPageId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CandidateEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CandidateEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CandidateEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CandidateEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CandidateEntryImpl candidateEntryImpl = new CandidateEntryImpl();

		candidateEntryImpl.setUuid(getUuid());
		candidateEntryImpl.setCandidateEntryId(getCandidateEntryId());
		candidateEntryImpl.setGroupId(getGroupId());
		candidateEntryImpl.setCompanyId(getCompanyId());
		candidateEntryImpl.setUserId(getUserId());
		candidateEntryImpl.setUserName(getUserName());
		candidateEntryImpl.setCreateDate(getCreateDate());
		candidateEntryImpl.setModifiedDate(getModifiedDate());
		candidateEntryImpl.setWikiPageId(getWikiPageId());

		candidateEntryImpl.resetOriginalValues();

		return candidateEntryImpl;
	}

	@Override
	public int compareTo(CandidateEntry candidateEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				candidateEntry.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateEntry)) {
			return false;
		}

		CandidateEntry candidateEntry = (CandidateEntry)obj;

		long primaryKey = candidateEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CandidateEntryModelImpl candidateEntryModelImpl = this;

		candidateEntryModelImpl._originalUuid = candidateEntryModelImpl._uuid;

		candidateEntryModelImpl._originalGroupId = candidateEntryModelImpl._groupId;

		candidateEntryModelImpl._setOriginalGroupId = false;

		candidateEntryModelImpl._originalCompanyId = candidateEntryModelImpl._companyId;

		candidateEntryModelImpl._setOriginalCompanyId = false;

		candidateEntryModelImpl._originalUserId = candidateEntryModelImpl._userId;

		candidateEntryModelImpl._setOriginalUserId = false;

		candidateEntryModelImpl._originalCreateDate = candidateEntryModelImpl._createDate;

		candidateEntryModelImpl._setModifiedDate = false;

		candidateEntryModelImpl._originalWikiPageId = candidateEntryModelImpl._wikiPageId;

		candidateEntryModelImpl._setOriginalWikiPageId = false;

		candidateEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CandidateEntry> toCacheModel() {
		CandidateEntryCacheModel candidateEntryCacheModel = new CandidateEntryCacheModel();

		candidateEntryCacheModel.uuid = getUuid();

		String uuid = candidateEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			candidateEntryCacheModel.uuid = null;
		}

		candidateEntryCacheModel.candidateEntryId = getCandidateEntryId();

		candidateEntryCacheModel.groupId = getGroupId();

		candidateEntryCacheModel.companyId = getCompanyId();

		candidateEntryCacheModel.userId = getUserId();

		candidateEntryCacheModel.userName = getUserName();

		String userName = candidateEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			candidateEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			candidateEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			candidateEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			candidateEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			candidateEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		candidateEntryCacheModel.wikiPageId = getWikiPageId();

		return candidateEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", candidateEntryId=");
		sb.append(getCandidateEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", wikiPageId=");
		sb.append(getWikiPageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.micro.maintainance.candidate.model.CandidateEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateEntryId</column-name><column-value><![CDATA[");
		sb.append(getCandidateEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wikiPageId</column-name><column-value><![CDATA[");
		sb.append(getWikiPageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CandidateEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CandidateEntry.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _candidateEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _originalCreateDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _wikiPageId;
	private long _originalWikiPageId;
	private boolean _setOriginalWikiPageId;
	private long _columnBitmask;
	private CandidateEntry _escapedModel;
}