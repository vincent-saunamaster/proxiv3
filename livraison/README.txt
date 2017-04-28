Installation du programme Proxibanquev3.

I)PREREQUIS 

1- Installer le JRE sur le poste de travail.
	--> T�l�charger le JRE de JAVA:  "https://www.java.com/fr/download/"
	--> Installer JAVA.exe

2- Ajouter l'application JAVA dans les variables d'environnement.
	Suivez cette d�marche:
	--> Panneau de configuration 	--> Syst�me 	--> Param�tres syst�me avanc�s
	--> Cliquez sur l'onglet: Param�tres syst�me avanc�s 	--> Variables d'environnement
	--> Dans la fen�tre "Variables utilisateur": Cliquez sur "Nouvelle"
	--> Ajoutez dans "Nom de la variable": PATH
	--> Ajouter dans "Valeur de la variable" le chemin d'acc�s :
		 "C:\Program Files\Java\jre1.8.0_121\bin" 
	--> Cliquez sur OK


3- Installer l'application Wampserver64 sur le poste de travail
   --> Telecharger l'application wampserver64 sur "http://www.wampserver.com/"
   --> Installer et configurer l'application : 
	--> Lancer le serveur et aller dans pHpMyAdmin
   	--> se connecter avec l'identifiant "root" sans mot de passe
  	--> Cr�er une nouvelle base de donn�es nomm�e "proxiv3" avec interclassement "utf8-general-ci"
  	--> Importer la base de donn�es test "proxiv3.sql" qui se trouve dans le dossier d'installation ProxiV3 --> BDD 

4- Installer le serveur d'application apache-tomcat-9.0.0
   --> Telecharger le serveur apache-tomcat-9.0.0.M19.zip  sur "https://tomcat.apache.org/download-90.cgi" prendre la version : 
	Binary Distributions --> Core: --> zip 
   --> le dezipper et installer les fichiers � la racine du disque C:/.


5- Mise en place du fichier .war sur le poste de travail.
   --> Placer le fichier ProxyV3.war depuis le dossier d'installation dans le dossier webapp de tomcat


II) INSTALLATION DE PROXI V3

1- Lancement du serveur d'application TOMCAT 
   --> Lancer "startup.bat" depuis le dossier "C:\apache-tomcat-9.0.0.M19\bin"

2- Relever le num�ro de port du serveur d'application TOMCAT dans le fichier "server.xml" dans le dossier "C:\apache-tomcat-9.0.0.M19\conf"
  --> il faudra remplacer NumPort par ce numero dans la suite du fichier d'installation suivant

3- Ex�cution du programme .war
	--> Ouvrer votre navigateur internet (chrome, internet explorer..)
	--> Entrer l'URL "http://localhost:NumPort/ProxiV3/index.html"

4- afin de tester les fonctionnalit�s, deux conseillers ont �t� cr�e, ci-dessous leur login :

(identifiant)
(mot de passe)

bourne
bourne

bourne2
bourne2

--------------Fonctionalit�s qui ne marchent pas--------------------

1 - Liste des comptes
2 - Virement 
3 - Ajouter/Supprimer/modifier -> Ces fonctionalit�s ont transitoirement fonctionn�.