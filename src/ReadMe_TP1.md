# TP1 - Analyse de Couverture de Tests

Ce dépôt contient le premier travail pratique (TP1) axé sur l'analyse de couverture de tests. Le travail comprend plusieurs exercices, chacun avec différentes approches de couverture de tests.

## Structure

Le projet est organisé comme suit :

```
src/
├── main/java/TP1/          # Code source des exercices
└── test/java/TP1/          # Fichiers de tests
    ├── LineCoverageTest/   # Tests axés sur la couverture de lignes
    ├── BranchCoverageTest/ # Tests axés sur la couverture de branches
    └── ConditionCoverageTest/ # Tests axés sur la couverture de conditions
```

## Exercices

### Exo1 - Palindrome
Tests pour vérifier si une chaîne est un palindrome, avec couverture pour :
- Chaînes vides
- Chaînes à un seul caractère
- Palindromes de longueur paire et impaire
- Chaînes non-palindromes

### Exo2 - Anagramme
Tests pour vérifier si deux chaînes sont des anagrammes, avec couverture pour :
- Cas d'entrées nulles
- Chaînes vides
- Chaînes de longueurs différentes
- Anagrammes valides
- Non-anagrammes
- Sensibilité à la casse
- Caractères spéciaux

### Exo3 - Recherche Binaire
Tests pour l'algorithme de recherche binaire, avec couverture pour :
- Tableaux vides
- Tableaux à un seul élément
- Tableaux de longueur paire et impaire
- Cas où l'élément est trouvé/non trouvé
- Cas limites

### Exo4 - Équation Quadratique
Tests pour la résolution d'équations quadratiques, avec couverture pour :
- Entrée invalide (a = 0)
- Pas de racines réelles (delta < 0)
- Une racine (delta = 0)
- Deux racines (delta > 0)
- Cas limites

### Exo5 - Numération Romaine
Tests pour la conversion de nombres en chiffres romains, avec couverture pour :
- Entrée invalide (n < 1 ou n > 3999)
- Cas de symboles uniques
- Cas de symboles multiples
- Cas de soustraction (IV, IX, etc.)
- Combinaisons complexes

### Exo6 - FizzBuzz
Tests pour le jeu FizzBuzz, avec couverture pour :
- Entrée invalide (n < 1)
- Nombres divisibles par 3 (Fizz)
- Nombres divisibles par 5 (Buzz)
- Nombres divisibles par 3 et 5 (FizzBuzz)
- Nombres réguliers

## Approches de Couverture de Tests

Chaque exercice est testé en utilisant trois approches différentes de couverture :

1. **Couverture de Lignes**
   - Assure que chaque ligne de code est exécutée
   - Se concentre sur la fonctionnalité de base
   - Cas de test minimaux pour couvrir toutes les lignes

2. **Couverture de Branches**
   - Assure que tous les points de décision sont testés
   - Teste les résultats vrai et faux
   - Plus complet que la couverture de lignes

3. **Couverture de Conditions**
   - Assure que toutes les conditions dans les points de décision sont testées
   - Teste les combinaisons de conditions
   - Approche la plus approfondie

## Exécution des Tests

Pour exécuter les tests, utilisez votre framework de test Java préféré (JUnit). Chaque classe de test est autonome et peut être exécutée indépendamment.

## Notes

- Toutes les classes de test suivent la convention de nommage `ExoXTest.java` où X est le numéro de l'exercice
- Les tests sont organisés dans des packages séparés pour chaque type de couverture
- Les commentaires dans les fichiers de test expliquent les objectifs de couverture pour chaque cas de test