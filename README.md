# Rapport sur la Configuration des MicroServices

## Partie 1 -> MicroService Equipe
- Status : ok
- Commentaire : Le service est lié au service Eureka-server.

## Partie 2 -> MicroService Player
- Status : ok
- Commentaire : Le service est lié au service Eureka-server.

## Partie 3 -> MicroService Match
- Status : ok
- Commentaire : Le service est lié au service Eureka-server.

## Partie 4 -> MicroService Stats
- Status : ok
- Commentaire : Le service est lié au service Eureka-server.

**Note :** Tout les services contiennent des listes qui font office de base de données. Le service Eureka-server est accessible ici : [http://localhost:8761/](http://localhost:8761/)

## Partie 5 -> Swagger
- Status : ok
- Commentaire : "intégrer image", lien pour y accéder : [http://localhost:XXXX/swagger-ui.html](http://localhost:XXXX/swagger-ui.html)

## Partie 6 -> Circuit Breaker
- Status : NOK
- Commentaire : Partie passée en raison de la priorisation des autres tâches.

## Partie 7 -> Actuator
- Status : ok
- Commentaire : Tout les liens sont visibles depuis le navigateur à [http://localhost:XXXX/actuator](http://localhost:XXXX/actuator) : "intégrer image"

## Partie 8 -> Load Balancing
- Status : ok
- Commentaire : Le service Match a été lancé sur 3 ports (8081, 8095, et 8096) : "intégrer image"

## Partie 9 -> Docker & Kubernetes
- Status : NOK (no time)
- Commentaire : Non réalisé en raison de contraintes de temps.
