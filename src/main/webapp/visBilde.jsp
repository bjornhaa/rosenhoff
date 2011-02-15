<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

    <h:panelGroup id="body">
   		<h:commandLink value="Tilbake til liste" action="#{bildeBean.hentBilderForKatalog}" />
   		<f:verbatim><p></f:verbatim>    		
		<f:verbatim><img src="ShowImage?type=bilde&id=</f:verbatim><t:outputText value="#{bildeBean.selectedBildeId}" /><f:verbatim>"></f:verbatim>
   		<f:verbatim><p></f:verbatim>
   		<h:commandLink value="Tilbake til liste" action="#{bildeBean.hentBilderForKatalog}" />
		
    </h:panelGroup>