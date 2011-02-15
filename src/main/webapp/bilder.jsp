<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

    <h:panelGroup id="body">		

		<f:verbatim>Bildeserier<br><br></f:verbatim>

		<t:dataTable var="katalog" value="#{bildeBean.kataloger}">
			<t:column>
				<h:commandLink value="#{katalog}" action="#{bildeBean.hentBilderForKatalog}">
		             <t:updateActionListener property="#{bildeBean.selectedKatalog}" value="#{katalog}" />		
		        </h:commandLink>
			</t:column>		
		</t:dataTable>
		
    </h:panelGroup>
