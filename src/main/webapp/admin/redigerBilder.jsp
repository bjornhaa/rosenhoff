<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

    <h:panelGroup id="body">

		<h:form name="saveForm">
		<h:messages />
		<h:panelGrid columns="2" border="1" headerClass="TableHeader" width="250" rowClasses="TableRow">
			<f:facet name="header">
				<f:verbatim>Legg inn ny bildeserie</f:verbatim>
			</f:facet>
			<t:outputLabel value="Navn" for="katalog"/>
			<h:panelGroup>
			<h:inputText id="katalog" value="#{adminBildeBean.selectedKatalog}" required="true"/>			
            <t:message for="katalog" showDetail="true"/>
			</h:panelGroup>
			<f:verbatim>&nbsp;</f:verbatim>
			<t:commandButton value="Legg til" action="#{adminBildeBean.nyKatalog}"/>			
		</h:panelGrid>
        </h:form>

		<f:verbatim>Bildeserier</f:verbatim>

		<t:dataTable var="katalog" value="#{adminBildeBean.kataloger}">
			<t:column>
				<h:commandLink value="#{katalog}" action="#{adminBildeBean.hentBilderForKatalog}">
		             <t:updateActionListener property="#{adminBildeBean.selectedKatalog}" value="#{katalog}" />		
		        </h:commandLink>
			</t:column>		
		</t:dataTable>

	</h:panelGroup>