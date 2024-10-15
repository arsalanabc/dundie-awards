gradle-build:
	./gradlew build -x test

run-local:
	java -jar build/libs/dundie_awards-latest.jar

run-local-docker:
	docker run -p3000:3000 -t my_app .

dc-build:
	/usr/local/lib/docker/cli-plugins/docker-compose build

dc-up:
	/usr/local/lib/docker/cli-plugins/docker-compose up