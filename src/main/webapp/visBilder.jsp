<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

    <h:panelGroup id="body">		
		<h:commandLink value="Tilbake til bildeserier" action="#{bildeBean.hentBildeListe}" />
		
		<f:verbatim><br></f:verbatim>
		<f:verbatim><br></f:verbatim>
		<f:verbatim>Trykk på bildet for full versjon</f:verbatim>
		<f:verbatim><br></f:verbatim>
		<f:verbatim><br></f:verbatim>

		<t:newspaperTable var="bilde" value="#{bildeBean.bilder}" newspaperColumns="5">
			<t:column>
				<h:commandLink action="visBilde">
					<f:verbatim><img width="200px" src="ShowImage?type=bilde&id=</f:verbatim><t:outputText value="#{bilde.id}" /><f:verbatim>"></f:verbatim>
		             <t:updateActionListener property="#{bildeBean.selectedBildeId}" value="#{bilde.id}" />		
				</h:commandLink>
				
				<f:verbatim><br></f:verbatim>
				<t:outputText value="#{bilde.bildetekst}" />
				<f:verbatim><br></f:verbatim>
				<f:verbatim><br></f:verbatim>
			</t:column>		
		</t:newspaperTable>

		<f:verbatim><br></f:verbatim>
		<f:verbatim><br></f:verbatim>
		<h:commandLink value="Tilbake til bildeserier" action="#{bildeBean.hentBildeListe}" />
		
    </h:panelGroup>
		