# Projet Bitchest-Springboot

Bienvenue dans le projet **Bitchest-Springboot**, une application dédiée à l'achat et à la vente de crypto-monnaies. Ce projet est conçu avec le framework **Spring Boot** et utilise une authentification sécurisée basée sur **JWT (JSON Web Tokens)** pour garantir la sécurité des transactions et la gestion des rôles. Ce système offre un contrôle d'accès efficace pour les administrateurs et les clients.

## Description du projet

Le projet **Bitchest-Springboot** permet aux utilisateurs de s'authentifier via JWT, de gérer un solde initial de **500€**, et de procéder à l'achat et à la vente de crypto-monnaies compatibles avec leur solde. L'application fournit une liste dynamique de crypto-monnaies avec leurs variations sur 24 heures. 

Les fonctionnalités principales incluent :
- **Authentification et gestion des utilisateurs** avec **Spring Security** et **JWT**.
- Attribution d'un solde initial de 500€ pour commencer l'expérience.
- **Achat et vente de crypto-monnaies** : les utilisateurs peuvent acheter et vendre des crypto-monnaies en fonction de leur solde.
- Liste dynamique des crypto-monnaies disponibles avec **variation sur 24h**.
- **Ajout de nouvelles crypto-monnaies** par l'administrateur via l'API publique de **CoinGecko**.
- Sécurisation des données utilisateurs, avec un **hachage des mots de passe** et une gestion des **tokens JWT**.

## Fonctionnalités principales

### 1. **Authentification JWT**

- L'authentification des utilisateurs se fait via **JSON Web Tokens (JWT)**, garantissant une sécurité optimale pour l'accès aux services de l'application.
- Les utilisateurs doivent se connecter avec leurs identifiants pour obtenir un token qui permet l'accès aux fonctionnalités sécurisées de l'application.
- Les rôles sont gérés grâce à **Spring Security**, permettant une gestion granulaire des autorisations.

### 2. **Gestion du solde et des transactions**

- Chaque utilisateur commence avec un solde initial de **500€**.
- Les utilisateurs peuvent acheter et vendre des crypto-monnaies compatibles avec leur solde.
- Le solde des utilisateurs est mis à jour dynamiquement en fonction de leurs transactions (achats et ventes).

### 3. **Liste dynamique des crypto-monnaies**

- Une liste dynamique affiche les crypto-monnaies disponibles à la vente, accompagnée de leur variation sur 24h.
- Les administrateurs peuvent ajouter de nouvelles crypto-monnaies en utilisant l'API publique **CoinGecko**.
  
### 4. **Sécurisation des données et gestion des rôles**

- Chaque utilisateur dispose de ses propres données sécurisées. 
- Les mots de passe sont hachés pour une meilleure sécurité.
- La gestion des rôles (administrateur ou utilisateur standard) permet d'attribuer des droits d'accès spécifiques.

## Installation

### Prérequis

- **Java 11** ou version supérieure
- **Maven** pour la gestion des dépendances

### Étapes d'installation

1. Clonez ce dépôt sur votre machine locale.
   ```bash
   git clone https://github.com/votre-utilisateur/bitchest-springboot.git

2. Allez dans le répertoire du projet
cd bitchest-springboot

3. Installez les dépendances avec Maven
 mvn install

4. Démarrez l'application Spring Boot.
mvn spring-boot:run

L'application sera disponible à l'adresse suivante : http://localhost:8080



## Documentation
Vous pouvez consulter la documentation officielle de Spring Boot et JWT à ces liens :

** https://spring.io/projects/spring-boot **
** https://spring.io/projects/spring-security **
** https://api.coingecko.com/api/v3/coins/list **


## Dépendances dans pom.xml
Voici les dépendances clés à inclure dans votre fichier pom.xml :

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.18</version> 
        <relativePath/>
    </parent>
    <groupId>tn.springboot</groupId>
    <artifactId>bitshest</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>bitshest</name>
    <description>Projet Bitshest - The Digital School</description>

    <properties>
        <java.version>1.8</java.version>
        <maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.29</version>
            </dependency>
        </dependencies>
    </dependencyManagement>


    <dependencies>
        <!-- Spring Boot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
    <!-- Spring Security OAuth2 Resource Server -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-oauth2-resource-server</artifactId>
    </dependency>

    <!-- Spring Security OAuth2 JWT support -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-oauth2-jose</artifactId>
    </dependency>
    
        <!-- JWT pour gestion des Tokens -->
  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
  </dependency>

  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>



        <!-- BCrypt pour hachage des mots de passe -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-crypto</artifactId>
        </dependency>

        <!-- Lombok pour réduire le boilerplate -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Driver MySQL -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- JSON Processing -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>

        <!-- Spring Boot Starter Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.32</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.32</version>
        </dependency>



    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
