Eine Art Model-View-Controller-Pattern...

Main -> Klasse, die beim Aufruf geöffnet wird; direktes Weiterleiten zur View
View -> Die Tabelle, die den Mensaplan darstellt [-> Link zum Login]
Login -> Controller (Dient dem admin sich anzumelden und den Mensaplan zu verändern) [-> Link zum Editor]
Editor -> Admin kann den Mensaplan verändern [-> Link zur View]
Menu -> Objekt Menu
Model -> Speichern der Objekte Menu [-> Speichern der Liste in /menus/Datei.dat]