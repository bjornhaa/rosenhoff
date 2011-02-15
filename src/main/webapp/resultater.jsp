<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<f:verbatim><h3>Resultater</h3></f:verbatim>
<t:dataTable var="resultatView" value="#{adminResultatBean.resultater}" cellpadding="1" cellspacing="1" width="75%"
             headerClass="TableHeader" columnClasses="TableRow">
    <t:column>
        <f:facet name="header">
            <t:outputText value="Dato">
                <f:convertDateTime pattern="dd.MM.yyyy" type="date" locale="no_no"/>
            </t:outputText>
        </f:facet>
        <t:outputText value="#{resultatView.dato}"/>
    </t:column>

    <t:column>
        <f:facet name="header">
            <t:outputText value="Hjemme"/>
        </f:facet>
        <t:outputText value="#{(resultatView.hjemme == 'Borte') ? resultatView.motstander : 'Rosenhoff'}"/>
    </t:column>

    <t:column>
        <f:facet name="header">
            <t:outputText value="Borte"/>
        </f:facet>
        <t:outputText value="#{(resultatView.hjemme == 'Borte') ? 'Rosenhoff' : resultatView.motstander}"/>
    </t:column>

    <t:column>
        <f:facet name="header">
            <t:outputText value="Resultat"/>
        </f:facet>
        <t:outputText value="#{(resultatView.hjemme == 'Borte') ? resultatView.maalSluppetInn : resultatView.maalScoret}"/>
        <t:outputText value=" - "/>
        <t:outputText value="#{(resultatView.hjemme == 'Borte') ? resultatView.maalScoret : resultatView.maalSluppetInn}"/>
    </t:column>
</t:dataTable>
