# Rapport sur la Configuration des MicroServices

## Partie 1 -> MicroService Equipe
- Status : ok
- Commentaire : Le service est lié au service Eureka-server. Chaque équipe contient un chef d'équipe qui est un player, implémenté sur la branche "try_hystrix_circuit_breaker" pour le circuit breaker (non mergé car ne marche pas :( ).

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
- Commentaire : ![image](https://github.com/Quentin-creat/java_intense/assets/66668804/2f143558-ab22-4da4-8a00-791a75619808)
, lien pour y accéder : [http://localhost:XXXX/swagger-ui.html](http://localhost:XXXX/swagger-ui.html)

## Partie 6 -> Circuit Breaker
- Status : NOK :(
- Commentaire : Ne fonctionne pas, le services Team est censé faire une requête sur le service Player pour récupérer le chef d'équipe sur le GET Team, la jointure fonctionne mais le circuit breaker ne compile pas, je pense que c'est un pb de version java / dépendances. Testable sur la branche "try_hystrix_circuit_breaker"

## Partie 7 -> Actuator
- Status : ok
- Commentaire : Tout les liens sont visibles depuis le navigateur à [http://localhost:XXXX/actuator](http://localhost:XXXX/actuator) : ![image](https://github.com/Quentin-creat/java_intense/assets/66668804/289d3e89-6bed-411f-8b57-690f4bee48c2)


## Partie 8 -> Load Balancing
- Status : ok
- Commentaire : Le service Match a été lancé sur 3 ports (8081, 8095, et 8096) : ![image](https://github.com/Quentin-creat/java_intense/assets/66668804/3dd8c00d-0329-4ee4-a05b-8d4ef929ffe8)

- ![image](https://github.com/Quentin-creat/java_intense/assets/66668804/e39a357d-76c8-41c4-99b7-25dc0a7af5a6)


## Partie 9 -> Docker & Kubernetes
- Status : NOK (no time)
- Commentaire : Non réalisé en raison de contraintes de temps.
