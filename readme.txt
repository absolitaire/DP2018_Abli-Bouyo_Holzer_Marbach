Comment lancer le jeu :
Il suffit généralement de lancer le fichier .jar ou le projet sous Eclipse.
Il ne faut pas lancer au préalable rmiregestry.exe.
Si des exceptions de type ConnectionRefused se produisent en cas
d'hébergement d'un serveur ou de connexion du client (notamment sur les PC
de la fac), il faut lancer le fichier jar avec la commande suivante :

java -Djava.rmi.server.hostname=A.B.C.D -jar DP2018_BatailleNavale_Abli-Bouyo_Holzer_Marbach.jar

en remplaçant A.B.C.D par l'adresse IP de la machine sur laquelle on lance le jeu.