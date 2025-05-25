# Tests Unitaires TP3 - Tests d'Intégration Partie 1

## Objectifs
Ce TP vise à explorer les tests d'intégration en Java avec JUnit et Mockito. Les exercices couvrent :
- Les interactions simples entre modules.
- Les interactions avec une base de données en utilisant des mocks.
- L'intégration avec une API externe simulée.

## Prérequis
- Java 8 ou supérieur
- IntelliJ IDEA
- Maven pour gérer les dépendances (JUnit 5, Mockito)
- Compte GitHub pour pusher le code

## Structure du Projet
- **src/main/java/TP3/PART1** : Contient les classes et interfaces des trois exercices.
- **src/test/java/TP3/PART1** : Contient les tests JUnit pour chaque exercice.
- **pom.xml** : Fichier Maven avec les dépendances nécessaires.

## Réponses aux Questions
- **Pourquoi utiliser des mocks ?** : Les mocks permettent d'isoler les dépendances externes (comme une base de données ou une API) pour tester uniquement la logique de la classe cible, sans dépendre d'un environnement réel.
- **Différence entre tests unitaires** : et tests d'intégration ? Les tests unitaires testent une unité de code isolée (une méthode ou une classe). Les tests d'intégration vérifient l'interaction entre plusieurs composants ou modules.
- **Pourquoi tester plusieurs scénarios**: dans l'Exercice 3 ? Tester différents cas (succès, échec, données invalides) garantit que le système gère correctement tous les scénarios possibles, y compris les erreurs.

# Tests Unitaires TP3 -  Intégration avec Docker et Testcontainers Partie 2
Ce projet a été développé dans le cadre du TP3 de tests d'intégration. Il démontre l'utilisation de :
- Spring Boot pour développer une API REST de gestion de tâches.
- Testcontainers pour effectuer des tests d'intégration réels avec une base de données MySQL dans un conteneur Docker.

## Technologies utilisées

- Java 17+
- Spring Boot 3.x
- Maven
- MySQL 8.0 (via Testcontainers)
- Testcontainers 1.19.x
- JUnit 5

### Scénarios testés
- Restructure la partie 1 ,tester avec des conteneurs Docker ou lieu de mocker
- Création et récupération d’une tâche
- Suppression d’une tâche
