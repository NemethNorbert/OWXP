<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="owxp_subscribe_OWXPSubscribePortlet.caption"/></b>
</p>

<div class="subscribe">
	<c:choose>
		<c:when test="<%= SubscriptionLocalServiceUtil.isSubscribed(company.getCompanyId(), user.getUserId(), User.class.getName(), themeDisplay.getLayout().getUserId()) %>">
			<portlet:actionURL name="subscribe" var="unsubscribeURL">
				<portlet:param name="subscriber" value="<%= themeDisplay.getLayout().getUserId() %>" />
				<portlet:param name="subscribeTo" value="<%= user.getUserId() %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				iconCssClass="icon-remove-sign"
				label="<%= true %>"
				message="unsubscribe"
				url="<%= unsubscribeURL %>"
			/>
		</c:when>
		<c:otherwise>
			<portlet:actionURL name="unsubscribe" var="subscribeURL">
				<portlet:param name="subscriber" value="<%= themeDisplay.getLayout().getUserId() %>" />
				<portlet:param name="subscriberTo" value="<%= user.getUserId() %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				iconCssClass="icon-ok-sign"
				label="<%= true %>"
				message="subscribe"
				url="<%= subscribeURL %>"
			/>
		</c:otherwise>
	</c:choose>
</div>