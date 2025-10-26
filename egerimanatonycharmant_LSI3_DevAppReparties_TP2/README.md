# Calculatrice Client-Serveur en Java

## Description

Ce projet implémente une calculatrice distribuée utilisant l'architecture client-serveur en Java. Le serveur accepte des opérations arithmétiques envoyées par les clients, effectue les calculs et renvoie les résultats.

## Architecture

Le projet se compose de deux composants principaux :

### Serveur (`Server.class`)
- Écoute sur le port **1234**
- Accepte les connexions des clients
- Reçoit les opérations arithmétiques
- Effectue les calculs
- Renvoie les résultats aux clients

### Client (`Client.class`)
- Se connecte au serveur à l'adresse **127.0.0.1:1234**
- Permet à l'utilisateur de saisir des opérations
- Envoie les opérations au serveur
- Affiche les résultats reçus

## Fonctionnalités

### Opérations supportées
- **Addition** (`+`) : additionne deux nombres
- **Soustraction** (`-`) : soustrait le second nombre du premier
- **Multiplication** (`*`) : multiplie deux nombres
- **Division** (`/`) : divise le premier nombre par le second

### Format des opérations
```
nombre1 opérateur nombre2
```

**Exemples :**
- `34 * 55`
- `100 / 5`
- `45 + 67`
- `90 - 23`

## Installation et Exécution

### Prérequis
- Java Runtime Environment (JRE) ou Java Development Kit (JDK)
- Les fichiers compilés `Server.class` et `Client.class`

### Démarrage du serveur
```bash
java serverPackage.Server
```

Le serveur affichera :
```
Serveur en attente de connexion...
```

### Démarrage du client
Dans un autre terminal :
```bash
java clientPackage.Client
```

Le client affichera :
```
Connecté au serveur.
Entrez une opération (ex: 34 * 55) :
```

## Utilisation

1. Démarrez d'abord le serveur
2. Lancez un ou plusieurs clients
3. Dans le client, entrez une opération au format `nombre1 opérateur nombre2`
4. Le résultat s'affichera immédiatement
5. Appuyez sur Entrée pour quitter

### Exemple de session
```
Entrez une opération (ex: 34 * 55) : 12 + 8
Résultat reçu : 20.0
Appuyez sur Entrée pour quitter...
```

## Gestion des erreurs

Le système gère plusieurs types d'erreurs :

- **Format invalide** : Si l'opération n'est pas au bon format
- **Division par zéro** : Détection et message d'erreur approprié
- **Opérateur invalide** : Si l'opérateur n'est pas reconnu
- **Erreurs de connexion** : Gestion des erreurs réseau

## Détails techniques

### Communication
- Protocole : TCP/IP
- Port : 1234
- Adresse serveur : 127.0.0.1 (localhost)

### Classes utilisées
- `java.net.ServerSocket` : Pour le serveur
- `java.net.Socket` : Pour les connexions client-serveur
- `java.io.BufferedReader` / `java.io.PrintWriter` : Pour la communication
- `java.util.Scanner` : Pour la saisie utilisateur

## Limitations

- Le serveur traite les connexions de manière séquentielle (une à la fois)
- Conçu pour fonctionner en local (127.0.0.1)
- Prend en charge uniquement les opérations binaires simples
