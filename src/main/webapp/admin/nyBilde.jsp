<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

    <h:panelGroup id="body">
    
		<h:form name="saveForm" enctype="multipart/form-data">
		<h:messages />
		<h:panelGrid columns="2" border="1" headerClass="TableHeader" width="193" rowClasses="TableRow">
			<f:facet name="header">
				<f:verbatim>Legg inn nytt bilde</f:verbatim>
			</f:facet>
			<t:outputLabel value="Velg fil" for="fil"/>
			<h:panelGroup>
			<t:inputFileUpload id="fil"
                               value="#{adminBildeBean.bildeFil}"
                               accept="image/*"
                               storage="file"
                               required="true"/>			
            <t:message for="fil" showDetail="true"/>
			</h:panelGroup>
			<t:outputLabel value="Bildetekst" for="tekst"/>
			<h:panelGroup>
			<h:inputText id="tekst" value="#{adminBildeBean.selectedBildeTekst}" maxlength="20"/>
            <t:message for="tekst" />
			</h:panelGroup>
			<f:verbatim>&nbsp;</f:verbatim>
			<t:commandButton value="Legg til" action="#{adminBildeBean.lagreBilde}"/>			
		</h:panelGrid>
        </h:form>
        
		<t:newspaperTable var="bilde" value="#{adminBildeBean.bilder}" newspaperColumns="4">
			<t:column>
				<f:verbatim><img width="200px" src="<%=request.getContextPath()%>/ShowImage?id=</f:verbatim><t:outputText value="#{bilde.id}" /><f:verbatim>"></f:verbatim>
				<f:verbatim><br></f:verbatim>
				<t:outputText value="#{bilde.bildetekst}" />
				<f:verbatim><br></f:verbatim>
				<h:commandLink value="slett" action="#{adminBildeBean.slettBilde}">
		             <t:updateActionListener property="#{adminBildeBean.selectedId}" value="#{bilde.id}" converter="javax.faces.Integer"/>		
		        </h:commandLink>
				<f:verbatim><br></f:verbatim>
				<f:verbatim><br></f:verbatim>
			</t:column>
		</t:newspaperTable>
	</h:panelGroup>		