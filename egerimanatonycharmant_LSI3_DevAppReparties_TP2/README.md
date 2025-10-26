# Calculatrice Client-Serveur en Java

## Description

Ce projet impl�mente une calculatrice distribu�e utilisant l'architecture client-serveur en Java. Le serveur accepte des op�rations arithm�tiques envoy�es par les clients, effectue les calculs et renvoie les r�sultats.

## Architecture

Le projet se compose de deux composants principaux :

### Serveur (`Server.class`)
- �coute sur le port **1234**
- Accepte les connexions des clients
- Re�oit les op�rations arithm�tiques
- Effectue les calculs
- Renvoie les r�sultats aux clients

### Client (`Client.class`)
- Se connecte au serveur � l'adresse **127.0.0.1:1234**
- Permet � l'utilisateur de saisir des op�rations
- Envoie les op�rations au serveur
- Affiche les r�sultats re�us

## Fonctionnalit�s

### Op�rations support�es
- **Addition** (`+`) : additionne deux nombres
- **Soustraction** (`-`) : soustrait le second nombre du premier
- **Multiplication** (`*`) : multiplie deux nombres
- **Division** (`/`) : divise le premier nombre par le second

### Format des op�rations
```
nombre1 op�rateur nombre2
```

**Exemples :**
- `34 * 55`
- `100 / 5`
- `45 + 67`
- `90 - 23`

## Installation et Ex�cution

### Pr�requis
- Java Runtime Environment (JRE) ou Java Development Kit (JDK)
- Les fichiers compil�s `Server.class` et `Client.class`

### D�marrage du serveur
```bash
java serverPackage.Server
```

Le serveur affichera :
```
Serveur en attente de connexion...
```

### D�marrage du client
Dans un autre terminal :
```bash
java clientPackage.Client
```

Le client affichera :
```
Connect� au serveur.
Entrez une op�ration (ex: 34 * 55) :
```

## Utilisation

1. D�marrez d'abord le serveur
2. Lancez un ou plusieurs clients
3. Dans le client, entrez une op�ration au format `nombre1 op�rateur nombre2`
4. Le r�sultat s'affichera imm�diatement
5. Appuyez sur Entr�e pour quitter

### Exemple de session
```
Entrez une op�ration (ex: 34 * 55) : 12 + 8
R�sultat re�u : 20.0
Appuyez sur Entr�e pour quitter...
```

## Gestion des erreurs

Le syst�me g�re plusieurs types d'erreurs :

- **Format invalide** : Si l'op�ration n'est pas au bon format
- **Division par z�ro** : D�tection et message d'erreur appropri�
- **Op�rateur invalide** : Si l'op�rateur n'est pas reconnu
- **Erreurs de connexion** : Gestion des erreurs r�seau

## D�tails techniques

### Communication
- Protocole : TCP/IP
- Port : 1234
- Adresse serveur : 127.0.0.1 (localhost)

### Classes utilis�es
- `java.net.ServerSocket` : Pour le serveur
- `java.net.Socket` : Pour les connexions client-serveur
- `java.io.BufferedReader` / `java.io.PrintWriter` : Pour la communication
- `java.util.Scanner` : Pour la saisie utilisateur

## Limitations

- Le serveur traite les connexions de mani�re s�quentielle (une � la fois)
- Con�u pour fonctionner en local (127.0.0.1)
- Prend en charge uniquement les op�rations binaires simples
