gradle-build:
	./gradlew build

run-local:
	java -jar build/libs/dundie_awards-latest.jar
run-local-docker:
	docker run -p3000:3000 -t my_app .