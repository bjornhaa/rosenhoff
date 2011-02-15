<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<html>
<link rel="stylesheet" href="css/rosenhoff.css" type="text/css">

<body>
<table>
    <tr>
        <td class="TableRow">
            <!-- spillertabell -->
            <t:dataTable var="spillere" value="#{adminSpillerBean.spillere}" cellspacing="1" cellpadding="1"
                         headerClass="TableHeader" columnClasses="TableRow">

            <t:column>
            <!-- spillertabell -->
            <f:verbatim>
            <table border="0">
                <tr>
                    <td colspan="2">
                        </f:verbatim>
                        <t:outputText value="#{spillere.navn}"/>
                        <f:verbatim>
                    </td>
                </tr>
                <tr>
                    <td><img
                            src="ShowImage?type=spiller&id=</f:verbatim><t:outputText value="#{spillere.id}"/><f:verbatim>"
                            width="150"/></td>
                    <td>
                        <table width="100%" border="0" cellspacing="2" cellpadding="2">
                            <tr>
                                <td>Posisjon</td>
                                <td>
                                    </f:verbatim>
                                    <t:outputText value="#{spillere.posisjon}"/>
                                    <f:verbatim>
                                </td>
                            </tr>
                            <tr>
                                <td>Mobil</td>
                                <td>
                                    </f:verbatim>
                                    <t:outputText value="#{spillere.mobil}"/>
                                    <f:verbatim>
                                </td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td>
                                    </f:verbatim>
                                    <t:outputText value="#{spillere.email}"/>
                                    <f:verbatim>
                                </td>
                            </tr>
                            <tr>
                                <td>Kamper i &aring;r</td>
                                <td>
                                    </f:verbatim>
                                    <t:outputText value="#{spillere.kamper}"/>
                                    <f:verbatim>
                                </td>
                            </tr>
                            <tr>
                                <td>Utvisninger</td>
                                <td>
                                    </f:verbatim>
                                    <t:outputText value="#{spillere.utv}"/>
                                    <f:verbatim>
                                </td>
                            </tr>
                            <tr>
                                <td>Poeng i &aring;r</td>
                                <td>
                                    </f:verbatim>
                                    <t:outputText value="#{spillere.navn}"/>
                                    <f:verbatim>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            </f:verbatim>
            <!-- slutt på spillertabell -->
            <t:outputText style="height: 20px">&nbsp;</t:outputText>
            </t:column>


            </t:dataTable>

</body>

</html>