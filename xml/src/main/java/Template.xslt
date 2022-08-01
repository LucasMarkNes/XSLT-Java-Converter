<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <table border="1">
            <tr>
                <th>Codigo</th>
                <th>Nome</th>
                <th>Estoque</th>
            </tr>
            <xsl:for-each select="Produtos/produto">
                <tr>
                    <td>
                        <br><xsl:value-of select="codigo"/></br>
                    </td>
                    <td>
                        <br><xsl:value-of select="nome"/></br>
                    </td>
                    <td>
                        <br><xsl:value-of select="estoque"/></br>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>