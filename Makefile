.PHONY: up
up:
	gradlew localDeploy
	cd ../entry && docker compose up api