<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<f:verbatim><h3>Aktiviteter fremover</h3></f:verbatim>
<t:dataTable var="aktivitetGuiWrapper" value="#{AktivitetBean.aktiviteter}" cellspacing="1" cellpadding="1"
             headerClass="TableHeader" columnClasses="TableRow">
    <t:column>
        <f:facet name="header">
            <t:outputText value="Dato"/>
        </f:facet>
        <t:outputText value="#{aktivitetGuiWrapper.naar}">
            <f:convertDateTime pattern="EEEE dd.MM" type="date" locale="no_no"/>
        </t:outputText>
    </t:column>

    <t:column>
        <f:facet name="header">
            <h:outputText value="Tidspunkt"/>
        </f:facet>
        <t:outputText value="#{aktivitetGuiWrapper.naar}">
            <f:convertDateTime pattern="HH.mm" timeZone="Europe/Oslo"/>
        </t:outputText>
        <t:outputText value=" - "/>
        <t:outputText value="#{aktivitetGuiWrapper.ferdig}">
            <f:convertDateTime pattern="HH.mm" timeZone="Europe/Oslo"/>
        </t:outputText>
    </t:column>

    <t:column>
        <f:facet name="header">
            <h:outputText value="Hva"/>
        </f:facet>
        <h:outputText value="#{aktivitetGuiWrapper.hva}"/>
    </t:column>

    <t:column>
        <f:facet name="header">
            <h:outputText value="Hvor"/>
        </f:facet>
        <h:outputText value="#{aktivitetGuiWrapper.hvor}"/>
    </t:column>
</t:dataTable>


