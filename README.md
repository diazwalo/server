# Squelette de la partie serveur REST

# Lancement du serveur pour les tests
Le serveur se lance avec la commande `mvn exec:java`.
La ressource exemple fournie est accessible avec l'URL
`http://localhost:8080/api/v1/myresource`

Pour arrêter le serveur, il faut faire un `CTRL + C`

# Génération de l'archive de déploiement
On peut générer une archive avec l'ensemble du code et des librairies
nécessaires pour un déploiement à l'aide de la commande `mvn package`.

Vous obtiendrez dans le répertoire `target` une archive exécutable
nommée `server-1.0-SNAPSHOT.jar`.

Cette archive peut être exécutée au moyen de la commande `java -jar
target/server-1.0-SNAPSHOT.jar`.
