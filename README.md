# E-Commerce Microservices Application (Spring Cloud)

Architecture distribuée de microservices pour une application e-commerce développée avec **Spring Boot** et **Spring Cloud**.

---



##  Démonstration & Captures d'Écran

---

### 1. Discovery Service — Eureka Dashboard (Port `8761`)

Le tableau de bord Eureka permet de vérifier en temps réel l'enregistrement de l'ensemble des microservices (`CONFIG-SERVICE`, `GATEWAY-SERVICE`, `CUSTOMER-SERVICE`, `INVENTORY-SERVICE`, `BILLING-SERVICE`).

* **URL du Dashboard :** [http://localhost:8761/](http://localhost:8761/)

![Eureka Interface](screenshot-readme/eureka%20interface.png)

---

### 2. Config Service (Port `9999`)

Le Config Service expose les fichiers de configuration centralisés stockés dans le dépôt Git local (`config-repo`).

#### A. Configuration de Customer Service (Profil par défaut)
* **URL :** [http://localhost:9999/customer-service/default](http://localhost:9999/customer-service/default)

![Configuration Customer Service Default](screenshot-readme/onfiguration%20Customer%20Service%20default.png)

#### B. Configuration de Customer Service (Profil dev)
* **URL :** [http://localhost:9999/customer-service/dev](http://localhost:9999/customer-service/dev)

![Configuration Customer Service Dev](screenshot-readme/Configuration%20Customer%20Service%20dev.png)

#### C. Configuration de Customer Service (Profil prod)
* **URL :** [http://localhost:9999/customer-service/prod](http://localhost:9999/customer-service/prod)

![Configuration Customer Service Prod](screenshot-readme/Configuration%20Customer%20Service%20prod.png)

#### D. Configuration d'Inventory Service
* **URL :** [http://localhost:9999/inventory-service/default](http://localhost:9999/inventory-service/default)

![Configuration Inventory Service](screenshot-readme/Configuration%20Inventory%20Service.png)

#### E. Configuration de Billing Service
* **URL :** [http://localhost:9999/billing-service/default](http://localhost:9999/billing-service/default)

![Configuration Billing Service](screenshot-readme/Configuration%20Billing%20Service.png)

---

### 3. Customer Service & Injection de Configuration

`customer-service` récupère sa configuration depuis le `config-service`. Deux contrôleurs permettent de tester l'injection des valeurs injectées :
* **Test Config 1 :** Paramètres globaux partagés (`global.params.p1`, `global.params.p2`) via `@Value`
* **Test Config 2 :** Paramètres spécifiques au service (`customer.params.x`, `customer.params.y`) via `@ConfigurationProperties`

#### A. Test Config 1 (Global Params)
* **URL Gateway :** [http://localhost:8888/customer-service/testConfig1](http://localhost:8888/customer-service/testConfig1)
* **URL Directe :** [http://localhost:8083/testConfig1](http://localhost:8083/testConfig1)

![Test Config 1](screenshot-readme/Test%20Config%201%20global%20params.png)

#### B. Test Config 2 (Params X et Y)
* **URL Gateway :** [http://localhost:8888/customer-service/testConfig2](http://localhost:8888/customer-service/testConfig2)
* **URL Directe :** [http://localhost:8083/testConfig2](http://localhost:8083/testConfig2)

![Test Config 2](screenshot-readme/est%20Config%202%20params%20x%20y.png)

#### C. Consultation de la liste des Clients (Spring Data REST)
* **URL Gateway :** [http://localhost:8888/customer-service/api/customers](http://localhost:8888/customer-service/api/customers)
* **URL Directe :** [http://localhost:8083/api/customers](http://localhost:8083/api/customers)

![Liste des clients](screenshot-readme/Liste%20des%20clients.png)

---

### 4. Inventory Service — Consultation des Produits

`inventory-service` gère le catalogue et le stock des produits exposés avec Spring Data REST.

* **URL Gateway :** [http://localhost:8888/inventory-service/products](http://localhost:8888/inventory-service/products)
* **URL Directe :** [http://localhost:8084/products](http://localhost:8084/products)
* **Détail d'un produit (id=1) :** [http://localhost:8888/inventory-service/products/1](http://localhost:8888/inventory-service/products/1)

![Liste des produits](screenshot-readme/Liste%20des%20produits.png)

---

### 5. Billing Service — Facturation & Communication Inter-Services

`billing-service` crée et gère des factures composées de plusieurs lignes de commandes (`ProductItem`). 
Il utilise **Spring Cloud OpenFeign** pour communiquer avec `customer-service` et `inventory-service` afin d'enrichir la facture avec les informations complètes du client et des produits.

* **URL Gateway :** [http://localhost:8888/billing-service/api/bills](http://localhost:8888/billing-service/api/bills)
* **URL Directe :** [http://localhost:8085/api/bills](http://localhost:8085/api/bills)
* **Détail d'une facture complète (id=1) :** [http://localhost:8888/billing-service/api/bills/1](http://localhost:8888/billing-service/api/bills/1)

![Liste des factures](screenshot-readme/Liste%20des%20factures.png)

---
