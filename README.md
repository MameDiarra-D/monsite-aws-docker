# monsite-aws-docker

API REST Spring Boot (gestion de tâches) + MySQL, lancée avec Docker Compose.

## Routes
- GET    /api/taches
- POST   /api/taches        {"titre":"Réviser AWS","terminee":false}
- PUT    /api/taches/{id}
- DELETE /api/taches/{id}

## Lancer
1. `cd backend && mvn clean package -DskipTests` (génère `backend/target/app.jar`)
2. `cp .env.example .env` puis remplacer les mots de passe
3. `docker compose up -d --build`
4. Tester : http://localhost:8080/api/taches
