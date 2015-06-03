<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="xml" indent="yes"/>

<xsl:template match="/">
  <SchoolOfApplicants>
	<Header>
		<CurrentDate><xsl:value-of select="date" /></CurrentDate>
		<Records><xsl:value-of select="records" /></Records>
	</Header>
	<Fish>
		<Name><xsl:value-of select="fullname" /></Name>
		<DOB><xsl:value-of select="dob" /></DOB>
		<Type><xsl:value-of select="type" /></Type>
		<Address home = <xsl:value-of select="home" />>
			<Ocean><xsl:value-of select="ocean" /></Ocean>
			<Reef><xsl:value-of select="reef" /></Reef>
			<Depth><xsl:value-of select="depth" /></Depth>
		</Address>
	</Fish>
  </SchoolOfApplicants>
</xsl:template>

</xsl:stylesheet>