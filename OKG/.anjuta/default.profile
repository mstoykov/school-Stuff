<?xml version="1.0"?>
<anjuta>
    <plugin name="Tools" mandatory="no">
        <require group="Anjuta Plugin"
                 attribute="Location"
                 value="anjuta-tools:ATPPlugin"/>
    </plugin>
    <plugin name="Git" mandatory="no">
        <require group="Anjuta Plugin"
                 attribute="Location"
                 value="anjuta-git:Git"/>
    </plugin>
    <plugin name="API Help" mandatory="no">
        <require group="Anjuta Plugin"
                 attribute="Location"
                 value="anjuta-devhelp:AnjutaDevhelp"/>
    </plugin>
    <plugin name="Anjuta JS Debugger Plugin" mandatory="no">
        <require group="Anjuta Plugin"
                 attribute="Location"
                 value="js_debugger:JSDbg"/>
    </plugin>
</anjuta>
