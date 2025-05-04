# Réponses aux Exercices
## Exercice 1 : Initiation
les tests sont implémentés dans CalculatriceTest.java en utilisant Mockito pour vérifier à la fois l'état (via getResult()) et les interactions (via verify et verifyNoMoreInteractions).

## Exercice 2 : Mocker un service externe (API)
Les tests sont implémentés dans UserServiceTest.java pour vérifier l'interaction avec le mock UtilisateurApi.

## Exercice 3 : Mocker un service externe avec différents scénarios
Les tests dans UserServiceTest.java couvrent les quatre scénarios demandés (exception, erreur de validation, vérification de l'ID, capture d'arguments).

## Exercice 4 : Jeu de dés
### Tâche 1 : Objets à mocker
- Objets à mocker : 
Banque, Joueur, De (deux instances : de1, de2).
  #### Pourquoi :
- Banque : Gère les fonds et la solvabilité de manière externe. Le mocker permet de contrôler son comportement (par exemple, l'état de solvabilité) sans gérer de vrais fonds.
- Joueur : Gère les actions du joueur (mise, débit, crédit). Le mocker isole Jeu de l'état réel du joueur et permet de simuler des scénarios comme l'insolvabilité.
- De : Les lancers de dés sont aléatoires dans une implémentation réelle. Le mocker permet de contrôler les résultats des lancers pour des tests déterministes.
Le mocker de ces dépendances garantit que Jeu est testé en isolation, en se concentrant sur sa logique sans dépendre des implémentations externes.
### Tâche 2 : Scénarios (Classes d'équivalence)
- Jeu fermé : Le jeu doit lever une JeuFermeException.
- Joueur insolvable : Le Joueur lève une DebitImpossibleException lors du débit, et le jeu ne doit pas lancer les dés.
- Joueur perd (somme ≠ 7) : La somme des dés n'est pas 7, la mise du joueur est créditée à la banque, aucun gain n'est crédité au joueur.
- Joueur gagne (somme = 7), banque solvable : La somme des dés est 7, la banque crédite au joueur le double de la mise, la banque reste solvable, le jeu reste ouvert.
- Joueur gagne (somme = 7), banque insolvable : La somme des dés est 7, la banque crédite le joueur, mais devient insolvable, le jeu se ferme.
### Tâche 4 : Type de test pour le cas où le jeu est fermé
- Type : Test d'état.
- raison : Nous vérifions l'état de Jeu (si estOuvert est false) et le comportement résultant (levé de JeuFermeException). Aucune interaction avec les mocks (banque, joueur, de1, de2) n'est vérifiée car le jeu n'interagit pas avec eux lorsqu'il est fermé.
### Tâche 5 : 
Type de test pour le cas où le joueur est insolvable
#### Comment tester que le jeu ne touche pas aux dés : 
Nous utilisons verify(de1, never()).lancer() et verify(de2, never()).lancer() pour s'assurer que les dés ne sont pas lancés.
- Type : Test d'interaction.
- Raison : Nous vérifions les interactions (ou leur absence) avec les mocks des dés (de1, de2). Nous nous assurons que lancer() n'est pas appelé, en nous concentrant sur le comportement de Jeu vis-à-vis de ses dépendances plutôt que sur son état.
### Tâche 7 : Mock vs Implémentation réelle de la banque
#### Test avec mock (testJouerPlayerWinsBankInsolvent) : 
Contrôle explicitement banque.est_solvable() pour renvoyer false. Le test est déterministe et isolé, se concentrant sur la réaction de Jeu à l'état de la banque. Nous ne nous préoccupons pas de la logique interne de la banque.
#### Test avec banque réelle (testJouerPlayerWinsBankInsolventWithRealBank) :
Utilise BanqueImpl avec une gestion réelle des fonds. Ce test vérifie l'intégration entre Jeu et Banque, mais il est moins isolé et plus complexe car il faut gérer l'état de la banque (fonds, minimum). Il se rapproche d'un test d'intégration plutôt que d'un test unitaire.
Équilibre : Le mocker assure l'isolation et la prédictibilité des tests, mais suppose que le comportement du mock correspond à l'implémentation réelle. L'utilisation de la banque réelle teste l'interaction réelle, mais introduit des dépendances et une complexité potentielle.