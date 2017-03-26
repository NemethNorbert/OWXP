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

package com.liferay.micro.maintainance.analysis.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AnalysisEntry service. Represents a row in the &quot;Analysis_AnalysisEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntry
 * @see com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryImpl
 * @see com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl
 * @generated
 */
@ProviderType
public interface AnalysisEntryModel extends BaseModel<AnalysisEntry>,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a analysis entry model instance should use the {@link AnalysisEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this analysis entry.
	 *
	 * @return the primary key of this analysis entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this analysis entry.
	 *
	 * @param primaryKey the primary key of this analysis entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this analysis entry.
	 *
	 * @return the uuid of this analysis entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this analysis entry.
	 *
	 * @param uuid the uuid of this analysis entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the analysis entry ID of this analysis entry.
	 *
	 * @return the analysis entry ID of this analysis entry
	 */
	public long getAnalysisEntryId();

	/**
	 * Sets the analysis entry ID of this analysis entry.
	 *
	 * @param analysisEntryId the analysis entry ID of this analysis entry
	 */
	public void setAnalysisEntryId(long analysisEntryId);

	/**
	 * Returns the company ID of this analysis entry.
	 *
	 * @return the company ID of this analysis entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this analysis entry.
	 *
	 * @param companyId the company ID of this analysis entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this analysis entry.
	 *
	 * @return the user ID of this analysis entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this analysis entry.
	 *
	 * @param userId the user ID of this analysis entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this analysis entry.
	 *
	 * @return the user uuid of this analysis entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this analysis entry.
	 *
	 * @param userUuid the user uuid of this analysis entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this analysis entry.
	 *
	 * @return the user name of this analysis entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this analysis entry.
	 *
	 * @param userName the user name of this analysis entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this analysis entry.
	 *
	 * @return the create date of this analysis entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this analysis entry.
	 *
	 * @param createDate the create date of this analysis entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this analysis entry.
	 *
	 * @return the modified date of this analysis entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this analysis entry.
	 *
	 * @param modifiedDate the modified date of this analysis entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the candidate maintenance ID of this analysis entry.
	 *
	 * @return the candidate maintenance ID of this analysis entry
	 */
	public long getCandidateMaintenanceId();

	/**
	 * Sets the candidate maintenance ID of this analysis entry.
	 *
	 * @param candidateMaintenanceId the candidate maintenance ID of this analysis entry
	 */
	public void setCandidateMaintenanceId(long candidateMaintenanceId);

	/**
	 * Returns the analysis data of this analysis entry.
	 *
	 * @return the analysis data of this analysis entry
	 */
	@AutoEscape
	public String getAnalysisData();

	/**
	 * Sets the analysis data of this analysis entry.
	 *
	 * @param analysisData the analysis data of this analysis entry
	 */
	public void setAnalysisData(String analysisData);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(AnalysisEntry analysisEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AnalysisEntry> toCacheModel();

	@Override
	public AnalysisEntry toEscapedModel();

	@Override
	public AnalysisEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}