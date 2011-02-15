<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<h:panelGroup id="body">

    <f:verbatim><br>

        <h3>Resultatet er lagret</h3></f:verbatim>
    <f:verbatim>Du må også legge inn spillere som har spilt denne kampen for at toppscorerlisten skal bli korrekt:<br></f:verbatim>

    <t:dataTable var="spiller" value="#{adminSpillerBean.spillere}" cellpadding="1" cellspacing="1"
                 headerClass="TableHeader" columnClasses="TableRow">
        <t:column>
            <f:facet name="header">
                <t:outputText value=" "/>
            </f:facet>
            <t:outputText value="#{spiller.navn}"/>
        </t:column>
        <t:column>
            <f:facet name="header">
                <t:outputText value=" "/>
            </f:facet>
            <t:outputText value="checkbox"/>
        </t:column>
    </t:dataTable>

</h:panelGroup>